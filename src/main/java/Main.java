import ast.*;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedGraph;
import picocli.CommandLine;
import picocli.CommandLine.*;
import ql.QLLexer;
import ql.QLParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.List;
import java.util.concurrent.Callable;

@Command(name = "java -jar eval.jar",
        version="F20",
        mixinStandardHelpOptions = true)
public class Main implements Callable<Integer> {

    static class ExitCode {
        final static int OK = 0;
        final static int INVALID_DATA_FILE = 101;
    }

    @Parameters(index = "0",
            description = "Input data file.")
    File mFile;

    @ArgGroup(multiplicity = "1")
    InputArg inputArg;

    static class InputArg {
        @Option(names = "-f",
                description = "Formula or expression to evaluate.")
        String fOrExpr;

        @Option(names = "-i",
                description = "Parse input from stdin.",
                required = true)
        boolean stdin;
    }

    @Option(names = "-x",
            description = "Show AST")
    boolean showAST;

    Thread uiThread;

    int[][] salesArray;

    @Override
    public Integer call() {
        try {
            salesArray = CSVReader.read(mFile);
        } catch (Exception e) {
            System.err.println("Error parsing data file");
            return ExitCode.INVALID_DATA_FILE;
        }

        if(inputArg.stdin) {
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine().trim();
                if(input.equalsIgnoreCase("exit"))
                    break;
                if(!input.isEmpty())
                    parseAndEvaluate(input);
            }
            scanner.close();
        } else {
            parseAndEvaluate(inputArg.fOrExpr);
        }

        return ExitCode.OK;
    }

    public void parseAndEvaluate(String fOrExpr) {
        QLLexer lexer = new QLLexer(CharStreams.fromString(fOrExpr));
        TokenStream tokens = new CommonTokenStream(lexer);
        QLParser parser = new QLParser(tokens);
        ASTBuilder builder = new ASTBuilder();

        try {
            QLParser.StartContext context = parser.start();
            if(parser.getNumberOfSyntaxErrors() > 0)
                return;

            if(context.formula() != null) {
                Formula ast = (Formula) builder.visitFormula(context.formula());
                if(showAST) showAST(ast);

                boolean result = new Eval(salesArray).eval(ast);
                System.out.println(result);

            } else if(context.nExp() != null) {
                NExp ast = (NExp) builder.visitNExp(context.nExp());
                if(showAST) showAST(ast);

                int result = new Eval(salesArray).eval(ast);
                System.out.println(result);

            } else if(context.sExp() != null) {
                SExp ast = (SExp) builder.visitSExp(context.sExp());
                if(showAST) showAST(ast);

                Set<Integer> result = new Eval(salesArray).eval(ast);
                List<Integer> asList = new LinkedList<>(result);
                Collections.sort(asList);
                System.out.println(asList);

            }
        } catch (BaseEval.UnboundVariableException | BaseEval.DivisionByZeroException e) {
            System.err.println(e.getClass().getSimpleName());
        }

        if(uiThread != null)
            try {
                uiThread.join();
            } catch (InterruptedException e) {
                // ignored
            }
    }

    public void showAST(final ASTNode root) {
        uiThread = new Thread(() -> {
            try {
                drawAST(root);
            } catch (IllegalAccessException e) {
                // ignored
            }
        });

        uiThread.start();
    }

    public void drawAST(ASTNode root) throws IllegalAccessException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        Graph<ASTNode, LabeledEdge> graph
                = new DefaultDirectedGraph<>(LabeledEdge.class);

        Stack<ASTNode> stack = new Stack<>();
        HashSet<ASTNode> visited = new HashSet<>();
        stack.add(root);
        visited.add(root);
        graph.addVertex(root);

        while(!stack.isEmpty()) {
            ASTNode current = stack.pop();
            Field[] fields = current.getClass().getDeclaredFields();

            for (Field field : fields) {
                if(!Modifier.isPublic(field.getModifiers()))
                    continue;

                Object obj = field.get(current);
                if(obj instanceof ASTNode) {
                    ASTNode next = (ASTNode) field.get(current);
                    graph.addVertex(next);

                    graph.addEdge(current, next,
                            new LabeledEdge(field.getName()));

                    if(!visited.contains(next)) {
                        visited.add(next);
                        stack.add(next);
                    }
                }
            }
        }

        JGraphXAdapter<ASTNode, LabeledEdge> jgxAdapter
                = new JGraphXAdapter<>(graph);

        mxGraphComponent component = new mxGraphComponent(jgxAdapter);
        component.getViewport().setBackground(Color.white);

        jgxAdapter.getCellToVertexMap().forEach((mxICell, capsuleInstance) -> {
            component.getGraph().updateCellSize(mxICell);
            mxICell.getGeometry().setWidth(mxICell.getGeometry().getWidth()+20);
        });

        Map<String, Object> labeledEdge
                = new HashMap<>(component.getGraph().getStylesheet().getDefaultEdgeStyle());
        labeledEdge.put(mxConstants.STYLE_VERTICAL_LABEL_POSITION, "bottom");
        labeledEdge.put(mxConstants.STYLE_VERTICAL_ALIGN, "bottom");
        component.getGraph().getStylesheet().putCellStyle("defaultEdge", labeledEdge);

        component.getGraph().refresh();

        mxCompactTreeLayout layout = new mxCompactTreeLayout(jgxAdapter);
        layout.setLevelDistance(75);
        layout.setGroupPadding(75);
        layout.setNodeDistance(25);
        layout.setHorizontal(true);
        layout.execute(jgxAdapter.getDefaultParent());

        component.getGraph().setAllowDanglingEdges(false);
        component.getGraph().setCellsResizable(false);
        component.getGraph().setCellsEditable(false);
        component.getGraph().setCellsMovable(false);
        component.getGraph().setLabelsClipped(false);
        component.getGraph().setResetEdgesOnMove(false);
        component.getGraph().setVertexLabelsMovable(false);
        component.getGraph().setEdgeLabelsMovable(true);

        frame.getContentPane().add(component);
        frame.pack();
        frame.setVisible(true);

        Object lock = new Object();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                synchronized (lock) {
                    frame.setVisible(false);
                    lock.notify();
                }
            }
        });

        synchronized(lock) {
            while (frame.isVisible()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // ignored
                }
            }
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    static class LabeledEdge extends DefaultEdge {
        private final String label;
        public LabeledEdge(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
}

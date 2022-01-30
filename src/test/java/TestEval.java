import ast.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ql.QLLexer;
import ql.QLParser;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TestEval {
    static int[][] salesArray;

    // Num expression tests

    @Test
    //done
    public void testNat() {
        int result = new Eval(salesArray).eval(
                (NExp) parse("2")
        );

        Assert.assertEquals(2, result);
    }

    @Test
    //done
    public void testSalesAt() {
        int result = new Eval(salesArray).eval(
                (NExp) parse("M[2,3]")
        );

        Assert.assertEquals(6, result);
    }

    @Test
    //done
    public void testSalesForP() {
        int result = new Eval(salesArray).eval(
                (NExp) parse("salesForP(M,3)")
        );

        Assert.assertEquals(18, result);
    }

    @Test
    //done
    public void testSalesForD() {
        int result = new Eval(salesArray).eval(
                (NExp) parse("salesForD(M,2)")
        );

        Assert.assertEquals(8, result);
    }

    @Test
    //done
    public void testSalesForM() {
        int result = new Eval(salesArray).eval(
                (NExp) parse("salesForM(M)")
        );

        Assert.assertEquals(87, result);
    }

    @Test
    //done
    public void testSize() {
        int result = new Eval(salesArray).eval(
                (NExp) parse("size(Day)")
        );

        Assert.assertEquals(5, result);
    }

    @Test
    //done
    public void testNumSum() {
        int result = new Eval(salesArray).eval(
                (NExp) parse("4 + 2")
        );

        Assert.assertEquals(6, result);
    }

    @Test
    //done
    public void testNumDiff() {
        int result = new Eval(salesArray).eval(
                (NExp) parse("4 - 2")
        );

        Assert.assertEquals(2, result);
    }

    @Test
    //done
    public void testNumProd() {
        int result = new Eval(salesArray).eval(
                (NExp) parse("4 * 2")
        );

        Assert.assertEquals(8, result);
    }

    @Test
    //done
    public void testNumDiv() {
        int result = new Eval(salesArray).eval(
                (NExp) parse("4 / 2")
        );

        Assert.assertEquals(2, result);
    }

    @Test(expected = BaseEval.DivisionByZeroException.class)
    //done
    public void testNumDivByZero() {
        new Eval(salesArray).eval(
                (NExp) parse("4 / 0")
        );
    }

    // Set expressions tests

    @Test
    //done
    public void testDay() {
        Set<Integer> result = new Eval(salesArray).eval(
                (SExp) parse("Day")
        );

        Set<Integer> expected = new HashSet<>();
        for(int i=1; i<= 5; i++)
            expected.add(i);
        Assert.assertEquals(expected, result);
    }

    @Test
    //done
    public void testProd() {
        Set<Integer> result = new Eval(salesArray).eval(
                (SExp) parse("Prod")
        );

        Set<Integer> expected = new HashSet<>();
        for(int i=1; i<=4; i++)
            expected.add(i);
        Assert.assertEquals(expected, result);
    }

    @Test
    //done
    public void testSale() {
        Set<Integer> result = new Eval(salesArray).eval(
                (SExp) parse("Sale")
        );

        Set<Integer> expected = new HashSet<>();
        for (int[] ints : salesArray)
            for (int anInt : ints)
                expected.add(anInt);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetComprehension() {
        Set<Integer> result = new Eval(salesArray).eval(
                (SExp) parse("{d : Day | d > 2}")
        );

        Set<Integer> expected = new HashSet<>();
        for(int i=3; i<= 5; i++)
            expected.add(i);
        Assert.assertEquals(expected, result);
    }

    @Test
    //done
    public void testUnion() {
        Set<Integer> result = new Eval(salesArray).eval(
                (SExp) parse("Day + Prod")
        );

        Set<Integer> expected = new HashSet<>();
        for(int i=1; i<= 5; i++)
            expected.add(i);
        for(int i=1; i<= 4; i++)
            expected.add(i);
        Assert.assertEquals(expected, result);
    }

    @Test
    //done
    public void testDiff() {
        Set<Integer> result = new Eval(salesArray).eval(
                (SExp) parse("Day - Prod")
        );

        Set<Integer> expected = new HashSet<>();
        for(int i=1; i<= 5; i++)
            expected.add(i);
        for(int i=1; i<= 4; i++)
            expected.remove(i);
        Assert.assertEquals(expected, result);
    }

    @Test
    //done
    public void testIntersection() {
        Set<Integer> result = new Eval(salesArray).eval(
                (SExp) parse("Day & Prod")
        );

        Set<Integer> expected = new HashSet<>();
        for(int i=1; i<= 4; i++)
            expected.add(i);
        Assert.assertEquals(expected, result);
    }

    @Test
    //done
    public void testSetEquality() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("Day == Day")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("Day == Prod")
        );
        Assert.assertFalse(result);
    }

    // Test formulas
    @Test
    //done
    public void testEquals() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("5 == 5")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
            (Formula) parse("5 == 4")
        );
        Assert.assertFalse(result);
    }

    @Test
    //done
    public void testNotEquals() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("5 != 5")
        );
        Assert.assertFalse(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("5 != 4")
        );
        Assert.assertTrue(result);
    }

    @Test
    //done
    public void testLessThan() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("4 < 5")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("5 < 4")
        );
        Assert.assertFalse(result);
    }

    @Test
    //done
    public void testLessThanOrEquals() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("4 <= 5")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("5 <= 5")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("5 <= 4")
        );
        Assert.assertFalse(result);
    }

    @Test
    //done
    public void testGreaterThan() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("4 > 5")
        );
        Assert.assertFalse(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("5 > 4")
        );
        Assert.assertTrue(result);
    }

    @Test
    //done
    public void testGreaterThanOrEquals() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("4 >= 5")
        );
        Assert.assertFalse(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("5 >= 5")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("5 >= 4")
        );
        Assert.assertTrue(result);
    }

    @Test
    //done
    public void testUnary() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("!(3 == 3)")
        );
        Assert.assertFalse(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("!(3 == 2)")
        );
        Assert.assertTrue(result);
    }

    @Test
    //done
    public void testAnd() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("(2 < 3) && (3 < 4)")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 < 3) && (3 > 4)")
        );
        Assert.assertFalse(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 > 3) && (3 < 4)")
        );
        Assert.assertFalse(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 > 3) && (3 > 4)")
        );
        Assert.assertFalse(result);
    }

    @Test
    //done
    public void testOr() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("(2 < 3) || (3 < 4)")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 < 3) || (3 > 4)")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 > 3) || (3 < 4)")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 > 3) || (3 > 4)")
        );
        Assert.assertFalse(result);
    }

    @Test
    //done
    public void testImplies() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("(2 < 3) => (3 < 4)")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 < 3) => (3 > 4)")
        );
        Assert.assertFalse(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 > 3) => (3 < 4)")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 > 3) => (3 > 4)")
        );
        Assert.assertTrue(result);
    }

    @Test
    //done
    public void testEquivalence() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("(2 < 3) <=> (3 < 4)")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 < 3) <=> (3 > 4)")
        );
        Assert.assertFalse(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 > 3) <=> (3 < 4)")
        );
        Assert.assertFalse(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("(2 > 3) <=> (3 > 4)")
        );
        Assert.assertTrue(result);
    }

    @Test
    //done
    public void testForall() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("forall d : Day . d > 0")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("forall p : Prod . forall d : Day . M[p,d] > 3")
        );
        Assert.assertFalse(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("forall p : Prod . forall d : Day . M[p,d] < 10")
        );
        Assert.assertTrue(result);
    }

    @Test
    //done
    public void testExists() {
        boolean result = new Eval(salesArray).eval(
                (Formula) parse("exists d : Day . d == 6")
        );
        Assert.assertFalse(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("exists d : Day . d == 1")
        );
        Assert.assertTrue(result);

        result = new Eval(salesArray).eval(
                (Formula) parse("exists p : Prod . exists d : Day . M[p,d] == 6")
        );
        Assert.assertTrue(result);
    }

    // Misc. tests

    @Test(expected = BaseEval.UnboundVariableException.class)
    //done
    public void testFreeVar() {
        new Eval(salesArray).eval(
                (NExp) parse("x")
        );
    }

    @BeforeClass
    public static void readData() throws IOException {
        File file = new File(
                URLDecoder.decode(Objects.requireNonNull(TestEval.class.getClassLoader()
                        .getResource("salesArray.csv")).getFile(),"UTF-8")
        );

        salesArray = CSVReader.read(file);
    }

    public ASTNode parse(String input) {
        QLLexer lexer = new QLLexer(CharStreams.fromString(input));
        TokenStream tokens = new CommonTokenStream(lexer);
        QLParser p = new QLParser(tokens);

        ASTBuilder builder = new ASTBuilder();
        QLParser.StartContext context = p.start();
        Assert.assertEquals(0, p.getNumberOfSyntaxErrors());

        if(context.formula() != null)
            return builder.visitFormula(context.formula());
        if(context.nExp() != null)
            return builder.visitNExp(context.nExp());
        return builder.visitSExp(context.sExp());
    }
}
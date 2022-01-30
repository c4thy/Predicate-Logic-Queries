package ast;

public class BinNOp implements ASTNode {
    public enum Kind {
        ADD,    // addition
        DIFF,   // difference
        MULT,   // multiplication
        DIV     // division
    }

    public Kind kind;

    public static BinNOp ADD() {
        return new BinNOp(Kind.ADD);
    }

    public static BinNOp DIFF() {
        return new BinNOp(Kind.DIFF);
    }

    public static BinNOp MULT() {
        return new BinNOp(Kind.MULT);
    }

    public static BinNOp DIV() {
        return new BinNOp(Kind.DIV);
    }

    private BinNOp(Kind value) {
        this.kind = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" = '"+ kind +"'";
    }
}

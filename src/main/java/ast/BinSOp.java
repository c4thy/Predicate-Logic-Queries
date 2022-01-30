package ast;

public class BinSOp implements ASTNode {
    public enum Kind {
        UNION,      // union
        DIFF,       // set difference
        INTER       // intersection
    }

    public Kind kind;

    public static BinSOp UNION() {
        return new BinSOp(Kind.UNION);
    }

    public static BinSOp DIFF() {
        return new BinSOp(Kind.DIFF);
    }

    public static BinSOp INTER() {
        return new BinSOp(Kind.INTER);
    }

    private BinSOp(Kind value) {
        this.kind = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" = '"+ kind +"'";
    }
}

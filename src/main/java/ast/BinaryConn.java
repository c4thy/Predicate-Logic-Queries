package ast;

public class BinaryConn implements ASTNode {
    public enum Kind {
        AND,
        OR,
        IMPLY,
        EQUIV
    }

    public Kind kind;

    public static BinaryConn AND() {
        return new BinaryConn(Kind.AND);
    }

    public static BinaryConn OR() {
        return new BinaryConn(Kind.OR);
    }

    public static BinaryConn IMPLY() {
        return new BinaryConn(Kind.IMPLY);
    }

    public static BinaryConn EQUIV() {
        return new BinaryConn(Kind.EQUIV);
    }

    private BinaryConn(Kind value) {
        this.kind = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" = '"+ kind +"'";
    }
}

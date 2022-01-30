package ast;

public class UnaryConn implements ASTNode {
    public enum Kind {
        NOT
    }

    public Kind kind;

    public static UnaryConn NOT() {
        return new UnaryConn(Kind.NOT);
    }

    private UnaryConn(Kind value) {
        this.kind = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"='"+ kind +"'";
    }
}

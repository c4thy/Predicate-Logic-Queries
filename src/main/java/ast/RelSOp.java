package ast;

public class RelSOp implements ASTNode {
    public enum Kind {
        EQ,     // equals
    }

    public Kind kind;

    public static RelSOp EQ() {
        return new RelSOp(Kind.EQ);
    }

    private RelSOp(Kind value) {
        this.kind = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" = '"+ kind +"'";
    }
}

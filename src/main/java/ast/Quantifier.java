package ast;

public class Quantifier implements ASTNode {
    public enum Kind {
        FORALL,
        EXISTS
    }

    public Kind kind;

    public static Quantifier FORALL() {
        return new Quantifier(Kind.FORALL);
    }

    public static Quantifier EXISTS() {
        return new Quantifier(Kind.EXISTS);
    }

    private Quantifier(Kind value) {
        this.kind = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" = '"+ kind +"'";
    }
}

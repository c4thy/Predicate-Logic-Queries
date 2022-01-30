package ast;

public class RelNOp implements ASTNode {
    public enum Kind {
        EQ,     // equals
        NEQ,    // not equals
        LT,     // less than
        LTE,     // less than or equals
        GT,     // greater than
        GTE      // greater than or equals
    }

    public Kind kind;

    public static RelNOp EQ() {
        return new RelNOp(Kind.EQ);
    }

    public static RelNOp NEQ() {
        return new RelNOp(Kind.NEQ);
    }

    public static RelNOp LT() {
        return new RelNOp(Kind.LT);
    }

    public static RelNOp LTE() {
        return new RelNOp(Kind.LTE);
    }

    public static RelNOp GT() {
        return new RelNOp(Kind.GT);
    }

    public static RelNOp GTE() {
        return new RelNOp(Kind.GTE);
    }

    private RelNOp(Kind value) {
        this.kind = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" = '"+ kind +"'";
    }
}

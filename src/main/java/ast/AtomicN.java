package ast;

public class AtomicN extends Atomic {
    public RelNOp relNOp;
    public NExp lhs;
    public NExp rhs;

    public AtomicN(RelNOp relNOp, NExp lhs, NExp rhs) {
        this.relNOp = relNOp;
        this.lhs = lhs;
        this.rhs = rhs;
    }
}

package ast;

public class AtomicS extends Atomic {
    public RelSOp relSOp;
    public SExp lhs;
    public SExp rhs;

    public AtomicS(RelSOp relSOp, SExp lhs, SExp rhs) {
        this.relSOp = relSOp;
        this.lhs = lhs;
        this.rhs = rhs;
    }
}

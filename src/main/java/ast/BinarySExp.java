package ast;

public class BinarySExp extends SExp {
    public BinSOp op;
    public SExp lhs;
    public SExp rhs;

    public BinarySExp(BinSOp op, SExp lhs, SExp rhs) {
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
    }
}

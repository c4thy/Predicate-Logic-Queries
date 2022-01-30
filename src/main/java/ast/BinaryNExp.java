package ast;

public class BinaryNExp extends NExp {
    public BinNOp op;
    public NExp lhs;
    public NExp rhs;

    public BinaryNExp(BinNOp op, NExp lhs, NExp rhs) {
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
    }
}

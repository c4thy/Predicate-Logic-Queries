package ast;

public class Binary extends Formula {
    public BinaryConn binConn;
    public Formula lhs;
    public Formula rhs;

    public Binary(BinaryConn binConn, Formula lhs, Formula rhs) {
        this.binConn = binConn;
        this.lhs = lhs;
        this.rhs = rhs;
    }
}

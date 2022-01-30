package ast;

public class Unary extends Formula {
    public UnaryConn unConn;
    public Formula formula;

    public Unary(UnaryConn unConn, Formula formula) {
        this.unConn = unConn;
        this.formula = formula;
    }
}

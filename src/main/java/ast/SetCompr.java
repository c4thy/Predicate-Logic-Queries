package ast;

public class SetCompr extends SExp {
    public Var var;
    public Type type;
    public Formula formula;

    public SetCompr(Var var, Type type, Formula formula) {
        this.var = var;
        this.type = type;
        this.formula = formula;
    }
}

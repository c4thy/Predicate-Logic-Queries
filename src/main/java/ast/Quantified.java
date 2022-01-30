package ast;

public class Quantified extends Formula {
    public Quantifier quantifier;
    public Var var;
    public Type type;
    public Formula formula;

    public Quantified(Quantifier quantifier, Var var, Type type, Formula formula) {
        this.quantifier = quantifier;
        this.var = var;
        this.type = type;
        this.formula = formula;
    }
}

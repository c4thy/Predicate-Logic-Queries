import ast.Formula;
import ast.NExp;
import ast.SExp;

import java.util.*;

public abstract class BaseEval {
    /**
     *
     * @param formula formula to evaluate
     * @param env evaluation environment (see Env.java)
     * @return the boolean value of the formula
     */
    protected abstract Boolean evalFormula(Formula formula, Env env);

    /**
     *
     * @param exp set expression to evaluate
     * @param env evaluation environment (see Env.java)
     * @return the set of integer value evaluated from the expression
     */
    protected abstract Set<Integer> evalSExp(SExp exp, Env env);

    /**
     *
     * @param exp numerical expression to evaluate
     * @param env evaluation environment (see Env.java)
     * @return the integer value of the expression
     */
    protected abstract Integer evalNExp(NExp exp, Env env);


    /**
     * Must be thrown whenever a variable cannot be evaluated to a value
     * e.g., forall d: Day . M[p,d] > 0
     */
    static class UnboundVariableException extends RuntimeException { }

    /**
     * Must be thrown whenever a division by zero is attempted
     */
    static class DivisionByZeroException extends RuntimeException { }

    public boolean eval(Formula formula) {
        return evalFormula(formula, new Env());
    }

    public int eval(NExp nExp) {
        return evalNExp(nExp, new Env());
    }

    public Set<Integer> eval(SExp sExp) {
        return evalSExp(sExp, new Env());
    }
}

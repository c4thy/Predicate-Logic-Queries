import ast.*;
import ql.QLParser;

import java.io.Serializable;
import java.util.*;

/**
 * Name: Cathy Yan
 * Student Number: 20102139
 *
 * CISC422 Fall 2021 -- Assignment 1
 */

public class Eval extends BaseEval {
    //-----------------------!! DO NOT MODIFY !!-------------------------
    private int[][] M;
    public Eval(int[][] M) {
        this.M = M;
    }
    //-------------------------------------------------------------------

    //NUM EXPRESSION -- Helper Functions:

    //Evaluate the numeric value of NExp
    public int evalNat(NExp exp){
        return ((Nat) exp).value;
    }

    //Evaluate SalesForP
    public int evalSalesForP(NExp exp, Env env){
        int prod = evalNExp(((SalesForP) exp).product, env);
        int sum = 0;
        for (int i = 0; i < M[prod-1].length; i++) {
            sum = sum + M[prod-1][i];
        }
        return sum;
    }

    //Evaluate SalesForD
    public int evalSalesForD(NExp exp, Env env){
        int day = evalNExp(((SalesForD) exp).day, env);
        int sum = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (j == (day-1))
                    sum = sum + M[i][day-1];
            }
        }
        return sum;
    }

    //Evaluate SalesForM
    public int evalSalesForM(){
        int sum = 0;
        for (int i = 0; i < M.length; i++){
            for (int j = 0; j < M[0].length; j++){
                sum = sum + M[i][j];
            }
        }
        return sum;
    }

    //Evaluate SalesAt
    public int evalSalesAt(NExp exp, Env env){
        int prod = evalNExp(((SalesAt) exp).product, env);
        int day = evalNExp(((SalesAt) exp).day, env);
        return M[prod-1][day-1];
    }

    //Evaluate Size of SExp
    public int evalSize(SExp exp){
        Set<Integer> sExp = evalType(exp);
        return sExp.size();
    }

    //Supports Binary Number Operations:
    public int evalNumOp(NExp exp, NExp lhs, NExp rhs, Env env){
        int exp1 = evalNExp(lhs, env);
        int exp2 = evalNExp(rhs, env);

        // binNop is ADD
        if (((BinaryNExp) exp).op.kind == BinNOp.ADD().kind){
            return exp1 + exp2;
        }
        // binNop is DIFF
        else if (((BinaryNExp) exp).op.kind == BinNOp.DIFF().kind){
            return exp1 - exp2;
        }
        //binNop is MULT
        else if (((BinaryNExp) exp).op.kind == BinNOp.MULT().kind){
            return exp1 * exp2;
        }
        //binNop is DIV
        else if (((BinaryNExp) exp).op.kind == BinNOp.DIV().kind){

            //DIVISION by ZERO error handling
            if (exp2 == 0){
                throw new BaseEval.DivisionByZeroException();
            }
            else return exp1/exp2;
        }
        return 0;
    }

    //SET EXPRESSION -- Helper Functions:

    //Evaluate what Type exp is:
    public Set<Integer> evalType(SExp exp){

        //exp is Day
        if(((Type) exp).kind == Type.DAY().kind){
            return evalDay();
        }
        //exp is Product
        else if (((Type) exp).kind == Type.PRODUCT().kind){
            return evalProd();
        }
        //exp is Sale
        else if (((Type) exp).kind == Type.SALE().kind){
            return evalSale();
        }
        return null;
    }

    //Get set of Days
    public Set<Integer> evalDay(){
        int count = 1;
        Set<Integer> days = new HashSet<>();
        for (int i = 0; i < M[0].length; i++){
            days.add(count);
            count++;
        }
        return days;
    }

    //Get set of Products
    public Set<Integer> evalProd(){
        int count = 1;
        Set<Integer> prods = new HashSet<>();
        for (int i = 0; i < M.length; i++){
            prods.add(count);
            count++;
        }
        return prods;
    }

    //Get set of Sales
    public Set<Integer> evalSale(){
        Set<Integer> sales = new HashSet<>();
        for (int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                sales.add(M[i][j]);
            }
        }
        return sales;
    }

    //Supports all Binary Set Operations
    public Set<Integer> evalBinSetOp(SExp exp, Set<Integer> lhs, Set<Integer> rhs){

        //Union:
        if(((BinarySExp) exp).op.kind == BinSOp.UNION().kind ){
            Set<Integer> unionSet = lhs;
            for (int i = 1; i <= rhs.size(); i++){
                unionSet.add(i);
            }
            return unionSet;
        }

        //Diff:
        else if(((BinarySExp) exp).op.kind == BinSOp.DIFF().kind) {
            Set<Integer> diffSet = lhs;
            for (int i = 1; i <= rhs.size(); i++){
                diffSet.remove(i);
            }
            return diffSet;
        }

        //Intersection:
        else if(((BinarySExp) exp).op.kind == BinSOp.INTER().kind) {
            if (lhs.size() > rhs.size()){
                return rhs;
            } else if (lhs.size() < rhs.size()){
                return lhs;
            } else return lhs;
        }

        return null;
    }

    //Supports Set Comprehension
    public Set<Integer> evalSetCompr(SExp exp, Env env){
        Set<Integer> typeSet = evalType(((SetCompr) exp).type);
        Var varForm = ((SetCompr) exp).var;
        Set<Integer> resultSet = new HashSet<>();

        for (int element : typeSet){
            env.push(varForm.name, element);
            if(evalFormula(((SetCompr) exp).formula, env)){
                resultSet.add(element);
                makeEmptyStack(env);
            }
        }
        makeEmptyStack(env);
        return resultSet;
    }

    //FORMULAS -- Helper Functions:

    //Supports relNOp
    public Boolean evalrelNumOp(Formula formula, NExp lhs, NExp rhs, Env env){
        int exp1 = evalNExp(lhs, env);
        int exp2 = evalNExp(rhs, env);

        //Equals:
        if(((AtomicN) formula).relNOp.kind == RelNOp.EQ().kind){
            return exp1 == exp2;
        }
        //Not equals:
        else if (((AtomicN) formula).relNOp.kind == RelNOp.NEQ().kind){
            return exp1 != exp2;
        }
        //Less than:
        else if (((AtomicN) formula).relNOp.kind == RelNOp.LT().kind){
            return exp1 < exp2;
        }
        //Less than equals:
        else if (((AtomicN) formula).relNOp.kind == RelNOp.LTE().kind){
            return exp1 <= exp2;
        }
        //Greater than:
        else if (((AtomicN) formula).relNOp.kind == RelNOp.GT().kind){
            return exp1 > exp2;
        }
        //Greater than equals:
        else if (((AtomicN) formula).relNOp.kind == RelNOp.GTE().kind){
            return exp1 >= exp2;
        }
        return false;
    }

    //Supports relSOp:
    public Boolean evalrelSetOp(Formula formula, SExp lhs, SExp rhs){
        Set<Integer> exp1 = evalType(lhs);
        Set<Integer> exp2 = evalType(rhs);

        //Set equality
        if (((AtomicS) formula).relSOp.kind == RelSOp.EQ().kind){
            if(exp1.equals(exp2)) return true;
        }
        return false;
    }

    //Supports Binary conditionals
    public Boolean evalBinConn(Boolean boolLHS, Boolean boolRHS, Formula formula){

        //And:
        if (((Binary) formula).binConn.kind == BinaryConn.AND().kind){
            return boolLHS && boolRHS;
        }
        //Or:
        else if (((Binary) formula).binConn.kind == BinaryConn.OR().kind){
            return boolLHS || boolRHS;
        }
        //Implies:
        else if (((Binary) formula).binConn.kind == BinaryConn.IMPLY().kind){
            //implication like p -> q is logically equivalent to !p V q
            return (!boolLHS) || boolRHS;
        }
        //Equivalence:
        else if (((Binary) formula).binConn.kind == BinaryConn.EQUIV().kind){
            return boolLHS == boolRHS;
        }
        return false;
    }

    //Clears the stack in the environment
    public void makeEmptyStack(Env env){
        while(!env.stack.isEmpty()){
            env.pop();
        }
    }

    //Supports quantified formulas:
    public Boolean evalQuantified(Formula formula, Env env){
        Set<Integer> typeSet = evalType(((Quantified) formula).type);
        Var varForm = ((Quantified) formula).var;

        //Exists:
        if (((Quantified) formula).quantifier.kind == Quantifier.EXISTS().kind){
            for (int element : typeSet){
                env.push(varForm.name, element);
                if (evalFormula(((Quantified) formula).formula, env)){
                    makeEmptyStack(env);
                    return true;
                }
            }
            makeEmptyStack(env);
            return false;
        }

        //For All:
        if (((Quantified) formula).quantifier.kind == Quantifier.FORALL().kind){
            for (int element : typeSet){
                env.push(varForm.name, element);
                if (!evalFormula(((Quantified) formula).formula, env)){
                    makeEmptyStack(env);
                    return false;
                }
            }
            makeEmptyStack(env);
            return true;
        }
        return false;
    }


    @Override
    protected Integer evalNExp(NExp exp, Env env) {

        //exp is Variable
        if (exp instanceof Var){
            //Free var error exception
            if(env.lookup(((Var) exp).name) == -1){
                throw new BaseEval.UnboundVariableException();
            }
            else return env.lookup(((Var) exp).name);
        }

        //exp is NAT
        if (exp instanceof Nat) {
            return evalNat(exp);
        }

        //exp is SalesForP
        if (exp instanceof SalesForP) {
            return evalSalesForP(exp, env);
        }

        //exp is SalesForD
        if (exp instanceof SalesForD) {
            return evalSalesForD(exp, env);
        }

        //exp is SalesForM
        if (exp instanceof SalesForM) {
            return evalSalesForM();
        }

        //exp is SalesAt
        if (exp instanceof SalesAt){
            return evalSalesAt(exp, env);

        }

        //exp is Size
        if (exp instanceof Size){
            return evalSize(((Size) exp).sExp);
        }

        //exp is binNop
        if (exp instanceof BinaryNExp){
            return evalNumOp(exp, ((BinaryNExp) exp).lhs, ((BinaryNExp) exp).rhs, env);
        }
        return 0;
    }


    @Override
    protected Set<Integer> evalSExp(SExp exp, Env env) {

        //exp is Type
        if (exp instanceof Type){
            return evalType(exp);
        }

        //exp is BinarySExp
        if (exp instanceof BinarySExp){
            return evalBinSetOp(exp, evalType(((BinarySExp) exp).lhs), evalType(((BinarySExp) exp).rhs));
        }

        //exp is SetCompr
        if (exp instanceof SetCompr){
            return evalSetCompr(exp, env);
        }
        return null;
    }


    @Override
    protected Boolean evalFormula(Formula formula, Env env) {

        //formula is AtomicN
        if (formula instanceof AtomicN){
            return evalrelNumOp(formula, ((AtomicN) formula).lhs, ((AtomicN) formula).rhs, env);
        }

        //formula is AtomicS
        if(formula instanceof AtomicS){
            return evalrelSetOp(formula, ((AtomicS) formula).lhs, ((AtomicS) formula).rhs);
        }

        //formula is Unary
        if (formula instanceof Unary){
            Formula unaryForm = ((Unary) formula).formula;
            Boolean evaluatedForm = evalrelNumOp(unaryForm, ((AtomicN) unaryForm).lhs, ((AtomicN) unaryForm).rhs, env);

            return !evaluatedForm;
        }

        //formula is Binary
        if (formula instanceof Binary){
            Formula binLHS = ((Binary) formula).lhs;
            Boolean boolLHS = evalrelNumOp(binLHS, ((AtomicN) binLHS).lhs, ((AtomicN) binLHS).rhs, env);
            Formula binRHS = ((Binary) formula).rhs;
            Boolean boolRHS = evalrelNumOp(binRHS, ((AtomicN) binRHS).lhs, ((AtomicN) binRHS).rhs, env);

            return evalBinConn(boolLHS, boolRHS, formula);
        }

        //formula is Quantified
        if (formula instanceof Quantified){
            return evalQuantified(formula, env);
        }
        return false;
    }
}

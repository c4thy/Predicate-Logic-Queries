package ast;

import ql.QLBaseVisitor;
import ql.QLParser;

public class ASTBuilder extends QLBaseVisitor<ASTNode> {

    /*
     * Formulas
     */

    @Override
    public ASTNode visitAtomicN(QLParser.AtomicNContext ctx) {
        RelNOp op = (RelNOp) visitRelNOp(ctx.relNOp());
        NExp lhs = (NExp) visitNExp(ctx.nExp(0));
        NExp rhs = (NExp) visitNExp(ctx.nExp(1));
        return new AtomicN(op, lhs, rhs);
    }

    @Override
    public ASTNode visitAtomicS(QLParser.AtomicSContext ctx) {
        RelSOp op = (RelSOp) visitRelSOp(ctx.relSOp());
        SExp lhs = (SExp) visitSExp(ctx.sExp(0));
        SExp rhs = (SExp) visitSExp(ctx.sExp(1));
        return new AtomicS(op, lhs, rhs);
    }

    @Override
    public ASTNode visitUnary(QLParser.UnaryContext ctx) {
        UnaryConn conn = (UnaryConn) visitUnConn(ctx.unConn());
        Formula formula = (Formula) visitFormula(ctx.formula());
        return new Unary(conn, formula);
    }

    @Override
    public ASTNode visitBinary(QLParser.BinaryContext ctx) {
        BinaryConn conn = (BinaryConn) visitBinConn(ctx.binConn());
        Formula lhs = (Formula) visitFormula(ctx.formula(0));
        Formula rhs = (Formula) visitFormula(ctx.formula(1));
        return new Binary(conn, lhs, rhs);
    }

    @Override
    public ASTNode visitQuantified(QLParser.QuantifiedContext ctx) {
        Quantifier quant = (Quantifier) visitQuantifier(ctx.quantifier());
        Var var = (Var) visitVar(ctx.var());
        Type type = (Type) visitType(ctx.type());
        Formula formula = (Formula) visitFormula(ctx.formula());
        return new Quantified(quant, var, type, formula);
    }

    @Override
    public ASTNode visitBracketed(QLParser.BracketedContext ctx) {
        return visitFormula(ctx.formula());
    }

    /*
     * Connectives
     */

    @Override
    public ASTNode visitUnConn(QLParser.UnConnContext ctx) {
        if(ctx.NOT() != null)
            return UnaryConn.NOT();
        throw new IllegalArgumentException();
    }

    @Override
    public ASTNode visitBinConn(QLParser.BinConnContext ctx) {
        if(ctx.AND() != null)
            return BinaryConn.AND();
        if(ctx.OR() != null)
            return BinaryConn.OR();
        if(ctx.IMPLY() != null)
            return BinaryConn.IMPLY();
        if(ctx.EQUIV() != null)
            return BinaryConn.EQUIV();
        throw new IllegalArgumentException();
    }

    @Override
    public ASTNode visitQuantifier(QLParser.QuantifierContext ctx) {
        if(ctx.FORALL() != null)
            return Quantifier.FORALL();
        if(ctx.EXISTS() != null)
            return Quantifier.EXISTS();
        throw new IllegalArgumentException();
    }

    /*
     * Operators
     */

    @Override
    public ASTNode visitRelSOp(QLParser.RelSOpContext ctx) {
        if(ctx.EQ() != null)
            return RelSOp.EQ();
        throw new IllegalArgumentException();
    }

    @Override
    public ASTNode visitRelNOp(QLParser.RelNOpContext ctx) {
        if(ctx.EQ() != null)
            return RelNOp.EQ();
        if(ctx.NEQ() != null)
            return RelNOp.NEQ();
        if(ctx.GT() != null)
            return RelNOp.GT();
        if(ctx.LT() != null)
            return RelNOp.LT();
        if(ctx.GTE() != null)
            return RelNOp.GTE();
        if(ctx.LTE() != null)
            return RelNOp.LTE();
        throw new IllegalArgumentException();
    }

    @Override
    public ASTNode visitBinNOp(QLParser.BinNOpContext ctx) {
        if(ctx.PLUS() != null)
            return BinNOp.ADD();
        if(ctx.MINUS() != null)
            return BinNOp.DIFF();
        if(ctx.ASTRIX() != null)
            return BinNOp.MULT();
        if(ctx.SLASH() != null)
            return BinNOp.DIV();
        throw new IllegalArgumentException();
    }

    @Override
    public ASTNode visitBinSOp(QLParser.BinSOpContext ctx) {
        if(ctx.AMPER() != null)
            return BinSOp.INTER();
        if(ctx.PLUS() != null)
            return BinSOp.UNION();
        if(ctx.MINUS() != null)
            return BinSOp.DIFF();
        throw new IllegalArgumentException();
    }

    /*
     * Operands
     */

    @Override
    public ASTNode visitVar(QLParser.VarContext ctx) {
        return new Var(ctx.getText());
    }

    @Override
    public ASTNode visitNat(QLParser.NatContext ctx) {
        int value;
        try {
            value = Integer.parseInt(ctx.getText());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return new Nat(value);
    }

    /*
     * Constant expressions
     */

    @Override
    public ASTNode visitSize(QLParser.SizeContext ctx) {
        SExp sExp = (SExp) visitSExp(ctx.sExp());
        return new Size(sExp);
    }

    @Override
    public ASTNode visitSalesAt(QLParser.SalesAtContext ctx) {
        NExp product = (NExp) visitNExp(ctx.nExp(0));
        NExp day = (NExp) visitNExp(ctx.nExp(1));
        return new SalesAt(product, day);
    }

    @Override
    public ASTNode visitSalesForM(QLParser.SalesForMContext ctx) {
        return new SalesForM();
    }

    @Override
    public ASTNode visitSalesForD(QLParser.SalesForDContext ctx) {
        NExp day = (NExp) visitNExp(ctx.nExp());
        return new SalesForD(day);
    }

    @Override
    public ASTNode visitSalesForP(QLParser.SalesForPContext ctx) {
        NExp product = (NExp) visitNExp(ctx.nExp());
        return new SalesForP(product);
    }

    /*
     * Set expressions
     */

    @Override
    public ASTNode visitBracketedSExp(QLParser.BracketedSExpContext ctx) {
        return visitSExp(ctx.sExp());
    }

    @Override
    public ASTNode visitTypeRef(QLParser.TypeRefContext ctx) {
        return visitType(ctx.type());
    }

    @Override
    public ASTNode visitBinarySExp(QLParser.BinarySExpContext ctx) {
        BinSOp op = (BinSOp) visitBinSOp(ctx.binSOp());
        SExp lhs = (SExp) visitSExp(ctx.sExp(0));
        SExp rhs = (SExp) visitSExp(ctx.sExp(1));
        return new BinarySExp(op, lhs, rhs);
    }

    @Override
    public ASTNode visitSetCompr(QLParser.SetComprContext ctx) {
        Var var = (Var) visitVar(ctx.var());
        Type type = (Type) visitType(ctx.type());
        Formula formula = (Formula) visitFormula(ctx.formula());
        return new SetCompr(var, type, formula);
    }

    @Override
    public ASTNode visitType(QLParser.TypeContext ctx) {
        if(ctx.DAY() != null)
            return ast.Type.DAY();
        if(ctx.PRODUCT() != null)
            return ast.Type.PRODUCT();
        if(ctx.SALE() != null)
            return ast.Type.SALE();
        throw new IllegalArgumentException();
    }

    /*
     * Num expressions
     */

    @Override
    public ASTNode visitBracketedNExp(QLParser.BracketedNExpContext ctx) {
        return visitNExp(ctx.nExp());
    }

    @Override
    public ASTNode visitVarRef(QLParser.VarRefContext ctx) {
        return visitVar(ctx.var());
    }

    @Override
    public ASTNode visitBinaryNExp(QLParser.BinaryNExpContext ctx) {
        BinNOp op = (BinNOp) visitBinNOp(ctx.binNOp());
        NExp lhs = (NExp) visitNExp(ctx.nExp(0));
        NExp rhs = (NExp) visitNExp(ctx.nExp(1));
        return new BinaryNExp(op, lhs, rhs);
    }

    /*
     * Roots
     */

    public ASTNode visitFormula(QLParser.FormulaContext ctx) {
        if(ctx instanceof QLParser.AtomicNContext)
            return visitAtomicN((QLParser.AtomicNContext) ctx);
        if(ctx instanceof QLParser.AtomicSContext)
            return visitAtomicS((QLParser.AtomicSContext) ctx);
        if(ctx instanceof QLParser.BinaryContext)
            return visitBinary((QLParser.BinaryContext) ctx);
        if(ctx instanceof QLParser.UnaryContext)
            return visitUnary((QLParser.UnaryContext) ctx);
        if(ctx instanceof QLParser.QuantifiedContext)
            return visitQuantified((QLParser.QuantifiedContext) ctx);
        if(ctx instanceof QLParser.BracketedContext)
            return visitBracketed((QLParser.BracketedContext) ctx);
        throw new IllegalArgumentException();
    }

    public ASTNode visitSExp(QLParser.SExpContext ctx) {
        if(ctx instanceof QLParser.TypeRefContext)
            return visitTypeRef((QLParser.TypeRefContext) ctx);
        if(ctx instanceof QLParser.SetComprContext)
            return visitSetCompr((QLParser.SetComprContext) ctx);
        if(ctx instanceof QLParser.BinarySExpContext)
            return visitBinarySExp((QLParser.BinarySExpContext) ctx);
        if(ctx instanceof QLParser.BracketedSExpContext)
            return visitBracketedSExp((QLParser.BracketedSExpContext) ctx);
        throw new IllegalArgumentException();
    }

    public ASTNode visitNExp(QLParser.NExpContext ctx) {
        if(ctx instanceof QLParser.NatContext)
            return visitNat((QLParser.NatContext) ctx);
        if(ctx instanceof QLParser.VarRefContext)
            return visitVarRef((QLParser.VarRefContext) ctx);
        if(ctx instanceof QLParser.SizeContext)
            return visitSize((QLParser.SizeContext) ctx);
        if(ctx instanceof QLParser.SalesAtContext)
            return visitSalesAt((QLParser.SalesAtContext) ctx);
        if(ctx instanceof QLParser.SalesForMContext)
            return visitSalesForM((QLParser.SalesForMContext) ctx);
        if(ctx instanceof QLParser.SalesForDContext)
            return visitSalesForD((QLParser.SalesForDContext) ctx);
        if(ctx instanceof QLParser.SalesForPContext)
            return visitSalesForP((QLParser.SalesForPContext) ctx);
        if(ctx instanceof QLParser.BinaryNExpContext)
            return visitBinaryNExp((QLParser.BinaryNExpContext) ctx);
        if(ctx instanceof QLParser.BracketedNExpContext)
            return visitBracketedNExp((QLParser.BracketedNExpContext) ctx);
        throw new IllegalArgumentException();
    }
}

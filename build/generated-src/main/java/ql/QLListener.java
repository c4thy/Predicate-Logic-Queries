// Generated from QL.g by ANTLR 4.8
package ql;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(QLParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(QLParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Quantified}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterQuantified(QLParser.QuantifiedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Quantified}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitQuantified(QLParser.QuantifiedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomicN}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAtomicN(QLParser.AtomicNContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomicN}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAtomicN(QLParser.AtomicNContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterBinary(QLParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitBinary(QLParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bracketed}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterBracketed(QLParser.BracketedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bracketed}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitBracketed(QLParser.BracketedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomicS}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAtomicS(QLParser.AtomicSContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomicS}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAtomicS(QLParser.AtomicSContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterUnary(QLParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitUnary(QLParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#unConn}.
	 * @param ctx the parse tree
	 */
	void enterUnConn(QLParser.UnConnContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#unConn}.
	 * @param ctx the parse tree
	 */
	void exitUnConn(QLParser.UnConnContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#binConn}.
	 * @param ctx the parse tree
	 */
	void enterBinConn(QLParser.BinConnContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#binConn}.
	 * @param ctx the parse tree
	 */
	void exitBinConn(QLParser.BinConnContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(QLParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(QLParser.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(QLParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(QLParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#relSOp}.
	 * @param ctx the parse tree
	 */
	void enterRelSOp(QLParser.RelSOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#relSOp}.
	 * @param ctx the parse tree
	 */
	void exitRelSOp(QLParser.RelSOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Nat}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void enterNat(QLParser.NatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Nat}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void exitNat(QLParser.NatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(QLParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(QLParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SalesForP}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void enterSalesForP(QLParser.SalesForPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SalesForP}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void exitSalesForP(QLParser.SalesForPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SalesForM}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void enterSalesForM(QLParser.SalesForMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SalesForM}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void exitSalesForM(QLParser.SalesForMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketedNExp}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void enterBracketedNExp(QLParser.BracketedNExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketedNExp}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void exitBracketedNExp(QLParser.BracketedNExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SalesAt}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void enterSalesAt(QLParser.SalesAtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SalesAt}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void exitSalesAt(QLParser.SalesAtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryNExp}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryNExp(QLParser.BinaryNExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryNExp}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryNExp(QLParser.BinaryNExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SalesForD}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void enterSalesForD(QLParser.SalesForDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SalesForD}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void exitSalesForD(QLParser.SalesForDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Size}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void enterSize(QLParser.SizeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Size}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 */
	void exitSize(QLParser.SizeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#binNOp}.
	 * @param ctx the parse tree
	 */
	void enterBinNOp(QLParser.BinNOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#binNOp}.
	 * @param ctx the parse tree
	 */
	void exitBinNOp(QLParser.BinNOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#relNOp}.
	 * @param ctx the parse tree
	 */
	void enterRelNOp(QLParser.RelNOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#relNOp}.
	 * @param ctx the parse tree
	 */
	void exitRelNOp(QLParser.RelNOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeRef}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 */
	void enterTypeRef(QLParser.TypeRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeRef}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 */
	void exitTypeRef(QLParser.TypeRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracketedSExp}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 */
	void enterBracketedSExp(QLParser.BracketedSExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracketedSExp}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 */
	void exitBracketedSExp(QLParser.BracketedSExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetCompr}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 */
	void enterSetCompr(QLParser.SetComprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetCompr}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 */
	void exitSetCompr(QLParser.SetComprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinarySExp}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 */
	void enterBinarySExp(QLParser.BinarySExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinarySExp}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 */
	void exitBinarySExp(QLParser.BinarySExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#binSOp}.
	 * @param ctx the parse tree
	 */
	void enterBinSOp(QLParser.BinSOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#binSOp}.
	 * @param ctx the parse tree
	 */
	void exitBinSOp(QLParser.BinSOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(QLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(QLParser.TypeContext ctx);
}
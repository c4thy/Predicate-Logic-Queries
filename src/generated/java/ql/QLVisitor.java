// Generated from QL.g by ANTLR 4.8
package ql;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(QLParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Quantified}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantified(QLParser.QuantifiedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomicN}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicN(QLParser.AtomicNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Binary}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(QLParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bracketed}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketed(QLParser.BracketedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomicS}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicS(QLParser.AtomicSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link QLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(QLParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#unConn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnConn(QLParser.UnConnContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#binConn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinConn(QLParser.BinConnContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(QLParser.QuantifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(QLParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#relSOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelSOp(QLParser.RelSOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Nat}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNat(QLParser.NatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(QLParser.VarRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SalesForP}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSalesForP(QLParser.SalesForPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SalesForM}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSalesForM(QLParser.SalesForMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketedNExp}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketedNExp(QLParser.BracketedNExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SalesAt}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSalesAt(QLParser.SalesAtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryNExp}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryNExp(QLParser.BinaryNExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SalesForD}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSalesForD(QLParser.SalesForDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Size}
	 * labeled alternative in {@link QLParser#nExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSize(QLParser.SizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#binNOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinNOp(QLParser.BinNOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#relNOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelNOp(QLParser.RelNOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeRef}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRef(QLParser.TypeRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketedSExp}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketedSExp(QLParser.BracketedSExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetCompr}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetCompr(QLParser.SetComprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinarySExp}
	 * labeled alternative in {@link QLParser#sExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinarySExp(QLParser.BinarySExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#binSOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinSOp(QLParser.BinSOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(QLParser.TypeContext ctx);
}
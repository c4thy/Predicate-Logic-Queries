// Generated from QL.g by ANTLR 4.8
package ql;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, DAY=11, PRODUCT=12, SALE=13, MATRIX=14, SALES_FOR_M=15, SALES_FOR_D=16, 
		SALES_FOR_P=17, SIZE=18, FORALL=19, EXISTS=20, EQ=21, LT=22, GT=23, NEQ=24, 
		LTE=25, GTE=26, PLUS=27, MINUS=28, ASTRIX=29, SLASH=30, AMPER=31, AND=32, 
		OR=33, IMPLY=34, EQUIV=35, NOT=36, ID=37, NUMBER=38, LINE_COMMENT=39, 
		WS=40;
	public static final int
		RULE_start = 0, RULE_formula = 1, RULE_unConn = 2, RULE_binConn = 3, RULE_quantifier = 4, 
		RULE_var = 5, RULE_relSOp = 6, RULE_nExp = 7, RULE_binNOp = 8, RULE_relNOp = 9, 
		RULE_sExp = 10, RULE_binSOp = 11, RULE_type = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "formula", "unConn", "binConn", "quantifier", "var", "relSOp", 
			"nExp", "binNOp", "relNOp", "sExp", "binSOp", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'.'", "'('", "')'", "'['", "','", "']'", "'{'", "'|'", 
			"'}'", null, null, null, null, null, null, null, null, null, null, null, 
			"'<'", "'>'", "'!='", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "DAY", 
			"PRODUCT", "SALE", "MATRIX", "SALES_FOR_M", "SALES_FOR_D", "SALES_FOR_P", 
			"SIZE", "FORALL", "EXISTS", "EQ", "LT", "GT", "NEQ", "LTE", "GTE", "PLUS", 
			"MINUS", "ASTRIX", "SLASH", "AMPER", "AND", "OR", "IMPLY", "EQUIV", "NOT", 
			"ID", "NUMBER", "LINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "QL.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(QLParser.EOF, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public NExpContext nExp() {
			return getRuleContext(NExpContext.class,0);
		}
		public SExpContext sExp() {
			return getRuleContext(SExpContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(26);
				formula(0);
				}
				break;
			case 2:
				{
				setState(27);
				nExp(0);
				}
				break;
			case 3:
				{
				setState(28);
				sExp(0);
				}
				break;
			}
			setState(31);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QuantifiedContext extends FormulaContext {
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public QuantifiedContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuantified(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuantified(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuantified(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomicNContext extends FormulaContext {
		public List<NExpContext> nExp() {
			return getRuleContexts(NExpContext.class);
		}
		public NExpContext nExp(int i) {
			return getRuleContext(NExpContext.class,i);
		}
		public RelNOpContext relNOp() {
			return getRuleContext(RelNOpContext.class,0);
		}
		public AtomicNContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterAtomicN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitAtomicN(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitAtomicN(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public BinConnContext binConn() {
			return getRuleContext(BinConnContext.class,0);
		}
		public BinaryContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketedContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public BracketedContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBracketed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBracketed(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBracketed(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomicSContext extends FormulaContext {
		public List<SExpContext> sExp() {
			return getRuleContexts(SExpContext.class);
		}
		public SExpContext sExp(int i) {
			return getRuleContext(SExpContext.class,i);
		}
		public RelSOpContext relSOp() {
			return getRuleContext(RelSOpContext.class,0);
		}
		public AtomicSContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterAtomicS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitAtomicS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitAtomicS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryContext extends FormulaContext {
		public UnConnContext unConn() {
			return getRuleContext(UnConnContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public UnaryContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_formula, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new AtomicNContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(34);
				nExp(0);
				setState(35);
				relNOp();
				setState(36);
				nExp(0);
				}
				break;
			case 2:
				{
				_localctx = new AtomicSContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				sExp(0);
				setState(39);
				relSOp();
				setState(40);
				sExp(0);
				}
				break;
			case 3:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				unConn();
				setState(43);
				formula(4);
				}
				break;
			case 4:
				{
				_localctx = new QuantifiedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				quantifier();
				setState(46);
				var();
				setState(47);
				match(T__0);
				setState(48);
				type();
				setState(49);
				match(T__1);
				setState(50);
				formula(2);
				}
				break;
			case 5:
				{
				_localctx = new BracketedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(T__2);
				setState(53);
				formula(0);
				setState(54);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_formula);
					setState(58);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(59);
					binConn();
					setState(60);
					formula(4);
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnConnContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(QLParser.NOT, 0); }
		public UnConnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unConn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterUnConn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitUnConn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitUnConn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnConnContext unConn() throws RecognitionException {
		UnConnContext _localctx = new UnConnContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unConn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(NOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinConnContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(QLParser.AND, 0); }
		public TerminalNode OR() { return getToken(QLParser.OR, 0); }
		public TerminalNode IMPLY() { return getToken(QLParser.IMPLY, 0); }
		public TerminalNode EQUIV() { return getToken(QLParser.EQUIV, 0); }
		public BinConnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binConn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBinConn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBinConn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBinConn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinConnContext binConn() throws RecognitionException {
		BinConnContext _localctx = new BinConnContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_binConn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLY) | (1L << EQUIV))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierContext extends ParserRuleContext {
		public TerminalNode FORALL() { return getToken(QLParser.FORALL, 0); }
		public TerminalNode EXISTS() { return getToken(QLParser.EXISTS, 0); }
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_quantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !(_la==FORALL || _la==EXISTS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QLParser.ID, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelSOpContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(QLParser.EQ, 0); }
		public RelSOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relSOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterRelSOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitRelSOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitRelSOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelSOpContext relSOp() throws RecognitionException {
		RelSOpContext _localctx = new RelSOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_relSOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(EQ);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NExpContext extends ParserRuleContext {
		public NExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nExp; }
	 
		public NExpContext() { }
		public void copyFrom(NExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NatContext extends NExpContext {
		public TerminalNode NUMBER() { return getToken(QLParser.NUMBER, 0); }
		public NatContext(NExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterNat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitNat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitNat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarRefContext extends NExpContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarRefContext(NExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterVarRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitVarRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitVarRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SalesForPContext extends NExpContext {
		public TerminalNode SALES_FOR_P() { return getToken(QLParser.SALES_FOR_P, 0); }
		public TerminalNode MATRIX() { return getToken(QLParser.MATRIX, 0); }
		public NExpContext nExp() {
			return getRuleContext(NExpContext.class,0);
		}
		public SalesForPContext(NExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterSalesForP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitSalesForP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitSalesForP(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SalesForMContext extends NExpContext {
		public TerminalNode SALES_FOR_M() { return getToken(QLParser.SALES_FOR_M, 0); }
		public TerminalNode MATRIX() { return getToken(QLParser.MATRIX, 0); }
		public SalesForMContext(NExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterSalesForM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitSalesForM(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitSalesForM(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketedNExpContext extends NExpContext {
		public NExpContext nExp() {
			return getRuleContext(NExpContext.class,0);
		}
		public BracketedNExpContext(NExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBracketedNExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBracketedNExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBracketedNExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SalesAtContext extends NExpContext {
		public TerminalNode MATRIX() { return getToken(QLParser.MATRIX, 0); }
		public List<NExpContext> nExp() {
			return getRuleContexts(NExpContext.class);
		}
		public NExpContext nExp(int i) {
			return getRuleContext(NExpContext.class,i);
		}
		public SalesAtContext(NExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterSalesAt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitSalesAt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitSalesAt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryNExpContext extends NExpContext {
		public List<NExpContext> nExp() {
			return getRuleContexts(NExpContext.class);
		}
		public NExpContext nExp(int i) {
			return getRuleContext(NExpContext.class,i);
		}
		public BinNOpContext binNOp() {
			return getRuleContext(BinNOpContext.class,0);
		}
		public BinaryNExpContext(NExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBinaryNExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBinaryNExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBinaryNExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SalesForDContext extends NExpContext {
		public TerminalNode SALES_FOR_D() { return getToken(QLParser.SALES_FOR_D, 0); }
		public TerminalNode MATRIX() { return getToken(QLParser.MATRIX, 0); }
		public NExpContext nExp() {
			return getRuleContext(NExpContext.class,0);
		}
		public SalesForDContext(NExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterSalesForD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitSalesForD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitSalesForD(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SizeContext extends NExpContext {
		public TerminalNode SIZE() { return getToken(QLParser.SIZE, 0); }
		public SExpContext sExp() {
			return getRuleContext(SExpContext.class,0);
		}
		public SizeContext(NExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NExpContext nExp() throws RecognitionException {
		return nExp(0);
	}

	private NExpContext nExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NExpContext _localctx = new NExpContext(_ctx, _parentState);
		NExpContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_nExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				_localctx = new NatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(78);
				match(NUMBER);
				}
				break;
			case ID:
				{
				_localctx = new VarRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				var();
				}
				break;
			case MATRIX:
				{
				_localctx = new SalesAtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(MATRIX);
				setState(81);
				match(T__4);
				setState(82);
				nExp(0);
				setState(83);
				match(T__5);
				setState(84);
				nExp(0);
				setState(85);
				match(T__6);
				}
				break;
			case SALES_FOR_M:
				{
				_localctx = new SalesForMContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				match(SALES_FOR_M);
				setState(88);
				match(T__2);
				setState(89);
				match(MATRIX);
				setState(90);
				match(T__3);
				}
				break;
			case SALES_FOR_D:
				{
				_localctx = new SalesForDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(SALES_FOR_D);
				setState(92);
				match(T__2);
				setState(93);
				match(MATRIX);
				setState(94);
				match(T__5);
				setState(95);
				nExp(0);
				setState(96);
				match(T__3);
				}
				break;
			case SALES_FOR_P:
				{
				_localctx = new SalesForPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(SALES_FOR_P);
				setState(99);
				match(T__2);
				setState(100);
				match(MATRIX);
				setState(101);
				match(T__5);
				setState(102);
				nExp(0);
				setState(103);
				match(T__3);
				}
				break;
			case SIZE:
				{
				_localctx = new SizeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				match(SIZE);
				setState(106);
				match(T__2);
				setState(107);
				sExp(0);
				setState(108);
				match(T__3);
				}
				break;
			case T__2:
				{
				_localctx = new BracketedNExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				match(T__2);
				setState(111);
				nExp(0);
				setState(112);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryNExpContext(new NExpContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_nExp);
					setState(116);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(117);
					binNOp();
					setState(118);
					nExp(3);
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BinNOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(QLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(QLParser.MINUS, 0); }
		public TerminalNode ASTRIX() { return getToken(QLParser.ASTRIX, 0); }
		public TerminalNode SLASH() { return getToken(QLParser.SLASH, 0); }
		public BinNOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binNOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBinNOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBinNOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBinNOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinNOpContext binNOp() throws RecognitionException {
		BinNOpContext _localctx = new BinNOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_binNOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << ASTRIX) | (1L << SLASH))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelNOpContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(QLParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(QLParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(QLParser.LT, 0); }
		public TerminalNode LTE() { return getToken(QLParser.LTE, 0); }
		public TerminalNode GT() { return getToken(QLParser.GT, 0); }
		public TerminalNode GTE() { return getToken(QLParser.GTE, 0); }
		public RelNOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relNOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterRelNOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitRelNOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitRelNOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelNOpContext relNOp() throws RecognitionException {
		RelNOpContext _localctx = new RelNOpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_relNOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << LT) | (1L << GT) | (1L << NEQ) | (1L << LTE) | (1L << GTE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SExpContext extends ParserRuleContext {
		public SExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sExp; }
	 
		public SExpContext() { }
		public void copyFrom(SExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeRefContext extends SExpContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeRefContext(SExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitTypeRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitTypeRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketedSExpContext extends SExpContext {
		public SExpContext sExp() {
			return getRuleContext(SExpContext.class,0);
		}
		public BracketedSExpContext(SExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBracketedSExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBracketedSExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBracketedSExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetComprContext extends SExpContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public SetComprContext(SExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterSetCompr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitSetCompr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitSetCompr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinarySExpContext extends SExpContext {
		public List<SExpContext> sExp() {
			return getRuleContexts(SExpContext.class);
		}
		public SExpContext sExp(int i) {
			return getRuleContext(SExpContext.class,i);
		}
		public BinSOpContext binSOp() {
			return getRuleContext(BinSOpContext.class,0);
		}
		public BinarySExpContext(SExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBinarySExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBinarySExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBinarySExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SExpContext sExp() throws RecognitionException {
		return sExp(0);
	}

	private SExpContext sExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SExpContext _localctx = new SExpContext(_ctx, _parentState);
		SExpContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_sExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DAY:
			case PRODUCT:
			case SALE:
				{
				_localctx = new TypeRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(130);
				type();
				}
				break;
			case T__7:
				{
				_localctx = new SetComprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				match(T__7);
				setState(132);
				var();
				setState(133);
				match(T__0);
				setState(134);
				type();
				setState(135);
				match(T__8);
				setState(136);
				formula(0);
				setState(137);
				match(T__9);
				}
				break;
			case T__2:
				{
				_localctx = new BracketedSExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(T__2);
				setState(140);
				sExp(0);
				setState(141);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinarySExpContext(new SExpContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_sExp);
					setState(145);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(146);
					binSOp();
					setState(147);
					sExp(3);
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BinSOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(QLParser.PLUS, 0); }
		public TerminalNode AMPER() { return getToken(QLParser.AMPER, 0); }
		public TerminalNode MINUS() { return getToken(QLParser.MINUS, 0); }
		public BinSOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binSOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterBinSOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitBinSOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitBinSOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinSOpContext binSOp() throws RecognitionException {
		BinSOpContext _localctx = new BinSOpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_binSOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << AMPER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode DAY() { return getToken(QLParser.DAY, 0); }
		public TerminalNode PRODUCT() { return getToken(QLParser.PRODUCT, 0); }
		public TerminalNode SALE() { return getToken(QLParser.SALE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLListener ) ((QLListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QLVisitor ) return ((QLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DAY) | (1L << PRODUCT) | (1L << SALE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 7:
			return nExp_sempred((NExpContext)_localctx, predIndex);
		case 10:
			return sExp_sempred((SExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean nExp_sempred(NExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean sExp_sempred(SExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00a1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\5\2 \n\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3;\n\3\3\3\3\3\3\3\3\3\7\3A\n\3\f\3\16\3D\13\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tu\n\t\3\t\3\t\3\t\3\t\7\t{\n"+
		"\t\f\t\16\t~\13\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u0092\n\f\3\f\3\f\3\f\3\f\7\f\u0098\n\f\f\f"+
		"\16\f\u009b\13\f\3\r\3\r\3\16\3\16\3\16\2\5\4\20\26\17\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\2\b\3\2\"%\3\2\25\26\3\2\35 \3\2\27\34\4\2\35\36!!"+
		"\3\2\r\17\2\u00a6\2\37\3\2\2\2\4:\3\2\2\2\6E\3\2\2\2\bG\3\2\2\2\nI\3\2"+
		"\2\2\fK\3\2\2\2\16M\3\2\2\2\20t\3\2\2\2\22\177\3\2\2\2\24\u0081\3\2\2"+
		"\2\26\u0091\3\2\2\2\30\u009c\3\2\2\2\32\u009e\3\2\2\2\34 \5\4\3\2\35 "+
		"\5\20\t\2\36 \5\26\f\2\37\34\3\2\2\2\37\35\3\2\2\2\37\36\3\2\2\2\37 \3"+
		"\2\2\2 !\3\2\2\2!\"\7\2\2\3\"\3\3\2\2\2#$\b\3\1\2$%\5\20\t\2%&\5\24\13"+
		"\2&\'\5\20\t\2\';\3\2\2\2()\5\26\f\2)*\5\16\b\2*+\5\26\f\2+;\3\2\2\2,"+
		"-\5\6\4\2-.\5\4\3\6.;\3\2\2\2/\60\5\n\6\2\60\61\5\f\7\2\61\62\7\3\2\2"+
		"\62\63\5\32\16\2\63\64\7\4\2\2\64\65\5\4\3\4\65;\3\2\2\2\66\67\7\5\2\2"+
		"\678\5\4\3\289\7\6\2\29;\3\2\2\2:#\3\2\2\2:(\3\2\2\2:,\3\2\2\2:/\3\2\2"+
		"\2:\66\3\2\2\2;B\3\2\2\2<=\f\5\2\2=>\5\b\5\2>?\5\4\3\6?A\3\2\2\2@<\3\2"+
		"\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\5\3\2\2\2DB\3\2\2\2EF\7&\2\2F\7\3"+
		"\2\2\2GH\t\2\2\2H\t\3\2\2\2IJ\t\3\2\2J\13\3\2\2\2KL\7\'\2\2L\r\3\2\2\2"+
		"MN\7\27\2\2N\17\3\2\2\2OP\b\t\1\2Pu\7(\2\2Qu\5\f\7\2RS\7\20\2\2ST\7\7"+
		"\2\2TU\5\20\t\2UV\7\b\2\2VW\5\20\t\2WX\7\t\2\2Xu\3\2\2\2YZ\7\21\2\2Z["+
		"\7\5\2\2[\\\7\20\2\2\\u\7\6\2\2]^\7\22\2\2^_\7\5\2\2_`\7\20\2\2`a\7\b"+
		"\2\2ab\5\20\t\2bc\7\6\2\2cu\3\2\2\2de\7\23\2\2ef\7\5\2\2fg\7\20\2\2gh"+
		"\7\b\2\2hi\5\20\t\2ij\7\6\2\2ju\3\2\2\2kl\7\24\2\2lm\7\5\2\2mn\5\26\f"+
		"\2no\7\6\2\2ou\3\2\2\2pq\7\5\2\2qr\5\20\t\2rs\7\6\2\2su\3\2\2\2tO\3\2"+
		"\2\2tQ\3\2\2\2tR\3\2\2\2tY\3\2\2\2t]\3\2\2\2td\3\2\2\2tk\3\2\2\2tp\3\2"+
		"\2\2u|\3\2\2\2vw\f\4\2\2wx\5\22\n\2xy\5\20\t\5y{\3\2\2\2zv\3\2\2\2{~\3"+
		"\2\2\2|z\3\2\2\2|}\3\2\2\2}\21\3\2\2\2~|\3\2\2\2\177\u0080\t\4\2\2\u0080"+
		"\23\3\2\2\2\u0081\u0082\t\5\2\2\u0082\25\3\2\2\2\u0083\u0084\b\f\1\2\u0084"+
		"\u0092\5\32\16\2\u0085\u0086\7\n\2\2\u0086\u0087\5\f\7\2\u0087\u0088\7"+
		"\3\2\2\u0088\u0089\5\32\16\2\u0089\u008a\7\13\2\2\u008a\u008b\5\4\3\2"+
		"\u008b\u008c\7\f\2\2\u008c\u0092\3\2\2\2\u008d\u008e\7\5\2\2\u008e\u008f"+
		"\5\26\f\2\u008f\u0090\7\6\2\2\u0090\u0092\3\2\2\2\u0091\u0083\3\2\2\2"+
		"\u0091\u0085\3\2\2\2\u0091\u008d\3\2\2\2\u0092\u0099\3\2\2\2\u0093\u0094"+
		"\f\4\2\2\u0094\u0095\5\30\r\2\u0095\u0096\5\26\f\5\u0096\u0098\3\2\2\2"+
		"\u0097\u0093\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\27\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\t\6\2\2\u009d"+
		"\31\3\2\2\2\u009e\u009f\t\7\2\2\u009f\33\3\2\2\2\t\37:Bt|\u0091\u0099";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
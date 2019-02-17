// Generated from E:/ITB Stuff/Tugas Akhir/callGrapher/grammar\PhpParser.g4 by ANTLR 4.7
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PhpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SeaWhitespace=1, HtmlText=2, XmlStart=3, PHPStart=4, HtmlScriptOpen=5, 
		HtmlStyleOpen=6, HtmlComment=7, HtmlDtd=8, HtmlOpen=9, Shebang=10, Error=11, 
		XmlText=12, XmlClose=13, PHPStartInside=14, HtmlClose=15, HtmlSlashClose=16, 
		HtmlSlash=17, HtmlEquals=18, HtmlStartQuoteString=19, HtmlStartDoubleQuoteString=20, 
		HtmlHex=21, HtmlDecimal=22, HtmlSpace=23, HtmlName=24, ErrorInside=25, 
		PHPStartInsideQuoteString=26, HtmlEndQuoteString=27, HtmlQuoteString=28, 
		ErrorHtmlQuote=29, PHPStartDoubleQuoteString=30, HtmlEndDoubleQuoteString=31, 
		HtmlDoubleQuoteString=32, ErrorHtmlDoubleQuote=33, ScriptText=34, ScriptClose=35, 
		PHPStartInsideScript=36, StyleBody=37, PHPEnd=38, Whitespace=39, MultiLineComment=40, 
		SingleLineComment=41, ShellStyleComment=42, Abstract=43, Array=44, As=45, 
		BinaryCast=46, BoolType=47, BooleanConstant=48, Break=49, Callable=50, 
		Case=51, Catch=52, Class=53, Clone=54, Const=55, Continue=56, Declare=57, 
		Default=58, Do=59, DoubleCast=60, DoubleType=61, Echo=62, Else=63, ElseIf=64, 
		Empty=65, EndDeclare=66, EndFor=67, EndForeach=68, EndIf=69, EndSwitch=70, 
		EndWhile=71, Eval=72, Exit=73, Extends=74, Final=75, Finally=76, FloatCast=77, 
		For=78, Foreach=79, Function=80, Global=81, Goto=82, If=83, Implements=84, 
		Import=85, Include=86, IncludeOnce=87, InstanceOf=88, InsteadOf=89, Int8Cast=90, 
		Int16Cast=91, Int64Type=92, IntType=93, Interface=94, IsSet=95, List=96, 
		LogicalAnd=97, LogicalOr=98, LogicalXor=99, Namespace=100, New=101, Null=102, 
		ObjectType=103, Parent_=104, Partial=105, Print=106, Private=107, Protected=108, 
		Public=109, Require=110, RequireOnce=111, Resource=112, Return=113, Static=114, 
		StringType=115, Switch=116, Throw=117, Trait=118, Try=119, Typeof=120, 
		UintCast=121, UnicodeCast=122, Unset=123, Use=124, Var=125, While=126, 
		Yield=127, Get=128, Set=129, Call=130, CallStatic=131, Constructor=132, 
		Destruct=133, Wakeup=134, Sleep=135, Autoload=136, IsSet__=137, Unset__=138, 
		ToString__=139, Invoke=140, SetState=141, Clone__=142, DebugInfo=143, 
		Namespace__=144, Class__=145, Traic__=146, Function__=147, Method__=148, 
		Line__=149, File__=150, Dir__=151, Lgeneric=152, Rgeneric=153, DoubleArrow=154, 
		Inc=155, Dec=156, IsIdentical=157, IsNoidentical=158, IsEqual=159, IsNotEq=160, 
		IsSmallerOrEqual=161, IsGreaterOrEqual=162, PlusEqual=163, MinusEqual=164, 
		MulEqual=165, Pow=166, PowEqual=167, DivEqual=168, Concaequal=169, ModEqual=170, 
		ShiftLeftEqual=171, ShiftRightEqual=172, AndEqual=173, OrEqual=174, XorEqual=175, 
		BooleanOr=176, BooleanAnd=177, ShiftLeft=178, ShiftRight=179, DoubleColon=180, 
		ObjectOperator=181, NamespaceSeparator=182, Ellipsis=183, Less=184, Greater=185, 
		Ampersand=186, Pipe=187, Bang=188, Caret=189, Plus=190, Minus=191, Asterisk=192, 
		Percent=193, Divide=194, Tilde=195, SuppressWarnings=196, Dollar=197, 
		Dot=198, QuestionMark=199, OpenRoundBracket=200, CloseRoundBracket=201, 
		OpenSquareBracket=202, CloseSquareBracket=203, OpenCurlyBracket=204, CloseCurlyBracket=205, 
		Comma=206, Colon=207, SemiColon=208, Eq=209, Quote=210, BackQuote=211, 
		VarName=212, Label=213, Octal=214, Decimal=215, Real=216, Hex=217, Binary=218, 
		BackQuoteString=219, SingleQuoteString=220, DoubleQuote=221, StartNowDoc=222, 
		StartHereDoc=223, ErrorPhp=224, CurlyDollar=225, StringPart=226, Comment=227, 
		PHPEndSingleLineComment=228, CommentEnd=229, HereDocText=230, XmlText2=231;
	public static final int
		RULE_start = 0, RULE_htmlDocument = 1, RULE_htmlElementOrPhpBlock = 2, 
		RULE_htmlElements = 3, RULE_htmlElement = 4, RULE_scriptTextPart = 5, 
		RULE_phpBlock = 6, RULE_importStatement = 7, RULE_topStatement = 8, RULE_useDeclaration = 9, 
		RULE_useDeclarationContentList = 10, RULE_useDeclarationContent = 11, 
		RULE_namespaceDeclaration = 12, RULE_namespaceStatement = 13, RULE_functionDeclaration = 14, 
		RULE_classDeclaration = 15, RULE_classEntryType = 16, RULE_interfaceList = 17, 
		RULE_typeParameterListInBrackets = 18, RULE_typeParameterList = 19, RULE_typeParameterWithDefaultsList = 20, 
		RULE_typeParameterDecl = 21, RULE_typeParameterWithDefaultDecl = 22, RULE_genericDynamicArgs = 23, 
		RULE_attributes = 24, RULE_attributesGroup = 25, RULE_attribute = 26, 
		RULE_attributeArgList = 27, RULE_attributeNamedArgList = 28, RULE_attributeNamedArg = 29, 
		RULE_innerStatementList = 30, RULE_innerStatement = 31, RULE_statement = 32, 
		RULE_emptyStatement = 33, RULE_blockStatement = 34, RULE_ifStatement = 35, 
		RULE_elseIfStatement = 36, RULE_elseIfColonStatement = 37, RULE_elseStatement = 38, 
		RULE_elseColonStatement = 39, RULE_whileStatement = 40, RULE_doWhileStatement = 41, 
		RULE_forStatement = 42, RULE_forInit = 43, RULE_forUpdate = 44, RULE_switchStatement = 45, 
		RULE_switchBlock = 46, RULE_breakStatement = 47, RULE_continueStatement = 48, 
		RULE_returnStatement = 49, RULE_expressionStatement = 50, RULE_unsetStatement = 51, 
		RULE_foreachStatement = 52, RULE_tryCatchFinally = 53, RULE_catchClause = 54, 
		RULE_finallyStatement = 55, RULE_throwStatement = 56, RULE_gotoStatement = 57, 
		RULE_declareStatement = 58, RULE_inlineHtmlStatement = 59, RULE_inlineHtml = 60, 
		RULE_declareList = 61, RULE_formalParameterList = 62, RULE_formalParameter = 63, 
		RULE_typeHint = 64, RULE_globalStatement = 65, RULE_globalVar = 66, RULE_echoStatement = 67, 
		RULE_staticVariableStatement = 68, RULE_classStatement = 69, RULE_traitAdaptations = 70, 
		RULE_traitAdaptationStatement = 71, RULE_traitPrecedence = 72, RULE_traitAlias = 73, 
		RULE_traitMethodReference = 74, RULE_baseCtorCall = 75, RULE_methodBody = 76, 
		RULE_propertyModifiers = 77, RULE_memberModifiers = 78, RULE_variableInitializer = 79, 
		RULE_identifierInititalizer = 80, RULE_globalConstantDeclaration = 81, 
		RULE_expressionList = 82, RULE_parenthesis = 83, RULE_expression = 84, 
		RULE_newExpr = 85, RULE_assignmentOperator = 86, RULE_yieldExpression = 87, 
		RULE_arrayItemList = 88, RULE_arrayItem = 89, RULE_lambdaFunctionUseVars = 90, 
		RULE_lambdaFunctionUseVar = 91, RULE_qualifiedStaticTypeRef = 92, RULE_typeRef = 93, 
		RULE_indirectTypeRef = 94, RULE_qualifiedNamespaceName = 95, RULE_namespaceNameList = 96, 
		RULE_qualifiedNamespaceNameList = 97, RULE_arguments = 98, RULE_actualArgument = 99, 
		RULE_constantInititalizer = 100, RULE_constantArrayItemList = 101, RULE_constantArrayItem = 102, 
		RULE_constant = 103, RULE_literalConstant = 104, RULE_numericConstant = 105, 
		RULE_classConstant = 106, RULE_stringConstant = 107, RULE_string = 108, 
		RULE_interpolatedStringPart = 109, RULE_chainList = 110, RULE_chain = 111, 
		RULE_memberAccess = 112, RULE_functionCall = 113, RULE_functionCallName = 114, 
		RULE_actualArguments = 115, RULE_chainBase = 116, RULE_keyedFieldName = 117, 
		RULE_keyedSimpleFieldName = 118, RULE_keyedVariable = 119, RULE_squareCurlyExpression = 120, 
		RULE_assignmentList = 121, RULE_assignmentListElement = 122, RULE_modifier = 123, 
		RULE_identifier = 124, RULE_memberModifier = 125, RULE_magicConstant = 126, 
		RULE_magicMethod = 127, RULE_primitiveType = 128, RULE_castOperation = 129;
	public static final String[] ruleNames = {
		"start", "htmlDocument", "htmlElementOrPhpBlock", "htmlElements", "htmlElement", 
		"scriptTextPart", "phpBlock", "importStatement", "topStatement", "useDeclaration", 
		"useDeclarationContentList", "useDeclarationContent", "namespaceDeclaration", 
		"namespaceStatement", "functionDeclaration", "classDeclaration", "classEntryType", 
		"interfaceList", "typeParameterListInBrackets", "typeParameterList", "typeParameterWithDefaultsList", 
		"typeParameterDecl", "typeParameterWithDefaultDecl", "genericDynamicArgs", 
		"attributes", "attributesGroup", "attribute", "attributeArgList", "attributeNamedArgList", 
		"attributeNamedArg", "innerStatementList", "innerStatement", "statement", 
		"emptyStatement", "blockStatement", "ifStatement", "elseIfStatement", 
		"elseIfColonStatement", "elseStatement", "elseColonStatement", "whileStatement", 
		"doWhileStatement", "forStatement", "forInit", "forUpdate", "switchStatement", 
		"switchBlock", "breakStatement", "continueStatement", "returnStatement", 
		"expressionStatement", "unsetStatement", "foreachStatement", "tryCatchFinally", 
		"catchClause", "finallyStatement", "throwStatement", "gotoStatement", 
		"declareStatement", "inlineHtmlStatement", "inlineHtml", "declareList", 
		"formalParameterList", "formalParameter", "typeHint", "globalStatement", 
		"globalVar", "echoStatement", "staticVariableStatement", "classStatement", 
		"traitAdaptations", "traitAdaptationStatement", "traitPrecedence", "traitAlias", 
		"traitMethodReference", "baseCtorCall", "methodBody", "propertyModifiers", 
		"memberModifiers", "variableInitializer", "identifierInititalizer", "globalConstantDeclaration", 
		"expressionList", "parenthesis", "expression", "newExpr", "assignmentOperator", 
		"yieldExpression", "arrayItemList", "arrayItem", "lambdaFunctionUseVars", 
		"lambdaFunctionUseVar", "qualifiedStaticTypeRef", "typeRef", "indirectTypeRef", 
		"qualifiedNamespaceName", "namespaceNameList", "qualifiedNamespaceNameList", 
		"arguments", "actualArgument", "constantInititalizer", "constantArrayItemList", 
		"constantArrayItem", "constant", "literalConstant", "numericConstant", 
		"classConstant", "stringConstant", "string", "interpolatedStringPart", 
		"chainList", "chain", "memberAccess", "functionCall", "functionCallName", 
		"actualArguments", "chainBase", "keyedFieldName", "keyedSimpleFieldName", 
		"keyedVariable", "squareCurlyExpression", "assignmentList", "assignmentListElement", 
		"modifier", "identifier", "memberModifier", "magicConstant", "magicMethod", 
		"primitiveType", "castOperation"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "'/>'", null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "'abstract'", "'array'", "'as'", 
		"'binary'", null, null, "'break'", "'callable'", "'case'", "'catch'", 
		"'class'", "'clone'", "'const'", "'continue'", "'declare'", "'default'", 
		"'do'", "'real'", "'double'", "'echo'", "'else'", "'elseif'", "'empty'", 
		"'enddeclare'", "'endfor'", "'endforeach'", "'endif'", "'endswitch'", 
		"'endwhile'", "'eval'", "'die'", "'extends'", "'final'", "'finally'", 
		"'float'", "'for'", "'foreach'", "'function'", "'global'", "'goto'", "'if'", 
		"'implements'", "'import'", "'include'", "'include_once'", "'instanceof'", 
		"'insteadof'", "'int8'", "'int16'", "'int64'", null, "'interface'", "'isset'", 
		"'list'", "'and'", "'or'", "'xor'", "'namespace'", "'new'", "'null'", 
		"'object'", "'parent'", "'partial'", "'print'", "'private'", "'protected'", 
		"'public'", "'require'", "'require_once'", "'resource'", "'return'", "'static'", 
		"'string'", "'switch'", "'throw'", "'trait'", "'try'", "'clrtypeof'", 
		null, "'unicode'", "'unset'", "'use'", "'var'", "'while'", "'yield'", 
		"'__get'", "'__set'", "'__call'", "'__callstatic'", "'__construct'", "'__destruct'", 
		"'__wakeup'", "'__sleep'", "'__autoload'", "'__isset'", "'__unset'", "'__tostring'", 
		"'__invoke'", "'__set_state'", "'__clone'", "'__debuginfo'", "'__namespace__'", 
		"'__class__'", "'__trait__'", "'__function__'", "'__method__'", "'__line__'", 
		"'__file__'", "'__dir__'", "'<:'", "':>'", "'=>'", "'++'", "'--'", "'==='", 
		"'!=='", "'=='", null, "'<='", "'>='", "'+='", "'-='", "'*='", "'**'", 
		"'**='", "'/='", "'.='", "'%='", "'<<='", "'>>='", "'&='", "'|='", "'^='", 
		"'||'", "'&&'", "'<<'", "'>>'", "'::'", "'->'", "'\\'", "'...'", null, 
		null, "'&'", "'|'", "'!'", "'^'", "'+'", "'-'", "'*'", "'%'", null, "'~'", 
		"'@'", null, "'.'", null, "'('", "')'", "'['", "']'", null, "'}'", "','", 
		"':'", "';'", null, "'''", "'`'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SeaWhitespace", "HtmlText", "XmlStart", "PHPStart", "HtmlScriptOpen", 
		"HtmlStyleOpen", "HtmlComment", "HtmlDtd", "HtmlOpen", "Shebang", "Error", 
		"XmlText", "XmlClose", "PHPStartInside", "HtmlClose", "HtmlSlashClose", 
		"HtmlSlash", "HtmlEquals", "HtmlStartQuoteString", "HtmlStartDoubleQuoteString", 
		"HtmlHex", "HtmlDecimal", "HtmlSpace", "HtmlName", "ErrorInside", "PHPStartInsideQuoteString", 
		"HtmlEndQuoteString", "HtmlQuoteString", "ErrorHtmlQuote", "PHPStartDoubleQuoteString", 
		"HtmlEndDoubleQuoteString", "HtmlDoubleQuoteString", "ErrorHtmlDoubleQuote", 
		"ScriptText", "ScriptClose", "PHPStartInsideScript", "StyleBody", "PHPEnd", 
		"Whitespace", "MultiLineComment", "SingleLineComment", "ShellStyleComment", 
		"Abstract", "Array", "As", "BinaryCast", "BoolType", "BooleanConstant", 
		"Break", "Callable", "Case", "Catch", "Class", "Clone", "Const", "Continue", 
		"Declare", "Default", "Do", "DoubleCast", "DoubleType", "Echo", "Else", 
		"ElseIf", "Empty", "EndDeclare", "EndFor", "EndForeach", "EndIf", "EndSwitch", 
		"EndWhile", "Eval", "Exit", "Extends", "Final", "Finally", "FloatCast", 
		"For", "Foreach", "Function", "Global", "Goto", "If", "Implements", "Import", 
		"Include", "IncludeOnce", "InstanceOf", "InsteadOf", "Int8Cast", "Int16Cast", 
		"Int64Type", "IntType", "Interface", "IsSet", "List", "LogicalAnd", "LogicalOr", 
		"LogicalXor", "Namespace", "New", "Null", "ObjectType", "Parent_", "Partial", 
		"Print", "Private", "Protected", "Public", "Require", "RequireOnce", "Resource", 
		"Return", "Static", "StringType", "Switch", "Throw", "Trait", "Try", "Typeof", 
		"UintCast", "UnicodeCast", "Unset", "Use", "Var", "While", "Yield", "Get", 
		"Set", "Call", "CallStatic", "Constructor", "Destruct", "Wakeup", "Sleep", 
		"Autoload", "IsSet__", "Unset__", "ToString__", "Invoke", "SetState", 
		"Clone__", "DebugInfo", "Namespace__", "Class__", "Traic__", "Function__", 
		"Method__", "Line__", "File__", "Dir__", "Lgeneric", "Rgeneric", "DoubleArrow", 
		"Inc", "Dec", "IsIdentical", "IsNoidentical", "IsEqual", "IsNotEq", "IsSmallerOrEqual", 
		"IsGreaterOrEqual", "PlusEqual", "MinusEqual", "MulEqual", "Pow", "PowEqual", 
		"DivEqual", "Concaequal", "ModEqual", "ShiftLeftEqual", "ShiftRightEqual", 
		"AndEqual", "OrEqual", "XorEqual", "BooleanOr", "BooleanAnd", "ShiftLeft", 
		"ShiftRight", "DoubleColon", "ObjectOperator", "NamespaceSeparator", "Ellipsis", 
		"Less", "Greater", "Ampersand", "Pipe", "Bang", "Caret", "Plus", "Minus", 
		"Asterisk", "Percent", "Divide", "Tilde", "SuppressWarnings", "Dollar", 
		"Dot", "QuestionMark", "OpenRoundBracket", "CloseRoundBracket", "OpenSquareBracket", 
		"CloseSquareBracket", "OpenCurlyBracket", "CloseCurlyBracket", "Comma", 
		"Colon", "SemiColon", "Eq", "Quote", "BackQuote", "VarName", "Label", 
		"Octal", "Decimal", "Real", "Hex", "Binary", "BackQuoteString", "SingleQuoteString", 
		"DoubleQuote", "StartNowDoc", "StartHereDoc", "ErrorPhp", "CurlyDollar", 
		"StringPart", "Comment", "PHPEndSingleLineComment", "CommentEnd", "HereDocText", 
		"XmlText2"
	};
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
	public String getGrammarFileName() { return "PhpParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PhpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public HtmlDocumentContext htmlDocument() {
			return getRuleContext(HtmlDocumentContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			htmlDocument();
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

	public static class HtmlDocumentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PhpParser.EOF, 0); }
		public TerminalNode Shebang() { return getToken(PhpParser.Shebang, 0); }
		public List<HtmlElementOrPhpBlockContext> htmlElementOrPhpBlock() {
			return getRuleContexts(HtmlElementOrPhpBlockContext.class);
		}
		public HtmlElementOrPhpBlockContext htmlElementOrPhpBlock(int i) {
			return getRuleContext(HtmlElementOrPhpBlockContext.class,i);
		}
		public HtmlDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlDocument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterHtmlDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitHtmlDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitHtmlDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlDocumentContext htmlDocument() throws RecognitionException {
		HtmlDocumentContext _localctx = new HtmlDocumentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_htmlDocument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Shebang) {
				{
				setState(262);
				match(Shebang);
				}
			}

			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HtmlText) | (1L << XmlStart) | (1L << HtmlScriptOpen) | (1L << HtmlStyleOpen) | (1L << HtmlDtd) | (1L << HtmlOpen) | (1L << HtmlClose) | (1L << HtmlSlashClose) | (1L << HtmlSlash) | (1L << HtmlEquals) | (1L << HtmlStartQuoteString) | (1L << HtmlStartDoubleQuoteString) | (1L << HtmlHex) | (1L << HtmlDecimal) | (1L << HtmlName) | (1L << HtmlEndQuoteString) | (1L << HtmlQuoteString) | (1L << HtmlEndDoubleQuoteString) | (1L << HtmlDoubleQuoteString) | (1L << ScriptText) | (1L << ScriptClose) | (1L << StyleBody) | (1L << Abstract) | (1L << Array) | (1L << As) | (1L << BinaryCast) | (1L << BoolType) | (1L << BooleanConstant) | (1L << Break) | (1L << Callable) | (1L << Case) | (1L << Catch) | (1L << Class) | (1L << Clone) | (1L << Const) | (1L << Continue) | (1L << Declare) | (1L << Default) | (1L << Do) | (1L << DoubleCast) | (1L << DoubleType) | (1L << Echo) | (1L << Else))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ElseIf - 64)) | (1L << (Empty - 64)) | (1L << (EndDeclare - 64)) | (1L << (EndFor - 64)) | (1L << (EndForeach - 64)) | (1L << (EndIf - 64)) | (1L << (EndSwitch - 64)) | (1L << (EndWhile - 64)) | (1L << (Eval - 64)) | (1L << (Exit - 64)) | (1L << (Extends - 64)) | (1L << (Final - 64)) | (1L << (Finally - 64)) | (1L << (FloatCast - 64)) | (1L << (For - 64)) | (1L << (Foreach - 64)) | (1L << (Function - 64)) | (1L << (Global - 64)) | (1L << (Goto - 64)) | (1L << (If - 64)) | (1L << (Implements - 64)) | (1L << (Import - 64)) | (1L << (Include - 64)) | (1L << (IncludeOnce - 64)) | (1L << (InstanceOf - 64)) | (1L << (InsteadOf - 64)) | (1L << (Int8Cast - 64)) | (1L << (Int16Cast - 64)) | (1L << (Int64Type - 64)) | (1L << (IntType - 64)) | (1L << (Interface - 64)) | (1L << (IsSet - 64)) | (1L << (List - 64)) | (1L << (LogicalAnd - 64)) | (1L << (LogicalOr - 64)) | (1L << (LogicalXor - 64)) | (1L << (Namespace - 64)) | (1L << (New - 64)) | (1L << (Null - 64)) | (1L << (ObjectType - 64)) | (1L << (Parent_ - 64)) | (1L << (Partial - 64)) | (1L << (Print - 64)) | (1L << (Private - 64)) | (1L << (Protected - 64)) | (1L << (Public - 64)) | (1L << (Require - 64)) | (1L << (RequireOnce - 64)) | (1L << (Resource - 64)) | (1L << (Return - 64)) | (1L << (Static - 64)) | (1L << (StringType - 64)) | (1L << (Switch - 64)) | (1L << (Throw - 64)) | (1L << (Trait - 64)) | (1L << (Try - 64)) | (1L << (Typeof - 64)) | (1L << (UintCast - 64)) | (1L << (UnicodeCast - 64)) | (1L << (Unset - 64)) | (1L << (Use - 64)) | (1L << (Var - 64)) | (1L << (While - 64)) | (1L << (Yield - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (Get - 128)) | (1L << (Set - 128)) | (1L << (Call - 128)) | (1L << (CallStatic - 128)) | (1L << (Constructor - 128)) | (1L << (Destruct - 128)) | (1L << (Wakeup - 128)) | (1L << (Sleep - 128)) | (1L << (Autoload - 128)) | (1L << (IsSet__ - 128)) | (1L << (Unset__ - 128)) | (1L << (ToString__ - 128)) | (1L << (Invoke - 128)) | (1L << (SetState - 128)) | (1L << (Clone__ - 128)) | (1L << (DebugInfo - 128)) | (1L << (Namespace__ - 128)) | (1L << (Class__ - 128)) | (1L << (Traic__ - 128)) | (1L << (Function__ - 128)) | (1L << (Method__ - 128)) | (1L << (Line__ - 128)) | (1L << (File__ - 128)) | (1L << (Dir__ - 128)) | (1L << (Inc - 128)) | (1L << (Dec - 128)) | (1L << (NamespaceSeparator - 128)) | (1L << (Bang - 128)) | (1L << (Plus - 128)) | (1L << (Minus - 128)))) != 0) || ((((_la - 195)) & ~0x3f) == 0 && ((1L << (_la - 195)) & ((1L << (Tilde - 195)) | (1L << (SuppressWarnings - 195)) | (1L << (Dollar - 195)) | (1L << (OpenRoundBracket - 195)) | (1L << (OpenSquareBracket - 195)) | (1L << (OpenCurlyBracket - 195)) | (1L << (SemiColon - 195)) | (1L << (VarName - 195)) | (1L << (Label - 195)) | (1L << (Octal - 195)) | (1L << (Decimal - 195)) | (1L << (Real - 195)) | (1L << (Hex - 195)) | (1L << (Binary - 195)) | (1L << (BackQuoteString - 195)) | (1L << (SingleQuoteString - 195)) | (1L << (DoubleQuote - 195)) | (1L << (StartNowDoc - 195)) | (1L << (StartHereDoc - 195)))) != 0)) {
				{
				{
				setState(265);
				htmlElementOrPhpBlock();
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(271);
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

	public static class HtmlElementOrPhpBlockContext extends ParserRuleContext {
		public HtmlElementsContext htmlElements() {
			return getRuleContext(HtmlElementsContext.class,0);
		}
		public PhpBlockContext phpBlock() {
			return getRuleContext(PhpBlockContext.class,0);
		}
		public ScriptTextPartContext scriptTextPart() {
			return getRuleContext(ScriptTextPartContext.class,0);
		}
		public HtmlElementOrPhpBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElementOrPhpBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterHtmlElementOrPhpBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitHtmlElementOrPhpBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitHtmlElementOrPhpBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementOrPhpBlockContext htmlElementOrPhpBlock() throws RecognitionException {
		HtmlElementOrPhpBlockContext _localctx = new HtmlElementOrPhpBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlElementOrPhpBlock);
		try {
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				htmlElements();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				phpBlock();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(275);
				scriptTextPart();
				}
				break;
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

	public static class HtmlElementsContext extends ParserRuleContext {
		public List<HtmlElementContext> htmlElement() {
			return getRuleContexts(HtmlElementContext.class);
		}
		public HtmlElementContext htmlElement(int i) {
			return getRuleContext(HtmlElementContext.class,i);
		}
		public HtmlElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterHtmlElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitHtmlElements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitHtmlElements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementsContext htmlElements() throws RecognitionException {
		HtmlElementsContext _localctx = new HtmlElementsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_htmlElements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(278);
					htmlElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(281); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class HtmlElementContext extends ParserRuleContext {
		public TerminalNode HtmlDtd() { return getToken(PhpParser.HtmlDtd, 0); }
		public TerminalNode HtmlScriptOpen() { return getToken(PhpParser.HtmlScriptOpen, 0); }
		public TerminalNode HtmlClose() { return getToken(PhpParser.HtmlClose, 0); }
		public TerminalNode HtmlStyleOpen() { return getToken(PhpParser.HtmlStyleOpen, 0); }
		public TerminalNode HtmlOpen() { return getToken(PhpParser.HtmlOpen, 0); }
		public TerminalNode HtmlName() { return getToken(PhpParser.HtmlName, 0); }
		public TerminalNode HtmlSlashClose() { return getToken(PhpParser.HtmlSlashClose, 0); }
		public TerminalNode HtmlSlash() { return getToken(PhpParser.HtmlSlash, 0); }
		public TerminalNode HtmlText() { return getToken(PhpParser.HtmlText, 0); }
		public TerminalNode HtmlEquals() { return getToken(PhpParser.HtmlEquals, 0); }
		public TerminalNode HtmlStartQuoteString() { return getToken(PhpParser.HtmlStartQuoteString, 0); }
		public TerminalNode HtmlEndQuoteString() { return getToken(PhpParser.HtmlEndQuoteString, 0); }
		public TerminalNode HtmlStartDoubleQuoteString() { return getToken(PhpParser.HtmlStartDoubleQuoteString, 0); }
		public TerminalNode HtmlEndDoubleQuoteString() { return getToken(PhpParser.HtmlEndDoubleQuoteString, 0); }
		public TerminalNode HtmlHex() { return getToken(PhpParser.HtmlHex, 0); }
		public TerminalNode HtmlDecimal() { return getToken(PhpParser.HtmlDecimal, 0); }
		public TerminalNode HtmlQuoteString() { return getToken(PhpParser.HtmlQuoteString, 0); }
		public TerminalNode HtmlDoubleQuoteString() { return getToken(PhpParser.HtmlDoubleQuoteString, 0); }
		public TerminalNode StyleBody() { return getToken(PhpParser.StyleBody, 0); }
		public TerminalNode ScriptClose() { return getToken(PhpParser.ScriptClose, 0); }
		public TerminalNode XmlStart() { return getToken(PhpParser.XmlStart, 0); }
		public TerminalNode XmlClose() { return getToken(PhpParser.XmlClose, 0); }
		public List<TerminalNode> XmlText() { return getTokens(PhpParser.XmlText); }
		public TerminalNode XmlText(int i) {
			return getToken(PhpParser.XmlText, i);
		}
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterHtmlElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitHtmlElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitHtmlElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_htmlElement);
		int _la;
		try {
			setState(311);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlDtd:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				match(HtmlDtd);
				}
				break;
			case HtmlScriptOpen:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				match(HtmlScriptOpen);
				}
				break;
			case HtmlClose:
				enterOuterAlt(_localctx, 3);
				{
				setState(285);
				match(HtmlClose);
				}
				break;
			case HtmlStyleOpen:
				enterOuterAlt(_localctx, 4);
				{
				setState(286);
				match(HtmlStyleOpen);
				}
				break;
			case HtmlOpen:
				enterOuterAlt(_localctx, 5);
				{
				setState(287);
				match(HtmlOpen);
				}
				break;
			case HtmlName:
				enterOuterAlt(_localctx, 6);
				{
				setState(288);
				match(HtmlName);
				}
				break;
			case HtmlSlashClose:
				enterOuterAlt(_localctx, 7);
				{
				setState(289);
				match(HtmlSlashClose);
				}
				break;
			case HtmlSlash:
				enterOuterAlt(_localctx, 8);
				{
				setState(290);
				match(HtmlSlash);
				}
				break;
			case HtmlText:
				enterOuterAlt(_localctx, 9);
				{
				setState(291);
				match(HtmlText);
				}
				break;
			case HtmlEquals:
				enterOuterAlt(_localctx, 10);
				{
				setState(292);
				match(HtmlEquals);
				}
				break;
			case HtmlStartQuoteString:
				enterOuterAlt(_localctx, 11);
				{
				setState(293);
				match(HtmlStartQuoteString);
				}
				break;
			case HtmlEndQuoteString:
				enterOuterAlt(_localctx, 12);
				{
				setState(294);
				match(HtmlEndQuoteString);
				}
				break;
			case HtmlStartDoubleQuoteString:
				enterOuterAlt(_localctx, 13);
				{
				setState(295);
				match(HtmlStartDoubleQuoteString);
				}
				break;
			case HtmlEndDoubleQuoteString:
				enterOuterAlt(_localctx, 14);
				{
				setState(296);
				match(HtmlEndDoubleQuoteString);
				}
				break;
			case HtmlHex:
				enterOuterAlt(_localctx, 15);
				{
				setState(297);
				match(HtmlHex);
				}
				break;
			case HtmlDecimal:
				enterOuterAlt(_localctx, 16);
				{
				setState(298);
				match(HtmlDecimal);
				}
				break;
			case HtmlQuoteString:
				enterOuterAlt(_localctx, 17);
				{
				setState(299);
				match(HtmlQuoteString);
				}
				break;
			case HtmlDoubleQuoteString:
				enterOuterAlt(_localctx, 18);
				{
				setState(300);
				match(HtmlDoubleQuoteString);
				}
				break;
			case StyleBody:
				enterOuterAlt(_localctx, 19);
				{
				setState(301);
				match(StyleBody);
				}
				break;
			case ScriptClose:
				enterOuterAlt(_localctx, 20);
				{
				setState(302);
				match(ScriptClose);
				}
				break;
			case XmlStart:
				enterOuterAlt(_localctx, 21);
				{
				setState(303);
				match(XmlStart);
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==XmlText) {
					{
					{
					setState(304);
					match(XmlText);
					}
					}
					setState(309);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(310);
				match(XmlClose);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ScriptTextPartContext extends ParserRuleContext {
		public List<TerminalNode> ScriptText() { return getTokens(PhpParser.ScriptText); }
		public TerminalNode ScriptText(int i) {
			return getToken(PhpParser.ScriptText, i);
		}
		public ScriptTextPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptTextPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterScriptTextPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitScriptTextPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitScriptTextPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScriptTextPartContext scriptTextPart() throws RecognitionException {
		ScriptTextPartContext _localctx = new ScriptTextPartContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_scriptTextPart);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(313);
					match(ScriptText);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(316); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class PhpBlockContext extends ParserRuleContext {
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public List<TopStatementContext> topStatement() {
			return getRuleContexts(TopStatementContext.class);
		}
		public TopStatementContext topStatement(int i) {
			return getRuleContext(TopStatementContext.class,i);
		}
		public PhpBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phpBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPhpBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPhpBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitPhpBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhpBlockContext phpBlock() throws RecognitionException {
		PhpBlockContext _localctx = new PhpBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_phpBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(318);
					importStatement();
					}
					} 
				}
				setState(323);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(325); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(324);
					topStatement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(327); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode Import() { return getToken(PhpParser.Import, 0); }
		public TerminalNode Namespace() { return getToken(PhpParser.Namespace, 0); }
		public NamespaceNameListContext namespaceNameList() {
			return getRuleContext(NamespaceNameListContext.class,0);
		}
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitImportStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitImportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_importStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(Import);
			setState(330);
			match(Namespace);
			setState(331);
			namespaceNameList();
			setState(332);
			match(SemiColon);
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

	public static class TopStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public UseDeclarationContext useDeclaration() {
			return getRuleContext(UseDeclarationContext.class,0);
		}
		public NamespaceDeclarationContext namespaceDeclaration() {
			return getRuleContext(NamespaceDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public GlobalConstantDeclarationContext globalConstantDeclaration() {
			return getRuleContext(GlobalConstantDeclarationContext.class,0);
		}
		public TopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopStatementContext topStatement() throws RecognitionException {
		TopStatementContext _localctx = new TopStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_topStatement);
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				useDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(336);
				namespaceDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(337);
				functionDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(338);
				classDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(339);
				globalConstantDeclaration();
				}
				break;
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

	public static class UseDeclarationContext extends ParserRuleContext {
		public TerminalNode Use() { return getToken(PhpParser.Use, 0); }
		public UseDeclarationContentListContext useDeclarationContentList() {
			return getRuleContext(UseDeclarationContentListContext.class,0);
		}
		public TerminalNode Function() { return getToken(PhpParser.Function, 0); }
		public TerminalNode Const() { return getToken(PhpParser.Const, 0); }
		public UseDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterUseDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitUseDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitUseDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UseDeclarationContext useDeclaration() throws RecognitionException {
		UseDeclarationContext _localctx = new UseDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_useDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(Use);
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(343);
				_la = _input.LA(1);
				if ( !(_la==Const || _la==Function) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(346);
			useDeclarationContentList();
			setState(347);
			match(SemiColon);
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

	public static class UseDeclarationContentListContext extends ParserRuleContext {
		public List<UseDeclarationContentContext> useDeclarationContent() {
			return getRuleContexts(UseDeclarationContentContext.class);
		}
		public UseDeclarationContentContext useDeclarationContent(int i) {
			return getRuleContext(UseDeclarationContentContext.class,i);
		}
		public UseDeclarationContentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useDeclarationContentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterUseDeclarationContentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitUseDeclarationContentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitUseDeclarationContentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UseDeclarationContentListContext useDeclarationContentList() throws RecognitionException {
		UseDeclarationContentListContext _localctx = new UseDeclarationContentListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_useDeclarationContentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NamespaceSeparator) {
				{
				setState(349);
				match(NamespaceSeparator);
				}
			}

			setState(352);
			useDeclarationContent();
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(353);
				match(Comma);
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NamespaceSeparator) {
					{
					setState(354);
					match(NamespaceSeparator);
					}
				}

				setState(357);
				useDeclarationContent();
				}
				}
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class UseDeclarationContentContext extends ParserRuleContext {
		public NamespaceNameListContext namespaceNameList() {
			return getRuleContext(NamespaceNameListContext.class,0);
		}
		public TerminalNode As() { return getToken(PhpParser.As, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public UseDeclarationContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useDeclarationContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterUseDeclarationContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitUseDeclarationContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitUseDeclarationContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UseDeclarationContentContext useDeclarationContent() throws RecognitionException {
		UseDeclarationContentContext _localctx = new UseDeclarationContentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_useDeclarationContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			namespaceNameList();
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==As) {
				{
				setState(364);
				match(As);
				setState(365);
				identifier();
				}
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

	public static class NamespaceDeclarationContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(PhpParser.Namespace, 0); }
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public NamespaceNameListContext namespaceNameList() {
			return getRuleContext(NamespaceNameListContext.class,0);
		}
		public List<NamespaceStatementContext> namespaceStatement() {
			return getRuleContexts(NamespaceStatementContext.class);
		}
		public NamespaceStatementContext namespaceStatement(int i) {
			return getRuleContext(NamespaceStatementContext.class,i);
		}
		public NamespaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNamespaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNamespaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitNamespaceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceDeclarationContext namespaceDeclaration() throws RecognitionException {
		NamespaceDeclarationContext _localctx = new NamespaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_namespaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(Namespace);
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)))) != 0) || _la==Label) {
					{
					setState(369);
					namespaceNameList();
					}
				}

				setState(372);
				match(OpenCurlyBracket);
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HtmlText) | (1L << XmlStart) | (1L << HtmlScriptOpen) | (1L << HtmlStyleOpen) | (1L << HtmlDtd) | (1L << HtmlOpen) | (1L << HtmlClose) | (1L << HtmlSlashClose) | (1L << HtmlSlash) | (1L << HtmlEquals) | (1L << HtmlStartQuoteString) | (1L << HtmlStartDoubleQuoteString) | (1L << HtmlHex) | (1L << HtmlDecimal) | (1L << HtmlName) | (1L << HtmlEndQuoteString) | (1L << HtmlQuoteString) | (1L << HtmlEndDoubleQuoteString) | (1L << HtmlDoubleQuoteString) | (1L << ScriptText) | (1L << ScriptClose) | (1L << StyleBody) | (1L << Abstract) | (1L << Array) | (1L << As) | (1L << BinaryCast) | (1L << BoolType) | (1L << BooleanConstant) | (1L << Break) | (1L << Callable) | (1L << Case) | (1L << Catch) | (1L << Class) | (1L << Clone) | (1L << Const) | (1L << Continue) | (1L << Declare) | (1L << Default) | (1L << Do) | (1L << DoubleCast) | (1L << DoubleType) | (1L << Echo) | (1L << Else))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (ElseIf - 64)) | (1L << (Empty - 64)) | (1L << (EndDeclare - 64)) | (1L << (EndFor - 64)) | (1L << (EndForeach - 64)) | (1L << (EndIf - 64)) | (1L << (EndSwitch - 64)) | (1L << (EndWhile - 64)) | (1L << (Eval - 64)) | (1L << (Exit - 64)) | (1L << (Extends - 64)) | (1L << (Final - 64)) | (1L << (Finally - 64)) | (1L << (FloatCast - 64)) | (1L << (For - 64)) | (1L << (Foreach - 64)) | (1L << (Function - 64)) | (1L << (Global - 64)) | (1L << (Goto - 64)) | (1L << (If - 64)) | (1L << (Implements - 64)) | (1L << (Import - 64)) | (1L << (Include - 64)) | (1L << (IncludeOnce - 64)) | (1L << (InstanceOf - 64)) | (1L << (InsteadOf - 64)) | (1L << (Int8Cast - 64)) | (1L << (Int16Cast - 64)) | (1L << (Int64Type - 64)) | (1L << (IntType - 64)) | (1L << (Interface - 64)) | (1L << (IsSet - 64)) | (1L << (List - 64)) | (1L << (LogicalAnd - 64)) | (1L << (LogicalOr - 64)) | (1L << (LogicalXor - 64)) | (1L << (Namespace - 64)) | (1L << (New - 64)) | (1L << (Null - 64)) | (1L << (ObjectType - 64)) | (1L << (Parent_ - 64)) | (1L << (Partial - 64)) | (1L << (Print - 64)) | (1L << (Private - 64)) | (1L << (Protected - 64)) | (1L << (Public - 64)) | (1L << (Require - 64)) | (1L << (RequireOnce - 64)) | (1L << (Resource - 64)) | (1L << (Return - 64)) | (1L << (Static - 64)) | (1L << (StringType - 64)) | (1L << (Switch - 64)) | (1L << (Throw - 64)) | (1L << (Trait - 64)) | (1L << (Try - 64)) | (1L << (Typeof - 64)) | (1L << (UintCast - 64)) | (1L << (UnicodeCast - 64)) | (1L << (Unset - 64)) | (1L << (Use - 64)) | (1L << (Var - 64)) | (1L << (While - 64)) | (1L << (Yield - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (Get - 128)) | (1L << (Set - 128)) | (1L << (Call - 128)) | (1L << (CallStatic - 128)) | (1L << (Constructor - 128)) | (1L << (Destruct - 128)) | (1L << (Wakeup - 128)) | (1L << (Sleep - 128)) | (1L << (Autoload - 128)) | (1L << (IsSet__ - 128)) | (1L << (Unset__ - 128)) | (1L << (ToString__ - 128)) | (1L << (Invoke - 128)) | (1L << (SetState - 128)) | (1L << (Clone__ - 128)) | (1L << (DebugInfo - 128)) | (1L << (Namespace__ - 128)) | (1L << (Class__ - 128)) | (1L << (Traic__ - 128)) | (1L << (Function__ - 128)) | (1L << (Method__ - 128)) | (1L << (Line__ - 128)) | (1L << (File__ - 128)) | (1L << (Dir__ - 128)) | (1L << (Inc - 128)) | (1L << (Dec - 128)) | (1L << (NamespaceSeparator - 128)) | (1L << (Bang - 128)) | (1L << (Plus - 128)) | (1L << (Minus - 128)))) != 0) || ((((_la - 195)) & ~0x3f) == 0 && ((1L << (_la - 195)) & ((1L << (Tilde - 195)) | (1L << (SuppressWarnings - 195)) | (1L << (Dollar - 195)) | (1L << (OpenRoundBracket - 195)) | (1L << (OpenSquareBracket - 195)) | (1L << (OpenCurlyBracket - 195)) | (1L << (SemiColon - 195)) | (1L << (VarName - 195)) | (1L << (Label - 195)) | (1L << (Octal - 195)) | (1L << (Decimal - 195)) | (1L << (Real - 195)) | (1L << (Hex - 195)) | (1L << (Binary - 195)) | (1L << (BackQuoteString - 195)) | (1L << (SingleQuoteString - 195)) | (1L << (DoubleQuote - 195)) | (1L << (StartNowDoc - 195)) | (1L << (StartHereDoc - 195)))) != 0)) {
					{
					{
					setState(373);
					namespaceStatement();
					}
					}
					setState(378);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(379);
				match(CloseCurlyBracket);
				}
				break;
			case 2:
				{
				setState(380);
				namespaceNameList();
				setState(381);
				match(SemiColon);
				}
				break;
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

	public static class NamespaceStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public UseDeclarationContext useDeclaration() {
			return getRuleContext(UseDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public GlobalConstantDeclarationContext globalConstantDeclaration() {
			return getRuleContext(GlobalConstantDeclarationContext.class,0);
		}
		public NamespaceStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNamespaceStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNamespaceStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitNamespaceStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceStatementContext namespaceStatement() throws RecognitionException {
		NamespaceStatementContext _localctx = new NamespaceStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_namespaceStatement);
		try {
			setState(390);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(385);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				useDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(387);
				functionDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(388);
				classDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(389);
				globalConstantDeclaration();
				}
				break;
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TerminalNode Function() { return getToken(PhpParser.Function, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public TypeParameterListInBracketsContext typeParameterListInBrackets() {
			return getRuleContext(TypeParameterListInBracketsContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			attributes();
			setState(393);
			match(Function);
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ampersand) {
				{
				setState(394);
				match(Ampersand);
				}
			}

			setState(397);
			identifier();
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Lgeneric) {
				{
				setState(398);
				typeParameterListInBrackets();
				}
			}

			setState(401);
			match(OpenRoundBracket);
			setState(402);
			formalParameterList();
			setState(403);
			match(CloseRoundBracket);
			setState(404);
			blockStatement();
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public ClassEntryTypeContext classEntryType() {
			return getRuleContext(ClassEntryTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Interface() { return getToken(PhpParser.Interface, 0); }
		public TerminalNode Private() { return getToken(PhpParser.Private, 0); }
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public TerminalNode Partial() { return getToken(PhpParser.Partial, 0); }
		public List<ClassStatementContext> classStatement() {
			return getRuleContexts(ClassStatementContext.class);
		}
		public ClassStatementContext classStatement(int i) {
			return getRuleContext(ClassStatementContext.class,i);
		}
		public TypeParameterListInBracketsContext typeParameterListInBrackets() {
			return getRuleContext(TypeParameterListInBracketsContext.class,0);
		}
		public TerminalNode Extends() { return getToken(PhpParser.Extends, 0); }
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public TerminalNode Implements() { return getToken(PhpParser.Implements, 0); }
		public InterfaceListContext interfaceList() {
			return getRuleContext(InterfaceListContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			attributes();
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Private) {
				{
				setState(407);
				match(Private);
				}
			}

			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Abstract || _la==Final) {
				{
				setState(410);
				modifier();
				}
			}

			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Partial) {
				{
				setState(413);
				match(Partial);
				}
			}

			setState(438);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Trait:
				{
				setState(416);
				classEntryType();
				setState(417);
				identifier();
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Lgeneric) {
					{
					setState(418);
					typeParameterListInBrackets();
					}
				}

				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Extends) {
					{
					setState(421);
					match(Extends);
					setState(422);
					qualifiedStaticTypeRef();
					}
				}

				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Implements) {
					{
					setState(425);
					match(Implements);
					setState(426);
					interfaceList();
					}
				}

				}
				break;
			case Interface:
				{
				setState(429);
				match(Interface);
				setState(430);
				identifier();
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Lgeneric) {
					{
					setState(431);
					typeParameterListInBrackets();
					}
				}

				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Extends) {
					{
					setState(434);
					match(Extends);
					setState(435);
					interfaceList();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(440);
			match(OpenCurlyBracket);
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Abstract || _la==Const || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (Final - 75)) | (1L << (Function - 75)) | (1L << (Private - 75)) | (1L << (Protected - 75)) | (1L << (Public - 75)) | (1L << (Static - 75)) | (1L << (Use - 75)) | (1L << (Var - 75)))) != 0) || _la==OpenSquareBracket) {
				{
				{
				setState(441);
				classStatement();
				}
				}
				setState(446);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(447);
			match(CloseCurlyBracket);
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

	public static class ClassEntryTypeContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(PhpParser.Class, 0); }
		public TerminalNode Trait() { return getToken(PhpParser.Trait, 0); }
		public ClassEntryTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classEntryType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterClassEntryType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitClassEntryType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitClassEntryType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassEntryTypeContext classEntryType() throws RecognitionException {
		ClassEntryTypeContext _localctx = new ClassEntryTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_classEntryType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			_la = _input.LA(1);
			if ( !(_la==Class || _la==Trait) ) {
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

	public static class InterfaceListContext extends ParserRuleContext {
		public List<QualifiedStaticTypeRefContext> qualifiedStaticTypeRef() {
			return getRuleContexts(QualifiedStaticTypeRefContext.class);
		}
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef(int i) {
			return getRuleContext(QualifiedStaticTypeRefContext.class,i);
		}
		public InterfaceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInterfaceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInterfaceList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitInterfaceList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceListContext interfaceList() throws RecognitionException {
		InterfaceListContext _localctx = new InterfaceListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_interfaceList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			qualifiedStaticTypeRef();
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(452);
				match(Comma);
				setState(453);
				qualifiedStaticTypeRef();
				}
				}
				setState(458);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TypeParameterListInBracketsContext extends ParserRuleContext {
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public TypeParameterWithDefaultsListContext typeParameterWithDefaultsList() {
			return getRuleContext(TypeParameterWithDefaultsListContext.class,0);
		}
		public TypeParameterListInBracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterListInBrackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeParameterListInBrackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeParameterListInBrackets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTypeParameterListInBrackets(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterListInBracketsContext typeParameterListInBrackets() throws RecognitionException {
		TypeParameterListInBracketsContext _localctx = new TypeParameterListInBracketsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeParameterListInBrackets);
		try {
			setState(473);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(459);
				match(Lgeneric);
				setState(460);
				typeParameterList();
				setState(461);
				match(Rgeneric);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(463);
				match(Lgeneric);
				setState(464);
				typeParameterWithDefaultsList();
				setState(465);
				match(Rgeneric);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(467);
				match(Lgeneric);
				setState(468);
				typeParameterList();
				setState(469);
				match(Comma);
				setState(470);
				typeParameterWithDefaultsList();
				setState(471);
				match(Rgeneric);
				}
				break;
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

	public static class TypeParameterListContext extends ParserRuleContext {
		public List<TypeParameterDeclContext> typeParameterDecl() {
			return getRuleContexts(TypeParameterDeclContext.class);
		}
		public TypeParameterDeclContext typeParameterDecl(int i) {
			return getRuleContext(TypeParameterDeclContext.class,i);
		}
		public TypeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTypeParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterListContext typeParameterList() throws RecognitionException {
		TypeParameterListContext _localctx = new TypeParameterListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeParameterList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			typeParameterDecl();
			setState(480);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(476);
					match(Comma);
					setState(477);
					typeParameterDecl();
					}
					} 
				}
				setState(482);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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

	public static class TypeParameterWithDefaultsListContext extends ParserRuleContext {
		public List<TypeParameterWithDefaultDeclContext> typeParameterWithDefaultDecl() {
			return getRuleContexts(TypeParameterWithDefaultDeclContext.class);
		}
		public TypeParameterWithDefaultDeclContext typeParameterWithDefaultDecl(int i) {
			return getRuleContext(TypeParameterWithDefaultDeclContext.class,i);
		}
		public TypeParameterWithDefaultsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterWithDefaultsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeParameterWithDefaultsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeParameterWithDefaultsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTypeParameterWithDefaultsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterWithDefaultsListContext typeParameterWithDefaultsList() throws RecognitionException {
		TypeParameterWithDefaultsListContext _localctx = new TypeParameterWithDefaultsListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeParameterWithDefaultsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			typeParameterWithDefaultDecl();
			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(484);
				match(Comma);
				setState(485);
				typeParameterWithDefaultDecl();
				}
				}
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TypeParameterDeclContext extends ParserRuleContext {
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeParameterDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeParameterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeParameterDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTypeParameterDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterDeclContext typeParameterDecl() throws RecognitionException {
		TypeParameterDeclContext _localctx = new TypeParameterDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typeParameterDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			attributes();
			setState(492);
			identifier();
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

	public static class TypeParameterWithDefaultDeclContext extends ParserRuleContext {
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypeParameterWithDefaultDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterWithDefaultDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeParameterWithDefaultDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeParameterWithDefaultDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTypeParameterWithDefaultDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterWithDefaultDeclContext typeParameterWithDefaultDecl() throws RecognitionException {
		TypeParameterWithDefaultDeclContext _localctx = new TypeParameterWithDefaultDeclContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typeParameterWithDefaultDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			attributes();
			setState(495);
			identifier();
			setState(496);
			match(Eq);
			setState(499);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(497);
				qualifiedStaticTypeRef();
				}
				break;
			case 2:
				{
				setState(498);
				primitiveType();
				}
				break;
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

	public static class GenericDynamicArgsContext extends ParserRuleContext {
		public List<TypeRefContext> typeRef() {
			return getRuleContexts(TypeRefContext.class);
		}
		public TypeRefContext typeRef(int i) {
			return getRuleContext(TypeRefContext.class,i);
		}
		public GenericDynamicArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericDynamicArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterGenericDynamicArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitGenericDynamicArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitGenericDynamicArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericDynamicArgsContext genericDynamicArgs() throws RecognitionException {
		GenericDynamicArgsContext _localctx = new GenericDynamicArgsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_genericDynamicArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(Lgeneric);
			setState(502);
			typeRef();
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(503);
				match(Comma);
				setState(504);
				typeRef();
				}
				}
				setState(509);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(510);
			match(Rgeneric);
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

	public static class AttributesContext extends ParserRuleContext {
		public List<AttributesGroupContext> attributesGroup() {
			return getRuleContexts(AttributesGroupContext.class);
		}
		public AttributesGroupContext attributesGroup(int i) {
			return getRuleContext(AttributesGroupContext.class,i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_attributes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OpenSquareBracket) {
				{
				{
				setState(512);
				attributesGroup();
				}
				}
				setState(517);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class AttributesGroupContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AttributesGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributesGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAttributesGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAttributesGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitAttributesGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributesGroupContext attributesGroup() throws RecognitionException {
		AttributesGroupContext _localctx = new AttributesGroupContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_attributesGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			match(OpenSquareBracket);
			setState(522);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(519);
				identifier();
				setState(520);
				match(Colon);
				}
				break;
			}
			setState(524);
			attribute();
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(525);
				match(Comma);
				setState(526);
				attribute();
				}
				}
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(532);
			match(CloseSquareBracket);
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

	public static class AttributeContext extends ParserRuleContext {
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public AttributeArgListContext attributeArgList() {
			return getRuleContext(AttributeArgListContext.class,0);
		}
		public AttributeNamedArgListContext attributeNamedArgList() {
			return getRuleContext(AttributeNamedArgListContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_attribute);
		try {
			setState(552);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(534);
				qualifiedNamespaceName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(535);
				qualifiedNamespaceName();
				setState(536);
				match(OpenRoundBracket);
				setState(537);
				attributeArgList();
				setState(538);
				match(CloseRoundBracket);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(540);
				qualifiedNamespaceName();
				setState(541);
				match(OpenRoundBracket);
				setState(542);
				attributeNamedArgList();
				setState(543);
				match(CloseRoundBracket);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(545);
				qualifiedNamespaceName();
				setState(546);
				match(OpenRoundBracket);
				setState(547);
				attributeArgList();
				setState(548);
				match(Comma);
				setState(549);
				attributeNamedArgList();
				setState(550);
				match(CloseRoundBracket);
				}
				break;
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

	public static class AttributeArgListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AttributeArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeArgList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAttributeArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAttributeArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitAttributeArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeArgListContext attributeArgList() throws RecognitionException {
		AttributeArgListContext _localctx = new AttributeArgListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_attributeArgList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			expression(0);
			setState(559);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(555);
					match(Comma);
					setState(556);
					expression(0);
					}
					} 
				}
				setState(561);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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

	public static class AttributeNamedArgListContext extends ParserRuleContext {
		public List<AttributeNamedArgContext> attributeNamedArg() {
			return getRuleContexts(AttributeNamedArgContext.class);
		}
		public AttributeNamedArgContext attributeNamedArg(int i) {
			return getRuleContext(AttributeNamedArgContext.class,i);
		}
		public AttributeNamedArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeNamedArgList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAttributeNamedArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAttributeNamedArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitAttributeNamedArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeNamedArgListContext attributeNamedArgList() throws RecognitionException {
		AttributeNamedArgListContext _localctx = new AttributeNamedArgListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_attributeNamedArgList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			attributeNamedArg();
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(563);
				match(Comma);
				setState(564);
				attributeNamedArg();
				}
				}
				setState(569);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class AttributeNamedArgContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(PhpParser.VarName, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AttributeNamedArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeNamedArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAttributeNamedArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAttributeNamedArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitAttributeNamedArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeNamedArgContext attributeNamedArg() throws RecognitionException {
		AttributeNamedArgContext _localctx = new AttributeNamedArgContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_attributeNamedArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(VarName);
			setState(571);
			match(DoubleArrow);
			setState(572);
			expression(0);
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

	public static class InnerStatementListContext extends ParserRuleContext {
		public List<InnerStatementContext> innerStatement() {
			return getRuleContexts(InnerStatementContext.class);
		}
		public InnerStatementContext innerStatement(int i) {
			return getRuleContext(InnerStatementContext.class,i);
		}
		public InnerStatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerStatementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInnerStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInnerStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitInnerStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InnerStatementListContext innerStatementList() throws RecognitionException {
		InnerStatementListContext _localctx = new InnerStatementListContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_innerStatementList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(574);
					innerStatement();
					}
					} 
				}
				setState(579);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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

	public static class InnerStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InnerStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInnerStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInnerStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitInnerStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InnerStatementContext innerStatement() throws RecognitionException {
		InnerStatementContext _localctx = new InnerStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_innerStatement);
		try {
			setState(583);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(580);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(581);
				functionDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(582);
				classDeclaration();
				}
				break;
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

	public static class StatementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public YieldExpressionContext yieldExpression() {
			return getRuleContext(YieldExpressionContext.class,0);
		}
		public GlobalStatementContext globalStatement() {
			return getRuleContext(GlobalStatementContext.class,0);
		}
		public StaticVariableStatementContext staticVariableStatement() {
			return getRuleContext(StaticVariableStatementContext.class,0);
		}
		public EchoStatementContext echoStatement() {
			return getRuleContext(EchoStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public UnsetStatementContext unsetStatement() {
			return getRuleContext(UnsetStatementContext.class,0);
		}
		public ForeachStatementContext foreachStatement() {
			return getRuleContext(ForeachStatementContext.class,0);
		}
		public TryCatchFinallyContext tryCatchFinally() {
			return getRuleContext(TryCatchFinallyContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public GotoStatementContext gotoStatement() {
			return getRuleContext(GotoStatementContext.class,0);
		}
		public DeclareStatementContext declareStatement() {
			return getRuleContext(DeclareStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public InlineHtmlStatementContext inlineHtmlStatement() {
			return getRuleContext(InlineHtmlStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_statement);
		try {
			setState(612);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(585);
				identifier();
				setState(586);
				match(Colon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(588);
				blockStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(589);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(590);
				whileStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(591);
				doWhileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(592);
				forStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(593);
				switchStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(594);
				breakStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(595);
				continueStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(596);
				returnStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(597);
				yieldExpression();
				setState(598);
				match(SemiColon);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(600);
				globalStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(601);
				staticVariableStatement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(602);
				echoStatement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(603);
				expressionStatement();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(604);
				unsetStatement();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(605);
				foreachStatement();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(606);
				tryCatchFinally();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(607);
				throwStatement();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(608);
				gotoStatement();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(609);
				declareStatement();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(610);
				emptyStatement();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(611);
				inlineHtmlStatement();
				}
				break;
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

	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			match(SemiColon);
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

	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_blockStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			match(OpenCurlyBracket);
			setState(617);
			innerStatementList();
			setState(618);
			match(CloseCurlyBracket);
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(PhpParser.If, 0); }
		public ParenthesisContext parenthesis() {
			return getRuleContext(ParenthesisContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ElseIfStatementContext> elseIfStatement() {
			return getRuleContexts(ElseIfStatementContext.class);
		}
		public ElseIfStatementContext elseIfStatement(int i) {
			return getRuleContext(ElseIfStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public TerminalNode EndIf() { return getToken(PhpParser.EndIf, 0); }
		public List<ElseIfColonStatementContext> elseIfColonStatement() {
			return getRuleContexts(ElseIfColonStatementContext.class);
		}
		public ElseIfColonStatementContext elseIfColonStatement(int i) {
			return getRuleContext(ElseIfColonStatementContext.class,i);
		}
		public ElseColonStatementContext elseColonStatement() {
			return getRuleContext(ElseColonStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_ifStatement);
		int _la;
		try {
			int _alt;
			setState(648);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(620);
				match(If);
				setState(621);
				parenthesis();
				setState(622);
				statement();
				setState(626);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(623);
						elseIfStatement();
						}
						} 
					}
					setState(628);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				}
				setState(630);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(629);
					elseStatement();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(632);
				match(If);
				setState(633);
				parenthesis();
				setState(634);
				match(Colon);
				setState(635);
				innerStatementList();
				setState(639);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ElseIf) {
					{
					{
					setState(636);
					elseIfColonStatement();
					}
					}
					setState(641);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(643);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Else) {
					{
					setState(642);
					elseColonStatement();
					}
				}

				setState(645);
				match(EndIf);
				setState(646);
				match(SemiColon);
				}
				break;
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

	public static class ElseIfStatementContext extends ParserRuleContext {
		public TerminalNode ElseIf() { return getToken(PhpParser.ElseIf, 0); }
		public ParenthesisContext parenthesis() {
			return getRuleContext(ParenthesisContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterElseIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitElseIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitElseIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(650);
			match(ElseIf);
			setState(651);
			parenthesis();
			setState(652);
			statement();
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

	public static class ElseIfColonStatementContext extends ParserRuleContext {
		public TerminalNode ElseIf() { return getToken(PhpParser.ElseIf, 0); }
		public ParenthesisContext parenthesis() {
			return getRuleContext(ParenthesisContext.class,0);
		}
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public ElseIfColonStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfColonStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterElseIfColonStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitElseIfColonStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitElseIfColonStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfColonStatementContext elseIfColonStatement() throws RecognitionException {
		ElseIfColonStatementContext _localctx = new ElseIfColonStatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_elseIfColonStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			match(ElseIf);
			setState(655);
			parenthesis();
			setState(656);
			match(Colon);
			setState(657);
			innerStatementList();
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

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(PhpParser.Else, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			match(Else);
			setState(660);
			statement();
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

	public static class ElseColonStatementContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(PhpParser.Else, 0); }
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public ElseColonStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseColonStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterElseColonStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitElseColonStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitElseColonStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseColonStatementContext elseColonStatement() throws RecognitionException {
		ElseColonStatementContext _localctx = new ElseColonStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_elseColonStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(662);
			match(Else);
			setState(663);
			match(Colon);
			setState(664);
			innerStatementList();
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

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(PhpParser.While, 0); }
		public ParenthesisContext parenthesis() {
			return getRuleContext(ParenthesisContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public TerminalNode EndWhile() { return getToken(PhpParser.EndWhile, 0); }
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			match(While);
			setState(667);
			parenthesis();
			setState(674);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlText:
			case XmlStart:
			case HtmlScriptOpen:
			case HtmlStyleOpen:
			case HtmlDtd:
			case HtmlOpen:
			case HtmlClose:
			case HtmlSlashClose:
			case HtmlSlash:
			case HtmlEquals:
			case HtmlStartQuoteString:
			case HtmlStartDoubleQuoteString:
			case HtmlHex:
			case HtmlDecimal:
			case HtmlName:
			case HtmlEndQuoteString:
			case HtmlQuoteString:
			case HtmlEndDoubleQuoteString:
			case HtmlDoubleQuoteString:
			case ScriptText:
			case ScriptClose:
			case StyleBody:
			case Abstract:
			case Array:
			case As:
			case BinaryCast:
			case BoolType:
			case BooleanConstant:
			case Break:
			case Callable:
			case Case:
			case Catch:
			case Class:
			case Clone:
			case Const:
			case Continue:
			case Declare:
			case Default:
			case Do:
			case DoubleCast:
			case DoubleType:
			case Echo:
			case Else:
			case ElseIf:
			case Empty:
			case EndDeclare:
			case EndFor:
			case EndForeach:
			case EndIf:
			case EndSwitch:
			case EndWhile:
			case Eval:
			case Exit:
			case Extends:
			case Final:
			case Finally:
			case FloatCast:
			case For:
			case Foreach:
			case Function:
			case Global:
			case Goto:
			case If:
			case Implements:
			case Import:
			case Include:
			case IncludeOnce:
			case InstanceOf:
			case InsteadOf:
			case Int8Cast:
			case Int16Cast:
			case Int64Type:
			case IntType:
			case Interface:
			case IsSet:
			case List:
			case LogicalAnd:
			case LogicalOr:
			case LogicalXor:
			case Namespace:
			case New:
			case Null:
			case ObjectType:
			case Parent_:
			case Partial:
			case Print:
			case Private:
			case Protected:
			case Public:
			case Require:
			case RequireOnce:
			case Resource:
			case Return:
			case Static:
			case StringType:
			case Switch:
			case Throw:
			case Trait:
			case Try:
			case Typeof:
			case UintCast:
			case UnicodeCast:
			case Unset:
			case Use:
			case Var:
			case While:
			case Yield:
			case Get:
			case Set:
			case Call:
			case CallStatic:
			case Constructor:
			case Destruct:
			case Wakeup:
			case Sleep:
			case Autoload:
			case IsSet__:
			case Unset__:
			case ToString__:
			case Invoke:
			case SetState:
			case Clone__:
			case DebugInfo:
			case Namespace__:
			case Class__:
			case Traic__:
			case Function__:
			case Method__:
			case Line__:
			case File__:
			case Dir__:
			case Inc:
			case Dec:
			case NamespaceSeparator:
			case Bang:
			case Plus:
			case Minus:
			case Tilde:
			case SuppressWarnings:
			case Dollar:
			case OpenRoundBracket:
			case OpenSquareBracket:
			case OpenCurlyBracket:
			case SemiColon:
			case VarName:
			case Label:
			case Octal:
			case Decimal:
			case Real:
			case Hex:
			case Binary:
			case BackQuoteString:
			case SingleQuoteString:
			case DoubleQuote:
			case StartNowDoc:
			case StartHereDoc:
				{
				setState(668);
				statement();
				}
				break;
			case Colon:
				{
				setState(669);
				match(Colon);
				setState(670);
				innerStatementList();
				setState(671);
				match(EndWhile);
				setState(672);
				match(SemiColon);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DoWhileStatementContext extends ParserRuleContext {
		public TerminalNode Do() { return getToken(PhpParser.Do, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode While() { return getToken(PhpParser.While, 0); }
		public ParenthesisContext parenthesis() {
			return getRuleContext(ParenthesisContext.class,0);
		}
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			match(Do);
			setState(677);
			statement();
			setState(678);
			match(While);
			setState(679);
			parenthesis();
			setState(680);
			match(SemiColon);
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

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(PhpParser.For, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public TerminalNode EndFor() { return getToken(PhpParser.EndFor, 0); }
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			match(For);
			setState(683);
			match(OpenRoundBracket);
			setState(685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)) | (1L << (Inc - 107)) | (1L << (Dec - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Bang - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Tilde - 182)) | (1L << (SuppressWarnings - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (BackQuoteString - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
				{
				setState(684);
				forInit();
				}
			}

			setState(687);
			match(SemiColon);
			setState(689);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)) | (1L << (Inc - 107)) | (1L << (Dec - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Bang - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Tilde - 182)) | (1L << (SuppressWarnings - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (BackQuoteString - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
				{
				setState(688);
				expressionList();
				}
			}

			setState(691);
			match(SemiColon);
			setState(693);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)) | (1L << (Inc - 107)) | (1L << (Dec - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Bang - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Tilde - 182)) | (1L << (SuppressWarnings - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (BackQuoteString - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
				{
				setState(692);
				forUpdate();
				}
			}

			setState(695);
			match(CloseRoundBracket);
			setState(702);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlText:
			case XmlStart:
			case HtmlScriptOpen:
			case HtmlStyleOpen:
			case HtmlDtd:
			case HtmlOpen:
			case HtmlClose:
			case HtmlSlashClose:
			case HtmlSlash:
			case HtmlEquals:
			case HtmlStartQuoteString:
			case HtmlStartDoubleQuoteString:
			case HtmlHex:
			case HtmlDecimal:
			case HtmlName:
			case HtmlEndQuoteString:
			case HtmlQuoteString:
			case HtmlEndDoubleQuoteString:
			case HtmlDoubleQuoteString:
			case ScriptText:
			case ScriptClose:
			case StyleBody:
			case Abstract:
			case Array:
			case As:
			case BinaryCast:
			case BoolType:
			case BooleanConstant:
			case Break:
			case Callable:
			case Case:
			case Catch:
			case Class:
			case Clone:
			case Const:
			case Continue:
			case Declare:
			case Default:
			case Do:
			case DoubleCast:
			case DoubleType:
			case Echo:
			case Else:
			case ElseIf:
			case Empty:
			case EndDeclare:
			case EndFor:
			case EndForeach:
			case EndIf:
			case EndSwitch:
			case EndWhile:
			case Eval:
			case Exit:
			case Extends:
			case Final:
			case Finally:
			case FloatCast:
			case For:
			case Foreach:
			case Function:
			case Global:
			case Goto:
			case If:
			case Implements:
			case Import:
			case Include:
			case IncludeOnce:
			case InstanceOf:
			case InsteadOf:
			case Int8Cast:
			case Int16Cast:
			case Int64Type:
			case IntType:
			case Interface:
			case IsSet:
			case List:
			case LogicalAnd:
			case LogicalOr:
			case LogicalXor:
			case Namespace:
			case New:
			case Null:
			case ObjectType:
			case Parent_:
			case Partial:
			case Print:
			case Private:
			case Protected:
			case Public:
			case Require:
			case RequireOnce:
			case Resource:
			case Return:
			case Static:
			case StringType:
			case Switch:
			case Throw:
			case Trait:
			case Try:
			case Typeof:
			case UintCast:
			case UnicodeCast:
			case Unset:
			case Use:
			case Var:
			case While:
			case Yield:
			case Get:
			case Set:
			case Call:
			case CallStatic:
			case Constructor:
			case Destruct:
			case Wakeup:
			case Sleep:
			case Autoload:
			case IsSet__:
			case Unset__:
			case ToString__:
			case Invoke:
			case SetState:
			case Clone__:
			case DebugInfo:
			case Namespace__:
			case Class__:
			case Traic__:
			case Function__:
			case Method__:
			case Line__:
			case File__:
			case Dir__:
			case Inc:
			case Dec:
			case NamespaceSeparator:
			case Bang:
			case Plus:
			case Minus:
			case Tilde:
			case SuppressWarnings:
			case Dollar:
			case OpenRoundBracket:
			case OpenSquareBracket:
			case OpenCurlyBracket:
			case SemiColon:
			case VarName:
			case Label:
			case Octal:
			case Decimal:
			case Real:
			case Hex:
			case Binary:
			case BackQuoteString:
			case SingleQuoteString:
			case DoubleQuote:
			case StartNowDoc:
			case StartHereDoc:
				{
				setState(696);
				statement();
				}
				break;
			case Colon:
				{
				setState(697);
				match(Colon);
				setState(698);
				innerStatementList();
				setState(699);
				match(EndFor);
				setState(700);
				match(SemiColon);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ForInitContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_forInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			expressionList();
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

	public static class ForUpdateContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitForUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			expressionList();
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

	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode Switch() { return getToken(PhpParser.Switch, 0); }
		public ParenthesisContext parenthesis() {
			return getRuleContext(ParenthesisContext.class,0);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public TerminalNode EndSwitch() { return getToken(PhpParser.EndSwitch, 0); }
		public List<SwitchBlockContext> switchBlock() {
			return getRuleContexts(SwitchBlockContext.class);
		}
		public SwitchBlockContext switchBlock(int i) {
			return getRuleContext(SwitchBlockContext.class,i);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			match(Switch);
			setState(709);
			parenthesis();
			setState(733);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenCurlyBracket:
				{
				setState(710);
				match(OpenCurlyBracket);
				setState(712);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SemiColon) {
					{
					setState(711);
					match(SemiColon);
					}
				}

				setState(717);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Case || _la==Default) {
					{
					{
					setState(714);
					switchBlock();
					}
					}
					setState(719);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(720);
				match(CloseCurlyBracket);
				}
				break;
			case Colon:
				{
				setState(721);
				match(Colon);
				setState(723);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SemiColon) {
					{
					setState(722);
					match(SemiColon);
					}
				}

				setState(728);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Case || _la==Default) {
					{
					{
					setState(725);
					switchBlock();
					}
					}
					setState(730);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(731);
				match(EndSwitch);
				setState(732);
				match(SemiColon);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SwitchBlockContext extends ParserRuleContext {
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public List<TerminalNode> Case() { return getTokens(PhpParser.Case); }
		public TerminalNode Case(int i) {
			return getToken(PhpParser.Case, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Default() { return getTokens(PhpParser.Default); }
		public TerminalNode Default(int i) {
			return getToken(PhpParser.Default, i);
		}
		public SwitchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterSwitchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitSwitchBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitSwitchBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBlockContext switchBlock() throws RecognitionException {
		SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_switchBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(741); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(738);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case Case:
						{
						setState(735);
						match(Case);
						setState(736);
						expression(0);
						}
						break;
					case Default:
						{
						setState(737);
						match(Default);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(740);
					_la = _input.LA(1);
					if ( !(_la==Colon || _la==SemiColon) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(743); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(745);
			innerStatementList();
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

	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(PhpParser.Break, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_breakStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			match(Break);
			setState(749);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)) | (1L << (Inc - 107)) | (1L << (Dec - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Bang - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Tilde - 182)) | (1L << (SuppressWarnings - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (BackQuoteString - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
				{
				setState(748);
				expression(0);
				}
			}

			setState(751);
			match(SemiColon);
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

	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(PhpParser.Continue, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_continueStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			match(Continue);
			setState(755);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)) | (1L << (Inc - 107)) | (1L << (Dec - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Bang - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Tilde - 182)) | (1L << (SuppressWarnings - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (BackQuoteString - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
				{
				setState(754);
				expression(0);
				}
			}

			setState(757);
			match(SemiColon);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(PhpParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(759);
			match(Return);
			setState(761);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)) | (1L << (Inc - 107)) | (1L << (Dec - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Bang - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Tilde - 182)) | (1L << (SuppressWarnings - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (BackQuoteString - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
				{
				setState(760);
				expression(0);
				}
			}

			setState(763);
			match(SemiColon);
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

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(765);
			expression(0);
			setState(766);
			match(SemiColon);
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

	public static class UnsetStatementContext extends ParserRuleContext {
		public TerminalNode Unset() { return getToken(PhpParser.Unset, 0); }
		public ChainListContext chainList() {
			return getRuleContext(ChainListContext.class,0);
		}
		public UnsetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsetStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterUnsetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitUnsetStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitUnsetStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsetStatementContext unsetStatement() throws RecognitionException {
		UnsetStatementContext _localctx = new UnsetStatementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_unsetStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
			match(Unset);
			setState(769);
			match(OpenRoundBracket);
			setState(770);
			chainList();
			setState(771);
			match(CloseRoundBracket);
			setState(772);
			match(SemiColon);
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

	public static class ForeachStatementContext extends ParserRuleContext {
		public TerminalNode Foreach() { return getToken(PhpParser.Foreach, 0); }
		public List<ChainContext> chain() {
			return getRuleContexts(ChainContext.class);
		}
		public ChainContext chain(int i) {
			return getRuleContext(ChainContext.class,i);
		}
		public TerminalNode As() { return getToken(PhpParser.As, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode List() { return getToken(PhpParser.List, 0); }
		public AssignmentListContext assignmentList() {
			return getRuleContext(AssignmentListContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public TerminalNode EndForeach() { return getToken(PhpParser.EndForeach, 0); }
		public ForeachStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterForeachStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitForeachStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitForeachStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForeachStatementContext foreachStatement() throws RecognitionException {
		ForeachStatementContext _localctx = new ForeachStatementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_foreachStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(774);
			match(Foreach);
			setState(813);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(775);
				match(OpenRoundBracket);
				setState(776);
				chain();
				setState(777);
				match(As);
				setState(779);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ampersand) {
					{
					setState(778);
					match(Ampersand);
					}
				}

				setState(781);
				chain();
				setState(787);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleArrow) {
					{
					setState(782);
					match(DoubleArrow);
					setState(784);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Ampersand) {
						{
						setState(783);
						match(Ampersand);
						}
					}

					setState(786);
					chain();
					}
				}

				setState(789);
				match(CloseRoundBracket);
				}
				break;
			case 2:
				{
				setState(791);
				match(OpenRoundBracket);
				setState(792);
				expression(0);
				setState(793);
				match(As);
				setState(794);
				chain();
				setState(800);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleArrow) {
					{
					setState(795);
					match(DoubleArrow);
					setState(797);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Ampersand) {
						{
						setState(796);
						match(Ampersand);
						}
					}

					setState(799);
					chain();
					}
				}

				setState(802);
				match(CloseRoundBracket);
				}
				break;
			case 3:
				{
				setState(804);
				match(OpenRoundBracket);
				setState(805);
				chain();
				setState(806);
				match(As);
				setState(807);
				match(List);
				setState(808);
				match(OpenRoundBracket);
				setState(809);
				assignmentList();
				setState(810);
				match(CloseRoundBracket);
				setState(811);
				match(CloseRoundBracket);
				}
				break;
			}
			setState(821);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlText:
			case XmlStart:
			case HtmlScriptOpen:
			case HtmlStyleOpen:
			case HtmlDtd:
			case HtmlOpen:
			case HtmlClose:
			case HtmlSlashClose:
			case HtmlSlash:
			case HtmlEquals:
			case HtmlStartQuoteString:
			case HtmlStartDoubleQuoteString:
			case HtmlHex:
			case HtmlDecimal:
			case HtmlName:
			case HtmlEndQuoteString:
			case HtmlQuoteString:
			case HtmlEndDoubleQuoteString:
			case HtmlDoubleQuoteString:
			case ScriptText:
			case ScriptClose:
			case StyleBody:
			case Abstract:
			case Array:
			case As:
			case BinaryCast:
			case BoolType:
			case BooleanConstant:
			case Break:
			case Callable:
			case Case:
			case Catch:
			case Class:
			case Clone:
			case Const:
			case Continue:
			case Declare:
			case Default:
			case Do:
			case DoubleCast:
			case DoubleType:
			case Echo:
			case Else:
			case ElseIf:
			case Empty:
			case EndDeclare:
			case EndFor:
			case EndForeach:
			case EndIf:
			case EndSwitch:
			case EndWhile:
			case Eval:
			case Exit:
			case Extends:
			case Final:
			case Finally:
			case FloatCast:
			case For:
			case Foreach:
			case Function:
			case Global:
			case Goto:
			case If:
			case Implements:
			case Import:
			case Include:
			case IncludeOnce:
			case InstanceOf:
			case InsteadOf:
			case Int8Cast:
			case Int16Cast:
			case Int64Type:
			case IntType:
			case Interface:
			case IsSet:
			case List:
			case LogicalAnd:
			case LogicalOr:
			case LogicalXor:
			case Namespace:
			case New:
			case Null:
			case ObjectType:
			case Parent_:
			case Partial:
			case Print:
			case Private:
			case Protected:
			case Public:
			case Require:
			case RequireOnce:
			case Resource:
			case Return:
			case Static:
			case StringType:
			case Switch:
			case Throw:
			case Trait:
			case Try:
			case Typeof:
			case UintCast:
			case UnicodeCast:
			case Unset:
			case Use:
			case Var:
			case While:
			case Yield:
			case Get:
			case Set:
			case Call:
			case CallStatic:
			case Constructor:
			case Destruct:
			case Wakeup:
			case Sleep:
			case Autoload:
			case IsSet__:
			case Unset__:
			case ToString__:
			case Invoke:
			case SetState:
			case Clone__:
			case DebugInfo:
			case Namespace__:
			case Class__:
			case Traic__:
			case Function__:
			case Method__:
			case Line__:
			case File__:
			case Dir__:
			case Inc:
			case Dec:
			case NamespaceSeparator:
			case Bang:
			case Plus:
			case Minus:
			case Tilde:
			case SuppressWarnings:
			case Dollar:
			case OpenRoundBracket:
			case OpenSquareBracket:
			case OpenCurlyBracket:
			case SemiColon:
			case VarName:
			case Label:
			case Octal:
			case Decimal:
			case Real:
			case Hex:
			case Binary:
			case BackQuoteString:
			case SingleQuoteString:
			case DoubleQuote:
			case StartNowDoc:
			case StartHereDoc:
				{
				setState(815);
				statement();
				}
				break;
			case Colon:
				{
				setState(816);
				match(Colon);
				setState(817);
				innerStatementList();
				setState(818);
				match(EndForeach);
				setState(819);
				match(SemiColon);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TryCatchFinallyContext extends ParserRuleContext {
		public TerminalNode Try() { return getToken(PhpParser.Try, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public FinallyStatementContext finallyStatement() {
			return getRuleContext(FinallyStatementContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public TryCatchFinallyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryCatchFinally; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTryCatchFinally(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTryCatchFinally(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTryCatchFinally(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryCatchFinallyContext tryCatchFinally() throws RecognitionException {
		TryCatchFinallyContext _localctx = new TryCatchFinallyContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_tryCatchFinally);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(823);
			match(Try);
			setState(824);
			blockStatement();
			setState(840);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(826); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(825);
						catchClause();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(828); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(831);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
				case 1:
					{
					setState(830);
					finallyStatement();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(836);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Catch) {
					{
					{
					setState(833);
					catchClause();
					}
					}
					setState(838);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(839);
				finallyStatement();
				}
				break;
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

	public static class CatchClauseContext extends ParserRuleContext {
		public TerminalNode Catch() { return getToken(PhpParser.Catch, 0); }
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public TerminalNode VarName() { return getToken(PhpParser.VarName, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitCatchClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitCatchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_catchClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
			match(Catch);
			setState(843);
			match(OpenRoundBracket);
			setState(844);
			qualifiedStaticTypeRef();
			setState(845);
			match(VarName);
			setState(846);
			match(CloseRoundBracket);
			setState(847);
			blockStatement();
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

	public static class FinallyStatementContext extends ParserRuleContext {
		public TerminalNode Finally() { return getToken(PhpParser.Finally, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public FinallyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFinallyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFinallyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitFinallyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinallyStatementContext finallyStatement() throws RecognitionException {
		FinallyStatementContext _localctx = new FinallyStatementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_finallyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(849);
			match(Finally);
			setState(850);
			blockStatement();
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

	public static class ThrowStatementContext extends ParserRuleContext {
		public TerminalNode Throw() { return getToken(PhpParser.Throw, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitThrowStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitThrowStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852);
			match(Throw);
			setState(853);
			expression(0);
			setState(854);
			match(SemiColon);
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

	public static class GotoStatementContext extends ParserRuleContext {
		public TerminalNode Goto() { return getToken(PhpParser.Goto, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public GotoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterGotoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitGotoStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitGotoStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GotoStatementContext gotoStatement() throws RecognitionException {
		GotoStatementContext _localctx = new GotoStatementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_gotoStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(856);
			match(Goto);
			setState(857);
			identifier();
			setState(858);
			match(SemiColon);
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

	public static class DeclareStatementContext extends ParserRuleContext {
		public TerminalNode Declare() { return getToken(PhpParser.Declare, 0); }
		public DeclareListContext declareList() {
			return getRuleContext(DeclareListContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public TerminalNode EndDeclare() { return getToken(PhpParser.EndDeclare, 0); }
		public DeclareStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterDeclareStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitDeclareStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitDeclareStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareStatementContext declareStatement() throws RecognitionException {
		DeclareStatementContext _localctx = new DeclareStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_declareStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			match(Declare);
			setState(861);
			match(OpenRoundBracket);
			setState(862);
			declareList();
			setState(863);
			match(CloseRoundBracket);
			setState(870);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlText:
			case XmlStart:
			case HtmlScriptOpen:
			case HtmlStyleOpen:
			case HtmlDtd:
			case HtmlOpen:
			case HtmlClose:
			case HtmlSlashClose:
			case HtmlSlash:
			case HtmlEquals:
			case HtmlStartQuoteString:
			case HtmlStartDoubleQuoteString:
			case HtmlHex:
			case HtmlDecimal:
			case HtmlName:
			case HtmlEndQuoteString:
			case HtmlQuoteString:
			case HtmlEndDoubleQuoteString:
			case HtmlDoubleQuoteString:
			case ScriptText:
			case ScriptClose:
			case StyleBody:
			case Abstract:
			case Array:
			case As:
			case BinaryCast:
			case BoolType:
			case BooleanConstant:
			case Break:
			case Callable:
			case Case:
			case Catch:
			case Class:
			case Clone:
			case Const:
			case Continue:
			case Declare:
			case Default:
			case Do:
			case DoubleCast:
			case DoubleType:
			case Echo:
			case Else:
			case ElseIf:
			case Empty:
			case EndDeclare:
			case EndFor:
			case EndForeach:
			case EndIf:
			case EndSwitch:
			case EndWhile:
			case Eval:
			case Exit:
			case Extends:
			case Final:
			case Finally:
			case FloatCast:
			case For:
			case Foreach:
			case Function:
			case Global:
			case Goto:
			case If:
			case Implements:
			case Import:
			case Include:
			case IncludeOnce:
			case InstanceOf:
			case InsteadOf:
			case Int8Cast:
			case Int16Cast:
			case Int64Type:
			case IntType:
			case Interface:
			case IsSet:
			case List:
			case LogicalAnd:
			case LogicalOr:
			case LogicalXor:
			case Namespace:
			case New:
			case Null:
			case ObjectType:
			case Parent_:
			case Partial:
			case Print:
			case Private:
			case Protected:
			case Public:
			case Require:
			case RequireOnce:
			case Resource:
			case Return:
			case Static:
			case StringType:
			case Switch:
			case Throw:
			case Trait:
			case Try:
			case Typeof:
			case UintCast:
			case UnicodeCast:
			case Unset:
			case Use:
			case Var:
			case While:
			case Yield:
			case Get:
			case Set:
			case Call:
			case CallStatic:
			case Constructor:
			case Destruct:
			case Wakeup:
			case Sleep:
			case Autoload:
			case IsSet__:
			case Unset__:
			case ToString__:
			case Invoke:
			case SetState:
			case Clone__:
			case DebugInfo:
			case Namespace__:
			case Class__:
			case Traic__:
			case Function__:
			case Method__:
			case Line__:
			case File__:
			case Dir__:
			case Inc:
			case Dec:
			case NamespaceSeparator:
			case Bang:
			case Plus:
			case Minus:
			case Tilde:
			case SuppressWarnings:
			case Dollar:
			case OpenRoundBracket:
			case OpenSquareBracket:
			case OpenCurlyBracket:
			case SemiColon:
			case VarName:
			case Label:
			case Octal:
			case Decimal:
			case Real:
			case Hex:
			case Binary:
			case BackQuoteString:
			case SingleQuoteString:
			case DoubleQuote:
			case StartNowDoc:
			case StartHereDoc:
				{
				setState(864);
				statement();
				}
				break;
			case Colon:
				{
				setState(865);
				match(Colon);
				setState(866);
				innerStatementList();
				setState(867);
				match(EndDeclare);
				setState(868);
				match(SemiColon);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class InlineHtmlStatementContext extends ParserRuleContext {
		public List<InlineHtmlContext> inlineHtml() {
			return getRuleContexts(InlineHtmlContext.class);
		}
		public InlineHtmlContext inlineHtml(int i) {
			return getRuleContext(InlineHtmlContext.class,i);
		}
		public InlineHtmlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineHtmlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInlineHtmlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInlineHtmlStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitInlineHtmlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineHtmlStatementContext inlineHtmlStatement() throws RecognitionException {
		InlineHtmlStatementContext _localctx = new InlineHtmlStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_inlineHtmlStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(873); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(872);
					inlineHtml();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(875); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class InlineHtmlContext extends ParserRuleContext {
		public HtmlElementsContext htmlElements() {
			return getRuleContext(HtmlElementsContext.class,0);
		}
		public ScriptTextPartContext scriptTextPart() {
			return getRuleContext(ScriptTextPartContext.class,0);
		}
		public InlineHtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineHtml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInlineHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInlineHtml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitInlineHtml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineHtmlContext inlineHtml() throws RecognitionException {
		InlineHtmlContext _localctx = new InlineHtmlContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_inlineHtml);
		try {
			setState(879);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlText:
			case XmlStart:
			case HtmlScriptOpen:
			case HtmlStyleOpen:
			case HtmlDtd:
			case HtmlOpen:
			case HtmlClose:
			case HtmlSlashClose:
			case HtmlSlash:
			case HtmlEquals:
			case HtmlStartQuoteString:
			case HtmlStartDoubleQuoteString:
			case HtmlHex:
			case HtmlDecimal:
			case HtmlName:
			case HtmlEndQuoteString:
			case HtmlQuoteString:
			case HtmlEndDoubleQuoteString:
			case HtmlDoubleQuoteString:
			case ScriptClose:
			case StyleBody:
				enterOuterAlt(_localctx, 1);
				{
				setState(877);
				htmlElements();
				}
				break;
			case ScriptText:
				enterOuterAlt(_localctx, 2);
				{
				setState(878);
				scriptTextPart();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DeclareListContext extends ParserRuleContext {
		public List<IdentifierInititalizerContext> identifierInititalizer() {
			return getRuleContexts(IdentifierInititalizerContext.class);
		}
		public IdentifierInititalizerContext identifierInititalizer(int i) {
			return getRuleContext(IdentifierInititalizerContext.class,i);
		}
		public DeclareListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterDeclareList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitDeclareList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitDeclareList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclareListContext declareList() throws RecognitionException {
		DeclareListContext _localctx = new DeclareListContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_declareList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			identifierInititalizer();
			setState(886);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(882);
				match(Comma);
				setState(883);
				identifierInititalizer();
				}
				}
				setState(888);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FormalParameterListContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_formalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Ellipsis - 182)) | (1L << (Ampersand - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)))) != 0)) {
				{
				setState(889);
				formalParameter();
				}
			}

			setState(896);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(892);
				match(Comma);
				setState(893);
				formalParameter();
				}
				}
				setState(898);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FormalParameterContext extends ParserRuleContext {
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public TypeHintContext typeHint() {
			return getRuleContext(TypeHintContext.class,0);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(899);
			attributes();
			setState(901);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)))) != 0) || _la==NamespaceSeparator || _la==Label) {
				{
				setState(900);
				typeHint();
				}
			}

			setState(904);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ampersand) {
				{
				setState(903);
				match(Ampersand);
				}
			}

			setState(907);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(906);
				match(Ellipsis);
				}
			}

			setState(909);
			variableInitializer();
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

	public static class TypeHintContext extends ParserRuleContext {
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public TerminalNode Callable() { return getToken(PhpParser.Callable, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypeHintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeHint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeHint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeHint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTypeHint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeHintContext typeHint() throws RecognitionException {
		TypeHintContext _localctx = new TypeHintContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_typeHint);
		try {
			setState(914);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(911);
				qualifiedStaticTypeRef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(912);
				match(Callable);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(913);
				primitiveType();
				}
				break;
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

	public static class GlobalStatementContext extends ParserRuleContext {
		public TerminalNode Global() { return getToken(PhpParser.Global, 0); }
		public List<GlobalVarContext> globalVar() {
			return getRuleContexts(GlobalVarContext.class);
		}
		public GlobalVarContext globalVar(int i) {
			return getRuleContext(GlobalVarContext.class,i);
		}
		public GlobalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterGlobalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitGlobalStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitGlobalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalStatementContext globalStatement() throws RecognitionException {
		GlobalStatementContext _localctx = new GlobalStatementContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_globalStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(916);
			match(Global);
			setState(917);
			globalVar();
			setState(922);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(918);
				match(Comma);
				setState(919);
				globalVar();
				}
				}
				setState(924);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(925);
			match(SemiColon);
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

	public static class GlobalVarContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(PhpParser.VarName, 0); }
		public TerminalNode Dollar() { return getToken(PhpParser.Dollar, 0); }
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GlobalVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterGlobalVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitGlobalVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitGlobalVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalVarContext globalVar() throws RecognitionException {
		GlobalVarContext _localctx = new GlobalVarContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_globalVar);
		try {
			setState(935);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(927);
				match(VarName);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(928);
				match(Dollar);
				setState(929);
				chain();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(930);
				match(Dollar);
				setState(931);
				match(OpenCurlyBracket);
				setState(932);
				expression(0);
				setState(933);
				match(CloseCurlyBracket);
				}
				break;
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

	public static class EchoStatementContext extends ParserRuleContext {
		public TerminalNode Echo() { return getToken(PhpParser.Echo, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public EchoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_echoStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterEchoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitEchoStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitEchoStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EchoStatementContext echoStatement() throws RecognitionException {
		EchoStatementContext _localctx = new EchoStatementContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_echoStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(937);
			match(Echo);
			setState(938);
			expressionList();
			setState(939);
			match(SemiColon);
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

	public static class StaticVariableStatementContext extends ParserRuleContext {
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public StaticVariableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticVariableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterStaticVariableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitStaticVariableStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitStaticVariableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaticVariableStatementContext staticVariableStatement() throws RecognitionException {
		StaticVariableStatementContext _localctx = new StaticVariableStatementContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_staticVariableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(941);
			match(Static);
			setState(942);
			variableInitializer();
			setState(947);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(943);
				match(Comma);
				setState(944);
				variableInitializer();
				}
				}
				setState(949);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(950);
			match(SemiColon);
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

	public static class ClassStatementContext extends ParserRuleContext {
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public PropertyModifiersContext propertyModifiers() {
			return getRuleContext(PropertyModifiersContext.class,0);
		}
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public TerminalNode Const() { return getToken(PhpParser.Const, 0); }
		public List<IdentifierInititalizerContext> identifierInititalizer() {
			return getRuleContexts(IdentifierInititalizerContext.class);
		}
		public IdentifierInititalizerContext identifierInititalizer(int i) {
			return getRuleContext(IdentifierInititalizerContext.class,i);
		}
		public TerminalNode Function() { return getToken(PhpParser.Function, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public MemberModifiersContext memberModifiers() {
			return getRuleContext(MemberModifiersContext.class,0);
		}
		public TypeParameterListInBracketsContext typeParameterListInBrackets() {
			return getRuleContext(TypeParameterListInBracketsContext.class,0);
		}
		public BaseCtorCallContext baseCtorCall() {
			return getRuleContext(BaseCtorCallContext.class,0);
		}
		public TerminalNode Use() { return getToken(PhpParser.Use, 0); }
		public QualifiedNamespaceNameListContext qualifiedNamespaceNameList() {
			return getRuleContext(QualifiedNamespaceNameListContext.class,0);
		}
		public TraitAdaptationsContext traitAdaptations() {
			return getRuleContext(TraitAdaptationsContext.class,0);
		}
		public ClassStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterClassStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitClassStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitClassStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassStatementContext classStatement() throws RecognitionException {
		ClassStatementContext _localctx = new ClassStatementContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_classStatement);
		int _la;
		try {
			setState(1000);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(952);
				attributes();
				setState(953);
				propertyModifiers();
				setState(954);
				variableInitializer();
				setState(959);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(955);
					match(Comma);
					setState(956);
					variableInitializer();
					}
					}
					setState(961);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(962);
				match(SemiColon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(964);
				attributes();
				setState(965);
				match(Const);
				setState(966);
				identifierInititalizer();
				setState(971);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(967);
					match(Comma);
					setState(968);
					identifierInititalizer();
					}
					}
					setState(973);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(974);
				match(SemiColon);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(976);
				attributes();
				setState(978);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Abstract || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (Final - 75)) | (1L << (Private - 75)) | (1L << (Protected - 75)) | (1L << (Public - 75)) | (1L << (Static - 75)))) != 0)) {
					{
					setState(977);
					memberModifiers();
					}
				}

				setState(980);
				match(Function);
				setState(982);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ampersand) {
					{
					setState(981);
					match(Ampersand);
					}
				}

				setState(984);
				identifier();
				setState(986);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Lgeneric) {
					{
					setState(985);
					typeParameterListInBrackets();
					}
				}

				setState(988);
				match(OpenRoundBracket);
				setState(989);
				formalParameterList();
				setState(990);
				match(CloseRoundBracket);
				setState(992);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(991);
					baseCtorCall();
					}
				}

				setState(994);
				methodBody();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(996);
				match(Use);
				setState(997);
				qualifiedNamespaceNameList();
				setState(998);
				traitAdaptations();
				}
				break;
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

	public static class TraitAdaptationsContext extends ParserRuleContext {
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public List<TraitAdaptationStatementContext> traitAdaptationStatement() {
			return getRuleContexts(TraitAdaptationStatementContext.class);
		}
		public TraitAdaptationStatementContext traitAdaptationStatement(int i) {
			return getRuleContext(TraitAdaptationStatementContext.class,i);
		}
		public TraitAdaptationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitAdaptations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTraitAdaptations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTraitAdaptations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTraitAdaptations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitAdaptationsContext traitAdaptations() throws RecognitionException {
		TraitAdaptationsContext _localctx = new TraitAdaptationsContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_traitAdaptations);
		int _la;
		try {
			setState(1011);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SemiColon:
				enterOuterAlt(_localctx, 1);
				{
				setState(1002);
				match(SemiColon);
				}
				break;
			case OpenCurlyBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1003);
				match(OpenCurlyBracket);
				setState(1007);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)))) != 0) || _la==NamespaceSeparator || _la==Label) {
					{
					{
					setState(1004);
					traitAdaptationStatement();
					}
					}
					setState(1009);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1010);
				match(CloseCurlyBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TraitAdaptationStatementContext extends ParserRuleContext {
		public TraitPrecedenceContext traitPrecedence() {
			return getRuleContext(TraitPrecedenceContext.class,0);
		}
		public TraitAliasContext traitAlias() {
			return getRuleContext(TraitAliasContext.class,0);
		}
		public TraitAdaptationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitAdaptationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTraitAdaptationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTraitAdaptationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTraitAdaptationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitAdaptationStatementContext traitAdaptationStatement() throws RecognitionException {
		TraitAdaptationStatementContext _localctx = new TraitAdaptationStatementContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_traitAdaptationStatement);
		try {
			setState(1015);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1013);
				traitPrecedence();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1014);
				traitAlias();
				}
				break;
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

	public static class TraitPrecedenceContext extends ParserRuleContext {
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode InsteadOf() { return getToken(PhpParser.InsteadOf, 0); }
		public QualifiedNamespaceNameListContext qualifiedNamespaceNameList() {
			return getRuleContext(QualifiedNamespaceNameListContext.class,0);
		}
		public TraitPrecedenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitPrecedence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTraitPrecedence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTraitPrecedence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTraitPrecedence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitPrecedenceContext traitPrecedence() throws RecognitionException {
		TraitPrecedenceContext _localctx = new TraitPrecedenceContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_traitPrecedence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1017);
			qualifiedNamespaceName();
			setState(1018);
			match(DoubleColon);
			setState(1019);
			identifier();
			setState(1020);
			match(InsteadOf);
			setState(1021);
			qualifiedNamespaceNameList();
			setState(1022);
			match(SemiColon);
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

	public static class TraitAliasContext extends ParserRuleContext {
		public TraitMethodReferenceContext traitMethodReference() {
			return getRuleContext(TraitMethodReferenceContext.class,0);
		}
		public TerminalNode As() { return getToken(PhpParser.As, 0); }
		public MemberModifierContext memberModifier() {
			return getRuleContext(MemberModifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TraitAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTraitAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTraitAlias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTraitAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitAliasContext traitAlias() throws RecognitionException {
		TraitAliasContext _localctx = new TraitAliasContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_traitAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1024);
			traitMethodReference();
			setState(1025);
			match(As);
			setState(1031);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				{
				setState(1026);
				memberModifier();
				}
				break;
			case 2:
				{
				setState(1028);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(1027);
					memberModifier();
					}
					break;
				}
				setState(1030);
				identifier();
				}
				break;
			}
			setState(1033);
			match(SemiColon);
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

	public static class TraitMethodReferenceContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public TraitMethodReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitMethodReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTraitMethodReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTraitMethodReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTraitMethodReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitMethodReferenceContext traitMethodReference() throws RecognitionException {
		TraitMethodReferenceContext _localctx = new TraitMethodReferenceContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_traitMethodReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1038);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(1035);
				qualifiedNamespaceName();
				setState(1036);
				match(DoubleColon);
				}
				break;
			}
			setState(1040);
			identifier();
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

	public static class BaseCtorCallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BaseCtorCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseCtorCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterBaseCtorCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitBaseCtorCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitBaseCtorCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseCtorCallContext baseCtorCall() throws RecognitionException {
		BaseCtorCallContext _localctx = new BaseCtorCallContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_baseCtorCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1042);
			match(Colon);
			setState(1043);
			identifier();
			setState(1044);
			arguments();
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

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_methodBody);
		try {
			setState(1048);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SemiColon:
				enterOuterAlt(_localctx, 1);
				{
				setState(1046);
				match(SemiColon);
				}
				break;
			case OpenCurlyBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1047);
				blockStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PropertyModifiersContext extends ParserRuleContext {
		public MemberModifiersContext memberModifiers() {
			return getRuleContext(MemberModifiersContext.class,0);
		}
		public TerminalNode Var() { return getToken(PhpParser.Var, 0); }
		public PropertyModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyModifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPropertyModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPropertyModifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitPropertyModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyModifiersContext propertyModifiers() throws RecognitionException {
		PropertyModifiersContext _localctx = new PropertyModifiersContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_propertyModifiers);
		try {
			setState(1052);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Abstract:
			case Final:
			case Private:
			case Protected:
			case Public:
			case Static:
				enterOuterAlt(_localctx, 1);
				{
				setState(1050);
				memberModifiers();
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 2);
				{
				setState(1051);
				match(Var);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class MemberModifiersContext extends ParserRuleContext {
		public List<MemberModifierContext> memberModifier() {
			return getRuleContexts(MemberModifierContext.class);
		}
		public MemberModifierContext memberModifier(int i) {
			return getRuleContext(MemberModifierContext.class,i);
		}
		public MemberModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberModifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMemberModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMemberModifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitMemberModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberModifiersContext memberModifiers() throws RecognitionException {
		MemberModifiersContext _localctx = new MemberModifiersContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_memberModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1055); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1054);
				memberModifier();
				}
				}
				setState(1057); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Abstract || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (Final - 75)) | (1L << (Private - 75)) | (1L << (Protected - 75)) | (1L << (Public - 75)) | (1L << (Static - 75)))) != 0) );
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

	public static class VariableInitializerContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(PhpParser.VarName, 0); }
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public ConstantInititalizerContext constantInititalizer() {
			return getRuleContext(ConstantInititalizerContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitVariableInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitVariableInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_variableInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1059);
			match(VarName);
			setState(1062);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Eq) {
				{
				setState(1060);
				match(Eq);
				setState(1061);
				constantInititalizer();
				}
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

	public static class IdentifierInititalizerContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public ConstantInititalizerContext constantInititalizer() {
			return getRuleContext(ConstantInititalizerContext.class,0);
		}
		public IdentifierInititalizerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierInititalizer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIdentifierInititalizer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIdentifierInititalizer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitIdentifierInititalizer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierInititalizerContext identifierInititalizer() throws RecognitionException {
		IdentifierInititalizerContext _localctx = new IdentifierInititalizerContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_identifierInititalizer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1064);
			identifier();
			setState(1065);
			match(Eq);
			setState(1066);
			constantInititalizer();
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

	public static class GlobalConstantDeclarationContext extends ParserRuleContext {
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TerminalNode Const() { return getToken(PhpParser.Const, 0); }
		public List<IdentifierInititalizerContext> identifierInititalizer() {
			return getRuleContexts(IdentifierInititalizerContext.class);
		}
		public IdentifierInititalizerContext identifierInititalizer(int i) {
			return getRuleContext(IdentifierInititalizerContext.class,i);
		}
		public GlobalConstantDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalConstantDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterGlobalConstantDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitGlobalConstantDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitGlobalConstantDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalConstantDeclarationContext globalConstantDeclaration() throws RecognitionException {
		GlobalConstantDeclarationContext _localctx = new GlobalConstantDeclarationContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_globalConstantDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1068);
			attributes();
			setState(1069);
			match(Const);
			setState(1070);
			identifierInititalizer();
			setState(1075);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1071);
				match(Comma);
				setState(1072);
				identifierInititalizer();
				}
				}
				setState(1077);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1078);
			match(SemiColon);
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1080);
			expression(0);
			setState(1085);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1081);
				match(Comma);
				setState(1082);
				expression(0);
				}
				}
				setState(1087);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ParenthesisContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public YieldExpressionContext yieldExpression() {
			return getRuleContext(YieldExpressionContext.class,0);
		}
		public ParenthesisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesisContext parenthesis() throws RecognitionException {
		ParenthesisContext _localctx = new ParenthesisContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_parenthesis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1088);
			match(OpenRoundBracket);
			setState(1091);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				{
				setState(1089);
				expression(0);
				}
				break;
			case 2:
				{
				setState(1090);
				yieldExpression();
				}
				break;
			}
			setState(1093);
			match(CloseRoundBracket);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ChainExpressionContext extends ExpressionContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public ChainExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterChainExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitChainExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitChainExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryOperatorExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryOperatorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterUnaryOperatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitUnaryOperatorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitUnaryOperatorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SpecialWordExpressionContext extends ExpressionContext {
		public TerminalNode Yield() { return getToken(PhpParser.Yield, 0); }
		public TerminalNode List() { return getToken(PhpParser.List, 0); }
		public AssignmentListContext assignmentList() {
			return getRuleContext(AssignmentListContext.class,0);
		}
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IsSet() { return getToken(PhpParser.IsSet, 0); }
		public ChainListContext chainList() {
			return getRuleContext(ChainListContext.class,0);
		}
		public TerminalNode Empty() { return getToken(PhpParser.Empty, 0); }
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public TerminalNode Eval() { return getToken(PhpParser.Eval, 0); }
		public TerminalNode Exit() { return getToken(PhpParser.Exit, 0); }
		public ParenthesisContext parenthesis() {
			return getRuleContext(ParenthesisContext.class,0);
		}
		public SpecialWordExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterSpecialWordExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitSpecialWordExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitSpecialWordExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayCreationExpressionContext extends ExpressionContext {
		public TerminalNode Array() { return getToken(PhpParser.Array, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayItemListContext arrayItemList() {
			return getRuleContext(ArrayItemListContext.class,0);
		}
		public ArrayCreationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArrayCreationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArrayCreationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitArrayCreationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExpressionContext extends ExpressionContext {
		public NewExprContext newExpr() {
			return getRuleContext(NewExprContext.class,0);
		}
		public NewExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNewExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitNewExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisExpressionContext extends ExpressionContext {
		public ParenthesisContext parenthesis() {
			return getRuleContext(ParenthesisContext.class,0);
		}
		public ParenthesisExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterParenthesisExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitParenthesisExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitParenthesisExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BackQuoteStringExpressionContext extends ExpressionContext {
		public TerminalNode BackQuoteString() { return getToken(PhpParser.BackQuoteString, 0); }
		public BackQuoteStringExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterBackQuoteStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitBackQuoteStringExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitBackQuoteStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode QuestionMark() { return getToken(PhpParser.QuestionMark, 0); }
		public ConditionalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Divide() { return getToken(PhpParser.Divide, 0); }
		public ArithmeticExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArithmeticExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexerExpressionContext extends ExpressionContext {
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IndexerExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIndexerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIndexerExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitIndexerExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ScalarExpressionContext extends ExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode Label() { return getToken(PhpParser.Label, 0); }
		public ScalarExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterScalarExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitScalarExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitScalarExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixIncDecExpressionContext extends ExpressionContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public PrefixIncDecExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPrefixIncDecExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPrefixIncDecExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitPrefixIncDecExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Less() { return getToken(PhpParser.Less, 0); }
		public TerminalNode Greater() { return getToken(PhpParser.Greater, 0); }
		public TerminalNode IsNotEq() { return getToken(PhpParser.IsNotEq, 0); }
		public ComparisonExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LogicalAnd() { return getToken(PhpParser.LogicalAnd, 0); }
		public TerminalNode LogicalXor() { return getToken(PhpParser.LogicalXor, 0); }
		public TerminalNode LogicalOr() { return getToken(PhpParser.LogicalOr, 0); }
		public LogicalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterLogicalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitLogicalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitLogicalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintExpressionContext extends ExpressionContext {
		public TerminalNode Print() { return getToken(PhpParser.Print, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPrintExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPrintExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitPrintExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentExpressionContext extends ExpressionContext {
		public List<ChainContext> chain() {
			return getRuleContexts(ChainContext.class);
		}
		public ChainContext chain(int i) {
			return getRuleContext(ChainContext.class,i);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public NewExprContext newExpr() {
			return getRuleContext(NewExprContext.class,0);
		}
		public AssignmentExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixIncDecExpressionContext extends ExpressionContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public PostfixIncDecExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPostfixIncDecExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPostfixIncDecExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitPostfixIncDecExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IncludeExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Include() { return getToken(PhpParser.Include, 0); }
		public TerminalNode IncludeOnce() { return getToken(PhpParser.IncludeOnce, 0); }
		public TerminalNode Require() { return getToken(PhpParser.Require, 0); }
		public TerminalNode RequireOnce() { return getToken(PhpParser.RequireOnce, 0); }
		public IncludeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIncludeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIncludeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitIncludeExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastExpressionContext extends ExpressionContext {
		public CastOperationContext castOperation() {
			return getRuleContext(CastOperationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CastExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InstanceOfExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode InstanceOf() { return getToken(PhpParser.InstanceOf, 0); }
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public InstanceOfExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInstanceOfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInstanceOfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitInstanceOfExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaFunctionExpressionContext extends ExpressionContext {
		public TerminalNode Function() { return getToken(PhpParser.Function, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public LambdaFunctionUseVarsContext lambdaFunctionUseVars() {
			return getRuleContext(LambdaFunctionUseVarsContext.class,0);
		}
		public LambdaFunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterLambdaFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitLambdaFunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitLambdaFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BitwiseExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterBitwiseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitBitwiseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitBitwiseExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CloneExpressionContext extends ExpressionContext {
		public TerminalNode Clone() { return getToken(PhpParser.Clone, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CloneExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterCloneExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitCloneExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitCloneExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 168;
		enterRecursionRule(_localctx, 168, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				{
				_localctx = new CloneExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1096);
				match(Clone);
				setState(1097);
				expression(43);
				}
				break;
			case 2:
				{
				_localctx = new NewExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1098);
				newExpr();
				}
				break;
			case 3:
				{
				_localctx = new IndexerExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1099);
				stringConstant();
				setState(1100);
				match(OpenSquareBracket);
				setState(1101);
				expression(0);
				setState(1102);
				match(CloseSquareBracket);
				}
				break;
			case 4:
				{
				_localctx = new CastExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1104);
				match(OpenRoundBracket);
				setState(1105);
				castOperation();
				setState(1106);
				match(CloseRoundBracket);
				setState(1107);
				expression(40);
				}
				break;
			case 5:
				{
				_localctx = new UnaryOperatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1109);
				_la = _input.LA(1);
				if ( !(_la==Tilde || _la==SuppressWarnings) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1110);
				expression(39);
				}
				break;
			case 6:
				{
				_localctx = new UnaryOperatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1111);
				_la = _input.LA(1);
				if ( !(((((_la - 188)) & ~0x3f) == 0 && ((1L << (_la - 188)) & ((1L << (Bang - 188)) | (1L << (Plus - 188)) | (1L << (Minus - 188)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1112);
				expression(38);
				}
				break;
			case 7:
				{
				_localctx = new PrefixIncDecExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1113);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1114);
				chain();
				}
				break;
			case 8:
				{
				_localctx = new PostfixIncDecExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1115);
				chain();
				setState(1116);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 9:
				{
				_localctx = new PrintExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1118);
				match(Print);
				setState(1119);
				expression(35);
				}
				break;
			case 10:
				{
				_localctx = new ChainExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1120);
				chain();
				}
				break;
			case 11:
				{
				_localctx = new ScalarExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1121);
				constant();
				}
				break;
			case 12:
				{
				_localctx = new ScalarExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1122);
				string();
				}
				break;
			case 13:
				{
				_localctx = new ScalarExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1123);
				match(Label);
				}
				break;
			case 14:
				{
				_localctx = new BackQuoteStringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1124);
				match(BackQuoteString);
				}
				break;
			case 15:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1125);
				parenthesis();
				}
				break;
			case 16:
				{
				_localctx = new ArrayCreationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1137);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Array:
					{
					setState(1126);
					match(Array);
					setState(1127);
					match(OpenRoundBracket);
					setState(1129);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)) | (1L << (Inc - 107)) | (1L << (Dec - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Ampersand - 182)) | (1L << (Bang - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Tilde - 182)) | (1L << (SuppressWarnings - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (BackQuoteString - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
						{
						setState(1128);
						arrayItemList();
						}
					}

					setState(1131);
					match(CloseRoundBracket);
					}
					break;
				case OpenSquareBracket:
					{
					setState(1132);
					match(OpenSquareBracket);
					setState(1134);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)) | (1L << (Inc - 107)) | (1L << (Dec - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Ampersand - 182)) | (1L << (Bang - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Tilde - 182)) | (1L << (SuppressWarnings - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (BackQuoteString - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
						{
						setState(1133);
						arrayItemList();
						}
					}

					setState(1136);
					match(CloseSquareBracket);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1143);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
				case 1:
					{
					setState(1139);
					match(OpenSquareBracket);
					setState(1140);
					expression(0);
					setState(1141);
					match(CloseSquareBracket);
					}
					break;
				}
				}
				break;
			case 17:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1145);
				match(Yield);
				}
				break;
			case 18:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1146);
				match(List);
				setState(1147);
				match(OpenRoundBracket);
				setState(1148);
				assignmentList();
				setState(1149);
				match(CloseRoundBracket);
				setState(1150);
				match(Eq);
				setState(1151);
				expression(26);
				}
				break;
			case 19:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1153);
				match(IsSet);
				setState(1154);
				match(OpenRoundBracket);
				setState(1155);
				chainList();
				setState(1156);
				match(CloseRoundBracket);
				}
				break;
			case 20:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1158);
				match(Empty);
				setState(1159);
				match(OpenRoundBracket);
				setState(1160);
				chain();
				setState(1161);
				match(CloseRoundBracket);
				}
				break;
			case 21:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1163);
				match(Eval);
				setState(1164);
				match(OpenRoundBracket);
				setState(1165);
				expression(0);
				setState(1166);
				match(CloseRoundBracket);
				}
				break;
			case 22:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1168);
				match(Exit);
				setState(1172);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
				case 1:
					{
					setState(1169);
					match(OpenRoundBracket);
					setState(1170);
					match(CloseRoundBracket);
					}
					break;
				case 2:
					{
					setState(1171);
					parenthesis();
					}
					break;
				}
				}
				break;
			case 23:
				{
				_localctx = new IncludeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1174);
				_la = _input.LA(1);
				if ( !(_la==Include || _la==IncludeOnce) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1175);
				expression(21);
				}
				break;
			case 24:
				{
				_localctx = new IncludeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1176);
				_la = _input.LA(1);
				if ( !(_la==Require || _la==RequireOnce) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1177);
				expression(20);
				}
				break;
			case 25:
				{
				_localctx = new LambdaFunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Static) {
					{
					setState(1178);
					match(Static);
					}
				}

				setState(1181);
				match(Function);
				setState(1183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ampersand) {
					{
					setState(1182);
					match(Ampersand);
					}
				}

				setState(1185);
				match(OpenRoundBracket);
				setState(1186);
				formalParameterList();
				setState(1187);
				match(CloseRoundBracket);
				setState(1189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Use) {
					{
					setState(1188);
					lambdaFunctionUseVars();
					}
				}

				setState(1191);
				blockStatement();
				}
				break;
			case 26:
				{
				_localctx = new AssignmentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1193);
				chain();
				setState(1194);
				assignmentOperator();
				setState(1195);
				expression(5);
				}
				break;
			case 27:
				{
				_localctx = new AssignmentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1197);
				chain();
				setState(1198);
				match(Eq);
				setState(1199);
				match(Ampersand);
				setState(1202);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
				case 1:
					{
					setState(1200);
					chain();
					}
					break;
				case 2:
					{
					setState(1201);
					newExpr();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1258);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1206);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(1207);
						((ArithmeticExpressionContext)_localctx).op = match(Pow);
						setState(1208);
						expression(18);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1209);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1210);
						((ArithmeticExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (Asterisk - 192)) | (1L << (Percent - 192)) | (1L << (Divide - 192)))) != 0)) ) {
							((ArithmeticExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1211);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1212);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1213);
						((ArithmeticExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 190)) & ~0x3f) == 0 && ((1L << (_la - 190)) & ((1L << (Plus - 190)) | (1L << (Minus - 190)) | (1L << (Dot - 190)))) != 0)) ) {
							((ArithmeticExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1214);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1215);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1216);
						((ComparisonExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ShiftLeft || _la==ShiftRight) ) {
							((ComparisonExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1217);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1218);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1219);
						((ComparisonExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 161)) & ~0x3f) == 0 && ((1L << (_la - 161)) & ((1L << (IsSmallerOrEqual - 161)) | (1L << (IsGreaterOrEqual - 161)) | (1L << (Less - 161)) | (1L << (Greater - 161)))) != 0)) ) {
							((ComparisonExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1220);
						expression(14);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1221);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1222);
						((ComparisonExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 157)) & ~0x3f) == 0 && ((1L << (_la - 157)) & ((1L << (IsIdentical - 157)) | (1L << (IsNoidentical - 157)) | (1L << (IsEqual - 157)) | (1L << (IsNotEq - 157)))) != 0)) ) {
							((ComparisonExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1223);
						expression(13);
						}
						break;
					case 7:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1224);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1225);
						((BitwiseExpressionContext)_localctx).op = match(Ampersand);
						setState(1226);
						expression(12);
						}
						break;
					case 8:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1227);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1228);
						((BitwiseExpressionContext)_localctx).op = match(Caret);
						setState(1229);
						expression(11);
						}
						break;
					case 9:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1230);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1231);
						((BitwiseExpressionContext)_localctx).op = match(Pipe);
						setState(1232);
						expression(10);
						}
						break;
					case 10:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1233);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1234);
						((BitwiseExpressionContext)_localctx).op = match(BooleanAnd);
						setState(1235);
						expression(9);
						}
						break;
					case 11:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1236);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1237);
						((BitwiseExpressionContext)_localctx).op = match(BooleanOr);
						setState(1238);
						expression(8);
						}
						break;
					case 12:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1239);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1240);
						((ConditionalExpressionContext)_localctx).op = match(QuestionMark);
						setState(1242);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)) | (1L << (Inc - 107)) | (1L << (Dec - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Bang - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Tilde - 182)) | (1L << (SuppressWarnings - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (BackQuoteString - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
							{
							setState(1241);
							expression(0);
							}
						}

						setState(1244);
						match(Colon);
						setState(1245);
						expression(7);
						}
						break;
					case 13:
						{
						_localctx = new LogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1246);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1247);
						((LogicalExpressionContext)_localctx).op = match(LogicalAnd);
						setState(1248);
						expression(4);
						}
						break;
					case 14:
						{
						_localctx = new LogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1249);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1250);
						((LogicalExpressionContext)_localctx).op = match(LogicalXor);
						setState(1251);
						expression(3);
						}
						break;
					case 15:
						{
						_localctx = new LogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1252);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1253);
						((LogicalExpressionContext)_localctx).op = match(LogicalOr);
						setState(1254);
						expression(2);
						}
						break;
					case 16:
						{
						_localctx = new InstanceOfExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1255);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(1256);
						match(InstanceOf);
						setState(1257);
						typeRef();
						}
						break;
					}
					} 
				}
				setState(1262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,122,_ctx);
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

	public static class NewExprContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(PhpParser.New, 0); }
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public NewExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExprContext newExpr() throws RecognitionException {
		NewExprContext _localctx = new NewExprContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_newExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1263);
			match(New);
			setState(1264);
			typeRef();
			setState(1266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				{
				setState(1265);
				arguments();
				}
				break;
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

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAssignmentOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitAssignmentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1268);
			_la = _input.LA(1);
			if ( !(((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & ((1L << (PlusEqual - 163)) | (1L << (MinusEqual - 163)) | (1L << (MulEqual - 163)) | (1L << (PowEqual - 163)) | (1L << (DivEqual - 163)) | (1L << (Concaequal - 163)) | (1L << (ModEqual - 163)) | (1L << (ShiftLeftEqual - 163)) | (1L << (ShiftRightEqual - 163)) | (1L << (AndEqual - 163)) | (1L << (OrEqual - 163)) | (1L << (XorEqual - 163)) | (1L << (Eq - 163)))) != 0)) ) {
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

	public static class YieldExpressionContext extends ParserRuleContext {
		public TerminalNode Yield() { return getToken(PhpParser.Yield, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public YieldExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yieldExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterYieldExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitYieldExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitYieldExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YieldExpressionContext yieldExpression() throws RecognitionException {
		YieldExpressionContext _localctx = new YieldExpressionContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_yieldExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1270);
			match(Yield);
			setState(1271);
			expression(0);
			setState(1274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DoubleArrow) {
				{
				setState(1272);
				match(DoubleArrow);
				setState(1273);
				expression(0);
				}
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

	public static class ArrayItemListContext extends ParserRuleContext {
		public List<ArrayItemContext> arrayItem() {
			return getRuleContexts(ArrayItemContext.class);
		}
		public ArrayItemContext arrayItem(int i) {
			return getRuleContext(ArrayItemContext.class,i);
		}
		public ArrayItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayItemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArrayItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArrayItemList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitArrayItemList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayItemListContext arrayItemList() throws RecognitionException {
		ArrayItemListContext _localctx = new ArrayItemListContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_arrayItemList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1276);
			arrayItem();
			setState(1281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1277);
					match(Comma);
					setState(1278);
					arrayItem();
					}
					} 
				}
				setState(1283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			}
			setState(1285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(1284);
				match(Comma);
				}
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

	public static class ArrayItemContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public ArrayItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArrayItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArrayItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitArrayItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayItemContext arrayItem() throws RecognitionException {
		ArrayItemContext _localctx = new ArrayItemContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_arrayItem);
		int _la;
		try {
			setState(1299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1287);
				expression(0);
				setState(1290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleArrow) {
					{
					setState(1288);
					match(DoubleArrow);
					setState(1289);
					expression(0);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)) | (1L << (Inc - 107)) | (1L << (Dec - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Bang - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Tilde - 182)) | (1L << (SuppressWarnings - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (BackQuoteString - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
					{
					setState(1292);
					expression(0);
					setState(1293);
					match(DoubleArrow);
					}
				}

				setState(1297);
				match(Ampersand);
				setState(1298);
				chain();
				}
				break;
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

	public static class LambdaFunctionUseVarsContext extends ParserRuleContext {
		public TerminalNode Use() { return getToken(PhpParser.Use, 0); }
		public List<LambdaFunctionUseVarContext> lambdaFunctionUseVar() {
			return getRuleContexts(LambdaFunctionUseVarContext.class);
		}
		public LambdaFunctionUseVarContext lambdaFunctionUseVar(int i) {
			return getRuleContext(LambdaFunctionUseVarContext.class,i);
		}
		public LambdaFunctionUseVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaFunctionUseVars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterLambdaFunctionUseVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitLambdaFunctionUseVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitLambdaFunctionUseVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaFunctionUseVarsContext lambdaFunctionUseVars() throws RecognitionException {
		LambdaFunctionUseVarsContext _localctx = new LambdaFunctionUseVarsContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_lambdaFunctionUseVars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1301);
			match(Use);
			setState(1302);
			match(OpenRoundBracket);
			setState(1303);
			lambdaFunctionUseVar();
			setState(1308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1304);
				match(Comma);
				setState(1305);
				lambdaFunctionUseVar();
				}
				}
				setState(1310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1311);
			match(CloseRoundBracket);
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

	public static class LambdaFunctionUseVarContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(PhpParser.VarName, 0); }
		public LambdaFunctionUseVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaFunctionUseVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterLambdaFunctionUseVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitLambdaFunctionUseVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitLambdaFunctionUseVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaFunctionUseVarContext lambdaFunctionUseVar() throws RecognitionException {
		LambdaFunctionUseVarContext _localctx = new LambdaFunctionUseVarContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_lambdaFunctionUseVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ampersand) {
				{
				setState(1313);
				match(Ampersand);
				}
			}

			setState(1316);
			match(VarName);
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

	public static class QualifiedStaticTypeRefContext extends ParserRuleContext {
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public GenericDynamicArgsContext genericDynamicArgs() {
			return getRuleContext(GenericDynamicArgsContext.class,0);
		}
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public QualifiedStaticTypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedStaticTypeRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterQualifiedStaticTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitQualifiedStaticTypeRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitQualifiedStaticTypeRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedStaticTypeRefContext qualifiedStaticTypeRef() throws RecognitionException {
		QualifiedStaticTypeRefContext _localctx = new QualifiedStaticTypeRefContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_qualifiedStaticTypeRef);
		int _la;
		try {
			setState(1323);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1318);
				qualifiedNamespaceName();
				setState(1320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Lgeneric) {
					{
					setState(1319);
					genericDynamicArgs();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1322);
				match(Static);
				}
				break;
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

	public static class TypeRefContext extends ParserRuleContext {
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public IndirectTypeRefContext indirectTypeRef() {
			return getRuleContext(IndirectTypeRefContext.class,0);
		}
		public GenericDynamicArgsContext genericDynamicArgs() {
			return getRuleContext(GenericDynamicArgsContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public TypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitTypeRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeRefContext typeRef() throws RecognitionException {
		TypeRefContext _localctx = new TypeRefContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_typeRef);
		try {
			setState(1334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1327);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
				case 1:
					{
					setState(1325);
					qualifiedNamespaceName();
					}
					break;
				case 2:
					{
					setState(1326);
					indirectTypeRef();
					}
					break;
				}
				setState(1330);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
				case 1:
					{
					setState(1329);
					genericDynamicArgs();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1332);
				primitiveType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1333);
				match(Static);
				}
				break;
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

	public static class IndirectTypeRefContext extends ParserRuleContext {
		public ChainBaseContext chainBase() {
			return getRuleContext(ChainBaseContext.class,0);
		}
		public List<KeyedFieldNameContext> keyedFieldName() {
			return getRuleContexts(KeyedFieldNameContext.class);
		}
		public KeyedFieldNameContext keyedFieldName(int i) {
			return getRuleContext(KeyedFieldNameContext.class,i);
		}
		public IndirectTypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indirectTypeRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIndirectTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIndirectTypeRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitIndirectTypeRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndirectTypeRefContext indirectTypeRef() throws RecognitionException {
		IndirectTypeRefContext _localctx = new IndirectTypeRefContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_indirectTypeRef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1336);
			chainBase();
			setState(1341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1337);
					match(ObjectOperator);
					setState(1338);
					keyedFieldName();
					}
					} 
				}
				setState(1343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
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

	public static class QualifiedNamespaceNameContext extends ParserRuleContext {
		public NamespaceNameListContext namespaceNameList() {
			return getRuleContext(NamespaceNameListContext.class,0);
		}
		public TerminalNode Namespace() { return getToken(PhpParser.Namespace, 0); }
		public QualifiedNamespaceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNamespaceName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterQualifiedNamespaceName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitQualifiedNamespaceName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitQualifiedNamespaceName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNamespaceNameContext qualifiedNamespaceName() throws RecognitionException {
		QualifiedNamespaceNameContext _localctx = new QualifiedNamespaceNameContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_qualifiedNamespaceName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(1344);
				match(Namespace);
				}
				break;
			}
			setState(1348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NamespaceSeparator) {
				{
				setState(1347);
				match(NamespaceSeparator);
				}
			}

			setState(1350);
			namespaceNameList();
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

	public static class NamespaceNameListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public NamespaceNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNamespaceNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNamespaceNameList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitNamespaceNameList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceNameListContext namespaceNameList() throws RecognitionException {
		NamespaceNameListContext _localctx = new NamespaceNameListContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_namespaceNameList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1352);
			identifier();
			setState(1357);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1353);
					match(NamespaceSeparator);
					setState(1354);
					identifier();
					}
					} 
				}
				setState(1359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
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

	public static class QualifiedNamespaceNameListContext extends ParserRuleContext {
		public List<QualifiedNamespaceNameContext> qualifiedNamespaceName() {
			return getRuleContexts(QualifiedNamespaceNameContext.class);
		}
		public QualifiedNamespaceNameContext qualifiedNamespaceName(int i) {
			return getRuleContext(QualifiedNamespaceNameContext.class,i);
		}
		public QualifiedNamespaceNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNamespaceNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterQualifiedNamespaceNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitQualifiedNamespaceNameList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitQualifiedNamespaceNameList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNamespaceNameListContext qualifiedNamespaceNameList() throws RecognitionException {
		QualifiedNamespaceNameListContext _localctx = new QualifiedNamespaceNameListContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_qualifiedNamespaceNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1360);
			qualifiedNamespaceName();
			setState(1365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1361);
				match(Comma);
				setState(1362);
				qualifiedNamespaceName();
				}
				}
				setState(1367);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ActualArgumentContext> actualArgument() {
			return getRuleContexts(ActualArgumentContext.class);
		}
		public ActualArgumentContext actualArgument(int i) {
			return getRuleContext(ActualArgumentContext.class,i);
		}
		public YieldExpressionContext yieldExpression() {
			return getRuleContext(YieldExpressionContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1368);
			match(OpenRoundBracket);
			setState(1378);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
			case 1:
				{
				setState(1369);
				actualArgument();
				setState(1374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(1370);
					match(Comma);
					setState(1371);
					actualArgument();
					}
					}
					setState(1376);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(1377);
				yieldExpression();
				}
				break;
			}
			setState(1380);
			match(CloseRoundBracket);
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

	public static class ActualArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public ActualArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterActualArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitActualArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitActualArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualArgumentContext actualArgument() throws RecognitionException {
		ActualArgumentContext _localctx = new ActualArgumentContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_actualArgument);
		int _la;
		try {
			setState(1388);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Abstract:
			case Array:
			case As:
			case BinaryCast:
			case BoolType:
			case BooleanConstant:
			case Break:
			case Callable:
			case Case:
			case Catch:
			case Class:
			case Clone:
			case Const:
			case Continue:
			case Declare:
			case Default:
			case Do:
			case DoubleCast:
			case DoubleType:
			case Echo:
			case Else:
			case ElseIf:
			case Empty:
			case EndDeclare:
			case EndFor:
			case EndForeach:
			case EndIf:
			case EndSwitch:
			case EndWhile:
			case Eval:
			case Exit:
			case Extends:
			case Final:
			case Finally:
			case FloatCast:
			case For:
			case Foreach:
			case Function:
			case Global:
			case Goto:
			case If:
			case Implements:
			case Import:
			case Include:
			case IncludeOnce:
			case InstanceOf:
			case InsteadOf:
			case Int8Cast:
			case Int16Cast:
			case Int64Type:
			case IntType:
			case Interface:
			case IsSet:
			case List:
			case LogicalAnd:
			case LogicalOr:
			case LogicalXor:
			case Namespace:
			case New:
			case Null:
			case ObjectType:
			case Parent_:
			case Partial:
			case Print:
			case Private:
			case Protected:
			case Public:
			case Require:
			case RequireOnce:
			case Resource:
			case Return:
			case Static:
			case StringType:
			case Switch:
			case Throw:
			case Trait:
			case Try:
			case Typeof:
			case UintCast:
			case UnicodeCast:
			case Unset:
			case Use:
			case Var:
			case While:
			case Yield:
			case Get:
			case Set:
			case Call:
			case CallStatic:
			case Constructor:
			case Destruct:
			case Wakeup:
			case Sleep:
			case Autoload:
			case IsSet__:
			case Unset__:
			case ToString__:
			case Invoke:
			case SetState:
			case Clone__:
			case DebugInfo:
			case Namespace__:
			case Class__:
			case Traic__:
			case Function__:
			case Method__:
			case Line__:
			case File__:
			case Dir__:
			case Inc:
			case Dec:
			case NamespaceSeparator:
			case Ellipsis:
			case Bang:
			case Plus:
			case Minus:
			case Tilde:
			case SuppressWarnings:
			case Dollar:
			case OpenRoundBracket:
			case OpenSquareBracket:
			case VarName:
			case Label:
			case Octal:
			case Decimal:
			case Real:
			case Hex:
			case Binary:
			case BackQuoteString:
			case SingleQuoteString:
			case DoubleQuote:
			case StartNowDoc:
			case StartHereDoc:
				enterOuterAlt(_localctx, 1);
				{
				setState(1383);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1382);
					match(Ellipsis);
					}
				}

				setState(1385);
				expression(0);
				}
				break;
			case Ampersand:
				enterOuterAlt(_localctx, 2);
				{
				setState(1386);
				match(Ampersand);
				setState(1387);
				chain();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ConstantInititalizerContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode Array() { return getToken(PhpParser.Array, 0); }
		public ConstantArrayItemListContext constantArrayItemList() {
			return getRuleContext(ConstantArrayItemListContext.class,0);
		}
		public ConstantInititalizerContext constantInititalizer() {
			return getRuleContext(ConstantInititalizerContext.class,0);
		}
		public ConstantInititalizerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantInititalizer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterConstantInititalizer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitConstantInititalizer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitConstantInititalizer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantInititalizerContext constantInititalizer() throws RecognitionException {
		ConstantInititalizerContext _localctx = new ConstantInititalizerContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_constantInititalizer);
		int _la;
		try {
			setState(1411);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1390);
				constant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1391);
				string();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1392);
				match(Array);
				setState(1393);
				match(OpenRoundBracket);
				setState(1398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Dollar - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
					{
					setState(1394);
					constantArrayItemList();
					setState(1396);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(1395);
						match(Comma);
						}
					}

					}
				}

				setState(1400);
				match(CloseRoundBracket);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1401);
				match(OpenSquareBracket);
				setState(1406);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Dollar - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
					{
					setState(1402);
					constantArrayItemList();
					setState(1404);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(1403);
						match(Comma);
						}
					}

					}
				}

				setState(1408);
				match(CloseSquareBracket);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1409);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1410);
				constantInititalizer();
				}
				break;
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

	public static class ConstantArrayItemListContext extends ParserRuleContext {
		public List<ConstantArrayItemContext> constantArrayItem() {
			return getRuleContexts(ConstantArrayItemContext.class);
		}
		public ConstantArrayItemContext constantArrayItem(int i) {
			return getRuleContext(ConstantArrayItemContext.class,i);
		}
		public ConstantArrayItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantArrayItemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterConstantArrayItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitConstantArrayItemList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitConstantArrayItemList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantArrayItemListContext constantArrayItemList() throws RecognitionException {
		ConstantArrayItemListContext _localctx = new ConstantArrayItemListContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_constantArrayItemList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1413);
			constantArrayItem();
			setState(1418);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1414);
					match(Comma);
					setState(1415);
					constantArrayItem();
					}
					} 
				}
				setState(1420);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
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

	public static class ConstantArrayItemContext extends ParserRuleContext {
		public List<ConstantInititalizerContext> constantInititalizer() {
			return getRuleContexts(ConstantInititalizerContext.class);
		}
		public ConstantInititalizerContext constantInititalizer(int i) {
			return getRuleContext(ConstantInititalizerContext.class,i);
		}
		public ConstantArrayItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantArrayItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterConstantArrayItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitConstantArrayItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitConstantArrayItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantArrayItemContext constantArrayItem() throws RecognitionException {
		ConstantArrayItemContext _localctx = new ConstantArrayItemContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_constantArrayItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1421);
			constantInititalizer();
			setState(1424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DoubleArrow) {
				{
				setState(1422);
				match(DoubleArrow);
				setState(1423);
				constantInititalizer();
				}
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode Null() { return getToken(PhpParser.Null, 0); }
		public LiteralConstantContext literalConstant() {
			return getRuleContext(LiteralConstantContext.class,0);
		}
		public MagicConstantContext magicConstant() {
			return getRuleContext(MagicConstantContext.class,0);
		}
		public ClassConstantContext classConstant() {
			return getRuleContext(ClassConstantContext.class,0);
		}
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_constant);
		try {
			setState(1431);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1426);
				match(Null);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1427);
				literalConstant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1428);
				magicConstant();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1429);
				classConstant();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1430);
				qualifiedNamespaceName();
				}
				break;
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

	public static class LiteralConstantContext extends ParserRuleContext {
		public TerminalNode Real() { return getToken(PhpParser.Real, 0); }
		public TerminalNode BooleanConstant() { return getToken(PhpParser.BooleanConstant, 0); }
		public NumericConstantContext numericConstant() {
			return getRuleContext(NumericConstantContext.class,0);
		}
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public LiteralConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterLiteralConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitLiteralConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitLiteralConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralConstantContext literalConstant() throws RecognitionException {
		LiteralConstantContext _localctx = new LiteralConstantContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_literalConstant);
		try {
			setState(1437);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Real:
				enterOuterAlt(_localctx, 1);
				{
				setState(1433);
				match(Real);
				}
				break;
			case BooleanConstant:
				enterOuterAlt(_localctx, 2);
				{
				setState(1434);
				match(BooleanConstant);
				}
				break;
			case Octal:
			case Decimal:
			case Hex:
			case Binary:
				enterOuterAlt(_localctx, 3);
				{
				setState(1435);
				numericConstant();
				}
				break;
			case Label:
				enterOuterAlt(_localctx, 4);
				{
				setState(1436);
				stringConstant();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class NumericConstantContext extends ParserRuleContext {
		public TerminalNode Octal() { return getToken(PhpParser.Octal, 0); }
		public TerminalNode Decimal() { return getToken(PhpParser.Decimal, 0); }
		public TerminalNode Hex() { return getToken(PhpParser.Hex, 0); }
		public TerminalNode Binary() { return getToken(PhpParser.Binary, 0); }
		public NumericConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNumericConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNumericConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitNumericConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericConstantContext numericConstant() throws RecognitionException {
		NumericConstantContext _localctx = new NumericConstantContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_numericConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1439);
			_la = _input.LA(1);
			if ( !(((((_la - 214)) & ~0x3f) == 0 && ((1L << (_la - 214)) & ((1L << (Octal - 214)) | (1L << (Decimal - 214)) | (1L << (Hex - 214)) | (1L << (Binary - 214)))) != 0)) ) {
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

	public static class ClassConstantContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(PhpParser.Class, 0); }
		public TerminalNode Parent_() { return getToken(PhpParser.Parent_, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Constructor() { return getToken(PhpParser.Constructor, 0); }
		public TerminalNode Get() { return getToken(PhpParser.Get, 0); }
		public TerminalNode Set() { return getToken(PhpParser.Set, 0); }
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public KeyedVariableContext keyedVariable() {
			return getRuleContext(KeyedVariableContext.class,0);
		}
		public ClassConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterClassConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitClassConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitClassConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassConstantContext classConstant() throws RecognitionException {
		ClassConstantContext _localctx = new ClassConstantContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_classConstant);
		int _la;
		try {
			setState(1456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1441);
				_la = _input.LA(1);
				if ( !(_la==Class || _la==Parent_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1442);
				match(DoubleColon);
				setState(1447);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
				case 1:
					{
					setState(1443);
					identifier();
					}
					break;
				case 2:
					{
					setState(1444);
					match(Constructor);
					}
					break;
				case 3:
					{
					setState(1445);
					match(Get);
					}
					break;
				case 4:
					{
					setState(1446);
					match(Set);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1451);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Abstract:
				case Array:
				case As:
				case BinaryCast:
				case BoolType:
				case BooleanConstant:
				case Break:
				case Callable:
				case Case:
				case Catch:
				case Class:
				case Clone:
				case Const:
				case Continue:
				case Declare:
				case Default:
				case Do:
				case DoubleCast:
				case DoubleType:
				case Echo:
				case Else:
				case ElseIf:
				case Empty:
				case EndDeclare:
				case EndFor:
				case EndForeach:
				case EndIf:
				case EndSwitch:
				case EndWhile:
				case Eval:
				case Exit:
				case Extends:
				case Final:
				case Finally:
				case FloatCast:
				case For:
				case Foreach:
				case Function:
				case Global:
				case Goto:
				case If:
				case Implements:
				case Import:
				case Include:
				case IncludeOnce:
				case InstanceOf:
				case InsteadOf:
				case Int8Cast:
				case Int16Cast:
				case Int64Type:
				case IntType:
				case Interface:
				case IsSet:
				case List:
				case LogicalAnd:
				case LogicalOr:
				case LogicalXor:
				case Namespace:
				case New:
				case Null:
				case ObjectType:
				case Parent_:
				case Partial:
				case Print:
				case Private:
				case Protected:
				case Public:
				case Require:
				case RequireOnce:
				case Resource:
				case Return:
				case Static:
				case StringType:
				case Switch:
				case Throw:
				case Trait:
				case Try:
				case Typeof:
				case UintCast:
				case UnicodeCast:
				case Unset:
				case Use:
				case Var:
				case While:
				case Yield:
				case Get:
				case Set:
				case Call:
				case CallStatic:
				case Constructor:
				case Destruct:
				case Wakeup:
				case Sleep:
				case Autoload:
				case IsSet__:
				case Unset__:
				case ToString__:
				case Invoke:
				case SetState:
				case Clone__:
				case DebugInfo:
				case Namespace__:
				case Class__:
				case Traic__:
				case Function__:
				case Method__:
				case Line__:
				case File__:
				case Dir__:
				case NamespaceSeparator:
				case Label:
					{
					setState(1449);
					qualifiedStaticTypeRef();
					}
					break;
				case Dollar:
				case VarName:
					{
					setState(1450);
					keyedVariable();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1453);
				match(DoubleColon);
				setState(1454);
				identifier();
				}
				break;
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

	public static class StringConstantContext extends ParserRuleContext {
		public TerminalNode Label() { return getToken(PhpParser.Label, 0); }
		public StringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConstantContext stringConstant() throws RecognitionException {
		StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_stringConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1458);
			match(Label);
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode StartHereDoc() { return getToken(PhpParser.StartHereDoc, 0); }
		public List<TerminalNode> HereDocText() { return getTokens(PhpParser.HereDocText); }
		public TerminalNode HereDocText(int i) {
			return getToken(PhpParser.HereDocText, i);
		}
		public TerminalNode StartNowDoc() { return getToken(PhpParser.StartNowDoc, 0); }
		public TerminalNode SingleQuoteString() { return getToken(PhpParser.SingleQuoteString, 0); }
		public List<TerminalNode> DoubleQuote() { return getTokens(PhpParser.DoubleQuote); }
		public TerminalNode DoubleQuote(int i) {
			return getToken(PhpParser.DoubleQuote, i);
		}
		public List<InterpolatedStringPartContext> interpolatedStringPart() {
			return getRuleContexts(InterpolatedStringPartContext.class);
		}
		public InterpolatedStringPartContext interpolatedStringPart(int i) {
			return getRuleContext(InterpolatedStringPartContext.class,i);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_string);
		int _la;
		try {
			int _alt;
			setState(1481);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StartHereDoc:
				enterOuterAlt(_localctx, 1);
				{
				setState(1460);
				match(StartHereDoc);
				setState(1462); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1461);
						match(HereDocText);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1464); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,158,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case StartNowDoc:
				enterOuterAlt(_localctx, 2);
				{
				setState(1466);
				match(StartNowDoc);
				setState(1468); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1467);
						match(HereDocText);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1470); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case SingleQuoteString:
				enterOuterAlt(_localctx, 3);
				{
				setState(1472);
				match(SingleQuoteString);
				}
				break;
			case DoubleQuote:
				enterOuterAlt(_localctx, 4);
				{
				setState(1473);
				match(DoubleQuote);
				setState(1477);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (StringPart - 182)))) != 0)) {
					{
					{
					setState(1474);
					interpolatedStringPart();
					}
					}
					setState(1479);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1480);
				match(DoubleQuote);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class InterpolatedStringPartContext extends ParserRuleContext {
		public TerminalNode StringPart() { return getToken(PhpParser.StringPart, 0); }
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public InterpolatedStringPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interpolatedStringPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInterpolatedStringPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInterpolatedStringPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitInterpolatedStringPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterpolatedStringPartContext interpolatedStringPart() throws RecognitionException {
		InterpolatedStringPartContext _localctx = new InterpolatedStringPartContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_interpolatedStringPart);
		try {
			setState(1485);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringPart:
				enterOuterAlt(_localctx, 1);
				{
				setState(1483);
				match(StringPart);
				}
				break;
			case Abstract:
			case Array:
			case As:
			case BinaryCast:
			case BoolType:
			case BooleanConstant:
			case Break:
			case Callable:
			case Case:
			case Catch:
			case Class:
			case Clone:
			case Const:
			case Continue:
			case Declare:
			case Default:
			case Do:
			case DoubleCast:
			case DoubleType:
			case Echo:
			case Else:
			case ElseIf:
			case Empty:
			case EndDeclare:
			case EndFor:
			case EndForeach:
			case EndIf:
			case EndSwitch:
			case EndWhile:
			case Eval:
			case Exit:
			case Extends:
			case Final:
			case Finally:
			case FloatCast:
			case For:
			case Foreach:
			case Function:
			case Global:
			case Goto:
			case If:
			case Implements:
			case Import:
			case Include:
			case IncludeOnce:
			case InstanceOf:
			case InsteadOf:
			case Int8Cast:
			case Int16Cast:
			case Int64Type:
			case IntType:
			case Interface:
			case IsSet:
			case List:
			case LogicalAnd:
			case LogicalOr:
			case LogicalXor:
			case Namespace:
			case New:
			case Null:
			case ObjectType:
			case Parent_:
			case Partial:
			case Print:
			case Private:
			case Protected:
			case Public:
			case Require:
			case RequireOnce:
			case Resource:
			case Return:
			case Static:
			case StringType:
			case Switch:
			case Throw:
			case Trait:
			case Try:
			case Typeof:
			case UintCast:
			case UnicodeCast:
			case Unset:
			case Use:
			case Var:
			case While:
			case Yield:
			case Get:
			case Set:
			case Call:
			case CallStatic:
			case Constructor:
			case Destruct:
			case Wakeup:
			case Sleep:
			case Autoload:
			case IsSet__:
			case Unset__:
			case ToString__:
			case Invoke:
			case SetState:
			case Clone__:
			case DebugInfo:
			case Namespace__:
			case Class__:
			case Traic__:
			case Function__:
			case Method__:
			case Line__:
			case File__:
			case Dir__:
			case NamespaceSeparator:
			case Dollar:
			case OpenRoundBracket:
			case VarName:
			case Label:
				enterOuterAlt(_localctx, 2);
				{
				setState(1484);
				chain();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ChainListContext extends ParserRuleContext {
		public List<ChainContext> chain() {
			return getRuleContexts(ChainContext.class);
		}
		public ChainContext chain(int i) {
			return getRuleContext(ChainContext.class,i);
		}
		public ChainListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chainList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterChainList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitChainList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitChainList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChainListContext chainList() throws RecognitionException {
		ChainListContext _localctx = new ChainListContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_chainList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1487);
			chain();
			setState(1492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1488);
				match(Comma);
				setState(1489);
				chain();
				}
				}
				setState(1494);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ChainContext extends ParserRuleContext {
		public ChainBaseContext chainBase() {
			return getRuleContext(ChainBaseContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public NewExprContext newExpr() {
			return getRuleContext(NewExprContext.class,0);
		}
		public List<MemberAccessContext> memberAccess() {
			return getRuleContexts(MemberAccessContext.class);
		}
		public MemberAccessContext memberAccess(int i) {
			return getRuleContext(MemberAccessContext.class,i);
		}
		public ChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChainContext chain() throws RecognitionException {
		ChainContext _localctx = new ChainContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_chain);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
			case 1:
				{
				setState(1495);
				chainBase();
				}
				break;
			case 2:
				{
				setState(1496);
				functionCall();
				}
				break;
			case 3:
				{
				setState(1497);
				match(OpenRoundBracket);
				setState(1498);
				newExpr();
				setState(1499);
				match(CloseRoundBracket);
				}
				break;
			}
			setState(1506);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,165,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1503);
					memberAccess();
					}
					} 
				}
				setState(1508);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,165,_ctx);
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

	public static class MemberAccessContext extends ParserRuleContext {
		public KeyedFieldNameContext keyedFieldName() {
			return getRuleContext(KeyedFieldNameContext.class,0);
		}
		public ActualArgumentsContext actualArguments() {
			return getRuleContext(ActualArgumentsContext.class,0);
		}
		public MemberAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMemberAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitMemberAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1509);
			match(ObjectOperator);
			setState(1510);
			keyedFieldName();
			setState(1512);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,166,_ctx) ) {
			case 1:
				{
				setState(1511);
				actualArguments();
				}
				break;
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCallNameContext functionCallName() {
			return getRuleContext(FunctionCallNameContext.class,0);
		}
		public ActualArgumentsContext actualArguments() {
			return getRuleContext(ActualArgumentsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1514);
			functionCallName();
			setState(1515);
			actualArguments();
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

	public static class FunctionCallNameContext extends ParserRuleContext {
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public ClassConstantContext classConstant() {
			return getRuleContext(ClassConstantContext.class,0);
		}
		public ChainBaseContext chainBase() {
			return getRuleContext(ChainBaseContext.class,0);
		}
		public FunctionCallNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFunctionCallName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFunctionCallName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitFunctionCallName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallNameContext functionCallName() throws RecognitionException {
		FunctionCallNameContext _localctx = new FunctionCallNameContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_functionCallName);
		try {
			setState(1520);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1517);
				qualifiedNamespaceName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1518);
				classConstant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1519);
				chainBase();
				}
				break;
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

	public static class ActualArgumentsContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public GenericDynamicArgsContext genericDynamicArgs() {
			return getRuleContext(GenericDynamicArgsContext.class,0);
		}
		public List<SquareCurlyExpressionContext> squareCurlyExpression() {
			return getRuleContexts(SquareCurlyExpressionContext.class);
		}
		public SquareCurlyExpressionContext squareCurlyExpression(int i) {
			return getRuleContext(SquareCurlyExpressionContext.class,i);
		}
		public ActualArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterActualArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitActualArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitActualArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualArgumentsContext actualArguments() throws RecognitionException {
		ActualArgumentsContext _localctx = new ActualArgumentsContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_actualArguments);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Lgeneric) {
				{
				setState(1522);
				genericDynamicArgs();
				}
			}

			setState(1525);
			arguments();
			setState(1529);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,169,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1526);
					squareCurlyExpression();
					}
					} 
				}
				setState(1531);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,169,_ctx);
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

	public static class ChainBaseContext extends ParserRuleContext {
		public List<KeyedVariableContext> keyedVariable() {
			return getRuleContexts(KeyedVariableContext.class);
		}
		public KeyedVariableContext keyedVariable(int i) {
			return getRuleContext(KeyedVariableContext.class,i);
		}
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public ChainBaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chainBase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterChainBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitChainBase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitChainBase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChainBaseContext chainBase() throws RecognitionException {
		ChainBaseContext _localctx = new ChainBaseContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_chainBase);
		try {
			setState(1541);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Dollar:
			case VarName:
				enterOuterAlt(_localctx, 1);
				{
				setState(1532);
				keyedVariable();
				setState(1535);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
				case 1:
					{
					setState(1533);
					match(DoubleColon);
					setState(1534);
					keyedVariable();
					}
					break;
				}
				}
				break;
			case Abstract:
			case Array:
			case As:
			case BinaryCast:
			case BoolType:
			case BooleanConstant:
			case Break:
			case Callable:
			case Case:
			case Catch:
			case Class:
			case Clone:
			case Const:
			case Continue:
			case Declare:
			case Default:
			case Do:
			case DoubleCast:
			case DoubleType:
			case Echo:
			case Else:
			case ElseIf:
			case Empty:
			case EndDeclare:
			case EndFor:
			case EndForeach:
			case EndIf:
			case EndSwitch:
			case EndWhile:
			case Eval:
			case Exit:
			case Extends:
			case Final:
			case Finally:
			case FloatCast:
			case For:
			case Foreach:
			case Function:
			case Global:
			case Goto:
			case If:
			case Implements:
			case Import:
			case Include:
			case IncludeOnce:
			case InstanceOf:
			case InsteadOf:
			case Int8Cast:
			case Int16Cast:
			case Int64Type:
			case IntType:
			case Interface:
			case IsSet:
			case List:
			case LogicalAnd:
			case LogicalOr:
			case LogicalXor:
			case Namespace:
			case New:
			case Null:
			case ObjectType:
			case Parent_:
			case Partial:
			case Print:
			case Private:
			case Protected:
			case Public:
			case Require:
			case RequireOnce:
			case Resource:
			case Return:
			case Static:
			case StringType:
			case Switch:
			case Throw:
			case Trait:
			case Try:
			case Typeof:
			case UintCast:
			case UnicodeCast:
			case Unset:
			case Use:
			case Var:
			case While:
			case Yield:
			case Get:
			case Set:
			case Call:
			case CallStatic:
			case Constructor:
			case Destruct:
			case Wakeup:
			case Sleep:
			case Autoload:
			case IsSet__:
			case Unset__:
			case ToString__:
			case Invoke:
			case SetState:
			case Clone__:
			case DebugInfo:
			case Namespace__:
			case Class__:
			case Traic__:
			case Function__:
			case Method__:
			case Line__:
			case File__:
			case Dir__:
			case NamespaceSeparator:
			case Label:
				enterOuterAlt(_localctx, 2);
				{
				setState(1537);
				qualifiedStaticTypeRef();
				setState(1538);
				match(DoubleColon);
				setState(1539);
				keyedVariable();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class KeyedFieldNameContext extends ParserRuleContext {
		public KeyedSimpleFieldNameContext keyedSimpleFieldName() {
			return getRuleContext(KeyedSimpleFieldNameContext.class,0);
		}
		public KeyedVariableContext keyedVariable() {
			return getRuleContext(KeyedVariableContext.class,0);
		}
		public KeyedFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyedFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterKeyedFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitKeyedFieldName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitKeyedFieldName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyedFieldNameContext keyedFieldName() throws RecognitionException {
		KeyedFieldNameContext _localctx = new KeyedFieldNameContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_keyedFieldName);
		try {
			setState(1545);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Abstract:
			case Array:
			case As:
			case BinaryCast:
			case BoolType:
			case BooleanConstant:
			case Break:
			case Callable:
			case Case:
			case Catch:
			case Class:
			case Clone:
			case Const:
			case Continue:
			case Declare:
			case Default:
			case Do:
			case DoubleCast:
			case DoubleType:
			case Echo:
			case Else:
			case ElseIf:
			case Empty:
			case EndDeclare:
			case EndFor:
			case EndForeach:
			case EndIf:
			case EndSwitch:
			case EndWhile:
			case Eval:
			case Exit:
			case Extends:
			case Final:
			case Finally:
			case FloatCast:
			case For:
			case Foreach:
			case Function:
			case Global:
			case Goto:
			case If:
			case Implements:
			case Import:
			case Include:
			case IncludeOnce:
			case InstanceOf:
			case InsteadOf:
			case Int8Cast:
			case Int16Cast:
			case Int64Type:
			case IntType:
			case Interface:
			case IsSet:
			case List:
			case LogicalAnd:
			case LogicalOr:
			case LogicalXor:
			case Namespace:
			case New:
			case Null:
			case ObjectType:
			case Parent_:
			case Partial:
			case Print:
			case Private:
			case Protected:
			case Public:
			case Require:
			case RequireOnce:
			case Resource:
			case Return:
			case Static:
			case StringType:
			case Switch:
			case Throw:
			case Trait:
			case Try:
			case Typeof:
			case UintCast:
			case UnicodeCast:
			case Unset:
			case Use:
			case Var:
			case While:
			case Yield:
			case Get:
			case Set:
			case Call:
			case CallStatic:
			case Constructor:
			case Destruct:
			case Wakeup:
			case Sleep:
			case Autoload:
			case IsSet__:
			case Unset__:
			case ToString__:
			case Invoke:
			case SetState:
			case Clone__:
			case DebugInfo:
			case Namespace__:
			case Class__:
			case Traic__:
			case Function__:
			case Method__:
			case Line__:
			case File__:
			case Dir__:
			case OpenCurlyBracket:
			case Label:
				enterOuterAlt(_localctx, 1);
				{
				setState(1543);
				keyedSimpleFieldName();
				}
				break;
			case Dollar:
			case VarName:
				enterOuterAlt(_localctx, 2);
				{
				setState(1544);
				keyedVariable();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class KeyedSimpleFieldNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<SquareCurlyExpressionContext> squareCurlyExpression() {
			return getRuleContexts(SquareCurlyExpressionContext.class);
		}
		public SquareCurlyExpressionContext squareCurlyExpression(int i) {
			return getRuleContext(SquareCurlyExpressionContext.class,i);
		}
		public KeyedSimpleFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyedSimpleFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterKeyedSimpleFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitKeyedSimpleFieldName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitKeyedSimpleFieldName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyedSimpleFieldNameContext keyedSimpleFieldName() throws RecognitionException {
		KeyedSimpleFieldNameContext _localctx = new KeyedSimpleFieldNameContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_keyedSimpleFieldName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1552);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Abstract:
			case Array:
			case As:
			case BinaryCast:
			case BoolType:
			case BooleanConstant:
			case Break:
			case Callable:
			case Case:
			case Catch:
			case Class:
			case Clone:
			case Const:
			case Continue:
			case Declare:
			case Default:
			case Do:
			case DoubleCast:
			case DoubleType:
			case Echo:
			case Else:
			case ElseIf:
			case Empty:
			case EndDeclare:
			case EndFor:
			case EndForeach:
			case EndIf:
			case EndSwitch:
			case EndWhile:
			case Eval:
			case Exit:
			case Extends:
			case Final:
			case Finally:
			case FloatCast:
			case For:
			case Foreach:
			case Function:
			case Global:
			case Goto:
			case If:
			case Implements:
			case Import:
			case Include:
			case IncludeOnce:
			case InstanceOf:
			case InsteadOf:
			case Int8Cast:
			case Int16Cast:
			case Int64Type:
			case IntType:
			case Interface:
			case IsSet:
			case List:
			case LogicalAnd:
			case LogicalOr:
			case LogicalXor:
			case Namespace:
			case New:
			case Null:
			case ObjectType:
			case Parent_:
			case Partial:
			case Print:
			case Private:
			case Protected:
			case Public:
			case Require:
			case RequireOnce:
			case Resource:
			case Return:
			case Static:
			case StringType:
			case Switch:
			case Throw:
			case Trait:
			case Try:
			case Typeof:
			case UintCast:
			case UnicodeCast:
			case Unset:
			case Use:
			case Var:
			case While:
			case Yield:
			case Get:
			case Set:
			case Call:
			case CallStatic:
			case Constructor:
			case Destruct:
			case Wakeup:
			case Sleep:
			case Autoload:
			case IsSet__:
			case Unset__:
			case ToString__:
			case Invoke:
			case SetState:
			case Clone__:
			case DebugInfo:
			case Namespace__:
			case Class__:
			case Traic__:
			case Function__:
			case Method__:
			case Line__:
			case File__:
			case Dir__:
			case Label:
				{
				setState(1547);
				identifier();
				}
				break;
			case OpenCurlyBracket:
				{
				setState(1548);
				match(OpenCurlyBracket);
				setState(1549);
				expression(0);
				setState(1550);
				match(CloseCurlyBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1557);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1554);
					squareCurlyExpression();
					}
					} 
				}
				setState(1559);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
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

	public static class KeyedVariableContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(PhpParser.VarName, 0); }
		public List<TerminalNode> Dollar() { return getTokens(PhpParser.Dollar); }
		public TerminalNode Dollar(int i) {
			return getToken(PhpParser.Dollar, i);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<SquareCurlyExpressionContext> squareCurlyExpression() {
			return getRuleContexts(SquareCurlyExpressionContext.class);
		}
		public SquareCurlyExpressionContext squareCurlyExpression(int i) {
			return getRuleContext(SquareCurlyExpressionContext.class,i);
		}
		public KeyedVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyedVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterKeyedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitKeyedVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitKeyedVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyedVariableContext keyedVariable() throws RecognitionException {
		KeyedVariableContext _localctx = new KeyedVariableContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_keyedVariable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1563);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1560);
					match(Dollar);
					}
					} 
				}
				setState(1565);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
			}
			setState(1572);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VarName:
				{
				setState(1566);
				match(VarName);
				}
				break;
			case Dollar:
				{
				setState(1567);
				match(Dollar);
				setState(1568);
				match(OpenCurlyBracket);
				setState(1569);
				expression(0);
				setState(1570);
				match(CloseCurlyBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1577);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1574);
					squareCurlyExpression();
					}
					} 
				}
				setState(1579);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
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

	public static class SquareCurlyExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public SquareCurlyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareCurlyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterSquareCurlyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitSquareCurlyExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitSquareCurlyExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareCurlyExpressionContext squareCurlyExpression() throws RecognitionException {
		SquareCurlyExpressionContext _localctx = new SquareCurlyExpressionContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_squareCurlyExpression);
		int _la;
		try {
			setState(1589);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenSquareBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1580);
				match(OpenSquareBracket);
				setState(1582);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)) | (1L << (Inc - 107)) | (1L << (Dec - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Bang - 182)) | (1L << (Plus - 182)) | (1L << (Minus - 182)) | (1L << (Tilde - 182)) | (1L << (SuppressWarnings - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (OpenSquareBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)) | (1L << (Octal - 182)) | (1L << (Decimal - 182)) | (1L << (Real - 182)) | (1L << (Hex - 182)) | (1L << (Binary - 182)) | (1L << (BackQuoteString - 182)) | (1L << (SingleQuoteString - 182)) | (1L << (DoubleQuote - 182)) | (1L << (StartNowDoc - 182)) | (1L << (StartHereDoc - 182)))) != 0)) {
					{
					setState(1581);
					expression(0);
					}
				}

				setState(1584);
				match(CloseSquareBracket);
				}
				break;
			case OpenCurlyBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1585);
				match(OpenCurlyBracket);
				setState(1586);
				expression(0);
				setState(1587);
				match(CloseCurlyBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AssignmentListContext extends ParserRuleContext {
		public List<AssignmentListElementContext> assignmentListElement() {
			return getRuleContexts(AssignmentListElementContext.class);
		}
		public AssignmentListElementContext assignmentListElement(int i) {
			return getRuleContext(AssignmentListElementContext.class,i);
		}
		public AssignmentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAssignmentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAssignmentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitAssignmentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentListContext assignmentList() throws RecognitionException {
		AssignmentListContext _localctx = new AssignmentListContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_assignmentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1592);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)))) != 0)) {
				{
				setState(1591);
				assignmentListElement();
				}
			}

			setState(1600);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1594);
				match(Comma);
				setState(1596);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)))) != 0) || ((((_la - 182)) & ~0x3f) == 0 && ((1L << (_la - 182)) & ((1L << (NamespaceSeparator - 182)) | (1L << (Dollar - 182)) | (1L << (OpenRoundBracket - 182)) | (1L << (VarName - 182)) | (1L << (Label - 182)))) != 0)) {
					{
					setState(1595);
					assignmentListElement();
					}
				}

				}
				}
				setState(1602);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class AssignmentListElementContext extends ParserRuleContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public TerminalNode List() { return getToken(PhpParser.List, 0); }
		public AssignmentListContext assignmentList() {
			return getRuleContext(AssignmentListContext.class,0);
		}
		public AssignmentListElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentListElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAssignmentListElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAssignmentListElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitAssignmentListElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentListElementContext assignmentListElement() throws RecognitionException {
		AssignmentListElementContext _localctx = new AssignmentListElementContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_assignmentListElement);
		try {
			setState(1609);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1603);
				chain();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1604);
				match(List);
				setState(1605);
				match(OpenRoundBracket);
				setState(1606);
				assignmentList();
				setState(1607);
				match(CloseRoundBracket);
				}
				break;
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

	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode Abstract() { return getToken(PhpParser.Abstract, 0); }
		public TerminalNode Final() { return getToken(PhpParser.Final, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1611);
			_la = _input.LA(1);
			if ( !(_la==Abstract || _la==Final) ) {
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Label() { return getToken(PhpParser.Label, 0); }
		public TerminalNode Abstract() { return getToken(PhpParser.Abstract, 0); }
		public TerminalNode Array() { return getToken(PhpParser.Array, 0); }
		public TerminalNode As() { return getToken(PhpParser.As, 0); }
		public TerminalNode BinaryCast() { return getToken(PhpParser.BinaryCast, 0); }
		public TerminalNode BoolType() { return getToken(PhpParser.BoolType, 0); }
		public TerminalNode BooleanConstant() { return getToken(PhpParser.BooleanConstant, 0); }
		public TerminalNode Break() { return getToken(PhpParser.Break, 0); }
		public TerminalNode Callable() { return getToken(PhpParser.Callable, 0); }
		public TerminalNode Case() { return getToken(PhpParser.Case, 0); }
		public TerminalNode Catch() { return getToken(PhpParser.Catch, 0); }
		public TerminalNode Class() { return getToken(PhpParser.Class, 0); }
		public TerminalNode Clone() { return getToken(PhpParser.Clone, 0); }
		public TerminalNode Const() { return getToken(PhpParser.Const, 0); }
		public TerminalNode Continue() { return getToken(PhpParser.Continue, 0); }
		public TerminalNode Declare() { return getToken(PhpParser.Declare, 0); }
		public TerminalNode Default() { return getToken(PhpParser.Default, 0); }
		public TerminalNode Do() { return getToken(PhpParser.Do, 0); }
		public TerminalNode DoubleCast() { return getToken(PhpParser.DoubleCast, 0); }
		public TerminalNode DoubleType() { return getToken(PhpParser.DoubleType, 0); }
		public TerminalNode Echo() { return getToken(PhpParser.Echo, 0); }
		public TerminalNode Else() { return getToken(PhpParser.Else, 0); }
		public TerminalNode ElseIf() { return getToken(PhpParser.ElseIf, 0); }
		public TerminalNode Empty() { return getToken(PhpParser.Empty, 0); }
		public TerminalNode EndDeclare() { return getToken(PhpParser.EndDeclare, 0); }
		public TerminalNode EndFor() { return getToken(PhpParser.EndFor, 0); }
		public TerminalNode EndForeach() { return getToken(PhpParser.EndForeach, 0); }
		public TerminalNode EndIf() { return getToken(PhpParser.EndIf, 0); }
		public TerminalNode EndSwitch() { return getToken(PhpParser.EndSwitch, 0); }
		public TerminalNode EndWhile() { return getToken(PhpParser.EndWhile, 0); }
		public TerminalNode Eval() { return getToken(PhpParser.Eval, 0); }
		public TerminalNode Exit() { return getToken(PhpParser.Exit, 0); }
		public TerminalNode Extends() { return getToken(PhpParser.Extends, 0); }
		public TerminalNode Final() { return getToken(PhpParser.Final, 0); }
		public TerminalNode Finally() { return getToken(PhpParser.Finally, 0); }
		public TerminalNode FloatCast() { return getToken(PhpParser.FloatCast, 0); }
		public TerminalNode For() { return getToken(PhpParser.For, 0); }
		public TerminalNode Foreach() { return getToken(PhpParser.Foreach, 0); }
		public TerminalNode Function() { return getToken(PhpParser.Function, 0); }
		public TerminalNode Global() { return getToken(PhpParser.Global, 0); }
		public TerminalNode Goto() { return getToken(PhpParser.Goto, 0); }
		public TerminalNode If() { return getToken(PhpParser.If, 0); }
		public TerminalNode Implements() { return getToken(PhpParser.Implements, 0); }
		public TerminalNode Import() { return getToken(PhpParser.Import, 0); }
		public TerminalNode Include() { return getToken(PhpParser.Include, 0); }
		public TerminalNode IncludeOnce() { return getToken(PhpParser.IncludeOnce, 0); }
		public TerminalNode InstanceOf() { return getToken(PhpParser.InstanceOf, 0); }
		public TerminalNode InsteadOf() { return getToken(PhpParser.InsteadOf, 0); }
		public TerminalNode Int16Cast() { return getToken(PhpParser.Int16Cast, 0); }
		public TerminalNode Int64Type() { return getToken(PhpParser.Int64Type, 0); }
		public TerminalNode Int8Cast() { return getToken(PhpParser.Int8Cast, 0); }
		public TerminalNode Interface() { return getToken(PhpParser.Interface, 0); }
		public TerminalNode IntType() { return getToken(PhpParser.IntType, 0); }
		public TerminalNode IsSet() { return getToken(PhpParser.IsSet, 0); }
		public TerminalNode List() { return getToken(PhpParser.List, 0); }
		public TerminalNode LogicalAnd() { return getToken(PhpParser.LogicalAnd, 0); }
		public TerminalNode LogicalOr() { return getToken(PhpParser.LogicalOr, 0); }
		public TerminalNode LogicalXor() { return getToken(PhpParser.LogicalXor, 0); }
		public TerminalNode Namespace() { return getToken(PhpParser.Namespace, 0); }
		public TerminalNode New() { return getToken(PhpParser.New, 0); }
		public TerminalNode Null() { return getToken(PhpParser.Null, 0); }
		public TerminalNode ObjectType() { return getToken(PhpParser.ObjectType, 0); }
		public TerminalNode Parent_() { return getToken(PhpParser.Parent_, 0); }
		public TerminalNode Partial() { return getToken(PhpParser.Partial, 0); }
		public TerminalNode Print() { return getToken(PhpParser.Print, 0); }
		public TerminalNode Private() { return getToken(PhpParser.Private, 0); }
		public TerminalNode Protected() { return getToken(PhpParser.Protected, 0); }
		public TerminalNode Public() { return getToken(PhpParser.Public, 0); }
		public TerminalNode Require() { return getToken(PhpParser.Require, 0); }
		public TerminalNode RequireOnce() { return getToken(PhpParser.RequireOnce, 0); }
		public TerminalNode Resource() { return getToken(PhpParser.Resource, 0); }
		public TerminalNode Return() { return getToken(PhpParser.Return, 0); }
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public TerminalNode StringType() { return getToken(PhpParser.StringType, 0); }
		public TerminalNode Switch() { return getToken(PhpParser.Switch, 0); }
		public TerminalNode Throw() { return getToken(PhpParser.Throw, 0); }
		public TerminalNode Trait() { return getToken(PhpParser.Trait, 0); }
		public TerminalNode Try() { return getToken(PhpParser.Try, 0); }
		public TerminalNode Typeof() { return getToken(PhpParser.Typeof, 0); }
		public TerminalNode UintCast() { return getToken(PhpParser.UintCast, 0); }
		public TerminalNode UnicodeCast() { return getToken(PhpParser.UnicodeCast, 0); }
		public TerminalNode Unset() { return getToken(PhpParser.Unset, 0); }
		public TerminalNode Use() { return getToken(PhpParser.Use, 0); }
		public TerminalNode Var() { return getToken(PhpParser.Var, 0); }
		public TerminalNode While() { return getToken(PhpParser.While, 0); }
		public TerminalNode Yield() { return getToken(PhpParser.Yield, 0); }
		public TerminalNode Get() { return getToken(PhpParser.Get, 0); }
		public TerminalNode Set() { return getToken(PhpParser.Set, 0); }
		public TerminalNode Call() { return getToken(PhpParser.Call, 0); }
		public TerminalNode CallStatic() { return getToken(PhpParser.CallStatic, 0); }
		public TerminalNode Constructor() { return getToken(PhpParser.Constructor, 0); }
		public TerminalNode Destruct() { return getToken(PhpParser.Destruct, 0); }
		public TerminalNode Wakeup() { return getToken(PhpParser.Wakeup, 0); }
		public TerminalNode Sleep() { return getToken(PhpParser.Sleep, 0); }
		public TerminalNode Autoload() { return getToken(PhpParser.Autoload, 0); }
		public TerminalNode IsSet__() { return getToken(PhpParser.IsSet__, 0); }
		public TerminalNode Unset__() { return getToken(PhpParser.Unset__, 0); }
		public TerminalNode ToString__() { return getToken(PhpParser.ToString__, 0); }
		public TerminalNode Invoke() { return getToken(PhpParser.Invoke, 0); }
		public TerminalNode SetState() { return getToken(PhpParser.SetState, 0); }
		public TerminalNode Clone__() { return getToken(PhpParser.Clone__, 0); }
		public TerminalNode DebugInfo() { return getToken(PhpParser.DebugInfo, 0); }
		public TerminalNode Namespace__() { return getToken(PhpParser.Namespace__, 0); }
		public TerminalNode Class__() { return getToken(PhpParser.Class__, 0); }
		public TerminalNode Traic__() { return getToken(PhpParser.Traic__, 0); }
		public TerminalNode Function__() { return getToken(PhpParser.Function__, 0); }
		public TerminalNode Method__() { return getToken(PhpParser.Method__, 0); }
		public TerminalNode Line__() { return getToken(PhpParser.Line__, 0); }
		public TerminalNode File__() { return getToken(PhpParser.File__, 0); }
		public TerminalNode Dir__() { return getToken(PhpParser.Dir__, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1613);
			_la = _input.LA(1);
			if ( !(((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (Abstract - 43)) | (1L << (Array - 43)) | (1L << (As - 43)) | (1L << (BinaryCast - 43)) | (1L << (BoolType - 43)) | (1L << (BooleanConstant - 43)) | (1L << (Break - 43)) | (1L << (Callable - 43)) | (1L << (Case - 43)) | (1L << (Catch - 43)) | (1L << (Class - 43)) | (1L << (Clone - 43)) | (1L << (Const - 43)) | (1L << (Continue - 43)) | (1L << (Declare - 43)) | (1L << (Default - 43)) | (1L << (Do - 43)) | (1L << (DoubleCast - 43)) | (1L << (DoubleType - 43)) | (1L << (Echo - 43)) | (1L << (Else - 43)) | (1L << (ElseIf - 43)) | (1L << (Empty - 43)) | (1L << (EndDeclare - 43)) | (1L << (EndFor - 43)) | (1L << (EndForeach - 43)) | (1L << (EndIf - 43)) | (1L << (EndSwitch - 43)) | (1L << (EndWhile - 43)) | (1L << (Eval - 43)) | (1L << (Exit - 43)) | (1L << (Extends - 43)) | (1L << (Final - 43)) | (1L << (Finally - 43)) | (1L << (FloatCast - 43)) | (1L << (For - 43)) | (1L << (Foreach - 43)) | (1L << (Function - 43)) | (1L << (Global - 43)) | (1L << (Goto - 43)) | (1L << (If - 43)) | (1L << (Implements - 43)) | (1L << (Import - 43)) | (1L << (Include - 43)) | (1L << (IncludeOnce - 43)) | (1L << (InstanceOf - 43)) | (1L << (InsteadOf - 43)) | (1L << (Int8Cast - 43)) | (1L << (Int16Cast - 43)) | (1L << (Int64Type - 43)) | (1L << (IntType - 43)) | (1L << (Interface - 43)) | (1L << (IsSet - 43)) | (1L << (List - 43)) | (1L << (LogicalAnd - 43)) | (1L << (LogicalOr - 43)) | (1L << (LogicalXor - 43)) | (1L << (Namespace - 43)) | (1L << (New - 43)) | (1L << (Null - 43)) | (1L << (ObjectType - 43)) | (1L << (Parent_ - 43)) | (1L << (Partial - 43)) | (1L << (Print - 43)))) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (Private - 107)) | (1L << (Protected - 107)) | (1L << (Public - 107)) | (1L << (Require - 107)) | (1L << (RequireOnce - 107)) | (1L << (Resource - 107)) | (1L << (Return - 107)) | (1L << (Static - 107)) | (1L << (StringType - 107)) | (1L << (Switch - 107)) | (1L << (Throw - 107)) | (1L << (Trait - 107)) | (1L << (Try - 107)) | (1L << (Typeof - 107)) | (1L << (UintCast - 107)) | (1L << (UnicodeCast - 107)) | (1L << (Unset - 107)) | (1L << (Use - 107)) | (1L << (Var - 107)) | (1L << (While - 107)) | (1L << (Yield - 107)) | (1L << (Get - 107)) | (1L << (Set - 107)) | (1L << (Call - 107)) | (1L << (CallStatic - 107)) | (1L << (Constructor - 107)) | (1L << (Destruct - 107)) | (1L << (Wakeup - 107)) | (1L << (Sleep - 107)) | (1L << (Autoload - 107)) | (1L << (IsSet__ - 107)) | (1L << (Unset__ - 107)) | (1L << (ToString__ - 107)) | (1L << (Invoke - 107)) | (1L << (SetState - 107)) | (1L << (Clone__ - 107)) | (1L << (DebugInfo - 107)) | (1L << (Namespace__ - 107)) | (1L << (Class__ - 107)) | (1L << (Traic__ - 107)) | (1L << (Function__ - 107)) | (1L << (Method__ - 107)) | (1L << (Line__ - 107)) | (1L << (File__ - 107)) | (1L << (Dir__ - 107)))) != 0) || _la==Label) ) {
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

	public static class MemberModifierContext extends ParserRuleContext {
		public TerminalNode Public() { return getToken(PhpParser.Public, 0); }
		public TerminalNode Protected() { return getToken(PhpParser.Protected, 0); }
		public TerminalNode Private() { return getToken(PhpParser.Private, 0); }
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public TerminalNode Abstract() { return getToken(PhpParser.Abstract, 0); }
		public TerminalNode Final() { return getToken(PhpParser.Final, 0); }
		public MemberModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMemberModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMemberModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitMemberModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberModifierContext memberModifier() throws RecognitionException {
		MemberModifierContext _localctx = new MemberModifierContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_memberModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1615);
			_la = _input.LA(1);
			if ( !(_la==Abstract || ((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (Final - 75)) | (1L << (Private - 75)) | (1L << (Protected - 75)) | (1L << (Public - 75)) | (1L << (Static - 75)))) != 0)) ) {
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

	public static class MagicConstantContext extends ParserRuleContext {
		public TerminalNode Namespace__() { return getToken(PhpParser.Namespace__, 0); }
		public TerminalNode Class__() { return getToken(PhpParser.Class__, 0); }
		public TerminalNode Traic__() { return getToken(PhpParser.Traic__, 0); }
		public TerminalNode Function__() { return getToken(PhpParser.Function__, 0); }
		public TerminalNode Method__() { return getToken(PhpParser.Method__, 0); }
		public TerminalNode Line__() { return getToken(PhpParser.Line__, 0); }
		public TerminalNode File__() { return getToken(PhpParser.File__, 0); }
		public TerminalNode Dir__() { return getToken(PhpParser.Dir__, 0); }
		public MagicConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_magicConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMagicConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMagicConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitMagicConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MagicConstantContext magicConstant() throws RecognitionException {
		MagicConstantContext _localctx = new MagicConstantContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_magicConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1617);
			_la = _input.LA(1);
			if ( !(((((_la - 144)) & ~0x3f) == 0 && ((1L << (_la - 144)) & ((1L << (Namespace__ - 144)) | (1L << (Class__ - 144)) | (1L << (Traic__ - 144)) | (1L << (Function__ - 144)) | (1L << (Method__ - 144)) | (1L << (Line__ - 144)) | (1L << (File__ - 144)) | (1L << (Dir__ - 144)))) != 0)) ) {
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

	public static class MagicMethodContext extends ParserRuleContext {
		public TerminalNode Get() { return getToken(PhpParser.Get, 0); }
		public TerminalNode Set() { return getToken(PhpParser.Set, 0); }
		public TerminalNode Call() { return getToken(PhpParser.Call, 0); }
		public TerminalNode CallStatic() { return getToken(PhpParser.CallStatic, 0); }
		public TerminalNode Constructor() { return getToken(PhpParser.Constructor, 0); }
		public TerminalNode Destruct() { return getToken(PhpParser.Destruct, 0); }
		public TerminalNode Wakeup() { return getToken(PhpParser.Wakeup, 0); }
		public TerminalNode Sleep() { return getToken(PhpParser.Sleep, 0); }
		public TerminalNode Autoload() { return getToken(PhpParser.Autoload, 0); }
		public TerminalNode IsSet__() { return getToken(PhpParser.IsSet__, 0); }
		public TerminalNode Unset__() { return getToken(PhpParser.Unset__, 0); }
		public TerminalNode ToString__() { return getToken(PhpParser.ToString__, 0); }
		public TerminalNode Invoke() { return getToken(PhpParser.Invoke, 0); }
		public TerminalNode SetState() { return getToken(PhpParser.SetState, 0); }
		public TerminalNode Clone__() { return getToken(PhpParser.Clone__, 0); }
		public TerminalNode DebugInfo() { return getToken(PhpParser.DebugInfo, 0); }
		public MagicMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_magicMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMagicMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMagicMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitMagicMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MagicMethodContext magicMethod() throws RecognitionException {
		MagicMethodContext _localctx = new MagicMethodContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_magicMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1619);
			_la = _input.LA(1);
			if ( !(((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (Get - 128)) | (1L << (Set - 128)) | (1L << (Call - 128)) | (1L << (CallStatic - 128)) | (1L << (Constructor - 128)) | (1L << (Destruct - 128)) | (1L << (Wakeup - 128)) | (1L << (Sleep - 128)) | (1L << (Autoload - 128)) | (1L << (IsSet__ - 128)) | (1L << (Unset__ - 128)) | (1L << (ToString__ - 128)) | (1L << (Invoke - 128)) | (1L << (SetState - 128)) | (1L << (Clone__ - 128)) | (1L << (DebugInfo - 128)))) != 0)) ) {
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode BoolType() { return getToken(PhpParser.BoolType, 0); }
		public TerminalNode IntType() { return getToken(PhpParser.IntType, 0); }
		public TerminalNode Int64Type() { return getToken(PhpParser.Int64Type, 0); }
		public TerminalNode DoubleType() { return getToken(PhpParser.DoubleType, 0); }
		public TerminalNode StringType() { return getToken(PhpParser.StringType, 0); }
		public TerminalNode Resource() { return getToken(PhpParser.Resource, 0); }
		public TerminalNode ObjectType() { return getToken(PhpParser.ObjectType, 0); }
		public TerminalNode Array() { return getToken(PhpParser.Array, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1621);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Array) | (1L << BoolType) | (1L << DoubleType))) != 0) || ((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & ((1L << (Int64Type - 92)) | (1L << (IntType - 92)) | (1L << (ObjectType - 92)) | (1L << (Resource - 92)) | (1L << (StringType - 92)))) != 0)) ) {
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

	public static class CastOperationContext extends ParserRuleContext {
		public TerminalNode BoolType() { return getToken(PhpParser.BoolType, 0); }
		public TerminalNode Int8Cast() { return getToken(PhpParser.Int8Cast, 0); }
		public TerminalNode Int16Cast() { return getToken(PhpParser.Int16Cast, 0); }
		public TerminalNode IntType() { return getToken(PhpParser.IntType, 0); }
		public TerminalNode Int64Type() { return getToken(PhpParser.Int64Type, 0); }
		public TerminalNode UintCast() { return getToken(PhpParser.UintCast, 0); }
		public TerminalNode DoubleCast() { return getToken(PhpParser.DoubleCast, 0); }
		public TerminalNode DoubleType() { return getToken(PhpParser.DoubleType, 0); }
		public TerminalNode FloatCast() { return getToken(PhpParser.FloatCast, 0); }
		public TerminalNode StringType() { return getToken(PhpParser.StringType, 0); }
		public TerminalNode BinaryCast() { return getToken(PhpParser.BinaryCast, 0); }
		public TerminalNode UnicodeCast() { return getToken(PhpParser.UnicodeCast, 0); }
		public TerminalNode Array() { return getToken(PhpParser.Array, 0); }
		public TerminalNode ObjectType() { return getToken(PhpParser.ObjectType, 0); }
		public TerminalNode Resource() { return getToken(PhpParser.Resource, 0); }
		public TerminalNode Unset() { return getToken(PhpParser.Unset, 0); }
		public CastOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterCastOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitCastOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PhpParserVisitor ) return ((PhpParserVisitor<? extends T>)visitor).visitCastOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastOperationContext castOperation() throws RecognitionException {
		CastOperationContext _localctx = new CastOperationContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_castOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1623);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Array) | (1L << BinaryCast) | (1L << BoolType) | (1L << DoubleCast) | (1L << DoubleType))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (FloatCast - 77)) | (1L << (Int8Cast - 77)) | (1L << (Int16Cast - 77)) | (1L << (Int64Type - 77)) | (1L << (IntType - 77)) | (1L << (ObjectType - 77)) | (1L << (Resource - 77)) | (1L << (StringType - 77)) | (1L << (UintCast - 77)) | (1L << (UnicodeCast - 77)) | (1L << (Unset - 77)))) != 0)) ) {
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
		case 84:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 9);
		case 9:
			return precpred(_ctx, 8);
		case 10:
			return precpred(_ctx, 7);
		case 11:
			return precpred(_ctx, 6);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 1);
		case 15:
			return precpred(_ctx, 17);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u00e9\u065c\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\3\2\3\2\3\3\5\3\u010a"+
		"\n\3\3\3\7\3\u010d\n\3\f\3\16\3\u0110\13\3\3\3\3\3\3\4\3\4\3\4\5\4\u0117"+
		"\n\4\3\5\6\5\u011a\n\5\r\5\16\5\u011b\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0134\n\6"+
		"\f\6\16\6\u0137\13\6\3\6\5\6\u013a\n\6\3\7\6\7\u013d\n\7\r\7\16\7\u013e"+
		"\3\b\7\b\u0142\n\b\f\b\16\b\u0145\13\b\3\b\6\b\u0148\n\b\r\b\16\b\u0149"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0157\n\n\3\13\3\13\5"+
		"\13\u015b\n\13\3\13\3\13\3\13\3\f\5\f\u0161\n\f\3\f\3\f\3\f\5\f\u0166"+
		"\n\f\3\f\7\f\u0169\n\f\f\f\16\f\u016c\13\f\3\r\3\r\3\r\5\r\u0171\n\r\3"+
		"\16\3\16\5\16\u0175\n\16\3\16\3\16\7\16\u0179\n\16\f\16\16\16\u017c\13"+
		"\16\3\16\3\16\3\16\3\16\5\16\u0182\n\16\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u0189\n\17\3\20\3\20\3\20\5\20\u018e\n\20\3\20\3\20\5\20\u0192\n\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\5\21\u019b\n\21\3\21\5\21\u019e\n\21"+
		"\3\21\5\21\u01a1\n\21\3\21\3\21\3\21\5\21\u01a6\n\21\3\21\3\21\5\21\u01aa"+
		"\n\21\3\21\3\21\5\21\u01ae\n\21\3\21\3\21\3\21\5\21\u01b3\n\21\3\21\3"+
		"\21\5\21\u01b7\n\21\5\21\u01b9\n\21\3\21\3\21\7\21\u01bd\n\21\f\21\16"+
		"\21\u01c0\13\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\7\23\u01c9\n\23\f\23"+
		"\16\23\u01cc\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\5\24\u01dc\n\24\3\25\3\25\3\25\7\25\u01e1\n\25\f\25"+
		"\16\25\u01e4\13\25\3\26\3\26\3\26\7\26\u01e9\n\26\f\26\16\26\u01ec\13"+
		"\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30\u01f6\n\30\3\31\3\31"+
		"\3\31\3\31\7\31\u01fc\n\31\f\31\16\31\u01ff\13\31\3\31\3\31\3\32\7\32"+
		"\u0204\n\32\f\32\16\32\u0207\13\32\3\33\3\33\3\33\3\33\5\33\u020d\n\33"+
		"\3\33\3\33\3\33\7\33\u0212\n\33\f\33\16\33\u0215\13\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u022b\n\34\3\35\3\35\3\35\7\35\u0230\n\35\f\35\16"+
		"\35\u0233\13\35\3\36\3\36\3\36\7\36\u0238\n\36\f\36\16\36\u023b\13\36"+
		"\3\37\3\37\3\37\3\37\3 \7 \u0242\n \f \16 \u0245\13 \3!\3!\3!\5!\u024a"+
		"\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0267\n\"\3#\3#\3$\3$\3"+
		"$\3$\3%\3%\3%\3%\7%\u0273\n%\f%\16%\u0276\13%\3%\5%\u0279\n%\3%\3%\3%"+
		"\3%\3%\7%\u0280\n%\f%\16%\u0283\13%\3%\5%\u0286\n%\3%\3%\3%\5%\u028b\n"+
		"%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\5*\u02a5\n*\3+\3+\3+\3+\3+\3+\3,\3,\3,\5,\u02b0\n,\3,\3,\5,"+
		"\u02b4\n,\3,\3,\5,\u02b8\n,\3,\3,\3,\3,\3,\3,\3,\5,\u02c1\n,\3-\3-\3."+
		"\3.\3/\3/\3/\3/\5/\u02cb\n/\3/\7/\u02ce\n/\f/\16/\u02d1\13/\3/\3/\3/\5"+
		"/\u02d6\n/\3/\7/\u02d9\n/\f/\16/\u02dc\13/\3/\3/\5/\u02e0\n/\3\60\3\60"+
		"\3\60\5\60\u02e5\n\60\3\60\6\60\u02e8\n\60\r\60\16\60\u02e9\3\60\3\60"+
		"\3\61\3\61\5\61\u02f0\n\61\3\61\3\61\3\62\3\62\5\62\u02f6\n\62\3\62\3"+
		"\62\3\63\3\63\5\63\u02fc\n\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\5\66\u030e\n\66\3\66\3\66\3\66"+
		"\5\66\u0313\n\66\3\66\5\66\u0316\n\66\3\66\3\66\3\66\3\66\3\66\3\66\3"+
		"\66\3\66\5\66\u0320\n\66\3\66\5\66\u0323\n\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u0330\n\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\5\66\u0338\n\66\3\67\3\67\3\67\6\67\u033d\n\67\r\67\16\67\u033e"+
		"\3\67\5\67\u0342\n\67\3\67\7\67\u0345\n\67\f\67\16\67\u0348\13\67\3\67"+
		"\5\67\u034b\n\67\38\38\38\38\38\38\38\39\39\39\3:\3:\3:\3:\3;\3;\3;\3"+
		";\3<\3<\3<\3<\3<\3<\3<\3<\3<\3<\5<\u0369\n<\3=\6=\u036c\n=\r=\16=\u036d"+
		"\3>\3>\5>\u0372\n>\3?\3?\3?\7?\u0377\n?\f?\16?\u037a\13?\3@\5@\u037d\n"+
		"@\3@\3@\7@\u0381\n@\f@\16@\u0384\13@\3A\3A\5A\u0388\nA\3A\5A\u038b\nA"+
		"\3A\5A\u038e\nA\3A\3A\3B\3B\3B\5B\u0395\nB\3C\3C\3C\3C\7C\u039b\nC\fC"+
		"\16C\u039e\13C\3C\3C\3D\3D\3D\3D\3D\3D\3D\3D\5D\u03aa\nD\3E\3E\3E\3E\3"+
		"F\3F\3F\3F\7F\u03b4\nF\fF\16F\u03b7\13F\3F\3F\3G\3G\3G\3G\3G\7G\u03c0"+
		"\nG\fG\16G\u03c3\13G\3G\3G\3G\3G\3G\3G\3G\7G\u03cc\nG\fG\16G\u03cf\13"+
		"G\3G\3G\3G\3G\5G\u03d5\nG\3G\3G\5G\u03d9\nG\3G\3G\5G\u03dd\nG\3G\3G\3"+
		"G\3G\5G\u03e3\nG\3G\3G\3G\3G\3G\3G\5G\u03eb\nG\3H\3H\3H\7H\u03f0\nH\f"+
		"H\16H\u03f3\13H\3H\5H\u03f6\nH\3I\3I\5I\u03fa\nI\3J\3J\3J\3J\3J\3J\3J"+
		"\3K\3K\3K\3K\5K\u0407\nK\3K\5K\u040a\nK\3K\3K\3L\3L\3L\5L\u0411\nL\3L"+
		"\3L\3M\3M\3M\3M\3N\3N\5N\u041b\nN\3O\3O\5O\u041f\nO\3P\6P\u0422\nP\rP"+
		"\16P\u0423\3Q\3Q\3Q\5Q\u0429\nQ\3R\3R\3R\3R\3S\3S\3S\3S\3S\7S\u0434\n"+
		"S\fS\16S\u0437\13S\3S\3S\3T\3T\3T\7T\u043e\nT\fT\16T\u0441\13T\3U\3U\3"+
		"U\5U\u0446\nU\3U\3U\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3"+
		"V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\5V\u046c\nV\3V\3"+
		"V\3V\5V\u0471\nV\3V\5V\u0474\nV\3V\3V\3V\3V\5V\u047a\nV\3V\3V\3V\3V\3"+
		"V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\5"+
		"V\u0497\nV\3V\3V\3V\3V\3V\5V\u049e\nV\3V\3V\5V\u04a2\nV\3V\3V\3V\3V\5"+
		"V\u04a8\nV\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\5V\u04b5\nV\5V\u04b7\nV\3"+
		"V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3"+
		"V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\3V\5V\u04dd\nV\3V\3V\3V\3V\3V\3V\3"+
		"V\3V\3V\3V\3V\3V\3V\3V\7V\u04ed\nV\fV\16V\u04f0\13V\3W\3W\3W\5W\u04f5"+
		"\nW\3X\3X\3Y\3Y\3Y\3Y\5Y\u04fd\nY\3Z\3Z\3Z\7Z\u0502\nZ\fZ\16Z\u0505\13"+
		"Z\3Z\5Z\u0508\nZ\3[\3[\3[\5[\u050d\n[\3[\3[\3[\5[\u0512\n[\3[\3[\5[\u0516"+
		"\n[\3\\\3\\\3\\\3\\\3\\\7\\\u051d\n\\\f\\\16\\\u0520\13\\\3\\\3\\\3]\5"+
		"]\u0525\n]\3]\3]\3^\3^\5^\u052b\n^\3^\5^\u052e\n^\3_\3_\5_\u0532\n_\3"+
		"_\5_\u0535\n_\3_\3_\5_\u0539\n_\3`\3`\3`\7`\u053e\n`\f`\16`\u0541\13`"+
		"\3a\5a\u0544\na\3a\5a\u0547\na\3a\3a\3b\3b\3b\7b\u054e\nb\fb\16b\u0551"+
		"\13b\3c\3c\3c\7c\u0556\nc\fc\16c\u0559\13c\3d\3d\3d\3d\7d\u055f\nd\fd"+
		"\16d\u0562\13d\3d\5d\u0565\nd\3d\3d\3e\5e\u056a\ne\3e\3e\3e\5e\u056f\n"+
		"e\3f\3f\3f\3f\3f\3f\5f\u0577\nf\5f\u0579\nf\3f\3f\3f\3f\5f\u057f\nf\5"+
		"f\u0581\nf\3f\3f\3f\5f\u0586\nf\3g\3g\3g\7g\u058b\ng\fg\16g\u058e\13g"+
		"\3h\3h\3h\5h\u0593\nh\3i\3i\3i\3i\3i\5i\u059a\ni\3j\3j\3j\3j\5j\u05a0"+
		"\nj\3k\3k\3l\3l\3l\3l\3l\3l\5l\u05aa\nl\3l\3l\5l\u05ae\nl\3l\3l\3l\5l"+
		"\u05b3\nl\3m\3m\3n\3n\6n\u05b9\nn\rn\16n\u05ba\3n\3n\6n\u05bf\nn\rn\16"+
		"n\u05c0\3n\3n\3n\7n\u05c6\nn\fn\16n\u05c9\13n\3n\5n\u05cc\nn\3o\3o\5o"+
		"\u05d0\no\3p\3p\3p\7p\u05d5\np\fp\16p\u05d8\13p\3q\3q\3q\3q\3q\3q\5q\u05e0"+
		"\nq\3q\7q\u05e3\nq\fq\16q\u05e6\13q\3r\3r\3r\5r\u05eb\nr\3s\3s\3s\3t\3"+
		"t\3t\5t\u05f3\nt\3u\5u\u05f6\nu\3u\3u\7u\u05fa\nu\fu\16u\u05fd\13u\3v"+
		"\3v\3v\5v\u0602\nv\3v\3v\3v\3v\5v\u0608\nv\3w\3w\5w\u060c\nw\3x\3x\3x"+
		"\3x\3x\5x\u0613\nx\3x\7x\u0616\nx\fx\16x\u0619\13x\3y\7y\u061c\ny\fy\16"+
		"y\u061f\13y\3y\3y\3y\3y\3y\3y\5y\u0627\ny\3y\7y\u062a\ny\fy\16y\u062d"+
		"\13y\3z\3z\5z\u0631\nz\3z\3z\3z\3z\3z\5z\u0638\nz\3{\5{\u063b\n{\3{\3"+
		"{\5{\u063f\n{\7{\u0641\n{\f{\16{\u0644\13{\3|\3|\3|\3|\3|\3|\5|\u064c"+
		"\n|\3}\3}\3~\3~\3\177\3\177\3\u0080\3\u0080\3\u0081\3\u0081\3\u0082\3"+
		"\u0082\3\u0083\3\u0083\3\u0083\2\3\u00aa\u0084\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv"+
		"xz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac"+
		"\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4"+
		"\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc"+
		"\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4"+
		"\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\2\32\4\299RR\4\2\67\67"+
		"xx\3\2\u00d1\u00d2\3\2\u00c5\u00c6\4\2\u00be\u00be\u00c0\u00c1\3\2\u009d"+
		"\u009e\3\2XY\3\2pq\3\2\u00c2\u00c4\4\2\u00c0\u00c1\u00c8\u00c8\3\2\u00b4"+
		"\u00b5\4\2\u00a3\u00a4\u00ba\u00bb\3\2\u009f\u00a2\5\2\u00a5\u00a7\u00a9"+
		"\u00b1\u00d3\u00d3\3\2\u00c0\u00c1\4\2\u00d8\u00d9\u00db\u00dc\4\2\67"+
		"\67jj\4\2--MM\4\2-\u0099\u00d7\u00d7\6\2--MMmott\3\2\u0092\u0099\3\2\u0082"+
		"\u0091\t\2..\61\61??^_iirruu\13\2..\60\61>?OO\\_iirruu{}\2\u0702\2\u0106"+
		"\3\2\2\2\4\u0109\3\2\2\2\6\u0116\3\2\2\2\b\u0119\3\2\2\2\n\u0139\3\2\2"+
		"\2\f\u013c\3\2\2\2\16\u0143\3\2\2\2\20\u014b\3\2\2\2\22\u0156\3\2\2\2"+
		"\24\u0158\3\2\2\2\26\u0160\3\2\2\2\30\u016d\3\2\2\2\32\u0172\3\2\2\2\34"+
		"\u0188\3\2\2\2\36\u018a\3\2\2\2 \u0198\3\2\2\2\"\u01c3\3\2\2\2$\u01c5"+
		"\3\2\2\2&\u01db\3\2\2\2(\u01dd\3\2\2\2*\u01e5\3\2\2\2,\u01ed\3\2\2\2."+
		"\u01f0\3\2\2\2\60\u01f7\3\2\2\2\62\u0205\3\2\2\2\64\u0208\3\2\2\2\66\u022a"+
		"\3\2\2\28\u022c\3\2\2\2:\u0234\3\2\2\2<\u023c\3\2\2\2>\u0243\3\2\2\2@"+
		"\u0249\3\2\2\2B\u0266\3\2\2\2D\u0268\3\2\2\2F\u026a\3\2\2\2H\u028a\3\2"+
		"\2\2J\u028c\3\2\2\2L\u0290\3\2\2\2N\u0295\3\2\2\2P\u0298\3\2\2\2R\u029c"+
		"\3\2\2\2T\u02a6\3\2\2\2V\u02ac\3\2\2\2X\u02c2\3\2\2\2Z\u02c4\3\2\2\2\\"+
		"\u02c6\3\2\2\2^\u02e7\3\2\2\2`\u02ed\3\2\2\2b\u02f3\3\2\2\2d\u02f9\3\2"+
		"\2\2f\u02ff\3\2\2\2h\u0302\3\2\2\2j\u0308\3\2\2\2l\u0339\3\2\2\2n\u034c"+
		"\3\2\2\2p\u0353\3\2\2\2r\u0356\3\2\2\2t\u035a\3\2\2\2v\u035e\3\2\2\2x"+
		"\u036b\3\2\2\2z\u0371\3\2\2\2|\u0373\3\2\2\2~\u037c\3\2\2\2\u0080\u0385"+
		"\3\2\2\2\u0082\u0394\3\2\2\2\u0084\u0396\3\2\2\2\u0086\u03a9\3\2\2\2\u0088"+
		"\u03ab\3\2\2\2\u008a\u03af\3\2\2\2\u008c\u03ea\3\2\2\2\u008e\u03f5\3\2"+
		"\2\2\u0090\u03f9\3\2\2\2\u0092\u03fb\3\2\2\2\u0094\u0402\3\2\2\2\u0096"+
		"\u0410\3\2\2\2\u0098\u0414\3\2\2\2\u009a\u041a\3\2\2\2\u009c\u041e\3\2"+
		"\2\2\u009e\u0421\3\2\2\2\u00a0\u0425\3\2\2\2\u00a2\u042a\3\2\2\2\u00a4"+
		"\u042e\3\2\2\2\u00a6\u043a\3\2\2\2\u00a8\u0442\3\2\2\2\u00aa\u04b6\3\2"+
		"\2\2\u00ac\u04f1\3\2\2\2\u00ae\u04f6\3\2\2\2\u00b0\u04f8\3\2\2\2\u00b2"+
		"\u04fe\3\2\2\2\u00b4\u0515\3\2\2\2\u00b6\u0517\3\2\2\2\u00b8\u0524\3\2"+
		"\2\2\u00ba\u052d\3\2\2\2\u00bc\u0538\3\2\2\2\u00be\u053a\3\2\2\2\u00c0"+
		"\u0543\3\2\2\2\u00c2\u054a\3\2\2\2\u00c4\u0552\3\2\2\2\u00c6\u055a\3\2"+
		"\2\2\u00c8\u056e\3\2\2\2\u00ca\u0585\3\2\2\2\u00cc\u0587\3\2\2\2\u00ce"+
		"\u058f\3\2\2\2\u00d0\u0599\3\2\2\2\u00d2\u059f\3\2\2\2\u00d4\u05a1\3\2"+
		"\2\2\u00d6\u05b2\3\2\2\2\u00d8\u05b4\3\2\2\2\u00da\u05cb\3\2\2\2\u00dc"+
		"\u05cf\3\2\2\2\u00de\u05d1\3\2\2\2\u00e0\u05df\3\2\2\2\u00e2\u05e7\3\2"+
		"\2\2\u00e4\u05ec\3\2\2\2\u00e6\u05f2\3\2\2\2\u00e8\u05f5\3\2\2\2\u00ea"+
		"\u0607\3\2\2\2\u00ec\u060b\3\2\2\2\u00ee\u0612\3\2\2\2\u00f0\u061d\3\2"+
		"\2\2\u00f2\u0637\3\2\2\2\u00f4\u063a\3\2\2\2\u00f6\u064b\3\2\2\2\u00f8"+
		"\u064d\3\2\2\2\u00fa\u064f\3\2\2\2\u00fc\u0651\3\2\2\2\u00fe\u0653\3\2"+
		"\2\2\u0100\u0655\3\2\2\2\u0102\u0657\3\2\2\2\u0104\u0659\3\2\2\2\u0106"+
		"\u0107\5\4\3\2\u0107\3\3\2\2\2\u0108\u010a\7\f\2\2\u0109\u0108\3\2\2\2"+
		"\u0109\u010a\3\2\2\2\u010a\u010e\3\2\2\2\u010b\u010d\5\6\4\2\u010c\u010b"+
		"\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\7\2\2\3\u0112\5\3\2\2\2"+
		"\u0113\u0117\5\b\5\2\u0114\u0117\5\16\b\2\u0115\u0117\5\f\7\2\u0116\u0113"+
		"\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0115\3\2\2\2\u0117\7\3\2\2\2\u0118"+
		"\u011a\5\n\6\2\u0119\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u0119\3\2"+
		"\2\2\u011b\u011c\3\2\2\2\u011c\t\3\2\2\2\u011d\u013a\7\n\2\2\u011e\u013a"+
		"\7\7\2\2\u011f\u013a\7\21\2\2\u0120\u013a\7\b\2\2\u0121\u013a\7\13\2\2"+
		"\u0122\u013a\7\32\2\2\u0123\u013a\7\22\2\2\u0124\u013a\7\23\2\2\u0125"+
		"\u013a\7\4\2\2\u0126\u013a\7\24\2\2\u0127\u013a\7\25\2\2\u0128\u013a\7"+
		"\35\2\2\u0129\u013a\7\26\2\2\u012a\u013a\7!\2\2\u012b\u013a\7\27\2\2\u012c"+
		"\u013a\7\30\2\2\u012d\u013a\7\36\2\2\u012e\u013a\7\"\2\2\u012f\u013a\7"+
		"\'\2\2\u0130\u013a\7%\2\2\u0131\u0135\7\5\2\2\u0132\u0134\7\16\2\2\u0133"+
		"\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2"+
		"\2\2\u0136\u0138\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u013a\7\17\2\2\u0139"+
		"\u011d\3\2\2\2\u0139\u011e\3\2\2\2\u0139\u011f\3\2\2\2\u0139\u0120\3\2"+
		"\2\2\u0139\u0121\3\2\2\2\u0139\u0122\3\2\2\2\u0139\u0123\3\2\2\2\u0139"+
		"\u0124\3\2\2\2\u0139\u0125\3\2\2\2\u0139\u0126\3\2\2\2\u0139\u0127\3\2"+
		"\2\2\u0139\u0128\3\2\2\2\u0139\u0129\3\2\2\2\u0139\u012a\3\2\2\2\u0139"+
		"\u012b\3\2\2\2\u0139\u012c\3\2\2\2\u0139\u012d\3\2\2\2\u0139\u012e\3\2"+
		"\2\2\u0139\u012f\3\2\2\2\u0139\u0130\3\2\2\2\u0139\u0131\3\2\2\2\u013a"+
		"\13\3\2\2\2\u013b\u013d\7$\2\2\u013c\u013b\3\2\2\2\u013d\u013e\3\2\2\2"+
		"\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\r\3\2\2\2\u0140\u0142\5"+
		"\20\t\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0148\5\22"+
		"\n\2\u0147\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\17\3\2\2\2\u014b\u014c\7W\2\2\u014c\u014d\7f\2\2"+
		"\u014d\u014e\5\u00c2b\2\u014e\u014f\7\u00d2\2\2\u014f\21\3\2\2\2\u0150"+
		"\u0157\5B\"\2\u0151\u0157\5\24\13\2\u0152\u0157\5\32\16\2\u0153\u0157"+
		"\5\36\20\2\u0154\u0157\5 \21\2\u0155\u0157\5\u00a4S\2\u0156\u0150\3\2"+
		"\2\2\u0156\u0151\3\2\2\2\u0156\u0152\3\2\2\2\u0156\u0153\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0156\u0155\3\2\2\2\u0157\23\3\2\2\2\u0158\u015a\7~\2\2"+
		"\u0159\u015b\t\2\2\2\u015a\u0159\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c"+
		"\3\2\2\2\u015c\u015d\5\26\f\2\u015d\u015e\7\u00d2\2\2\u015e\25\3\2\2\2"+
		"\u015f\u0161\7\u00b8\2\2\u0160\u015f\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0162\u016a\5\30\r\2\u0163\u0165\7\u00d0\2\2\u0164\u0166"+
		"\7\u00b8\2\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167\3\2\2"+
		"\2\u0167\u0169\5\30\r\2\u0168\u0163\3\2\2\2\u0169\u016c\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\27\3\2\2\2\u016c\u016a\3\2\2"+
		"\2\u016d\u0170\5\u00c2b\2\u016e\u016f\7/\2\2\u016f\u0171\5\u00fa~\2\u0170"+
		"\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\31\3\2\2\2\u0172\u0181\7f\2\2"+
		"\u0173\u0175\5\u00c2b\2\u0174\u0173\3\2\2\2\u0174\u0175\3\2\2\2\u0175"+
		"\u0176\3\2\2\2\u0176\u017a\7\u00ce\2\2\u0177\u0179\5\34\17\2\u0178\u0177"+
		"\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b"+
		"\u017d\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u0182\7\u00cf\2\2\u017e\u017f"+
		"\5\u00c2b\2\u017f\u0180\7\u00d2\2\2\u0180\u0182\3\2\2\2\u0181\u0174\3"+
		"\2\2\2\u0181\u017e\3\2\2\2\u0182\33\3\2\2\2\u0183\u0189\5B\"\2\u0184\u0189"+
		"\5\24\13\2\u0185\u0189\5\36\20\2\u0186\u0189\5 \21\2\u0187\u0189\5\u00a4"+
		"S\2\u0188\u0183\3\2\2\2\u0188\u0184\3\2\2\2\u0188\u0185\3\2\2\2\u0188"+
		"\u0186\3\2\2\2\u0188\u0187\3\2\2\2\u0189\35\3\2\2\2\u018a\u018b\5\62\32"+
		"\2\u018b\u018d\7R\2\2\u018c\u018e\7\u00bc\2\2\u018d\u018c\3\2\2\2\u018d"+
		"\u018e\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0191\5\u00fa~\2\u0190\u0192"+
		"\5&\24\2\u0191\u0190\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\3\2\2\2\u0193"+
		"\u0194\7\u00ca\2\2\u0194\u0195\5~@\2\u0195\u0196\7\u00cb\2\2\u0196\u0197"+
		"\5F$\2\u0197\37\3\2\2\2\u0198\u019a\5\62\32\2\u0199\u019b\7m\2\2\u019a"+
		"\u0199\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d\3\2\2\2\u019c\u019e\5\u00f8"+
		"}\2\u019d\u019c\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a0\3\2\2\2\u019f"+
		"\u01a1\7k\2\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01b8\3\2"+
		"\2\2\u01a2\u01a3\5\"\22\2\u01a3\u01a5\5\u00fa~\2\u01a4\u01a6\5&\24\2\u01a5"+
		"\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a8\7L"+
		"\2\2\u01a8\u01aa\5\u00ba^\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa"+
		"\u01ad\3\2\2\2\u01ab\u01ac\7V\2\2\u01ac\u01ae\5$\23\2\u01ad\u01ab\3\2"+
		"\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b9\3\2\2\2\u01af\u01b0\7`\2\2\u01b0"+
		"\u01b2\5\u00fa~\2\u01b1\u01b3\5&\24\2\u01b2\u01b1\3\2\2\2\u01b2\u01b3"+
		"\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b5\7L\2\2\u01b5\u01b7\5$\23\2\u01b6"+
		"\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01a2\3\2"+
		"\2\2\u01b8\u01af\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01be\7\u00ce\2\2\u01bb"+
		"\u01bd\5\u008cG\2\u01bc\u01bb\3\2\2\2\u01bd\u01c0\3\2\2\2\u01be\u01bc"+
		"\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c1\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1"+
		"\u01c2\7\u00cf\2\2\u01c2!\3\2\2\2\u01c3\u01c4\t\3\2\2\u01c4#\3\2\2\2\u01c5"+
		"\u01ca\5\u00ba^\2\u01c6\u01c7\7\u00d0\2\2\u01c7\u01c9\5\u00ba^\2\u01c8"+
		"\u01c6\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2"+
		"\2\2\u01cb%\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cd\u01ce\7\u009a\2\2\u01ce"+
		"\u01cf\5(\25\2\u01cf\u01d0\7\u009b\2\2\u01d0\u01dc\3\2\2\2\u01d1\u01d2"+
		"\7\u009a\2\2\u01d2\u01d3\5*\26\2\u01d3\u01d4\7\u009b\2\2\u01d4\u01dc\3"+
		"\2\2\2\u01d5\u01d6\7\u009a\2\2\u01d6\u01d7\5(\25\2\u01d7\u01d8\7\u00d0"+
		"\2\2\u01d8\u01d9\5*\26\2\u01d9\u01da\7\u009b\2\2\u01da\u01dc\3\2\2\2\u01db"+
		"\u01cd\3\2\2\2\u01db\u01d1\3\2\2\2\u01db\u01d5\3\2\2\2\u01dc\'\3\2\2\2"+
		"\u01dd\u01e2\5,\27\2\u01de\u01df\7\u00d0\2\2\u01df\u01e1\5,\27\2\u01e0"+
		"\u01de\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2"+
		"\2\2\u01e3)\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5\u01ea\5.\30\2\u01e6\u01e7"+
		"\7\u00d0\2\2\u01e7\u01e9\5.\30\2\u01e8\u01e6\3\2\2\2\u01e9\u01ec\3\2\2"+
		"\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb+\3\2\2\2\u01ec\u01ea"+
		"\3\2\2\2\u01ed\u01ee\5\62\32\2\u01ee\u01ef\5\u00fa~\2\u01ef-\3\2\2\2\u01f0"+
		"\u01f1\5\62\32\2\u01f1\u01f2\5\u00fa~\2\u01f2\u01f5\7\u00d3\2\2\u01f3"+
		"\u01f6\5\u00ba^\2\u01f4\u01f6\5\u0102\u0082\2\u01f5\u01f3\3\2\2\2\u01f5"+
		"\u01f4\3\2\2\2\u01f6/\3\2\2\2\u01f7\u01f8\7\u009a\2\2\u01f8\u01fd\5\u00bc"+
		"_\2\u01f9\u01fa\7\u00d0\2\2\u01fa\u01fc\5\u00bc_\2\u01fb\u01f9\3\2\2\2"+
		"\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0200"+
		"\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0201\7\u009b\2\2\u0201\61\3\2\2\2"+
		"\u0202\u0204\5\64\33\2\u0203\u0202\3\2\2\2\u0204\u0207\3\2\2\2\u0205\u0203"+
		"\3\2\2\2\u0205\u0206\3\2\2\2\u0206\63\3\2\2\2\u0207\u0205\3\2\2\2\u0208"+
		"\u020c\7\u00cc\2\2\u0209\u020a\5\u00fa~\2\u020a\u020b\7\u00d1\2\2\u020b"+
		"\u020d\3\2\2\2\u020c\u0209\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020e\3\2"+
		"\2\2\u020e\u0213\5\66\34\2\u020f\u0210\7\u00d0\2\2\u0210\u0212\5\66\34"+
		"\2\u0211\u020f\3\2\2\2\u0212\u0215\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214"+
		"\3\2\2\2\u0214\u0216\3\2\2\2\u0215\u0213\3\2\2\2\u0216\u0217\7\u00cd\2"+
		"\2\u0217\65\3\2\2\2\u0218\u022b\5\u00c0a\2\u0219\u021a\5\u00c0a\2\u021a"+
		"\u021b\7\u00ca\2\2\u021b\u021c\58\35\2\u021c\u021d\7\u00cb\2\2\u021d\u022b"+
		"\3\2\2\2\u021e\u021f\5\u00c0a\2\u021f\u0220\7\u00ca\2\2\u0220\u0221\5"+
		":\36\2\u0221\u0222\7\u00cb\2\2\u0222\u022b\3\2\2\2\u0223\u0224\5\u00c0"+
		"a\2\u0224\u0225\7\u00ca\2\2\u0225\u0226\58\35\2\u0226\u0227\7\u00d0\2"+
		"\2\u0227\u0228\5:\36\2\u0228\u0229\7\u00cb\2\2\u0229\u022b\3\2\2\2\u022a"+
		"\u0218\3\2\2\2\u022a\u0219\3\2\2\2\u022a\u021e\3\2\2\2\u022a\u0223\3\2"+
		"\2\2\u022b\67\3\2\2\2\u022c\u0231\5\u00aaV\2\u022d\u022e\7\u00d0\2\2\u022e"+
		"\u0230\5\u00aaV\2\u022f\u022d\3\2\2\2\u0230\u0233\3\2\2\2\u0231\u022f"+
		"\3\2\2\2\u0231\u0232\3\2\2\2\u02329\3\2\2\2\u0233\u0231\3\2\2\2\u0234"+
		"\u0239\5<\37\2\u0235\u0236\7\u00d0\2\2\u0236\u0238\5<\37\2\u0237\u0235"+
		"\3\2\2\2\u0238\u023b\3\2\2\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a"+
		";\3\2\2\2\u023b\u0239\3\2\2\2\u023c\u023d\7\u00d6\2\2\u023d\u023e\7\u009c"+
		"\2\2\u023e\u023f\5\u00aaV\2\u023f=\3\2\2\2\u0240\u0242\5@!\2\u0241\u0240"+
		"\3\2\2\2\u0242\u0245\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244"+
		"?\3\2\2\2\u0245\u0243\3\2\2\2\u0246\u024a\5B\"\2\u0247\u024a\5\36\20\2"+
		"\u0248\u024a\5 \21\2\u0249\u0246\3\2\2\2\u0249\u0247\3\2\2\2\u0249\u0248"+
		"\3\2\2\2\u024aA\3\2\2\2\u024b\u024c\5\u00fa~\2\u024c\u024d\7\u00d1\2\2"+
		"\u024d\u0267\3\2\2\2\u024e\u0267\5F$\2\u024f\u0267\5H%\2\u0250\u0267\5"+
		"R*\2\u0251\u0267\5T+\2\u0252\u0267\5V,\2\u0253\u0267\5\\/\2\u0254\u0267"+
		"\5`\61\2\u0255\u0267\5b\62\2\u0256\u0267\5d\63\2\u0257\u0258\5\u00b0Y"+
		"\2\u0258\u0259\7\u00d2\2\2\u0259\u0267\3\2\2\2\u025a\u0267\5\u0084C\2"+
		"\u025b\u0267\5\u008aF\2\u025c\u0267\5\u0088E\2\u025d\u0267\5f\64\2\u025e"+
		"\u0267\5h\65\2\u025f\u0267\5j\66\2\u0260\u0267\5l\67\2\u0261\u0267\5r"+
		":\2\u0262\u0267\5t;\2\u0263\u0267\5v<\2\u0264\u0267\5D#\2\u0265\u0267"+
		"\5x=\2\u0266\u024b\3\2\2\2\u0266\u024e\3\2\2\2\u0266\u024f\3\2\2\2\u0266"+
		"\u0250\3\2\2\2\u0266\u0251\3\2\2\2\u0266\u0252\3\2\2\2\u0266\u0253\3\2"+
		"\2\2\u0266\u0254\3\2\2\2\u0266\u0255\3\2\2\2\u0266\u0256\3\2\2\2\u0266"+
		"\u0257\3\2\2\2\u0266\u025a\3\2\2\2\u0266\u025b\3\2\2\2\u0266\u025c\3\2"+
		"\2\2\u0266\u025d\3\2\2\2\u0266\u025e\3\2\2\2\u0266\u025f\3\2\2\2\u0266"+
		"\u0260\3\2\2\2\u0266\u0261\3\2\2\2\u0266\u0262\3\2\2\2\u0266\u0263\3\2"+
		"\2\2\u0266\u0264\3\2\2\2\u0266\u0265\3\2\2\2\u0267C\3\2\2\2\u0268\u0269"+
		"\7\u00d2\2\2\u0269E\3\2\2\2\u026a\u026b\7\u00ce\2\2\u026b\u026c\5> \2"+
		"\u026c\u026d\7\u00cf\2\2\u026dG\3\2\2\2\u026e\u026f\7U\2\2\u026f\u0270"+
		"\5\u00a8U\2\u0270\u0274\5B\"\2\u0271\u0273\5J&\2\u0272\u0271\3\2\2\2\u0273"+
		"\u0276\3\2\2\2\u0274\u0272\3\2\2\2\u0274\u0275\3\2\2\2\u0275\u0278\3\2"+
		"\2\2\u0276\u0274\3\2\2\2\u0277\u0279\5N(\2\u0278\u0277\3\2\2\2\u0278\u0279"+
		"\3\2\2\2\u0279\u028b\3\2\2\2\u027a\u027b\7U\2\2\u027b\u027c\5\u00a8U\2"+
		"\u027c\u027d\7\u00d1\2\2\u027d\u0281\5> \2\u027e\u0280\5L\'\2\u027f\u027e"+
		"\3\2\2\2\u0280\u0283\3\2\2\2\u0281\u027f\3\2\2\2\u0281\u0282\3\2\2\2\u0282"+
		"\u0285\3\2\2\2\u0283\u0281\3\2\2\2\u0284\u0286\5P)\2\u0285\u0284\3\2\2"+
		"\2\u0285\u0286\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0288\7G\2\2\u0288\u0289"+
		"\7\u00d2\2\2\u0289\u028b\3\2\2\2\u028a\u026e\3\2\2\2\u028a\u027a\3\2\2"+
		"\2\u028bI\3\2\2\2\u028c\u028d\7B\2\2\u028d\u028e\5\u00a8U\2\u028e\u028f"+
		"\5B\"\2\u028fK\3\2\2\2\u0290\u0291\7B\2\2\u0291\u0292\5\u00a8U\2\u0292"+
		"\u0293\7\u00d1\2\2\u0293\u0294\5> \2\u0294M\3\2\2\2\u0295\u0296\7A\2\2"+
		"\u0296\u0297\5B\"\2\u0297O\3\2\2\2\u0298\u0299\7A\2\2\u0299\u029a\7\u00d1"+
		"\2\2\u029a\u029b\5> \2\u029bQ\3\2\2\2\u029c\u029d\7\u0080\2\2\u029d\u02a4"+
		"\5\u00a8U\2\u029e\u02a5\5B\"\2\u029f\u02a0\7\u00d1\2\2\u02a0\u02a1\5>"+
		" \2\u02a1\u02a2\7I\2\2\u02a2\u02a3\7\u00d2\2\2\u02a3\u02a5\3\2\2\2\u02a4"+
		"\u029e\3\2\2\2\u02a4\u029f\3\2\2\2\u02a5S\3\2\2\2\u02a6\u02a7\7=\2\2\u02a7"+
		"\u02a8\5B\"\2\u02a8\u02a9\7\u0080\2\2\u02a9\u02aa\5\u00a8U\2\u02aa\u02ab"+
		"\7\u00d2\2\2\u02abU\3\2\2\2\u02ac\u02ad\7P\2\2\u02ad\u02af\7\u00ca\2\2"+
		"\u02ae\u02b0\5X-\2\u02af\u02ae\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b1"+
		"\3\2\2\2\u02b1\u02b3\7\u00d2\2\2\u02b2\u02b4\5\u00a6T\2\u02b3\u02b2\3"+
		"\2\2\2\u02b3\u02b4\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02b7\7\u00d2\2\2"+
		"\u02b6\u02b8\5Z.\2\u02b7\u02b6\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8\u02b9"+
		"\3\2\2\2\u02b9\u02c0\7\u00cb\2\2\u02ba\u02c1\5B\"\2\u02bb\u02bc\7\u00d1"+
		"\2\2\u02bc\u02bd\5> \2\u02bd\u02be\7E\2\2\u02be\u02bf\7\u00d2\2\2\u02bf"+
		"\u02c1\3\2\2\2\u02c0\u02ba\3\2\2\2\u02c0\u02bb\3\2\2\2\u02c1W\3\2\2\2"+
		"\u02c2\u02c3\5\u00a6T\2\u02c3Y\3\2\2\2\u02c4\u02c5\5\u00a6T\2\u02c5[\3"+
		"\2\2\2\u02c6\u02c7\7v\2\2\u02c7\u02df\5\u00a8U\2\u02c8\u02ca\7\u00ce\2"+
		"\2\u02c9\u02cb\7\u00d2\2\2\u02ca\u02c9\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb"+
		"\u02cf\3\2\2\2\u02cc\u02ce\5^\60\2\u02cd\u02cc\3\2\2\2\u02ce\u02d1\3\2"+
		"\2\2\u02cf\u02cd\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02d2\3\2\2\2\u02d1"+
		"\u02cf\3\2\2\2\u02d2\u02e0\7\u00cf\2\2\u02d3\u02d5\7\u00d1\2\2\u02d4\u02d6"+
		"\7\u00d2\2\2\u02d5\u02d4\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02da\3\2\2"+
		"\2\u02d7\u02d9\5^\60\2\u02d8\u02d7\3\2\2\2\u02d9\u02dc\3\2\2\2\u02da\u02d8"+
		"\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dd\3\2\2\2\u02dc\u02da\3\2\2\2\u02dd"+
		"\u02de\7H\2\2\u02de\u02e0\7\u00d2\2\2\u02df\u02c8\3\2\2\2\u02df\u02d3"+
		"\3\2\2\2\u02e0]\3\2\2\2\u02e1\u02e2\7\65\2\2\u02e2\u02e5\5\u00aaV\2\u02e3"+
		"\u02e5\7<\2\2\u02e4\u02e1\3\2\2\2\u02e4\u02e3\3\2\2\2\u02e5\u02e6\3\2"+
		"\2\2\u02e6\u02e8\t\4\2\2\u02e7\u02e4\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9"+
		"\u02e7\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ec\5>"+
		" \2\u02ec_\3\2\2\2\u02ed\u02ef\7\63\2\2\u02ee\u02f0\5\u00aaV\2\u02ef\u02ee"+
		"\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1\u02f2\7\u00d2\2"+
		"\2\u02f2a\3\2\2\2\u02f3\u02f5\7:\2\2\u02f4\u02f6\5\u00aaV\2\u02f5\u02f4"+
		"\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f8\7\u00d2\2"+
		"\2\u02f8c\3\2\2\2\u02f9\u02fb\7s\2\2\u02fa\u02fc\5\u00aaV\2\u02fb\u02fa"+
		"\3\2\2\2\u02fb\u02fc\3\2\2\2\u02fc\u02fd\3\2\2\2\u02fd\u02fe\7\u00d2\2"+
		"\2\u02fee\3\2\2\2\u02ff\u0300\5\u00aaV\2\u0300\u0301\7\u00d2\2\2\u0301"+
		"g\3\2\2\2\u0302\u0303\7}\2\2\u0303\u0304\7\u00ca\2\2\u0304\u0305\5\u00de"+
		"p\2\u0305\u0306\7\u00cb\2\2\u0306\u0307\7\u00d2\2\2\u0307i\3\2\2\2\u0308"+
		"\u032f\7Q\2\2\u0309\u030a\7\u00ca\2\2\u030a\u030b\5\u00e0q\2\u030b\u030d"+
		"\7/\2\2\u030c\u030e\7\u00bc\2\2\u030d\u030c\3\2\2\2\u030d\u030e\3\2\2"+
		"\2\u030e\u030f\3\2\2\2\u030f\u0315\5\u00e0q\2\u0310\u0312\7\u009c\2\2"+
		"\u0311\u0313\7\u00bc\2\2\u0312\u0311\3\2\2\2\u0312\u0313\3\2\2\2\u0313"+
		"\u0314\3\2\2\2\u0314\u0316\5\u00e0q\2\u0315\u0310\3\2\2\2\u0315\u0316"+
		"\3\2\2\2\u0316\u0317\3\2\2\2\u0317\u0318\7\u00cb\2\2\u0318\u0330\3\2\2"+
		"\2\u0319\u031a\7\u00ca\2\2\u031a\u031b\5\u00aaV\2\u031b\u031c\7/\2\2\u031c"+
		"\u0322\5\u00e0q\2\u031d\u031f\7\u009c\2\2\u031e\u0320\7\u00bc\2\2\u031f"+
		"\u031e\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0321\3\2\2\2\u0321\u0323\5\u00e0"+
		"q\2\u0322\u031d\3\2\2\2\u0322\u0323\3\2\2\2\u0323\u0324\3\2\2\2\u0324"+
		"\u0325\7\u00cb\2\2\u0325\u0330\3\2\2\2\u0326\u0327\7\u00ca\2\2\u0327\u0328"+
		"\5\u00e0q\2\u0328\u0329\7/\2\2\u0329\u032a\7b\2\2\u032a\u032b\7\u00ca"+
		"\2\2\u032b\u032c\5\u00f4{\2\u032c\u032d\7\u00cb\2\2\u032d\u032e\7\u00cb"+
		"\2\2\u032e\u0330\3\2\2\2\u032f\u0309\3\2\2\2\u032f\u0319\3\2\2\2\u032f"+
		"\u0326\3\2\2\2\u0330\u0337\3\2\2\2\u0331\u0338\5B\"\2\u0332\u0333\7\u00d1"+
		"\2\2\u0333\u0334\5> \2\u0334\u0335\7F\2\2\u0335\u0336\7\u00d2\2\2\u0336"+
		"\u0338\3\2\2\2\u0337\u0331\3\2\2\2\u0337\u0332\3\2\2\2\u0338k\3\2\2\2"+
		"\u0339\u033a\7y\2\2\u033a\u034a\5F$\2\u033b\u033d\5n8\2\u033c\u033b\3"+
		"\2\2\2\u033d\u033e\3\2\2\2\u033e\u033c\3\2\2\2\u033e\u033f\3\2\2\2\u033f"+
		"\u0341\3\2\2\2\u0340\u0342\5p9\2\u0341\u0340\3\2\2\2\u0341\u0342\3\2\2"+
		"\2\u0342\u034b\3\2\2\2\u0343\u0345\5n8\2\u0344\u0343\3\2\2\2\u0345\u0348"+
		"\3\2\2\2\u0346\u0344\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0349\3\2\2\2\u0348"+
		"\u0346\3\2\2\2\u0349\u034b\5p9\2\u034a\u033c\3\2\2\2\u034a\u0346\3\2\2"+
		"\2\u034bm\3\2\2\2\u034c\u034d\7\66\2\2\u034d\u034e\7\u00ca\2\2\u034e\u034f"+
		"\5\u00ba^\2\u034f\u0350\7\u00d6\2\2\u0350\u0351\7\u00cb\2\2\u0351\u0352"+
		"\5F$\2\u0352o\3\2\2\2\u0353\u0354\7N\2\2\u0354\u0355\5F$\2\u0355q\3\2"+
		"\2\2\u0356\u0357\7w\2\2\u0357\u0358\5\u00aaV\2\u0358\u0359\7\u00d2\2\2"+
		"\u0359s\3\2\2\2\u035a\u035b\7T\2\2\u035b\u035c\5\u00fa~\2\u035c\u035d"+
		"\7\u00d2\2\2\u035du\3\2\2\2\u035e\u035f\7;\2\2\u035f\u0360\7\u00ca\2\2"+
		"\u0360\u0361\5|?\2\u0361\u0368\7\u00cb\2\2\u0362\u0369\5B\"\2\u0363\u0364"+
		"\7\u00d1\2\2\u0364\u0365\5> \2\u0365\u0366\7D\2\2\u0366\u0367\7\u00d2"+
		"\2\2\u0367\u0369\3\2\2\2\u0368\u0362\3\2\2\2\u0368\u0363\3\2\2\2\u0369"+
		"w\3\2\2\2\u036a\u036c\5z>\2\u036b\u036a\3\2\2\2\u036c\u036d\3\2\2\2\u036d"+
		"\u036b\3\2\2\2\u036d\u036e\3\2\2\2\u036ey\3\2\2\2\u036f\u0372\5\b\5\2"+
		"\u0370\u0372\5\f\7\2\u0371\u036f\3\2\2\2\u0371\u0370\3\2\2\2\u0372{\3"+
		"\2\2\2\u0373\u0378\5\u00a2R\2\u0374\u0375\7\u00d0\2\2\u0375\u0377\5\u00a2"+
		"R\2\u0376\u0374\3\2\2\2\u0377\u037a\3\2\2\2\u0378\u0376\3\2\2\2\u0378"+
		"\u0379\3\2\2\2\u0379}\3\2\2\2\u037a\u0378\3\2\2\2\u037b\u037d\5\u0080"+
		"A\2\u037c\u037b\3\2\2\2\u037c\u037d\3\2\2\2\u037d\u0382\3\2\2\2\u037e"+
		"\u037f\7\u00d0\2\2\u037f\u0381\5\u0080A\2\u0380\u037e\3\2\2\2\u0381\u0384"+
		"\3\2\2\2\u0382\u0380\3\2\2\2\u0382\u0383\3\2\2\2\u0383\177\3\2\2\2\u0384"+
		"\u0382\3\2\2\2\u0385\u0387\5\62\32\2\u0386\u0388\5\u0082B\2\u0387\u0386"+
		"\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u038a\3\2\2\2\u0389\u038b\7\u00bc\2"+
		"\2\u038a\u0389\3\2\2\2\u038a\u038b\3\2\2\2\u038b\u038d\3\2\2\2\u038c\u038e"+
		"\7\u00b9\2\2\u038d\u038c\3\2\2\2\u038d\u038e\3\2\2\2\u038e\u038f\3\2\2"+
		"\2\u038f\u0390\5\u00a0Q\2\u0390\u0081\3\2\2\2\u0391\u0395\5\u00ba^\2\u0392"+
		"\u0395\7\64\2\2\u0393\u0395\5\u0102\u0082\2\u0394\u0391\3\2\2\2\u0394"+
		"\u0392\3\2\2\2\u0394\u0393\3\2\2\2\u0395\u0083\3\2\2\2\u0396\u0397\7S"+
		"\2\2\u0397\u039c\5\u0086D\2\u0398\u0399\7\u00d0\2\2\u0399\u039b\5\u0086"+
		"D\2\u039a\u0398\3\2\2\2\u039b\u039e\3\2\2\2\u039c\u039a\3\2\2\2\u039c"+
		"\u039d\3\2\2\2\u039d\u039f\3\2\2\2\u039e\u039c\3\2\2\2\u039f\u03a0\7\u00d2"+
		"\2\2\u03a0\u0085\3\2\2\2\u03a1\u03aa\7\u00d6\2\2\u03a2\u03a3\7\u00c7\2"+
		"\2\u03a3\u03aa\5\u00e0q\2\u03a4\u03a5\7\u00c7\2\2\u03a5\u03a6\7\u00ce"+
		"\2\2\u03a6\u03a7\5\u00aaV\2\u03a7\u03a8\7\u00cf\2\2\u03a8\u03aa\3\2\2"+
		"\2\u03a9\u03a1\3\2\2\2\u03a9\u03a2\3\2\2\2\u03a9\u03a4\3\2\2\2\u03aa\u0087"+
		"\3\2\2\2\u03ab\u03ac\7@\2\2\u03ac\u03ad\5\u00a6T\2\u03ad\u03ae\7\u00d2"+
		"\2\2\u03ae\u0089\3\2\2\2\u03af\u03b0\7t\2\2\u03b0\u03b5\5\u00a0Q\2\u03b1"+
		"\u03b2\7\u00d0\2\2\u03b2\u03b4\5\u00a0Q\2\u03b3\u03b1\3\2\2\2\u03b4\u03b7"+
		"\3\2\2\2\u03b5\u03b3\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6\u03b8\3\2\2\2\u03b7"+
		"\u03b5\3\2\2\2\u03b8\u03b9\7\u00d2\2\2\u03b9\u008b\3\2\2\2\u03ba\u03bb"+
		"\5\62\32\2\u03bb\u03bc\5\u009cO\2\u03bc\u03c1\5\u00a0Q\2\u03bd\u03be\7"+
		"\u00d0\2\2\u03be\u03c0\5\u00a0Q\2\u03bf\u03bd\3\2\2\2\u03c0\u03c3\3\2"+
		"\2\2\u03c1\u03bf\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c4\3\2\2\2\u03c3"+
		"\u03c1\3\2\2\2\u03c4\u03c5\7\u00d2\2\2\u03c5\u03eb\3\2\2\2\u03c6\u03c7"+
		"\5\62\32\2\u03c7\u03c8\79\2\2\u03c8\u03cd\5\u00a2R\2\u03c9\u03ca\7\u00d0"+
		"\2\2\u03ca\u03cc\5\u00a2R\2\u03cb\u03c9\3\2\2\2\u03cc\u03cf\3\2\2\2\u03cd"+
		"\u03cb\3\2\2\2\u03cd\u03ce\3\2\2\2\u03ce\u03d0\3\2\2\2\u03cf\u03cd\3\2"+
		"\2\2\u03d0\u03d1\7\u00d2\2\2\u03d1\u03eb\3\2\2\2\u03d2\u03d4\5\62\32\2"+
		"\u03d3\u03d5\5\u009eP\2\u03d4\u03d3\3\2\2\2\u03d4\u03d5\3\2\2\2\u03d5"+
		"\u03d6\3\2\2\2\u03d6\u03d8\7R\2\2\u03d7\u03d9\7\u00bc\2\2\u03d8\u03d7"+
		"\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9\u03da\3\2\2\2\u03da\u03dc\5\u00fa~"+
		"\2\u03db\u03dd\5&\24\2\u03dc\u03db\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03de"+
		"\3\2\2\2\u03de\u03df\7\u00ca\2\2\u03df\u03e0\5~@\2\u03e0\u03e2\7\u00cb"+
		"\2\2\u03e1\u03e3\5\u0098M\2\u03e2\u03e1\3\2\2\2\u03e2\u03e3\3\2\2\2\u03e3"+
		"\u03e4\3\2\2\2\u03e4\u03e5\5\u009aN\2\u03e5\u03eb\3\2\2\2\u03e6\u03e7"+
		"\7~\2\2\u03e7\u03e8\5\u00c4c\2\u03e8\u03e9\5\u008eH\2\u03e9\u03eb\3\2"+
		"\2\2\u03ea\u03ba\3\2\2\2\u03ea\u03c6\3\2\2\2\u03ea\u03d2\3\2\2\2\u03ea"+
		"\u03e6\3\2\2\2\u03eb\u008d\3\2\2\2\u03ec\u03f6\7\u00d2\2\2\u03ed\u03f1"+
		"\7\u00ce\2\2\u03ee\u03f0\5\u0090I\2\u03ef\u03ee\3\2\2\2\u03f0\u03f3\3"+
		"\2\2\2\u03f1\u03ef\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f4\3\2\2\2\u03f3"+
		"\u03f1\3\2\2\2\u03f4\u03f6\7\u00cf\2\2\u03f5\u03ec\3\2\2\2\u03f5\u03ed"+
		"\3\2\2\2\u03f6\u008f\3\2\2\2\u03f7\u03fa\5\u0092J\2\u03f8\u03fa\5\u0094"+
		"K\2\u03f9\u03f7\3\2\2\2\u03f9\u03f8\3\2\2\2\u03fa\u0091\3\2\2\2\u03fb"+
		"\u03fc\5\u00c0a\2\u03fc\u03fd\7\u00b6\2\2\u03fd\u03fe\5\u00fa~\2\u03fe"+
		"\u03ff\7[\2\2\u03ff\u0400\5\u00c4c\2\u0400\u0401\7\u00d2\2\2\u0401\u0093"+
		"\3\2\2\2\u0402\u0403\5\u0096L\2\u0403\u0409\7/\2\2\u0404\u040a\5\u00fc"+
		"\177\2\u0405\u0407\5\u00fc\177\2\u0406\u0405\3\2\2\2\u0406\u0407\3\2\2"+
		"\2\u0407\u0408\3\2\2\2\u0408\u040a\5\u00fa~\2\u0409\u0404\3\2\2\2\u0409"+
		"\u0406\3\2\2\2\u040a\u040b\3\2\2\2\u040b\u040c\7\u00d2\2\2\u040c\u0095"+
		"\3\2\2\2\u040d\u040e\5\u00c0a\2\u040e\u040f\7\u00b6\2\2\u040f\u0411\3"+
		"\2\2\2\u0410\u040d\3\2\2\2\u0410\u0411\3\2\2\2\u0411\u0412\3\2\2\2\u0412"+
		"\u0413\5\u00fa~\2\u0413\u0097\3\2\2\2\u0414\u0415\7\u00d1\2\2\u0415\u0416"+
		"\5\u00fa~\2\u0416\u0417\5\u00c6d\2\u0417\u0099\3\2\2\2\u0418\u041b\7\u00d2"+
		"\2\2\u0419\u041b\5F$\2\u041a\u0418\3\2\2\2\u041a\u0419\3\2\2\2\u041b\u009b"+
		"\3\2\2\2\u041c\u041f\5\u009eP\2\u041d\u041f\7\177\2\2\u041e\u041c\3\2"+
		"\2\2\u041e\u041d\3\2\2\2\u041f\u009d\3\2\2\2\u0420\u0422\5\u00fc\177\2"+
		"\u0421\u0420\3\2\2\2\u0422\u0423\3\2\2\2\u0423\u0421\3\2\2\2\u0423\u0424"+
		"\3\2\2\2\u0424\u009f\3\2\2\2\u0425\u0428\7\u00d6\2\2\u0426\u0427\7\u00d3"+
		"\2\2\u0427\u0429\5\u00caf\2\u0428\u0426\3\2\2\2\u0428\u0429\3\2\2\2\u0429"+
		"\u00a1\3\2\2\2\u042a\u042b\5\u00fa~\2\u042b\u042c\7\u00d3\2\2\u042c\u042d"+
		"\5\u00caf\2\u042d\u00a3\3\2\2\2\u042e\u042f\5\62\32\2\u042f\u0430\79\2"+
		"\2\u0430\u0435\5\u00a2R\2\u0431\u0432\7\u00d0\2\2\u0432\u0434\5\u00a2"+
		"R\2\u0433\u0431\3\2\2\2\u0434\u0437\3\2\2\2\u0435\u0433\3\2\2\2\u0435"+
		"\u0436\3\2\2\2\u0436\u0438\3\2\2\2\u0437\u0435\3\2\2\2\u0438\u0439\7\u00d2"+
		"\2\2\u0439\u00a5\3\2\2\2\u043a\u043f\5\u00aaV\2\u043b\u043c\7\u00d0\2"+
		"\2\u043c\u043e\5\u00aaV\2\u043d\u043b\3\2\2\2\u043e\u0441\3\2\2\2\u043f"+
		"\u043d\3\2\2\2\u043f\u0440\3\2\2\2\u0440\u00a7\3\2\2\2\u0441\u043f\3\2"+
		"\2\2\u0442\u0445\7\u00ca\2\2\u0443\u0446\5\u00aaV\2\u0444\u0446\5\u00b0"+
		"Y\2\u0445\u0443\3\2\2\2\u0445\u0444\3\2\2\2\u0446\u0447\3\2\2\2\u0447"+
		"\u0448\7\u00cb\2\2\u0448\u00a9\3\2\2\2\u0449\u044a\bV\1\2\u044a\u044b"+
		"\78\2\2\u044b\u04b7\5\u00aaV-\u044c\u04b7\5\u00acW\2\u044d\u044e\5\u00d8"+
		"m\2\u044e\u044f\7\u00cc\2\2\u044f\u0450\5\u00aaV\2\u0450\u0451\7\u00cd"+
		"\2\2\u0451\u04b7\3\2\2\2\u0452\u0453\7\u00ca\2\2\u0453\u0454\5\u0104\u0083"+
		"\2\u0454\u0455\7\u00cb\2\2\u0455\u0456\5\u00aaV*\u0456\u04b7\3\2\2\2\u0457"+
		"\u0458\t\5\2\2\u0458\u04b7\5\u00aaV)\u0459\u045a\t\6\2\2\u045a\u04b7\5"+
		"\u00aaV(\u045b\u045c\t\7\2\2\u045c\u04b7\5\u00e0q\2\u045d\u045e\5\u00e0"+
		"q\2\u045e\u045f\t\7\2\2\u045f\u04b7\3\2\2\2\u0460\u0461\7l\2\2\u0461\u04b7"+
		"\5\u00aaV%\u0462\u04b7\5\u00e0q\2\u0463\u04b7\5\u00d0i\2\u0464\u04b7\5"+
		"\u00dan\2\u0465\u04b7\7\u00d7\2\2\u0466\u04b7\7\u00dd\2\2\u0467\u04b7"+
		"\5\u00a8U\2\u0468\u0469\7.\2\2\u0469\u046b\7\u00ca\2\2\u046a\u046c\5\u00b2"+
		"Z\2\u046b\u046a\3\2\2\2\u046b\u046c\3\2\2\2\u046c\u046d\3\2\2\2\u046d"+
		"\u0474\7\u00cb\2\2\u046e\u0470\7\u00cc\2\2\u046f\u0471\5\u00b2Z\2\u0470"+
		"\u046f\3\2\2\2\u0470\u0471\3\2\2\2\u0471\u0472\3\2\2\2\u0472\u0474\7\u00cd"+
		"\2\2\u0473\u0468\3\2\2\2\u0473\u046e\3\2\2\2\u0474\u0479\3\2\2\2\u0475"+
		"\u0476\7\u00cc\2\2\u0476\u0477\5\u00aaV\2\u0477\u0478\7\u00cd\2\2\u0478"+
		"\u047a\3\2\2\2\u0479\u0475\3\2\2\2\u0479\u047a\3\2\2\2\u047a\u04b7\3\2"+
		"\2\2\u047b\u04b7\7\u0081\2\2\u047c\u047d\7b\2\2\u047d\u047e\7\u00ca\2"+
		"\2\u047e\u047f\5\u00f4{\2\u047f\u0480\7\u00cb\2\2\u0480\u0481\7\u00d3"+
		"\2\2\u0481\u0482\5\u00aaV\34\u0482\u04b7\3\2\2\2\u0483\u0484\7a\2\2\u0484"+
		"\u0485\7\u00ca\2\2\u0485\u0486\5\u00dep\2\u0486\u0487\7\u00cb\2\2\u0487"+
		"\u04b7\3\2\2\2\u0488\u0489\7C\2\2\u0489\u048a\7\u00ca\2\2\u048a\u048b"+
		"\5\u00e0q\2\u048b\u048c\7\u00cb\2\2\u048c\u04b7\3\2\2\2\u048d\u048e\7"+
		"J\2\2\u048e\u048f\7\u00ca\2\2\u048f\u0490\5\u00aaV\2\u0490\u0491\7\u00cb"+
		"\2\2\u0491\u04b7\3\2\2\2\u0492\u0496\7K\2\2\u0493\u0494\7\u00ca\2\2\u0494"+
		"\u0497\7\u00cb\2\2\u0495\u0497\5\u00a8U\2\u0496\u0493\3\2\2\2\u0496\u0495"+
		"\3\2\2\2\u0496\u0497\3\2\2\2\u0497\u04b7\3\2\2\2\u0498\u0499\t\b\2\2\u0499"+
		"\u04b7\5\u00aaV\27\u049a\u049b\t\t\2\2\u049b\u04b7\5\u00aaV\26\u049c\u049e"+
		"\7t\2\2\u049d\u049c\3\2\2\2\u049d\u049e\3\2\2\2\u049e\u049f\3\2\2\2\u049f"+
		"\u04a1\7R\2\2\u04a0\u04a2\7\u00bc\2\2\u04a1\u04a0\3\2\2\2\u04a1\u04a2"+
		"\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04a4\7\u00ca\2\2\u04a4\u04a5\5~@\2"+
		"\u04a5\u04a7\7\u00cb\2\2\u04a6\u04a8\5\u00b6\\\2\u04a7\u04a6\3\2\2\2\u04a7"+
		"\u04a8\3\2\2\2\u04a8\u04a9\3\2\2\2\u04a9\u04aa\5F$\2\u04aa\u04b7\3\2\2"+
		"\2\u04ab\u04ac\5\u00e0q\2\u04ac\u04ad\5\u00aeX\2\u04ad\u04ae\5\u00aaV"+
		"\7\u04ae\u04b7\3\2\2\2\u04af\u04b0\5\u00e0q\2\u04b0\u04b1\7\u00d3\2\2"+
		"\u04b1\u04b4\7\u00bc\2\2\u04b2\u04b5\5\u00e0q\2\u04b3\u04b5\5\u00acW\2"+
		"\u04b4\u04b2\3\2\2\2\u04b4\u04b3\3\2\2\2\u04b5\u04b7\3\2\2\2\u04b6\u0449"+
		"\3\2\2\2\u04b6\u044c\3\2\2\2\u04b6\u044d\3\2\2\2\u04b6\u0452\3\2\2\2\u04b6"+
		"\u0457\3\2\2\2\u04b6\u0459\3\2\2\2\u04b6\u045b\3\2\2\2\u04b6\u045d\3\2"+
		"\2\2\u04b6\u0460\3\2\2\2\u04b6\u0462\3\2\2\2\u04b6\u0463\3\2\2\2\u04b6"+
		"\u0464\3\2\2\2\u04b6\u0465\3\2\2\2\u04b6\u0466\3\2\2\2\u04b6\u0467\3\2"+
		"\2\2\u04b6\u0473\3\2\2\2\u04b6\u047b\3\2\2\2\u04b6\u047c\3\2\2\2\u04b6"+
		"\u0483\3\2\2\2\u04b6\u0488\3\2\2\2\u04b6\u048d\3\2\2\2\u04b6\u0492\3\2"+
		"\2\2\u04b6\u0498\3\2\2\2\u04b6\u049a\3\2\2\2\u04b6\u049d\3\2\2\2\u04b6"+
		"\u04ab\3\2\2\2\u04b6\u04af\3\2\2\2\u04b7\u04ee\3\2\2\2\u04b8\u04b9\f\24"+
		"\2\2\u04b9\u04ba\7\u00a8\2\2\u04ba\u04ed\5\u00aaV\24\u04bb\u04bc\f\22"+
		"\2\2\u04bc\u04bd\t\n\2\2\u04bd\u04ed\5\u00aaV\23\u04be\u04bf\f\21\2\2"+
		"\u04bf\u04c0\t\13\2\2\u04c0\u04ed\5\u00aaV\22\u04c1\u04c2\f\20\2\2\u04c2"+
		"\u04c3\t\f\2\2\u04c3\u04ed\5\u00aaV\21\u04c4\u04c5\f\17\2\2\u04c5\u04c6"+
		"\t\r\2\2\u04c6\u04ed\5\u00aaV\20\u04c7\u04c8\f\16\2\2\u04c8\u04c9\t\16"+
		"\2\2\u04c9\u04ed\5\u00aaV\17\u04ca\u04cb\f\r\2\2\u04cb\u04cc\7\u00bc\2"+
		"\2\u04cc\u04ed\5\u00aaV\16\u04cd\u04ce\f\f\2\2\u04ce\u04cf\7\u00bf\2\2"+
		"\u04cf\u04ed\5\u00aaV\r\u04d0\u04d1\f\13\2\2\u04d1\u04d2\7\u00bd\2\2\u04d2"+
		"\u04ed\5\u00aaV\f\u04d3\u04d4\f\n\2\2\u04d4\u04d5\7\u00b3\2\2\u04d5\u04ed"+
		"\5\u00aaV\13\u04d6\u04d7\f\t\2\2\u04d7\u04d8\7\u00b2\2\2\u04d8\u04ed\5"+
		"\u00aaV\n\u04d9\u04da\f\b\2\2\u04da\u04dc\7\u00c9\2\2\u04db\u04dd\5\u00aa"+
		"V\2\u04dc\u04db\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd\u04de\3\2\2\2\u04de"+
		"\u04df\7\u00d1\2\2\u04df\u04ed\5\u00aaV\t\u04e0\u04e1\f\5\2\2\u04e1\u04e2"+
		"\7c\2\2\u04e2\u04ed\5\u00aaV\6\u04e3\u04e4\f\4\2\2\u04e4\u04e5\7e\2\2"+
		"\u04e5\u04ed\5\u00aaV\5\u04e6\u04e7\f\3\2\2\u04e7\u04e8\7d\2\2\u04e8\u04ed"+
		"\5\u00aaV\4\u04e9\u04ea\f\23\2\2\u04ea\u04eb\7Z\2\2\u04eb\u04ed\5\u00bc"+
		"_\2\u04ec\u04b8\3\2\2\2\u04ec\u04bb\3\2\2\2\u04ec\u04be\3\2\2\2\u04ec"+
		"\u04c1\3\2\2\2\u04ec\u04c4\3\2\2\2\u04ec\u04c7\3\2\2\2\u04ec\u04ca\3\2"+
		"\2\2\u04ec\u04cd\3\2\2\2\u04ec\u04d0\3\2\2\2\u04ec\u04d3\3\2\2\2\u04ec"+
		"\u04d6\3\2\2\2\u04ec\u04d9\3\2\2\2\u04ec\u04e0\3\2\2\2\u04ec\u04e3\3\2"+
		"\2\2\u04ec\u04e6\3\2\2\2\u04ec\u04e9\3\2\2\2\u04ed\u04f0\3\2\2\2\u04ee"+
		"\u04ec\3\2\2\2\u04ee\u04ef\3\2\2\2\u04ef\u00ab\3\2\2\2\u04f0\u04ee\3\2"+
		"\2\2\u04f1\u04f2\7g\2\2\u04f2\u04f4\5\u00bc_\2\u04f3\u04f5\5\u00c6d\2"+
		"\u04f4\u04f3\3\2\2\2\u04f4\u04f5\3\2\2\2\u04f5\u00ad\3\2\2\2\u04f6\u04f7"+
		"\t\17\2\2\u04f7\u00af\3\2\2\2\u04f8\u04f9\7\u0081\2\2\u04f9\u04fc\5\u00aa"+
		"V\2\u04fa\u04fb\7\u009c\2\2\u04fb\u04fd\5\u00aaV\2\u04fc\u04fa\3\2\2\2"+
		"\u04fc\u04fd\3\2\2\2\u04fd\u00b1\3\2\2\2\u04fe\u0503\5\u00b4[\2\u04ff"+
		"\u0500\7\u00d0\2\2\u0500\u0502\5\u00b4[\2\u0501\u04ff\3\2\2\2\u0502\u0505"+
		"\3\2\2\2\u0503\u0501\3\2\2\2\u0503\u0504\3\2\2\2\u0504\u0507\3\2\2\2\u0505"+
		"\u0503\3\2\2\2\u0506\u0508\7\u00d0\2\2\u0507\u0506\3\2\2\2\u0507\u0508"+
		"\3\2\2\2\u0508\u00b3\3\2\2\2\u0509\u050c\5\u00aaV\2\u050a\u050b\7\u009c"+
		"\2\2\u050b\u050d\5\u00aaV\2\u050c\u050a\3\2\2\2\u050c\u050d\3\2\2\2\u050d"+
		"\u0516\3\2\2\2\u050e\u050f\5\u00aaV\2\u050f\u0510\7\u009c\2\2\u0510\u0512"+
		"\3\2\2\2\u0511\u050e\3\2\2\2\u0511\u0512\3\2\2\2\u0512\u0513\3\2\2\2\u0513"+
		"\u0514\7\u00bc\2\2\u0514\u0516\5\u00e0q\2\u0515\u0509\3\2\2\2\u0515\u0511"+
		"\3\2\2\2\u0516\u00b5\3\2\2\2\u0517\u0518\7~\2\2\u0518\u0519\7\u00ca\2"+
		"\2\u0519\u051e\5\u00b8]\2\u051a\u051b\7\u00d0\2\2\u051b\u051d\5\u00b8"+
		"]\2\u051c\u051a\3\2\2\2\u051d\u0520\3\2\2\2\u051e\u051c\3\2\2\2\u051e"+
		"\u051f\3\2\2\2\u051f\u0521\3\2\2\2\u0520\u051e\3\2\2\2\u0521\u0522\7\u00cb"+
		"\2\2\u0522\u00b7\3\2\2\2\u0523\u0525\7\u00bc\2\2\u0524\u0523\3\2\2\2\u0524"+
		"\u0525\3\2\2\2\u0525\u0526\3\2\2\2\u0526\u0527\7\u00d6\2\2\u0527\u00b9"+
		"\3\2\2\2\u0528\u052a\5\u00c0a\2\u0529\u052b\5\60\31\2\u052a\u0529\3\2"+
		"\2\2\u052a\u052b\3\2\2\2\u052b\u052e\3\2\2\2\u052c\u052e\7t\2\2\u052d"+
		"\u0528\3\2\2\2\u052d\u052c\3\2\2\2\u052e\u00bb\3\2\2\2\u052f\u0532\5\u00c0"+
		"a\2\u0530\u0532\5\u00be`\2\u0531\u052f\3\2\2\2\u0531\u0530\3\2\2\2\u0532"+
		"\u0534\3\2\2\2\u0533\u0535\5\60\31\2\u0534\u0533\3\2\2\2\u0534\u0535\3"+
		"\2\2\2\u0535\u0539\3\2\2\2\u0536\u0539\5\u0102\u0082\2\u0537\u0539\7t"+
		"\2\2\u0538\u0531\3\2\2\2\u0538\u0536\3\2\2\2\u0538\u0537\3\2\2\2\u0539"+
		"\u00bd\3\2\2\2\u053a\u053f\5\u00eav\2\u053b\u053c\7\u00b7\2\2\u053c\u053e"+
		"\5\u00ecw\2\u053d\u053b\3\2\2\2\u053e\u0541\3\2\2\2\u053f\u053d\3\2\2"+
		"\2\u053f\u0540\3\2\2\2\u0540\u00bf\3\2\2\2\u0541\u053f\3\2\2\2\u0542\u0544"+
		"\7f\2\2\u0543\u0542\3\2\2\2\u0543\u0544\3\2\2\2\u0544\u0546\3\2\2\2\u0545"+
		"\u0547\7\u00b8\2\2\u0546\u0545\3\2\2\2\u0546\u0547\3\2\2\2\u0547\u0548"+
		"\3\2\2\2\u0548\u0549\5\u00c2b\2\u0549\u00c1\3\2\2\2\u054a\u054f\5\u00fa"+
		"~\2\u054b\u054c\7\u00b8\2\2\u054c\u054e\5\u00fa~\2\u054d\u054b\3\2\2\2"+
		"\u054e\u0551\3\2\2\2\u054f\u054d\3\2\2\2\u054f\u0550\3\2\2\2\u0550\u00c3"+
		"\3\2\2\2\u0551\u054f\3\2\2\2\u0552\u0557\5\u00c0a\2\u0553\u0554\7\u00d0"+
		"\2\2\u0554\u0556\5\u00c0a\2\u0555\u0553\3\2\2\2\u0556\u0559\3\2\2\2\u0557"+
		"\u0555\3\2\2\2\u0557\u0558\3\2\2\2\u0558\u00c5\3\2\2\2\u0559\u0557\3\2"+
		"\2\2\u055a\u0564\7\u00ca\2\2\u055b\u0560\5\u00c8e\2\u055c\u055d\7\u00d0"+
		"\2\2\u055d\u055f\5\u00c8e\2\u055e\u055c\3\2\2\2\u055f\u0562\3\2\2\2\u0560"+
		"\u055e\3\2\2\2\u0560\u0561\3\2\2\2\u0561\u0565\3\2\2\2\u0562\u0560\3\2"+
		"\2\2\u0563\u0565\5\u00b0Y\2\u0564\u055b\3\2\2\2\u0564\u0563\3\2\2\2\u0564"+
		"\u0565\3\2\2\2\u0565\u0566\3\2\2\2\u0566\u0567\7\u00cb\2\2\u0567\u00c7"+
		"\3\2\2\2\u0568\u056a\7\u00b9\2\2\u0569\u0568\3\2\2\2\u0569\u056a\3\2\2"+
		"\2\u056a\u056b\3\2\2\2\u056b\u056f\5\u00aaV\2\u056c\u056d\7\u00bc\2\2"+
		"\u056d\u056f\5\u00e0q\2\u056e\u0569\3\2\2\2\u056e\u056c\3\2\2\2\u056f"+
		"\u00c9\3\2\2\2\u0570\u0586\5\u00d0i\2\u0571\u0586\5\u00dan\2\u0572\u0573"+
		"\7.\2\2\u0573\u0578\7\u00ca\2\2\u0574\u0576\5\u00ccg\2\u0575\u0577\7\u00d0"+
		"\2\2\u0576\u0575\3\2\2\2\u0576\u0577\3\2\2\2\u0577\u0579\3\2\2\2\u0578"+
		"\u0574\3\2\2\2\u0578\u0579\3\2\2\2\u0579\u057a\3\2\2\2\u057a\u0586\7\u00cb"+
		"\2\2\u057b\u0580\7\u00cc\2\2\u057c\u057e\5\u00ccg\2\u057d\u057f\7\u00d0"+
		"\2\2\u057e\u057d\3\2\2\2\u057e\u057f\3\2\2\2\u057f\u0581\3\2\2\2\u0580"+
		"\u057c\3\2\2\2\u0580\u0581\3\2\2\2\u0581\u0582\3\2\2\2\u0582\u0586\7\u00cd"+
		"\2\2\u0583\u0584\t\20\2\2\u0584\u0586\5\u00caf\2\u0585\u0570\3\2\2\2\u0585"+
		"\u0571\3\2\2\2\u0585\u0572\3\2\2\2\u0585\u057b\3\2\2\2\u0585\u0583\3\2"+
		"\2\2\u0586\u00cb\3\2\2\2\u0587\u058c\5\u00ceh\2\u0588\u0589\7\u00d0\2"+
		"\2\u0589\u058b\5\u00ceh\2\u058a\u0588\3\2\2\2\u058b\u058e\3\2\2\2\u058c"+
		"\u058a\3\2\2\2\u058c\u058d\3\2\2\2\u058d\u00cd\3\2\2\2\u058e\u058c\3\2"+
		"\2\2\u058f\u0592\5\u00caf\2\u0590\u0591\7\u009c\2\2\u0591\u0593\5\u00ca"+
		"f\2\u0592\u0590\3\2\2\2\u0592\u0593\3\2\2\2\u0593\u00cf\3\2\2\2\u0594"+
		"\u059a\7h\2\2\u0595\u059a\5\u00d2j\2\u0596\u059a\5\u00fe\u0080\2\u0597"+
		"\u059a\5\u00d6l\2\u0598\u059a\5\u00c0a\2\u0599\u0594\3\2\2\2\u0599\u0595"+
		"\3\2\2\2\u0599\u0596\3\2\2\2\u0599\u0597\3\2\2\2\u0599\u0598\3\2\2\2\u059a"+
		"\u00d1\3\2\2\2\u059b\u05a0\7\u00da\2\2\u059c\u05a0\7\62\2\2\u059d\u05a0"+
		"\5\u00d4k\2\u059e\u05a0\5\u00d8m\2\u059f\u059b\3\2\2\2\u059f\u059c\3\2"+
		"\2\2\u059f\u059d\3\2\2\2\u059f\u059e\3\2\2\2\u05a0\u00d3\3\2\2\2\u05a1"+
		"\u05a2\t\21\2\2\u05a2\u00d5\3\2\2\2\u05a3\u05a4\t\22\2\2\u05a4\u05a9\7"+
		"\u00b6\2\2\u05a5\u05aa\5\u00fa~\2\u05a6\u05aa\7\u0086\2\2\u05a7\u05aa"+
		"\7\u0082\2\2\u05a8\u05aa\7\u0083\2\2\u05a9\u05a5\3\2\2\2\u05a9\u05a6\3"+
		"\2\2\2\u05a9\u05a7\3\2\2\2\u05a9\u05a8\3\2\2\2\u05aa\u05b3\3\2\2\2\u05ab"+
		"\u05ae\5\u00ba^\2\u05ac\u05ae\5\u00f0y\2\u05ad\u05ab\3\2\2\2\u05ad\u05ac"+
		"\3\2\2\2\u05ae\u05af\3\2\2\2\u05af\u05b0\7\u00b6\2\2\u05b0\u05b1\5\u00fa"+
		"~\2\u05b1\u05b3\3\2\2\2\u05b2\u05a3\3\2\2\2\u05b2\u05ad\3\2\2\2\u05b3"+
		"\u00d7\3\2\2\2\u05b4\u05b5\7\u00d7\2\2\u05b5\u00d9\3\2\2\2\u05b6\u05b8"+
		"\7\u00e1\2\2\u05b7\u05b9\7\u00e8\2\2\u05b8\u05b7\3\2\2\2\u05b9\u05ba\3"+
		"\2\2\2\u05ba\u05b8\3\2\2\2\u05ba\u05bb\3\2\2\2\u05bb\u05cc\3\2\2\2\u05bc"+
		"\u05be\7\u00e0\2\2\u05bd\u05bf\7\u00e8\2\2\u05be\u05bd\3\2\2\2\u05bf\u05c0"+
		"\3\2\2\2\u05c0\u05be\3\2\2\2\u05c0\u05c1\3\2\2\2\u05c1\u05cc\3\2\2\2\u05c2"+
		"\u05cc\7\u00de\2\2\u05c3\u05c7\7\u00df\2\2\u05c4\u05c6\5\u00dco\2\u05c5"+
		"\u05c4\3\2\2\2\u05c6\u05c9\3\2\2\2\u05c7\u05c5\3\2\2\2\u05c7\u05c8\3\2"+
		"\2\2\u05c8\u05ca\3\2\2\2\u05c9\u05c7\3\2\2\2\u05ca\u05cc\7\u00df\2\2\u05cb"+
		"\u05b6\3\2\2\2\u05cb\u05bc\3\2\2\2\u05cb\u05c2\3\2\2\2\u05cb\u05c3\3\2"+
		"\2\2\u05cc\u00db\3\2\2\2\u05cd\u05d0\7\u00e4\2\2\u05ce\u05d0\5\u00e0q"+
		"\2\u05cf\u05cd\3\2\2\2\u05cf\u05ce\3\2\2\2\u05d0\u00dd\3\2\2\2\u05d1\u05d6"+
		"\5\u00e0q\2\u05d2\u05d3\7\u00d0\2\2\u05d3\u05d5\5\u00e0q\2\u05d4\u05d2"+
		"\3\2\2\2\u05d5\u05d8\3\2\2\2\u05d6\u05d4\3\2\2\2\u05d6\u05d7\3\2\2\2\u05d7"+
		"\u00df\3\2\2\2\u05d8\u05d6\3\2\2\2\u05d9\u05e0\5\u00eav\2\u05da\u05e0"+
		"\5\u00e4s\2\u05db\u05dc\7\u00ca\2\2\u05dc\u05dd\5\u00acW\2\u05dd\u05de"+
		"\7\u00cb\2\2\u05de\u05e0\3\2\2\2\u05df\u05d9\3\2\2\2\u05df\u05da\3\2\2"+
		"\2\u05df\u05db\3\2\2\2\u05e0\u05e4\3\2\2\2\u05e1\u05e3\5\u00e2r\2\u05e2"+
		"\u05e1\3\2\2\2\u05e3\u05e6\3\2\2\2\u05e4\u05e2\3\2\2\2\u05e4\u05e5\3\2"+
		"\2\2\u05e5\u00e1\3\2\2\2\u05e6\u05e4\3\2\2\2\u05e7\u05e8\7\u00b7\2\2\u05e8"+
		"\u05ea\5\u00ecw\2\u05e9\u05eb\5\u00e8u\2\u05ea\u05e9\3\2\2\2\u05ea\u05eb"+
		"\3\2\2\2\u05eb\u00e3\3\2\2\2\u05ec\u05ed\5\u00e6t\2\u05ed\u05ee\5\u00e8"+
		"u\2\u05ee\u00e5\3\2\2\2\u05ef\u05f3\5\u00c0a\2\u05f0\u05f3\5\u00d6l\2"+
		"\u05f1\u05f3\5\u00eav\2\u05f2\u05ef\3\2\2\2\u05f2\u05f0\3\2\2\2\u05f2"+
		"\u05f1\3\2\2\2\u05f3\u00e7\3\2\2\2\u05f4\u05f6\5\60\31\2\u05f5\u05f4\3"+
		"\2\2\2\u05f5\u05f6\3\2\2\2\u05f6\u05f7\3\2\2\2\u05f7\u05fb\5\u00c6d\2"+
		"\u05f8\u05fa\5\u00f2z\2\u05f9\u05f8\3\2\2\2\u05fa\u05fd\3\2\2\2\u05fb"+
		"\u05f9\3\2\2\2\u05fb\u05fc\3\2\2\2\u05fc\u00e9\3\2\2\2\u05fd\u05fb\3\2"+
		"\2\2\u05fe\u0601\5\u00f0y\2\u05ff\u0600\7\u00b6\2\2\u0600\u0602\5\u00f0"+
		"y\2\u0601\u05ff\3\2\2\2\u0601\u0602\3\2\2\2\u0602\u0608\3\2\2\2\u0603"+
		"\u0604\5\u00ba^\2\u0604\u0605\7\u00b6\2\2\u0605\u0606\5\u00f0y\2\u0606"+
		"\u0608\3\2\2\2\u0607\u05fe\3\2\2\2\u0607\u0603\3\2\2\2\u0608\u00eb\3\2"+
		"\2\2\u0609\u060c\5\u00eex\2\u060a\u060c\5\u00f0y\2\u060b\u0609\3\2\2\2"+
		"\u060b\u060a\3\2\2\2\u060c\u00ed\3\2\2\2\u060d\u0613\5\u00fa~\2\u060e"+
		"\u060f\7\u00ce\2\2\u060f\u0610\5\u00aaV\2\u0610\u0611\7\u00cf\2\2\u0611"+
		"\u0613\3\2\2\2\u0612\u060d\3\2\2\2\u0612\u060e\3\2\2\2\u0613\u0617\3\2"+
		"\2\2\u0614\u0616\5\u00f2z\2\u0615\u0614\3\2\2\2\u0616\u0619\3\2\2\2\u0617"+
		"\u0615\3\2\2\2\u0617\u0618\3\2\2\2\u0618\u00ef\3\2\2\2\u0619\u0617\3\2"+
		"\2\2\u061a\u061c\7\u00c7\2\2\u061b\u061a\3\2\2\2\u061c\u061f\3\2\2\2\u061d"+
		"\u061b\3\2\2\2\u061d\u061e\3\2\2\2\u061e\u0626\3\2\2\2\u061f\u061d\3\2"+
		"\2\2\u0620\u0627\7\u00d6\2\2\u0621\u0622\7\u00c7\2\2\u0622\u0623\7\u00ce"+
		"\2\2\u0623\u0624\5\u00aaV\2\u0624\u0625\7\u00cf\2\2\u0625\u0627\3\2\2"+
		"\2\u0626\u0620\3\2\2\2\u0626\u0621\3\2\2\2\u0627\u062b\3\2\2\2\u0628\u062a"+
		"\5\u00f2z\2\u0629\u0628\3\2\2\2\u062a\u062d\3\2\2\2\u062b\u0629\3\2\2"+
		"\2\u062b\u062c\3\2\2\2\u062c\u00f1\3\2\2\2\u062d\u062b\3\2\2\2\u062e\u0630"+
		"\7\u00cc\2\2\u062f\u0631\5\u00aaV\2\u0630\u062f\3\2\2\2\u0630\u0631\3"+
		"\2\2\2\u0631\u0632\3\2\2\2\u0632\u0638\7\u00cd\2\2\u0633\u0634\7\u00ce"+
		"\2\2\u0634\u0635\5\u00aaV\2\u0635\u0636\7\u00cf\2\2\u0636\u0638\3\2\2"+
		"\2\u0637\u062e\3\2\2\2\u0637\u0633\3\2\2\2\u0638\u00f3\3\2\2\2\u0639\u063b"+
		"\5\u00f6|\2\u063a\u0639\3\2\2\2\u063a\u063b\3\2\2\2\u063b\u0642\3\2\2"+
		"\2\u063c\u063e\7\u00d0\2\2\u063d\u063f\5\u00f6|\2\u063e\u063d\3\2\2\2"+
		"\u063e\u063f\3\2\2\2\u063f\u0641\3\2\2\2\u0640\u063c\3\2\2\2\u0641\u0644"+
		"\3\2\2\2\u0642\u0640\3\2\2\2\u0642\u0643\3\2\2\2\u0643\u00f5\3\2\2\2\u0644"+
		"\u0642\3\2\2\2\u0645\u064c\5\u00e0q\2\u0646\u0647\7b\2\2\u0647\u0648\7"+
		"\u00ca\2\2\u0648\u0649\5\u00f4{\2\u0649\u064a\7\u00cb\2\2\u064a\u064c"+
		"\3\2\2\2\u064b\u0645\3\2\2\2\u064b\u0646\3\2\2\2\u064c\u00f7\3\2\2\2\u064d"+
		"\u064e\t\23\2\2\u064e\u00f9\3\2\2\2\u064f\u0650\t\24\2\2\u0650\u00fb\3"+
		"\2\2\2\u0651\u0652\t\25\2\2\u0652\u00fd\3\2\2\2\u0653\u0654\t\26\2\2\u0654"+
		"\u00ff\3\2\2\2\u0655\u0656\t\27\2\2\u0656\u0101\3\2\2\2\u0657\u0658\t"+
		"\30\2\2\u0658\u0103\3\2\2\2\u0659\u065a\t\31\2\2\u065a\u0105\3\2\2\2\u00ba"+
		"\u0109\u010e\u0116\u011b\u0135\u0139\u013e\u0143\u0149\u0156\u015a\u0160"+
		"\u0165\u016a\u0170\u0174\u017a\u0181\u0188\u018d\u0191\u019a\u019d\u01a0"+
		"\u01a5\u01a9\u01ad\u01b2\u01b6\u01b8\u01be\u01ca\u01db\u01e2\u01ea\u01f5"+
		"\u01fd\u0205\u020c\u0213\u022a\u0231\u0239\u0243\u0249\u0266\u0274\u0278"+
		"\u0281\u0285\u028a\u02a4\u02af\u02b3\u02b7\u02c0\u02ca\u02cf\u02d5\u02da"+
		"\u02df\u02e4\u02e9\u02ef\u02f5\u02fb\u030d\u0312\u0315\u031f\u0322\u032f"+
		"\u0337\u033e\u0341\u0346\u034a\u0368\u036d\u0371\u0378\u037c\u0382\u0387"+
		"\u038a\u038d\u0394\u039c\u03a9\u03b5\u03c1\u03cd\u03d4\u03d8\u03dc\u03e2"+
		"\u03ea\u03f1\u03f5\u03f9\u0406\u0409\u0410\u041a\u041e\u0423\u0428\u0435"+
		"\u043f\u0445\u046b\u0470\u0473\u0479\u0496\u049d\u04a1\u04a7\u04b4\u04b6"+
		"\u04dc\u04ec\u04ee\u04f4\u04fc\u0503\u0507\u050c\u0511\u0515\u051e\u0524"+
		"\u052a\u052d\u0531\u0534\u0538\u053f\u0543\u0546\u054f\u0557\u0560\u0564"+
		"\u0569\u056e\u0576\u0578\u057e\u0580\u0585\u058c\u0592\u0599\u059f\u05a9"+
		"\u05ad\u05b2\u05ba\u05c0\u05c7\u05cb\u05cf\u05d6\u05df\u05e4\u05ea\u05f2"+
		"\u05f5\u05fb\u0601\u0607\u060b\u0612\u0617\u061d\u0626\u062b\u0630\u0637"+
		"\u063a\u063e\u0642\u064b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
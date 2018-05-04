package rcalc.parsers.terminals;

import rcalc.lexer.Token;
import rcalc.parsers.ParseNode;

public abstract class TerminalNode extends ParseNode{
    private final int lineNum;
    private final int colNum;
    private Token token;

    TerminalNode(Token token, ParseNode n1, ParseNode n2, ParseNode n3) {
        super(n1, n2, n3);
        this.token = token;
        setLexVal(token.getLexVal());
        lineNum = token.getLineNum();
        colNum = token.getColNum();
    }

    public String toInfix() {
        setInfixExpr(getLexVal());
        return getPrefixExpr();
    }

    public String toPrefix() {
        setPrefixExpr(getLexVal());
        return getPrefixExpr();
    }

    public String toPostfix() {
        setPostfixExpr(getLexVal());
        return getPrefixExpr();
    }
    public double evaluate() {
        return getVal();
    }

    public int getLineNum() {
        return lineNum;
    }

    public int getColNum() {
        return colNum;
    }

    public Token getToken() {
        return token;
    }

}

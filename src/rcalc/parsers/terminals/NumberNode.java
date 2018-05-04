package rcalc.parsers.terminals;

import rcalc.lexer.Token;

public class NumberNode extends TerminalNode {
    public NumberNode(Token token) {
        super(token,null, null, null);
        setVal(Double.parseDouble(token.getLexVal()));
    }
}

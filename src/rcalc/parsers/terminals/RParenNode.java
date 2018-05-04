package rcalc.parsers.terminals;

import rcalc.lexer.Token;

public class RParenNode extends TerminalNode {
    public RParenNode(Token token) {
        super(token, null, null, null);
    }
}

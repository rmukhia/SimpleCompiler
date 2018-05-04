package rcalc.parsers.terminals;

import rcalc.lexer.Token;

public class LParenNode extends TerminalNode {
    public LParenNode(Token token) {
        super(token, null, null, null);
    }
}

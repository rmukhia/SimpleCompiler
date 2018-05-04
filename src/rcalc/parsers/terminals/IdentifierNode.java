package rcalc.parsers.terminals;

import rcalc.lexer.Token;

public class IdentifierNode extends TerminalNode {
    public IdentifierNode(Token token) {
        super(token,null, null, null);
    }
}

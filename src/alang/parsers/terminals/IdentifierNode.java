package alang.parsers.terminals;

import alang.lexer.Token;

public class IdentifierNode extends TerminalNode {
    public IdentifierNode(Token token) {
        super(token,null, null, null);
    }
}

package alang.parsers.terminals;

import alang.lexer.Token;

public class BlockCloseNode extends TerminalNode {
    public BlockCloseNode(Token token) {
        super(token, null, null, null);
    }
}

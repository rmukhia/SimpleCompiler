package rcalc.parsers.terminals;

import rcalc.lexer.Token;

public class BlockCloseNode extends TerminalNode {
    public BlockCloseNode(Token token) {
        super(token, null, null, null);
    }
}

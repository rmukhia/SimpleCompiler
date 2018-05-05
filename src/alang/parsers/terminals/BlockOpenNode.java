package alang.parsers.terminals;

import alang.lexer.Token;

public class BlockOpenNode extends TerminalNode {
    public BlockOpenNode(Token token) {
        super(token, null, null, null);
    }
}

package rcalc.parsers.terminals;

import rcalc.lexer.Token;

public class BlockOpenNode extends TerminalNode {
    public BlockOpenNode(Token token) {
        super(token, null, null, null);
    }
}

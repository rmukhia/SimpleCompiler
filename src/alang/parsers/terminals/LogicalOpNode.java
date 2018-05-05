package alang.parsers.terminals;

import alang.lexer.Token;

public class LogicalOpNode extends TerminalNode {
    public LogicalOpNode(Token token) {
        super(token, null, null, null);
    }
}

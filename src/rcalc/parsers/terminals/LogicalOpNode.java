package rcalc.parsers.terminals;

import rcalc.lexer.Token;

public class LogicalOpNode extends TerminalNode {
    public LogicalOpNode(Token token) {
        super(token, null, null, null);
    }
}

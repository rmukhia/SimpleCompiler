package rcalc.parsers.terminals;

import rcalc.lexer.Token;

public class EndStmtNode extends TerminalNode {
    public EndStmtNode(Token token) {
        super(token, null, null, null);
    }
}

package alang.parsers.terminals;

import alang.lexer.Token;

public class EndStmtNode extends TerminalNode {
    public EndStmtNode(Token token) {
        super(token, null, null, null);
    }
}

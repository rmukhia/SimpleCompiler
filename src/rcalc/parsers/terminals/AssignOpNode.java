package rcalc.parsers.terminals;

import rcalc.lexer.Token;

public class AssignOpNode extends TerminalNode {
    public AssignOpNode(Token token) {
        super(token, null, null, null);
    }

}

package rcalc.parsers.terminals;

import rcalc.lexer.Token;
import rcalc.semantic.Types;

public class BooleanNode extends TerminalNode {
    public BooleanNode(Token token) {
        super(token,null, null, null);
        bval = Boolean.parseBoolean(token.getLexVal());
        type = Types.BOOL;
    }
}

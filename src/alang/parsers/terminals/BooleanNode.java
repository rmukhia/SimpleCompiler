package alang.parsers.terminals;

import alang.lexer.Token;
import alang.semantic.Types;

public class BooleanNode extends TerminalNode {
    public BooleanNode(Token token) {
        super(token,null, null, null);
        bval = Boolean.parseBoolean(token.getLexVal());
        type = Types.BOOL;
    }
}

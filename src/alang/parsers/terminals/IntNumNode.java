package alang.parsers.terminals;

import alang.lexer.Token;
import alang.semantic.Types;

public class IntNumNode extends TerminalNode {
    public IntNumNode(Token token) {
        super(token,null, null, null);
        ival = Integer.parseInt(token.getLexVal());
        type = Types.INT;
    }
}

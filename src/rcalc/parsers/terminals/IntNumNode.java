package rcalc.parsers.terminals;

import rcalc.lexer.Token;
import rcalc.semantic.Types;

public class IntNumNode extends TerminalNode {
    public IntNumNode(Token token) {
        super(token,null, null, null);
        ival = Integer.parseInt(token.getLexVal());
        type = Types.INT;
    }
}

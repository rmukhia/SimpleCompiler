package rcalc.parsers.terminals;

import rcalc.lexer.Token;
import rcalc.semantic.Types;

public class RealNumNode extends TerminalNode {
    public RealNumNode(Token token) {
        super(token,null, null, null);
        dval = Double.parseDouble(token.getLexVal());
        type = Types.REAL;
    }
}

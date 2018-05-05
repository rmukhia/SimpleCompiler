package alang.parsers.terminals;

import alang.lexer.Token;
import alang.semantic.Types;

public class RealNumNode extends TerminalNode {
    public RealNumNode(Token token) {
        super(token,null, null, null);
        dval = Double.parseDouble(token.getLexVal());
        type = Types.REAL;
    }
}

package rcalc.parsers.terminals;

import rcalc.lexer.Token;
import rcalc.semantic.Types;

public class CharacterNode extends TerminalNode {
    public CharacterNode(Token token) {
        super(token,null, null, null);
        ival = token.getLexVal().charAt(1);
        type = Types.CHAR;
    }
}

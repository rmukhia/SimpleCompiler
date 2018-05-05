package alang.parsers.terminals;

import alang.lexer.Token;
import alang.semantic.Types;

public class CharacterNode extends TerminalNode {
    public CharacterNode(Token token) {
        super(token,null, null, null);
        ival = token.getLexVal().charAt(1);
        type = Types.CHAR;
    }
}

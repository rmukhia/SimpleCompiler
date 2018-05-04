package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.IdentifierNode;
import rcalc.parsers.terminals.NumberNode;

public class IDNode extends ParseNode{
    public IDNode(IdentifierNode n1) {
        super(n1, null, null);
        setProductionId(1);
    }
}

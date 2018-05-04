package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.*;

public class NUMNode extends ParseNode{
    public NUMNode(NumberNode n1) {
        super(n1, null, null);
        setProductionId(1);
    }
}

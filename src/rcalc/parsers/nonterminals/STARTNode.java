package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;

public class STARTNode extends ParseNode{
    public STARTNode(STMTLISTNode n1) {
        super(n1, null,null);
        setProductionId(20);
    }
}

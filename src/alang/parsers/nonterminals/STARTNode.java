package alang.parsers.nonterminals;

import alang.parsers.ParseNode;

public class STARTNode extends ParseNode{
    public STARTNode(STMTLISTNode n1) {
        super(n1, null,null);
        setProductionId(20);
    }
}

package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;

public class STARTNode extends ParseNode{
    public STARTNode(ASTERMNode n1) {
        super(n1, null,null);
        setProductionId(20);
        /* Infix Parser production */
        /* START -> ASTERM */
    }

    public STARTNode(TERMNode n1) {
        super(n1, null, null);
        setProductionId(21);
        /* PostFix and PreFix production */
        /* START -> TERM */
    }
}

package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.MultiplyNode;

public class MDTERMNode extends ParseNode {
    public MDTERMNode(MDTERMNode n1, MultiplyNode n2, TERMNode n3) {
        super(n1, n2, n3);
        setProductionId(17);
        /* Infix Parser production */
        /* MDTERM -> MDTERM * TERM */
    }

    public MDTERMNode(MDTERMNode n1, DivideNode n2, TERMNode n3) {
        super(n1, n2, n3);
        setProductionId(18);
        /* Infix Parser production */
        /* MDTERM -> MDTERM / TERM */
    }


    public MDTERMNode(TERMNode n1) {
        super(n1, null, null);
        setProductionId(19);
        /* Infix Parser production */
        /* MDTERM -> TERM */
    }
}

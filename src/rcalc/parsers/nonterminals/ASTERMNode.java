package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.MinusNode;
import rcalc.parsers.terminals.PlusNode;

public class ASTERMNode extends ParseNode{
    public ASTERMNode(ASTERMNode n1,PlusNode n2,  MDTERMNode n3) {
        super(n1, n2, n3);
        setProductionId(14);
        /* Infix Parser production */
        /* ASTERM -> ASTERM + MDTERM */
    }

    public ASTERMNode(ASTERMNode n1,MinusNode n2,  MDTERMNode n3) {
        super(n1, n2, n3);
        setProductionId(15);
        /* Infix Parser production */
        /* ASTERM -> ASTERM - MDTERM */
    }

    public ASTERMNode(MDTERMNode n1) {
       super(n1, null,null);
       setProductionId(16);
        /* Infix Parser production */
        /* ASTERM -> MDTERM */
    }
}

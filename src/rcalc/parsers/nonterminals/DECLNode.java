package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.DeclOpNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.MultiplyNode;
import rcalc.parsers.terminals.TypeNode;

public class DECLNode extends ParseNode {
    public DECLNode(IDNode n1, DeclOpNode n2, TypeNode n3) {
        super(n1, n2, n3);
        setProductionId(17);
        /* Infix Parser production */
        /* MDTERM -> MDTERM * TERM */
    }

    public DECLNode(IDNode n1, DeclOpNode n2, TypeNode n3, NUMNode n4) {
        super(n1, n2, n3);
        this.getChildren().add(n4);
        setProductionId(18);
        /* Infix Parser production */
        /* MDTERM -> MDTERM / TERM */
    }
}

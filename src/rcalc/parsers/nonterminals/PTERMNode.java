package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.LParenNode;
import rcalc.parsers.terminals.RParenNode;
import rcalc.semantic.Types;

public class PTERMNode extends ParseNode {
    public PTERMNode(LParenNode n1, ASTERMNode n2, RParenNode n3) {
        super(n1, n2, n3);
        /* Infix Parser production */
        /* PTERM -> ( ASTERM ) */
        setProductionId(2);
    }

    @Override
    public void processNode() throws Exception{
        super.processNode();
        ASTERMNode astermNode = (ASTERMNode) getChildren().get(1);
        if (astermNode.getType() == Types.INT)
            ival = astermNode.ival;
        else
            dval = astermNode.dval;
        type = astermNode.getType();
    }
}

package alang.parsers.nonterminals;

import alang.parsers.ParseNode;
import alang.parsers.terminals.LParenNode;
import alang.parsers.terminals.RParenNode;
import alang.semantic.Types;

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

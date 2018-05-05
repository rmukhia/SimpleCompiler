package alang.parsers.nonterminals;

import alang.parsers.ParseNode;
import alang.parsers.terminals.*;
import alang.semantic.Types;

public class TERMNode extends ParseNode {

    public TERMNode(TERMNode n1, ExponentNode n2, FACTORNode n3) {
        super(n1, n2, n3);
        setProductionId(1);
        /* Infix Parser production */
        /* TERM -> TERM EXP FACTOR */
    }

    public TERMNode(FACTORNode n1) {
        super(n1, null, null);
        setProductionId(2);
        /* Infix Parser production */
        /* Postfix Parser production */
        /* Prefix Parser production */
        /* TERM -> FACTOR */
    }

    @Override
    public void processNode() throws Exception{
        super.processNode();
        switch (getProductionId()) {
            case 1:
            {
                TERMNode termNode = (TERMNode)getChildren().get(0);
                FACTORNode factorNode = (FACTORNode)getChildren().get(2);
                if (termNode.getType() == Types.REAL && factorNode.getType() == Types.REAL) {
                    type = Types.REAL;
                    dval = termNode.dval * Math.pow(10.0, factorNode.dval);
                } else if (termNode.getType() == Types.REAL && factorNode.getType() == Types.INT) {
                    type = Types.REAL;
                    dval = termNode.dval * Math.pow(10.0, factorNode.ival);
                } else if (termNode.getType() == Types.INT && factorNode.getType() == Types.REAL) {
                    type = Types.REAL;
                    dval = termNode.ival * Math.pow(10.0, factorNode.dval);
                }
                else {
                    type = Types.INT;
                    ival = termNode.ival * (int)Math.pow(10.0, factorNode.ival);
                }
            }
            break;
            case 2:
            {
                FACTORNode factorNode = (FACTORNode)getChildren().get(0);
                if(factorNode.getType() == Types.INT)
                    ival = factorNode.ival;
                else
                    dval = factorNode.dval;
                type = factorNode.getType();
                break;
            }

        }
    }
}

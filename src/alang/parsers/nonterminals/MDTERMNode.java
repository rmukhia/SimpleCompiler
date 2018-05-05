package alang.parsers.nonterminals;

import alang.parsers.ParseNode;
import alang.parsers.terminals.DivideNode;
import alang.parsers.terminals.MultiplyNode;
import alang.semantic.Types;

public class MDTERMNode extends ParseNode {
    public MDTERMNode(MDTERMNode n1, MultiplyNode n2, TERMNode n3) {
        super(n1, n2, n3);
        setProductionId(1);
        /* Infix Parser production */
        /* MDTERM -> MDTERM * TERM */
    }

    public MDTERMNode(MDTERMNode n1, DivideNode n2, TERMNode n3) {
        super(n1, n2, n3);
        setProductionId(2);
        /* Infix Parser production */
        /* MDTERM -> MDTERM / TERM */
    }


    public MDTERMNode(TERMNode n1) {
        super(n1, null, null);
        setProductionId(3);
        /* Infix Parser production */
        /* MDTERM -> TERM */
    }


    @Override
    public void processNode() throws Exception {
        super.processNode();
        switch (getProductionId()) {
            case 1: {
                MDTERMNode mdtermNode = (MDTERMNode) getChildren().get(0);
                TERMNode termNode = (TERMNode) getChildren().get(2);
                if (mdtermNode.getType() == Types.INT && termNode.getType() == Types.INT) {
                    type = Types.INT;
                    ival = mdtermNode.ival * termNode.ival;
                } else {
                    if (mdtermNode.getType() == Types.INT)
                        dval = mdtermNode.ival;
                    else
                        dval = mdtermNode.dval;

                    if (termNode.getType() == Types.INT)
                        dval *= termNode.ival;
                    else
                        dval *= termNode.dval;

                    type = Types.REAL;
                }
            }
            break;
            case 2: {
                MDTERMNode mdtermNode = (MDTERMNode) getChildren().get(0);
                TERMNode termNode = (TERMNode) getChildren().get(2);
                if (mdtermNode.getType() == Types.INT && termNode.getType() == Types.INT) {
                    type = Types.INT;
                    ival = mdtermNode.ival / termNode.ival;
                } else {
                    if (mdtermNode.getType() == Types.INT)
                        dval = mdtermNode.ival;
                    else
                        dval = mdtermNode.dval;

                    if (termNode.getType() == Types.INT)
                        dval /= termNode.ival;
                    else
                        dval /= termNode.dval;

                    type = Types.REAL;
                }
            }
            break;
            case 3: {
                TERMNode termNode = (TERMNode) getChildren().get(0);
                if (termNode.getType() == Types.INT)
                    ival = termNode.ival;
                else
                    dval = termNode.dval;

                type = termNode.getType();
            }
            break;
        }
    }
}

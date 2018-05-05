package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.MinusNode;
import rcalc.parsers.terminals.PlusNode;
import rcalc.semantic.Types;

public class ASTERMNode extends ParseNode{
    public ASTERMNode(ASTERMNode n1,PlusNode n2,  MDTERMNode n3) {
        super(n1, n2, n3);
        setProductionId(1);
        /* Infix Parser production */
        /* ASTERM -> ASTERM + MDTERM */
    }

    public ASTERMNode(ASTERMNode n1,MinusNode n2,  MDTERMNode n3) {
        super(n1, n2, n3);
        setProductionId(2);
        /* Infix Parser production */
        /* ASTERM -> ASTERM - MDTERM */
    }

    public ASTERMNode(MDTERMNode n1) {
       super(n1, null,null);
       setProductionId(3);
        /* Infix Parser production */
        /* ASTERM -> MDTERM */
    }

    @Override
    public void processNode() throws Exception{
        super.processNode();
        switch (getProductionId()) {
            case 1: {
                ASTERMNode mdtermNode = (ASTERMNode) getChildren().get(0);
                MDTERMNode termNode = (MDTERMNode) getChildren().get(2);
                if (mdtermNode.getType() == Types.INT && termNode.getType() == Types.INT) {
                    type = Types.INT;
                    ival = mdtermNode.ival + termNode.ival;
                } else {
                    if (mdtermNode.getType() == Types.INT)
                        dval = mdtermNode.ival;
                    else
                        dval = mdtermNode.dval;

                    if (termNode.getType() == Types.INT)
                        dval += termNode.ival;
                    else
                        dval += termNode.dval;

                    type = Types.REAL;
                }
            }
            break;
            case 2: {
                ASTERMNode mdtermNode = (ASTERMNode) getChildren().get(0);
                MDTERMNode termNode = (MDTERMNode) getChildren().get(2);
                if (mdtermNode.getType() == Types.INT && termNode.getType() == Types.INT) {
                    type = Types.INT;
                    ival = mdtermNode.ival - termNode.ival;
                } else {
                    if (mdtermNode.getType() == Types.INT)
                        dval = mdtermNode.ival;
                    else
                        dval = mdtermNode.dval;

                    if (termNode.getType() == Types.INT)
                        dval -= termNode.ival;
                    else
                        dval -= termNode.dval;

                    type = Types.REAL;
                }
            }
            break;
            case 3: {
                MDTERMNode termNode = (MDTERMNode) getChildren().get(0);
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

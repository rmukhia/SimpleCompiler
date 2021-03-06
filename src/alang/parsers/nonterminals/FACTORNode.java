package alang.parsers.nonterminals;

import alang.parsers.ParseNode;
import alang.parsers.terminals.MinusNode;
import alang.semantic.Types;

public class FACTORNode extends ParseNode{
    public FACTORNode(MinusNode n1, FACTORNode n2) {
        super(n1, n2, null);
        setProductionId(1);
        /* Infix Parser production */
        /* FACTOR -> - FACTOR */
    }

    public FACTORNode(PTERMNode n1) {
        super(n1, null, null);
        setProductionId(2);
        /* Infix Parser production */
        /* FACTOR -> PTERM */
    }

    public FACTORNode(NUMNode n1) {
        super(n1, null, null);
        setProductionId(2);
        /* Infix Parser production */
        /* Postfix Parser production */
        /* Prefix Parser production */
        /* FACTOR -> NUM */
    }

    public FACTORNode(IDNode n1) {
        super(n1, null, null);
        setProductionId(2);
    }

    @Override
    public void processNode() throws Exception{
        super.processNode();
        switch (getProductionId()) {
            case 1:
                if (getChildren().get(1).type == Types.INT) {
                    ival = 0 - getChildren().get(1).ival;
                } else if (getChildren().get(1).type == Types.REAL){
                    dval = 0.0 - getChildren().get(1).dval;
                } else {
                    throw new Exception("Only int and real can be negated.");
                }
                type = getChildren().get(1).getType();
                break;
            case 2:
                if (getChildren().get(0).type == Types.INT) {
                    ival = getChildren().get(0).ival;
                } else if (getChildren().get(0).type == Types.CHAR) {
                    cval = getChildren().get(0).cval;
                } else if (getChildren().get(0).type == Types.BOOL) {
                    bval = getChildren().get(0).bval;
                } else {
                    dval = getChildren().get(0).dval;
                }
                type = getChildren().get(0).getType();
                break;
        }

    }




}

package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.MinusNode;
import rcalc.semantic.EvaluateExpr;

public class FACTORNode extends ParseNode{
    public FACTORNode(MinusNode n1, FACTORNode n2) {
        super(n1, n2, null);
        setProductionId(3);
        /* Infix Parser production */
        /* FACTOR -> - FACTOR */
    }

    public FACTORNode(PTERMNode n1) {
        super(n1, null, null);
        setProductionId(4);
        /* Infix Parser production */
        /* FACTOR -> PTERM */
    }

    public FACTORNode(NUMNode n1) {
        super(n1, null, null);
        setProductionId(5);
        /* Infix Parser production */
        /* Postfix Parser production */
        /* Prefix Parser production */
        /* FACTOR -> NUM */
    }

    public FACTORNode(IDNode n1) {
        super(n1, null, null);
        setProductionId(50);
    }

    @Override
    public void processNode() throws Exception{
        super.processNode();
        setVal(EvaluateExpr.evaluate(this, getProductionId()));
    }




}

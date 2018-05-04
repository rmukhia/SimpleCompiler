package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.*;
import rcalc.semantic.EvaluateExpr;

public class NUMNode extends ParseNode{
    public NUMNode(NumberNode n1) {
        super(n1, null, null);
        setProductionId(1);
    }

    @Override
    public void processNode() throws Exception{
        super.processNode();
        setVal(EvaluateExpr.evaluate(this, getProductionId()));
    }
}

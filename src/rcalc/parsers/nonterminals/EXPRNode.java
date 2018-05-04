package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.LogicalOpNode;
import rcalc.parsers.terminals.MultiplyNode;
import rcalc.semantic.EvaluateExpr;

public class EXPRNode extends ParseNode {
    public EXPRNode(EXPRNode n1, LogicalOpNode n2, ASTERMNode n3) {
        super(n1, n2, n3);
        setProductionId(51);
    }

    public EXPRNode(ASTERMNode n1) {
        super(n1, null, null);
        setProductionId(52);
    }

    @Override
    public void processNode() throws Exception{
        super.processNode();
        setVal(EvaluateExpr.evaluate(this, getProductionId()));
    }

}

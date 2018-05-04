package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.LogicalOpNode;
import rcalc.parsers.terminals.MultiplyNode;

public class EXPRNode extends ParseNode {
    public EXPRNode(EXPRNode n1, LogicalOpNode n2, ASTERMNode n3) {
        super(n1, n2, n3);
        setProductionId(17);
    }

    public EXPRNode(ASTERMNode n1) {
        super(n1, null, null);
        setProductionId(17);
    }
}

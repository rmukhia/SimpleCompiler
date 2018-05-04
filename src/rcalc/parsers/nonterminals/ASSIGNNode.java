package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.AssignOpNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.LogicalOpNode;
import rcalc.parsers.terminals.MultiplyNode;

public class ASSIGNNode extends ParseNode {
    public ASSIGNNode(EXPRNode n1, AssignOpNode n2, IDNode n3) {
        super(n1, n2, n3);
        setProductionId(17);
    }
}

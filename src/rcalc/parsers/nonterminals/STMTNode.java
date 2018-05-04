package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.EndStmtNode;
import rcalc.parsers.terminals.MultiplyNode;

public class STMTNode extends ParseNode {
    public STMTNode(DECLNode n1, EndStmtNode n2) {
        super(n1, n2, null);
        setProductionId(17);
    }

    public STMTNode(ASSIGNNode n1, EndStmtNode n2) {
        super(n1, n2, null);
        setProductionId(18);
    }

    public STMTNode(WHILENode n1, EndStmtNode n2) {
        super(n1, n2, null);
        setProductionId(19);
    }

    public STMTNode(IFNode n1, EndStmtNode n2) {
        super(n1, n2, null);
        setProductionId(19);
    }

    public STMTNode(IFELSENode n1, EndStmtNode n2) {
        super(n1, n2, null);
        setProductionId(19);
    }
}

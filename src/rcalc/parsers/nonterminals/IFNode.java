package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.IfOpNode;
import rcalc.parsers.terminals.MultiplyNode;

public class IFNode extends ParseNode {
    public IFNode(EXPRNode n1, IfOpNode n2, STMTBLOCKNode n3) {
        super(n1, n2, n3);
        setProductionId(17);
    }

}

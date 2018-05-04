package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.MultiplyNode;
import rcalc.parsers.terminals.WhileOpNode;

public class WHILENode extends ParseNode {
    public WHILENode(EXPRNode n1, WhileOpNode n2, STMTBLOCKNode n3) {
        super(n1, n2, n3);
        setProductionId(57);
    }
}

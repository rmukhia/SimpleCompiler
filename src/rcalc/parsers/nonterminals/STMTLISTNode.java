package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.MultiplyNode;

public class STMTLISTNode extends ParseNode {
    public STMTLISTNode(STMTLISTNode n1, STMTNode n2) {
        super(n1, n2, null);
    }

    public STMTLISTNode(STMTNode n1) {
        super(n1, null, null);
    }
}

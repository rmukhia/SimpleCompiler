package alang.parsers.nonterminals;

import alang.parsers.ParseNode;
import alang.parsers.terminals.DivideNode;
import alang.parsers.terminals.MultiplyNode;

public class STMTLISTNode extends ParseNode {
    public STMTLISTNode(STMTLISTNode n1, STMTNode n2) {
        super(n1, n2, null);
    }

    public STMTLISTNode(STMTNode n1) {
        super(n1, null, null);
    }
}

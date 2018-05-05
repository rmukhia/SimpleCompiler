package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;

public class PARAMLISTNode extends ParseNode {
    public PARAMLISTNode(PARAMLISTNode n1, PARAMNode n2) {
        super(n1, n2, null);
    }

    public PARAMLISTNode(PARAMNode n1) {
        super(n1, null, null);
    }
}

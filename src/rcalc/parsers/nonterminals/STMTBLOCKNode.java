package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.BlockCloseNode;
import rcalc.parsers.terminals.BlockOpenNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.MultiplyNode;

public class STMTBLOCKNode extends ParseNode {
    public STMTBLOCKNode(BlockOpenNode n1, STMTLISTNode n2, BlockCloseNode n3) {
        super(n1, n2, n3);
        setProductionId(65);
    }
}

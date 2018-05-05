package alang.parsers.nonterminals;

import alang.parsers.ParseNode;
import alang.parsers.terminals.BlockCloseNode;
import alang.parsers.terminals.BlockOpenNode;
import alang.parsers.terminals.DivideNode;
import alang.parsers.terminals.MultiplyNode;

public class STMTBLOCKNode extends ParseNode {
    public STMTBLOCKNode(BlockOpenNode n1, STMTLISTNode n2, BlockCloseNode n3) {
        super(n1, n2, n3);
    }
}

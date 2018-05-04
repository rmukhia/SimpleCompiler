package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.IfOpNode;
import rcalc.parsers.terminals.MultiplyNode;

public class IFELSENode extends ParseNode {
    public IFELSENode(IFNode n1, IfOpNode n2, IfOpNode n3, STMTBLOCKNode n4) {
        super(n1, n2, n3);
        this.getChildren().add(n4);
        setProductionId(17);
    }
}

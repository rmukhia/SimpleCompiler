package alang.parsers.nonterminals;

import alang.parsers.ParseNode;
import alang.parsers.terminals.DivideNode;
import alang.parsers.terminals.IfOpNode;
import alang.parsers.terminals.MultiplyNode;

public class IFELSENode extends ParseNode {
    public IFELSENode(IFNode n1, IfOpNode n2, IfOpNode n3, STMTBLOCKNode n4) {
        super(n1, n2, n3);
        this.getChildren().add(n4);
    }

    @Override
    public void compute() throws Exception {
        IFNode ifnode = (IFNode)getChildren().get(0);

        ifnode.compute();

        if(!ifnode.ran) {
            getChildren().get(3).compute();
        }
    }
}

package alang.parsers.nonterminals;

import alang.parsers.ParseNode;
import alang.parsers.terminals.DivideNode;
import alang.parsers.terminals.IfOpNode;
import alang.parsers.terminals.MultiplyNode;

public class IFNode extends ParseNode {
    public boolean ran = false;
    public IFNode(EXPRNode n1, IfOpNode n2, STMTBLOCKNode n3) {
        super(n1, n2, n3);
    }

    @Override
    public void compute() throws Exception {
        EXPRNode exprNode = (EXPRNode) getChildren().get(0);
        exprNode.compute();
        boolean run = false;

        switch (exprNode.getType()) {
            case REAL:
                run = exprNode.dval != 0.0;
                break;
            case BOOL:
                run = exprNode.bval;
                break;
            case INT:
                run = exprNode.ival != 0;
                break;
            case CHAR:
                run = true;
                break;
        }

        if (run) {
            ran = true;
            getChildren().get(2).compute();
        }
    }
}

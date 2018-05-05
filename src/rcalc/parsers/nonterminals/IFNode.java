package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.IfOpNode;
import rcalc.parsers.terminals.MultiplyNode;

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

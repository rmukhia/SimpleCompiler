package alang.parsers.nonterminals;

import alang.parsers.ParseNode;
import alang.parsers.terminals.DivideNode;
import alang.parsers.terminals.MultiplyNode;
import alang.parsers.terminals.WhileOpNode;

public class WHILENode extends ParseNode {
    public WHILENode(EXPRNode n1, WhileOpNode n2, STMTBLOCKNode n3) {
        super(n1, n2, n3);
    }

    private boolean shouldRun(EXPRNode exprNode) {
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

        return run;
    }
    @Override
    public void compute() throws Exception {
        EXPRNode exprNode = (EXPRNode) getChildren().get(0);
        exprNode.compute();

        while(shouldRun(exprNode)) {
            getChildren().get(2).compute();
            exprNode.compute();
        }
    }
}

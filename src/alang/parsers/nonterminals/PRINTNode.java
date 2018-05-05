package alang.parsers.nonterminals;

import alang.SimpleCompiler;
import alang.parsers.ParseNode;
import alang.parsers.terminals.IdentifierNode;
import alang.semantic.SymbolTableRow;

public class PRINTNode extends ParseNode{
    public PRINTNode(EXPRNode n1) {
        super(n1, null, null);
        setProductionId(75);
    }

    @Override
    public void processNode() throws Exception {
        super.processNode();
        EXPRNode exprNode = (EXPRNode)getChildren().get(0);

        switch (exprNode.getType()) {
            case CHAR:
                System.out.println(exprNode.cval);
                break;
            case INT:
                System.out.println(exprNode.ival);
                break;
            case BOOL:
                System.out.println(exprNode.bval);
                break;
            case REAL:
                System.out.println(exprNode.dval);
                break;
        }
    }
}

package alang.parsers.nonterminals;

import alang.parsers.ParseNode;
import alang.parsers.terminals.*;
import alang.semantic.Types;

public class EXPRNode extends ParseNode {
    public EXPRNode(EXPRNode n1, LogicalOpNode n2, ASTERMNode n3) {
        super(n1, n2, n3);
        setProductionId(1);
    }

    public EXPRNode(ASTERMNode n1) {
        super(n1, null, null);
        setProductionId(2);
    }

    public EXPRNode(BooleanNode n1) {
        super(n1, null, null);
        setProductionId(3);
        type = Types.BOOL;
    }

    public EXPRNode(CharacterNode n1) {
        super(n1, null, null);
        setProductionId(4);
        type = Types.CHAR;
    }

    private boolean logicalEval(String op, double a, double b) {
        switch (op) {
            case "==":
                return a == b;
            case ">":
                return a > b;
            case "<":
                return a < b;
            case ">=":
                return a >= b;
            case "<=":
                return a <= b;
            case "!=":
                return a != b;
        }
        return false;

    }

    @Override
    public void processNode() throws Exception{
        super.processNode();
        switch (getProductionId()) {
            case 1: {
                LogicalOpNode logicalOpNode = (LogicalOpNode)getChildren().get(1);
                String op = logicalOpNode.getLexVal();
                EXPRNode exprNode = (EXPRNode)getChildren().get(0);
                ASTERMNode astermNode = (ASTERMNode)getChildren().get(2);
                double a = 0;
                double b = 0;

                switch (exprNode.getType()) {
                    case REAL:
                        a = exprNode.dval;
                        break;
                    case INT:
                        a = exprNode.ival;
                        break;
                    case BOOL:
                        if (exprNode.bval) a = 1.0;
                        else a = 0.0;
                        break;
                    case CHAR:
                        a = exprNode.cval;
                        break;
                }

                switch (astermNode.getType()) {
                    case REAL:
                        b = astermNode.dval;
                        break;
                    case INT:
                        b = astermNode.ival;
                        break;
                    case BOOL:
                        if (astermNode.bval) b = 1.0;
                        else b = 0.0;
                        break;
                    case CHAR:
                        b = astermNode.cval;
                        break;
                }

                bval = logicalEval(op, a, b);
                type = Types.BOOL;
            }
            break;
            case 2:
            {
                ASTERMNode astermNode = (ASTERMNode)getChildren().get(0);
                if (astermNode.getType() == Types.INT)
                    ival = astermNode.ival;
                else
                    dval = astermNode.dval;
                type = astermNode.getType();
            }
            break;
            case 3:
            {
                bval = getChildren().get(0).bval;
                type = Types.BOOL;

            }
            break;
            case 4:
            {
                cval = getChildren().get(0).cval;
                type = Types.CHAR;
            }
            break;
        }
    }

}

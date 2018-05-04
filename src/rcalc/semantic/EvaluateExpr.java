package rcalc.semantic;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.LogicalOpNode;

public class EvaluateExpr {
    public static double eval(ParseNode node, int productionId) throws Exception {
        double result = 0;
        switch (productionId) {
            case 1:
                /* NUM -> NUMBER */
            case 4:
                /* FACTOR -> PTERM */
            case 5:
                /* FACTOR -> NUM */
            case 7:
                /* TERM -> FACTOR */
            case 16:
                /* ASTERM -> MDTERM */
            case 19:
                /* MDTERM -> TERM */
            case 20:
                /* START -> ASTERM */
            case 21:
                /* START -> TERM */
                result = node.getChildren().get(0).evaluate();
                break;
            case 2:
                /* PTERM -> ( ASTERM ) */
                result = node.getChildren().get(1).evaluate();
                break;
            case 3:
                /* FACTOR -> - FACTOR */
                result =  0 - node.getChildren().get(1).evaluate();
                break;
            case 6:
                /* TERM -> TERM EXP FACTOR */
            case 12:
                /* TERM -> FACTOR FACTOR EXP */
                /* TERM -> EXP FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
                result = node.getChildren().get(0).evaluate() * Math.pow(10.0, node.getChildren().get(2).evaluate());
                break;
            case 8:
                /* TERM -> FACTOR FACTOR + */
                /* TERM -> + FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 14:
                /* ASTERM -> ASTERM + MDTERM */
                result = node.getChildren().get(0).evaluate() + node.getChildren().get(2).evaluate();
                break;
            case 9:
                /* TERM -> FACTOR FACTOR - */
                /* TERM -> - FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 15:
                /* ASTERM -> ASTERM - MDTERM */
                result = node.getChildren().get(0).evaluate() - node.getChildren().get(2).evaluate();
                break;
            case 10:
                /* TERM -> FACTOR FACTOR * */
                /* TERM -> * FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 17:
                /* MDTERM -> MDTERM * TERM */
                result = node.getChildren().get(0).evaluate() * node.getChildren().get(2).evaluate();
                break;
            case 11:
                /* TERM -> FACTOR FACTOR / */
                /* TERM -> / FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 18:
                /* MDTERM -> MDTERM / TERM */
                result = node.getChildren().get(0).evaluate() / node.getChildren().get(2).evaluate();
                break;
            case 13:
                /* TERM -> ( TERM - ) */
                /* TERM -> ( - TERM ) */
                /* In prase tree the set up is ( operator operand ) */
                result =  0 - node.getChildren().get(2).evaluate();
                break;
            default:
                throw new Exception(node.getClass() + ":evaluate : Undefined Production " + productionId);

        }
        return result;
    }
    public static double evaluate(ParseNode node, int productionId) throws Exception {
        double result = 0;
        switch (productionId) {
            case 1:
                /* NUM -> NUMBER */
            case 4:
                /* FACTOR -> PTERM */
            case 5:
                /* FACTOR -> NUM */
            case 7:
                /* TERM -> FACTOR */
            case 16:
                /* ASTERM -> MDTERM */
            case 19:
                /* MDTERM -> TERM */
            case 20:
                /* START -> ASTERM */
            case 21:
            case 50:
            case 52:
                /* EXPR -> ASTERM */
                result = node.getChildren().get(0).getVal();
                break;
            case 2:
                /* PTERM -> ( ASTERM ) */
                result = node.getChildren().get(1).getVal();
                break;
            case 3:
                /* FACTOR -> - FACTOR */
                result =  0 - node.getChildren().get(1).getVal();
                break;
            case 6:
                /* TERM -> TERM EXP FACTOR */
            case 12:
                /* TERM -> FACTOR FACTOR EXP */
                /* TERM -> EXP FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
                result = node.getChildren().get(0).getVal() * Math.pow(10.0, node.getChildren().get(2).getVal());
                break;
            case 8:
                /* TERM -> FACTOR FACTOR + */
                /* TERM -> + FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 14:
                /* ASTERM -> ASTERM + MDTERM */
                result = node.getChildren().get(0).getVal() + node.getChildren().get(2).getVal();
                break;
            case 9:
                /* TERM -> FACTOR FACTOR - */
                /* TERM -> - FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 15:
                /* ASTERM -> ASTERM - MDTERM */
                result = node.getChildren().get(0).getVal() - node.getChildren().get(2).getVal();
                break;
            case 10:
                /* TERM -> FACTOR FACTOR * */
                /* TERM -> * FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 17:
                /* MDTERM -> MDTERM * TERM */
                result = node.getChildren().get(0).getVal() * node.getChildren().get(2).getVal();
                break;
            case 11:
                /* TERM -> FACTOR FACTOR / */
                /* TERM -> / FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 18:
                /* MDTERM -> MDTERM / TERM */
                result = node.getChildren().get(0).getVal() / node.getChildren().get(2).getVal();
                break;
            case 13:
                /* TERM -> ( TERM - ) */
                /* TERM -> ( - TERM ) */
                /* In prase tree the set up is ( operator operand ) */
                result =  0 - node.getChildren().get(2).getVal();
                break;
            case 51:
                /* EXPR -> EXPR LOGICALOP ASTERM */
                LogicalOpNode logicalOpNode = (LogicalOpNode)node.getChildren().get(1);
                String op = logicalOpNode.getLexVal();
                boolean r = true;
                switch (op) {
                    case "==":
                        r = (node.getChildren().get(0).getVal() == node.getChildren().get(2).getVal());
                        break;
                    case ">":
                        r = (node.getChildren().get(0).getVal() > node.getChildren().get(2).getVal());
                        break;
                    case "<":
                        r = (node.getChildren().get(0).getVal() < node.getChildren().get(2).getVal());
                        break;
                    case ">=":
                        r = (node.getChildren().get(0).getVal() >= node.getChildren().get(2).getVal());
                        break;
                    case "<=":
                        r = (node.getChildren().get(0).getVal() <= node.getChildren().get(2).getVal());
                        break;
                    case "!=":
                        r = (node.getChildren().get(0).getVal() != node.getChildren().get(2).getVal());
                        break;
                }
                if (r)
                    result = 1;
                else
                    result = 0;
                break;
            default:
                throw new Exception(node.getClass() + ":evaluate : Undefined Production " + productionId);

        }
        return result;
    }
}

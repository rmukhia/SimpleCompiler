package rcalc.semantic;

import rcalc.parsers.ParseNode;

public class Translation {
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

    public static String toInfix(ParseNode node, int productionId) throws Exception {
        String result;

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
                result = node.getChildren().get(0).toInfix();
                break;
            case 2:
                /* PTERM -> ( ASTERM ) */
                /*
                result = node.getChildren().get(0).toInfix() + " "
                        + node.getChildren().get(1).toInfix() + " "
                        + node.getChildren().get(2).toInfix();
                        */
                result = node.getChildren().get(1).toInfix();
                break;
            case 3:
                /* FACTOR -> - FACTOR */
                result =  node.getChildren().get(0).toInfix() + " "
                        + node.getChildren().get(1).toInfix();
                break;
            case 6:
                /* TERM -> TERM EXP FACTOR */
            case 12:
                /* TERM -> FACTOR FACTOR EXP */
                /* TERM -> EXP FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 8:
                /* TERM -> FACTOR FACTOR + */
                /* TERM -> + FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 14:
                /* ASTERM -> ASTERM + MDTERM */
            case 9:
                /* TERM -> FACTOR FACTOR - */
                /* TERM -> - FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 15:
                /* ASTERM -> ASTERM - MDTERM */
            case 10:
                /* TERM -> FACTOR FACTOR * */
                /* TERM -> * FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 17:
                /* MDTERM -> MDTERM * TERM */
            case 11:
                /* TERM -> FACTOR FACTOR / */
                /* TERM -> / FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 18:
                /* MDTERM -> MDTERM / TERM */
                result = "( "
                        + node.getChildren().get(0).toInfix() + " "
                        + node.getChildren().get(1).toInfix() + " "
                        + node.getChildren().get(2).toInfix() + " )";
                break;
            case 13:
                /* TERM -> ( TERM - ) */
                /* TERM -> ( - TERM ) */
                /* In prase tree the set up is ( operator operand ) */
                result =  node.getChildren().get(1).toInfix() + " "
                        + node.getChildren().get(2).toInfix();
                break;
            default:
                throw new Exception(node.getClass() + ":toInfix : Undefined Production" + productionId);
        }
        return  result;
    }

    public static String toPrefix(ParseNode node, int productionId) throws Exception {
        String result;

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
                result = node.getChildren().get(0).toPrefix();
                break;
            case 2:
                /* PTERM -> ( ASTERM ) */
                result = node.getChildren().get(1).toPrefix();
                break;
            case 3:
                /* FACTOR -> - FACTOR */
                result =  "(" + node.getChildren().get(0).toPrefix() + " "
                        + node.getChildren().get(1).toPrefix() + ")";
                break;
            case 6:
                /* TERM -> TERM EXP FACTOR */
            case 12:
                /* TERM -> FACTOR FACTOR EXP */
                /* TERM -> EXP FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 8:
                /* TERM -> FACTOR FACTOR + */
                /* TERM -> + FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 14:
                /* ASTERM -> ASTERM + MDTERM */
            case 9:
                /* TERM -> FACTOR FACTOR - */
                /* TERM -> - FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 15:
                /* ASTERM -> ASTERM - MDTERM */
            case 10:
                /* TERM -> FACTOR FACTOR * */
                /* TERM -> * FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 17:
                /* MDTERM -> MDTERM * TERM */
            case 11:
                /* TERM -> FACTOR FACTOR / */
                /* TERM -> / FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 18:
                /* MDTERM -> MDTERM / TERM */
                result = node.getChildren().get(1).toPrefix() + " "
                        + node.getChildren().get(0).toPrefix() + " "
                        + node.getChildren().get(2).toPrefix();
                break;
            case 13:
                /* TERM -> ( TERM - ) */
                /* TERM -> ( - TERM ) */
                /* In prase tree the set up is ( operator operand ) */
                result =  "(" + node.getChildren().get(1).toPrefix() + " "
                        + node.getChildren().get(2).toPrefix() + ")";
                break;
            default:
                throw new Exception(node.getClass() + ":toPrefix : Undefined Production" + productionId);
        }
        return  result;
    }

    public static String toPostfix(ParseNode node, int productionId) throws Exception {
        String result;

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
                result = node.getChildren().get(0).toPostfix();
                break;
            case 2:
                /* PTERM -> ( ASTERM ) */
                result = node.getChildren().get(1).toPostfix();
                break;
            case 3:
                /* FACTOR -> - FACTOR */
                result =  "(" + node.getChildren().get(1).toPostfix() + " "
                        + node.getChildren().get(0).toPostfix() + ")";
                break;
            case 6:
                /* TERM -> TERM EXP FACTOR */
            case 12:
                /* TERM -> FACTOR FACTOR EXP */
                /* TERM -> EXP FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 8:
                /* TERM -> FACTOR FACTOR + */
                /* TERM -> + FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 14:
                /* ASTERM -> ASTERM + MDTERM */
            case 9:
                /* TERM -> FACTOR FACTOR - */
                /* TERM -> - FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 15:
                /* ASTERM -> ASTERM - MDTERM */
            case 10:
                /* TERM -> FACTOR FACTOR * */
                /* TERM -> * FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 17:
                /* MDTERM -> MDTERM * TERM */
            case 11:
                /* TERM -> FACTOR FACTOR / */
                /* TERM -> / FACTOR FACTOR */
                /* In prase tree the set up is operand operator operand */
            case 18:
                /* MDTERM -> MDTERM / TERM */
                result = node.getChildren().get(0).toPostfix() + " "
                        + node.getChildren().get(2).toPostfix() + " "
                        + node.getChildren().get(1).toPostfix();
                break;
            case 13:
                /* TERM -> ( TERM - ) */
                /* TERM -> ( - TERM ) */
                /* In prase tree the set up is ( operator operand ) */
                result =  "(" + node.getChildren().get(2).toPostfix() + " "
                        + node.getChildren().get(1).toPostfix() + ")";
                break;
            default:
                throw new Exception(node.getClass() + ":toPostfix : Undefined Production" + productionId);
        }
        return  result;
    }
}

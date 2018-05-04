package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.*;

public class TERMNode extends ParseNode {

    public TERMNode(TERMNode n1, ExponentNode n2, FACTORNode n3) {
        super(n1, n2, n3);
        setProductionId(6);
        /* Infix Parser production */
        /* TERM -> TERM EXP FACTOR */
    }

    public TERMNode(FACTORNode n1) {
        super(n1, null, null);
        setProductionId(7);
        /* Infix Parser production */
        /* Postfix Parser production */
        /* Prefix Parser production */
        /* TERM -> FACTOR */
    }

    public TERMNode(TERMNode n1, PlusNode n2, TERMNode n3) {
        super(n1, n2, n3);
        setProductionId(8);
        /* Postfix Parser production */
        /* Prefix Parser production */
        /* TERM -> FACTOR FACTOR +  */
        /* TERM -> + FACTOR FACTOR  */
    }

    public TERMNode(TERMNode n1, MinusNode n2, TERMNode n3) {
        super(n1, n2, n3);
        setProductionId(9);
        /* Postfix Parser production */
        /* Prefix Parser production */
        /* TERM -> FACTOR FACTOR - */
        /* TERM -> - FACTOR FACTOR */
    }

    public TERMNode(TERMNode n1, MultiplyNode n2, TERMNode n3) {
        super(n1, n2, n3);
        setProductionId(10);
        /* Postfix Parser production */
        /* Prefix Parser production */
        /* TERM -> FACTOR FACTOR * */
        /* TERM -> * FACTOR FACTOR */
    }

    public TERMNode(TERMNode n1, DivideNode n2, TERMNode n3) {
        super(n1, n2, n3);
        setProductionId(11);
        /* Postfix Parser production */
        /* Prefix Parser production */
        /* TERM -> FACTOR FACTOR / */
        /* TERM -> / FACTOR FACTOR */
    }

    public TERMNode(TERMNode n1,  ExponentNode n2, TERMNode n3) {
        super(n1, n2, n3);
        setProductionId(12);
        /* Postfix Parser production */
        /* Prefix Parser production */
        /* TERM -> FACTOR FACTOR EXP */
        /* TERM -> EXP FACTOR FACTOR */
    }

    public TERMNode(LParenNode n1, MinusNode n2, TERMNode n3, RParenNode n4) {
        super(n1, n2, n3);
        this.getChildren().add(n4);
        setProductionId(13);
        /* Postfix Parser production */
        /* Prefix Parser production */
        /* TERM -> ( TERM - ) */
        /* TERM -> ( - TERM ) */
    }
}

package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.*;
import rcalc.semantic.Types;

public class NUMNode extends ParseNode{
    public NUMNode(RealNumNode n1) {
        super(n1, null, null);
        setProductionId(1);
        type = Types.REAL;
    }

    public NUMNode(IntNumNode n1) {
        super(n1, null, null);
        setProductionId(2);
        type = Types.INT;
    }

    @Override
    public void processNode() throws Exception{
        super.processNode();
        switch (getProductionId()) {
            case 1:
                dval = getChildren().get(0).dval;
                type = Types.REAL;
                break;
            case 2:
                ival = getChildren().get(0).ival;
                type = Types.INT;
                break;
        }
    }
}

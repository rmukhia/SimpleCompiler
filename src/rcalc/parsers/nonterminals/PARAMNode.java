package rcalc.parsers.nonterminals;

import rcalc.SimpleCompiler;
import rcalc.parsers.ParseNode;
import rcalc.semantic.SymbolTableRow;
import rcalc.semantic.Types;

public class PARAMNode extends ParseNode {
    public PARAMNode(EXPRNode n1) {
        super(n1, null, null);
        setProductionId(120);
    }

    @Override
    public void processNode() throws Exception{
        super.processNode();
        EXPRNode exprNode = (EXPRNode)getChildren().get(0);
        type = exprNode.getType();
        switch (type) {
            case REAL:
                dval = exprNode.dval;
                break;
            case BOOL:
                bval = exprNode.bval;
                break;
            case INT:
                ival = exprNode.ival;
                break;
            case CHAR:
                cval = exprNode.cval;
                break;
        }
        SymbolTableRow func = SimpleCompiler.currFunc;
        String id = func.funcParams.get(SimpleCompiler.currFuncParamIndex);

        SymbolTableRow row = SimpleCompiler.globalSymbolTable.lookup(id);

        if (!(row.getType() == getType() || (row.getType() == Types.REAL && getType() == Types.INT))) throw new Exception("Parameter <"+ id +"> type mismatch!");
        switch (row.getType()) {
            case REAL:
                row.dval = dval;
                if (getType() == Types.INT) row.dval = ival;
                else row.dval = dval;
                break;
            case CHAR:
                row.cval = cval;
                break;
            case BOOL:
                row.bval = bval;
                break;
            case INT:
                row.ival = ival;
                break;
        }
        SimpleCompiler.currFuncParamIndex++;
    }

}

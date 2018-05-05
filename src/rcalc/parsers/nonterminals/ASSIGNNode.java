package rcalc.parsers.nonterminals;

import rcalc.SimpleCompiler;
import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.AssignOpNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.LogicalOpNode;
import rcalc.parsers.terminals.MultiplyNode;
import rcalc.semantic.SymbolTableRow;
import rcalc.semantic.Types;

public class ASSIGNNode extends ParseNode {
    public ASSIGNNode(EXPRNode n1, AssignOpNode n2, IDNode n3) {
        super(n1, n2, n3);
        setProductionId(55);
    }

    @Override
    public void processNode() throws Exception {
        super.processNode();
        EXPRNode exprNode = (EXPRNode)getChildren().get(0);
        String id = getChildren().get(2).getLexVal();
        SymbolTableRow row = SimpleCompiler.globalSymbolTable.lookup(id);
        if (row == null) throw new Exception("Symbol not declared: " + id);

        if (row.getType() == exprNode.getType() ||
                (row.getType() == Types.REAL && exprNode.getType() == Types.INT)) {

        } else {
            throw new Exception("id <" + id +"> type mismatch in assignment!");
        }

        switch (row.getType()) {
            case INT:
                row.ival = exprNode.ival;
                break;
            case BOOL:
                row.bval = exprNode.bval;
                break;
            case CHAR:
                row.cval = exprNode.cval;
                break;
            case REAL:
                if (exprNode.getType() == Types.INT) row.dval = exprNode.ival;
                else row.dval = exprNode.dval;
                break;
        }
    }
}

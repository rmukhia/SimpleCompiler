package alang.parsers.nonterminals;

import alang.SimpleCompiler;
import alang.parsers.ParseNode;
import alang.parsers.terminals.AssignOpNode;
import alang.parsers.terminals.DivideNode;
import alang.parsers.terminals.LogicalOpNode;
import alang.parsers.terminals.MultiplyNode;
import alang.semantic.SymbolTableRow;
import alang.semantic.Types;

public class ASSIGNNode extends ParseNode {
    public ASSIGNNode(EXPRNode n1, AssignOpNode n2, IDNode n3) {
        super(n1, n2, n3);
        setProductionId(55);
    }

    @Override
    public void processNode() throws Exception {
        super.processNode();
        EXPRNode exprNode = (EXPRNode)getChildren().get(0);
        IDNode idNode = (IDNode)getChildren().get(2);
        String id = idNode.getLexVal();
        SymbolTableRow row = SimpleCompiler.globalSymbolTable.lookup(id);
        if (row == null) throw new Exception("Symbol not declared: " + id);

        if (row.getType() == exprNode.getType() ||
                (row.getType() == Types.REAL && exprNode.getType() == Types.INT)) {

        } else {
            throw new Exception("id <" + id +"> type mismatch in assignment!");
        }


        switch (row.getType()) {
            case INT:
                if (row.isArray())
                    row.arrayival[idNode.arrayIndex] = exprNode.ival;
                else
                    row.ival = exprNode.ival;
                break;
            case BOOL:
                if (row.isArray())
                    row.arraybval[idNode.arrayIndex] = exprNode.bval;
                else
                    row.bval = exprNode.bval;
                break;
            case CHAR:
                if (row.isArray())
                    row.arraycval[idNode.arrayIndex] = exprNode.cval;
                else
                    row.cval = exprNode.cval;
                break;
            case REAL:
                if(row.isArray()) {
                    if (exprNode.getType() == Types.INT) row.arraydval[idNode.arrayIndex] = exprNode.ival;
                    else row.arraydval[idNode.arrayIndex] = exprNode.dval;

                }
                else {
                    if (exprNode.getType() == Types.INT) row.dval = exprNode.ival;
                    else row.dval = exprNode.dval;
                }
                break;
        }
    }
}

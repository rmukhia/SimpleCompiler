package alang.parsers.nonterminals;

import alang.SimpleCompiler;
import alang.parsers.ParseNode;
import alang.parsers.terminals.IdentifierNode;
import alang.semantic.SymbolTableRow;
import alang.semantic.Types;

public class IDNode extends ParseNode{
    public int arrayIndex;
    public IDNode(IdentifierNode n1) {
        super(n1, null, null);
        setLexVal(n1.getLexVal());
        setProductionId(1);
    }

    public IDNode(IdentifierNode n1, NUMNode n2) {
        super(n1, n2, null);
        setLexVal(n1.getLexVal());
        setProductionId(2);
    }

    @Override
    public void processNode() throws Exception {
        super.processNode();
        setLexVal(getChildren().get(0).getLexVal());
        SymbolTableRow row = SimpleCompiler.globalSymbolTable.lookup(getLexVal());
        if (row == null)
            throw new Exception("Unknown identifier <" + getLexVal() + "> encountered!");
        switch (getProductionId()) {
            case 1: {
                switch(row.getType()) {
                    case INT:
                        ival = row.ival;
                        break;
                    case BOOL:
                        bval = row.bval;
                        break;
                    case CHAR:
                        cval = row.cval;
                        break;
                    case REAL:
                        dval = row.dval;
                        break;
                }
            }
            break;
            case 2: {
                NUMNode numNode = (NUMNode)getChildren().get(1);
                if (numNode.getType() != Types.INT)
                    throw new Exception("Array index for <" + getLexVal() + ">should be integer!");
                int index = numNode.ival;
                arrayIndex = index;
                switch(row.getType()) {
                    case INT:
                        ival = row.arrayival[index];
                        break;
                    case BOOL:
                        bval = row.arraybval[index];
                        break;
                    case CHAR:
                        cval = row.arraycval[index];
                        break;
                    case REAL:
                        dval = row.arraydval[index];
                        break;
                }

            }
            break;
        }
        type = row.getType();
    }
}

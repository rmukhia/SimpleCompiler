package alang.parsers.nonterminals;

import alang.SimpleCompiler;
import alang.parsers.ParseNode;
import alang.parsers.terminals.IdentifierNode;
import alang.semantic.SymbolTableRow;

public class IDNode extends ParseNode{
    public IDNode(IdentifierNode n1) {
        super(n1, null, null);
        setLexVal(n1.getLexVal());
    }

    @Override
    public void processNode() throws Exception {
        super.processNode();
        setLexVal(getChildren().get(0).getLexVal());
        SymbolTableRow row = SimpleCompiler.globalSymbolTable.lookup(getLexVal());
        if (row == null) return;
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
        type = row.getType();
    }
}

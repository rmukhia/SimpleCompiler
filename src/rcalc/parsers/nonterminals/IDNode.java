package rcalc.parsers.nonterminals;

import rcalc.SimpleCompiler;
import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.IdentifierNode;
import rcalc.parsers.terminals.NumberNode;
import rcalc.semantic.SymbolTableRow;

public class IDNode extends ParseNode{
    public IDNode(IdentifierNode n1) {
        super(n1, null, null);
        setProductionId(50);
    }

    @Override
    public void processNode() throws Exception {
        super.processNode();
        double r;
        setLexVal(getChildren().get(0).getLexVal());
        SymbolTableRow row = SimpleCompiler.globalSymbolTable.lookup(getLexVal());
        if (row == null) return;
        switch(row.getType()) {
            case INT:
                setVal(row.ival);
                break;
            case BOOL:
                if(row.bval) r = 1.0;
                else r = 0.0;
                setVal(r);
                break;
            case CHAR:
                setVal(row.cval);
                break;
            case REAL:
                setVal(row.dval);
                break;
        }
    }
}

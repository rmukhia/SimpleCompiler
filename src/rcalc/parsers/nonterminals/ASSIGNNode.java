package rcalc.parsers.nonterminals;

import rcalc.SimpleCompiler;
import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.AssignOpNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.LogicalOpNode;
import rcalc.parsers.terminals.MultiplyNode;
import rcalc.semantic.SymbolTableRow;

public class ASSIGNNode extends ParseNode {
    public ASSIGNNode(EXPRNode n1, AssignOpNode n2, IDNode n3) {
        super(n1, n2, n3);
        setProductionId(55);
    }

    @Override
    public void processNode() throws Exception {
        super.processNode();
        double val = getChildren().get(0).getVal();
        String id = getChildren().get(2).getLexVal();
        SymbolTableRow row = SimpleCompiler.globalSymbolTable.lookup(id);
        if (row == null) throw new Exception("Symbol not declared" + id);

        switch (row.getType()) {
            case INT:
                row.ival = (int) val;
                break;
            case BOOL:
                if (val == 0.0) row.bval = false;
                else row.bval = true;
                break;
            case CHAR:
                row.cval = (char)val;
                break;
            case REAL:
                row.dval = val;
                break;
        }
    }
}

package rcalc.parsers.nonterminals;

import rcalc.SimpleCompiler;
import rcalc.parsers.ParseNode;
import rcalc.semantic.SymbolTableRow;

public class FUNCCALLNode extends ParseNode {
    public FUNCCALLNode(IDNode n1, PARAMLISTNode n2) {
        super(n1, n2, null);
    }

    public FUNCCALLNode(IDNode n1) {
        super(n1, null, null);
    }

    @Override
    public void compute() throws Exception {
        String id = getChildren().get(0).getLexVal();
        SymbolTableRow row = SimpleCompiler.globalSymbolTable.lookup(id);
        SimpleCompiler.currFunc = row;
        SimpleCompiler.currFuncParamIndex = 0;
        super.compute();
    }

    @Override
    public void processNode() throws Exception {
        String id = getChildren().get(0).getLexVal();
        SymbolTableRow row = SimpleCompiler.globalSymbolTable.lookup(id);

        if (row == null) throw new Exception("Function " + id +"() not declared.");

        row.functionNode.call();
        SimpleCompiler.currFunc = null;
    }
}

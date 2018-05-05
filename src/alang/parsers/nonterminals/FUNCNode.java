package alang.parsers.nonterminals;

import alang.SimpleCompiler;
import alang.parsers.ParseNode;
import alang.parsers.terminals.IdentifierNode;
import alang.semantic.SymbolTableRow;

public class FUNCNode extends ParseNode {
    public FUNCNode(STMTBLOCKNode n1, IdentifierNode n2, DECLLISTNode n3) {
        super(n1, n2, n3);
        setProductionId(1);
    }

    public FUNCNode(STMTBLOCKNode n1, IDNode n2) {
        super(n1, n2, null);
        setProductionId(2);
    }

    @Override
    public void compute() throws Exception {
        getChildren().get(1).compute();
        String id = getChildren().get(1).getLexVal();
        SimpleCompiler.globalSymbolTable.add(id, new SymbolTableRow(this));
        if (getProductionId() == 1) {
            DECLLISTNode decllistNode = (DECLLISTNode) getChildren().get(2);
            decllistNode.func = id;
            decllistNode.compute();
        }
    }

    public void call() throws Exception {
        getChildren().get(0).compute();
    }
}

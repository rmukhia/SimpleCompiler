package rcalc.parsers.nonterminals;

import rcalc.parsers.ParseNode;

public class DECLLISTNode extends ParseNode {
    public String func = "";
    public DECLLISTNode(DECLLISTNode n1, DECLNode n2) {
        super(n1, n2, null);
        setProductionId(63);
    }

    public DECLLISTNode(DECLNode n1) {
        super(n1, null, null);
        setProductionId(64);
    }

    @Override
    public void compute() throws Exception {
        if (func.compareTo("") != 0) {
            if (getProductionId() == 63) {
                DECLLISTNode decllistNode = (DECLLISTNode) getChildren().get(0);
                decllistNode.func = this.func;

                DECLNode declNode = (DECLNode) getChildren().get(1);
                declNode.func = this.func;
            } else {
                DECLNode declNode = (DECLNode) getChildren().get(0);
                declNode.func = this.func;
            }
        }
        super.compute();
    }
}

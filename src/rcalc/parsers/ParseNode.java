package rcalc.parsers;

import rcalc.semantic.EvaluateExpr;

import java.util.LinkedList;

// The base class of all nodes
public abstract class ParseNode {
    private double val;
    private String lexVal;
    private LinkedList<ParseNode> children;
    private int productionId;

    protected ParseNode(ParseNode n1, ParseNode n2, ParseNode n3) {
        children = new LinkedList<ParseNode>();
        if (n1 != null) children.add(n1);
        if (n2 != null) children.add(n2);
        if (n3 != null) children.add(n3);
        this.lexVal = null;
    }

    public double evaluate() throws Exception {
        double result = EvaluateExpr.evaluate(this, getProductionId());
        setVal(result);
        return result;
    }

    public void processNode() throws Exception {};

    public void compute() throws Exception {
        for (ParseNode node :
                this.children) {
            node.compute();
        }
        processNode();
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public String getLexVal() {
        return lexVal;
    }

    public String getLexValOveride() {
        return  getLexVal();
    }

    public void setLexVal(String lexVal) {
        this.lexVal = lexVal;
    }

    public LinkedList<ParseNode> getChildren() {
        return children;
    }

    public void setChildren(LinkedList<ParseNode> children) {
        this.children = children;
    }

    public int getProductionId() {
        return productionId;
    }

    public void setProductionId(int productionId) {
        this.productionId = productionId;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }


}

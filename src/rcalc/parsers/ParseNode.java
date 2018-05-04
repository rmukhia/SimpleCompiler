package rcalc.parsers;

import rcalc.semantic.Translation;

import java.util.LinkedList;

// The base class of all nodes
public abstract class ParseNode {
    private double val;
    private String lexVal;
    private LinkedList<ParseNode> children;
    private int productionId;
    private String infixExpr;
    private String prefixExpr;
    private String postfixExpr;

    protected ParseNode(ParseNode n1, ParseNode n2, ParseNode n3) {
        children = new LinkedList<ParseNode>();
        if (n1 != null) children.add(n1);
        if (n2 != null) children.add(n2);
        if (n3 != null) children.add(n3);
        this.lexVal = null;
    }

    public double evaluate() throws Exception {
        double result = Translation.evaluate(this, getProductionId());
        setVal(result);
        return result;
    }

    public String toInfix() throws Exception {
        String expr = Translation.toInfix(this, getProductionId());
        setInfixExpr(expr);
        return expr;
    }

    public String toPrefix() throws Exception {
        String expr = Translation.toPrefix(this, getProductionId());
        setPrefixExpr(expr);
        return expr;
    }

    public String toPostfix() throws Exception {
        String expr = Translation.toPostfix(this, getProductionId());
        setPostfixExpr(expr);
        return expr;
    }

    protected double getVal() {
        return val;
    }

    protected void setVal(double val) {
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

    public String getInfixExpr() {
        return infixExpr;
    }

    public void setInfixExpr(String infixExpr) {
        this.infixExpr = infixExpr;
    }

    public String getPrefixExpr() {
        return prefixExpr;
    }

    public void setPrefixExpr(String prefixExpr) {
        this.prefixExpr = prefixExpr;
    }

    public String getPostfixExpr() {
        return postfixExpr;
    }

    public void setPostfixExpr(String postfixExpr) {
        this.postfixExpr = postfixExpr;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }
}

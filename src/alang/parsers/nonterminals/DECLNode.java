package alang.parsers.nonterminals;

import alang.SimpleCompiler;
import alang.parsers.ParseNode;
import alang.parsers.terminals.*;
import alang.semantic.SymbolTableRow;
import alang.semantic.Types;

public class DECLNode extends ParseNode {
    public String func = "";
    public DECLNode(IdentifierNode n1, DeclOpNode n2, TypeNode n3) {
        super(n1, n2, n3);
        setProductionId(1);
    }

    public DECLNode(IdentifierNode n1, DeclOpNode n2, TypeNode n3, NUMNode n4) {
        super(n1, n2, n3);
        this.getChildren().add(n4);
        setProductionId(2);
    }

    public DECLNode(IdentifierNode n1, DECLLISTNode n2) {
        super(n1, n2, null);
        setProductionId(3);
    }

    void updateFuncRow(String id, Types type) {
        if (this.func.compareTo("") != 0) {
            SymbolTableRow row = SimpleCompiler.globalSymbolTable.lookup(this.func);
            row.funcParams.add(id);
            row.funcTypes.add(type);
        }
    }

    @Override
    public void processNode() throws Exception {
        super.processNode();
        String id = getChildren().get(0).getLexVal();
        setLexVal(id);
        Types type;
        switch (getProductionId()) {
            case 1: {
                type = Types.INT;
                switch (getChildren().get(2).getLexVal()) {
                    case "int":
                        type = Types.INT;
                        break;
                    case "char":
                        type = Types.CHAR;
                        break;
                    case "real":
                        type = Types.REAL;
                        break;
                    case "bool":
                        type = Types.BOOL;
                        break;
                }
                if (SimpleCompiler.globalSymbolTable.lookup(id) != null)
                    throw new Exception("Identifier <" + id + "> is used more than once!");
                SimpleCompiler.globalSymbolTable.add(id, new SymbolTableRow(type));
                updateFuncRow(id, type);
            }
            break;
            case 2: {
                id = getChildren().get(0).getLexVal();
                type = Types.INT;

                NUMNode numNode = (NUMNode) getChildren().get(3);

                if (numNode.getType() != Types.INT)
                    throw new Exception ("Array declaration for <"+ id +"> should have integer size.");

                int size = numNode.ival;

                switch (getChildren().get(2).getLexVal()) {
                    case "int":
                        type = Types.INT;
                        break;
                    case "char":
                        type = Types.CHAR;
                        break;
                    case "real":
                        type = Types.REAL;
                        break;
                    case "bool":
                        type = Types.BOOL;
                        break;
                }
                if (SimpleCompiler.globalSymbolTable.lookup(id) != null)
                    throw new Exception("Identifier <" + id + "> is used more than once!");
                SimpleCompiler.globalSymbolTable.add(id, new SymbolTableRow(type, size));
                updateFuncRow(id, type);
            }
            break;
        }
    }
}

package rcalc.parsers.nonterminals;

import rcalc.SimpleCompiler;
import rcalc.parsers.ParseNode;
import rcalc.parsers.terminals.DeclOpNode;
import rcalc.parsers.terminals.DivideNode;
import rcalc.parsers.terminals.MultiplyNode;
import rcalc.parsers.terminals.TypeNode;
import rcalc.semantic.SymbolTableRow;
import rcalc.semantic.Types;

public class DECLNode extends ParseNode {
    public DECLNode(IDNode n1, DeclOpNode n2, TypeNode n3) {
        super(n1, n2, n3);
        setProductionId(53);
    }

    public DECLNode(IDNode n1, DeclOpNode n2, TypeNode n3, NUMNode n4) {
        super(n1, n2, n3);
        this.getChildren().add(n4);
        setProductionId(54);
    }

    @Override
    public void processNode() throws Exception {
        super.processNode();
        String id;
        Types type;
        switch (getProductionId()) {
            case 53:
                id = getChildren().get(0).getLexVal();
                type = Types.INT;
                switch(getChildren().get(2).getLexVal()) {
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
                SimpleCompiler.globalSymbolTable.add(id, new SymbolTableRow(type));
                break;
            case 54:
                id = getChildren().get(0).getLexVal();
                type = Types.INT;

                int size = (int)getChildren().get(3).getVal();

                switch(getChildren().get(2).getLexVal()) {
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
                SimpleCompiler.globalSymbolTable.add(id, new SymbolTableRow(type, size));
                break;
        }
    }
}

package rcalc.semantic;

import rcalc.parsers.ParseNode;
import rcalc.parsers.nonterminals.FUNCNode;

import java.util.ArrayList;
import java.util.HashMap;

public class SymbolTableRow {
    public int ival;
    public double dval;
    public char cval;
    public boolean bval;
    public int arrayival[];
    public double arraydval[];
    public char arraycval[];
    public boolean arraybval[];

    public FUNCNode functionNode;
    public ArrayList<String> funcParams = new ArrayList<>();
    public ArrayList<Types> funcTypes = new ArrayList<>();


    private Types type;
    private boolean isArray;
    private int arraySize;

    SymbolTable symbolTable;

    public SymbolTableRow(Types type, int arraySize) {
        this.type = type;
        this.isArray = true;
        this.arraySize = arraySize;
        switch (type) {
            case INT:
                arrayival = new int[arraySize];
                break;
            case CHAR:
                arraycval = new char[arraySize];
                break;
            case REAL:
                arraydval = new double[arraySize];
                break;
            case BOOL:
                arraybval = new boolean[arraySize];
                break;
        }
    }

    public SymbolTableRow(Types type) {
        this.type = type;
    }

    public SymbolTableRow(FUNCNode funcNode) {
        this.type = Types.FUNC;
        this.symbolTable = symbolTable;
        functionNode = funcNode;
        isArray = false;

    }

    public Types getType() {
        return type;
    }

    public boolean isArray() {
        return isArray;
    }

    public int getArraySize() {
        return arraySize;
    }
}

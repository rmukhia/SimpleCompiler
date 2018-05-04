package rcalc.lexer;

public class Token {
    private String lexVal;
    private int lineNum;
    private int colNum;

    public Token(String lexVal, int lineNum, int colNum) {
        this.lexVal = lexVal;
        this.lineNum = lineNum;
        this.colNum = colNum;
    }

    public String getLexVal() {
        return lexVal;
    }

    public int getLineNum() {
        return lineNum;
    }

    public int getColNum() {
        return colNum;
    }

}

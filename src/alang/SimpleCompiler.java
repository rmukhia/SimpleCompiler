package alang;

import alang.lexer.Lexer;
import alang.parsers.Parser;
import alang.parsers.ParseNode;
import java_cup.runtime.lr_parser;
import alang.semantic.SymbolTable;
import alang.semantic.SymbolTableRow;

import java.io.File;
import java.io.FileReader;
import java.io.StringReader;

public class SimpleCompiler {
    FileReader reader;
    public static SymbolTable globalSymbolTable;
    public static SymbolTableRow currFunc = null;
    public static int currFuncParamIndex = 0;

    public SimpleCompiler(FileReader reader) {
        this.reader = reader;
        if (globalSymbolTable == null)
            globalSymbolTable = new SymbolTable(null);
    }

    /* Returns an Parse tree */
    public ParseNode parse() throws Exception {
        Lexer lexer = new Lexer(reader);
        lr_parser parser = new Parser(lexer);
        try {
            return (ParseNode) parser.parse().value;
        } catch (Error e) {
            throw new Exception(e.getMessage());
        }
    }

    public void computer() throws Exception {

    }
}

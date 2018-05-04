package rcalc;

import rcalc.lexer.Lexer;
import rcalc.parsers.Parser;
import rcalc.parsers.ParseNode;
import java_cup.runtime.lr_parser;

import java.io.File;
import java.io.FileReader;
import java.io.StringReader;

public class SimpleCompiler {
    FileReader reader;

    public SimpleCompiler(FileReader reader) {
        this.reader = reader;
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
}

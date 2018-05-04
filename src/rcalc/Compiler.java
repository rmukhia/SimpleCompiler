package rcalc;

import rcalc.lexer.Lexer;
import rcalc.parsers.Parser;
import rcalc.parsers.ParseNode;
import java_cup.runtime.lr_parser;

import java.io.StringReader;

public class Compiler {
    /* Returns an Parse tree */
    public ParseNode parse(String s) throws Exception {
        StringReader reader = new StringReader(s);
        Lexer lexer = new Lexer(reader);
        lr_parser parser = new Parser(lexer);
        try {
            return (ParseNode) parser.parse().value;
        } catch (Error e) {
            throw new Exception(e.getMessage());
        }
    }
}

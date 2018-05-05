package ui;

import alang.SimpleCompiler;
import alang.parsers.ParseNode;
import alang.parsers.nonterminals.STARTNode;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader(args[0]);
            SimpleCompiler compiler = new SimpleCompiler(reader);
            ParseNode start = compiler.parse();
            start.compute();
            System.out.println("Executed");
            // Computed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

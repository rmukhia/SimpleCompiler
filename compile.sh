#!/usr/bin/env bash
# Generate Infix Parser
pushd src/alang/parsers/
java -jar ../../../vendor/jflex-1.6.1/lib/java-cup-11a.jar -parser Parser Parser.cup
popd


# Generate Lexer
vendor/jflex-1.6.1/bin/jflex src/alang/lexer/Lexer.jflex
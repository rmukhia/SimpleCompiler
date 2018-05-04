#!/usr/bin/env bash
# Generate Infix Parser
pushd src/rcalc/parsers/
java -jar ../../../vendor/jflex-1.6.1/lib/java-cup-11a.jar -parser Parser Parser.cup
popd


# Generate Lexer
vendor/jflex-1.6.1/bin/jflex src/rcalc/lexer/Lexer.jflex
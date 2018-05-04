/* --------------------------Usercode Section------------------------ */
package rcalc.lexer;
import java_cup.runtime.*;
import rcalc.parsers.sym;
import rcalc.lexer.Token;

%%

/* -----------------Options and Declarations Section----------------- */

%class Lexer
%public

%line
%column

%cup

/* Return tokens as symbols, for CUP parser */
%{
  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}


/* Macros */
LineTerminator  = \r|\n|\r\n
WhiteSpace      = {LineTerminator} | [ \t\f]
int             = [0-9]+
number          = {int}("."{int})?
identifier      = [A-Za-z][A-Za-z0-9]*
logicalop       = "<" | ">" | "==" | ">=" | "<=" | "!="
types           = "int" | "real" | "bool" | "char"

%%
/* ------------------------Lexical Rules Section---------------------- */

// Expressions
"+"                 { return symbol(sym.PLUS, new Token(yytext(), yyline + 1, yycolumn)); }
"-"                 { return symbol(sym.MINUS, new Token(yytext(), yyline + 1, yycolumn)); }
"*"                 { return symbol(sym.MULTIPLY, new Token(yytext(), yyline + 1, yycolumn)); }
"/"                 { return symbol(sym.DIVIDE, new Token(yytext(), yyline + 1, yycolumn)); }
"e" | "E"           { return symbol(sym.EXP, new Token(yytext(), yyline + 1, yycolumn)); }
"("                 { return symbol(sym.LPAREN, new Token(yytext(), yyline + 1, yycolumn)); }
")"                 { return symbol(sym.RPAREN, new Token(yytext(), yyline + 1, yycolumn)); }

"{"                 { return symbol(sym.BLOCKOPEN, new Token(yytext(), yyline +1, yycolumn)); }
"}"                 { return symbol(sym.BLOCKCLOSE, new Token(yytext(), yyline +1, yycolumn)); }

":"                 { return symbol(sym.DECLOP, new Token(yytext(), yyline + 1, yycolumn)); }
";"                 { return symbol(sym.ENDSTMT, new Token(yytext(), yyline + 1, yycolumn)); }
"=>"                { return symbol(sym.ASSIGNOP, new Token(yytext(), yyline + 1, yycolumn)); }
"?"                { return symbol(sym.IFOP, new Token(yytext(), yyline + 1, yycolumn)); }
"@"                { return symbol(sym.WHILEOP, new Token(yytext(), yyline + 1, yycolumn)); }


{logicalop}         { return symbol(sym.LOGICALOP, new Token(yytext(), yyline +1, yycolumn)); }
// Keywords
{types}             { return symbol(sym.TYPE, new Token(yytext(), yyline + 1, yycolumn)); }

{number}            { return symbol(sym.NUMBER, new Token(yytext(), yyline + 1, yycolumn)); }
{identifier}        { return symbol(sym.IDENTIFIER, new Token(yytext(), yyline + 1, yycolumn)); }

/* Don't do anything if whitespace is found */

{WhiteSpace}        { /* just skip what was found, do nothing */ }


/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */

[^]                 { throw new Error("Illegal character <"+yytext()+">"); }


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

%%
/* ------------------------Lexical Rules Section---------------------- */

"+"                 { return symbol(sym.PLUS, new Token(yytext(), yyline + 1, yycolumn)); }
"-"                 { return symbol(sym.MINUS, new Token(yytext(), yyline + 1, yycolumn)); }
"*"                 { return symbol(sym.MULTIPLY, new Token(yytext(), yyline + 1, yycolumn)); }
"/"                 { return symbol(sym.DIVIDE, new Token(yytext(), yyline + 1, yycolumn)); }
"e" | "E"           { return symbol(sym.EXP, new Token(yytext(), yyline + 1, yycolumn)); }
"("                 { return symbol(sym.LPAREN, new Token(yytext(), yyline + 1, yycolumn)); }
")"                 { return symbol(sym.RPAREN, new Token(yytext(), yyline + 1, yycolumn)); }

{number}            { return symbol(sym.NUMBER, new Token(yytext(), yyline + 1, yycolumn)); }

/* Don't do anything if whitespace is found */

{WhiteSpace}        { /* just skip what was found, do nothing */ }


/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */

[^]                 { throw new Error("Illegal character <"+yytext()+">"); }


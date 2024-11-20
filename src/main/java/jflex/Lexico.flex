package jflex;
import java_cup.runtime.*;
import equipo6.*;

%%

%cup
%public
%class Lexico
%line
%column
%char
//%type Symbol
%throws ErrorEnt
%throws ErrorReal


LETRA= [a-zA-Z]
DIGITOS= [0-9]
ID =  {LETRA}({LETRA}|{DIGITOS})*
COMENTARIO = ("//*" ~  "*//") | ("//*" ~ "//*" ~  "*//" ~ "*//")
CTE_ENT= {DIGITOS}+
CTE_REA= (({DIGITOS}+ "." {DIGITOS}*) | ( {DIGITOS}* "." {DIGITOS}+))
CTE_BIN= "0b" (0 | 1)+
ESPACIO=[ \t\f\n\r\n]+
CTE_STR = \" (({LETRA} | {DIGITOS}|[^\"]))*\"


 %eofval{
   return new Symbol(TokenConstants.EOF, null);
%eofval}

%%
<YYINITIAL>{
    "(" {return new Symbol(TokenConstants.PAR_ABR, yytext());}
    ")" {return new Symbol(TokenConstants.PAR_CIE, yytext());}
    "[" {return new Symbol(TokenConstants.COR_ABR, yytext());}
    "]" {return new Symbol(TokenConstants.COR_CIE, yytext());}
    "+" {return new Symbol(TokenConstants.OP_SUM, yytext());}
    "-" {return new Symbol(TokenConstants.OP_RES, yytext());}
    "/" {return new Symbol(TokenConstants.OP_DIV, yytext());}
    "*" {return new Symbol(TokenConstants.OP_MUL, yytext());}
    "<" {return new Symbol(TokenConstants.OP_MEN, yytext());}
    ">" {return new Symbol(TokenConstants.OP_MAY, yytext());}
    "!=" {return new Symbol(TokenConstants.OP_DIST, yytext());}
    "==" {return new Symbol(TokenConstants.OP_IGU, yytext());}
    ">=" {return new Symbol(TokenConstants.OP_MAYIG, yytext());}
    "<=" {return new Symbol(TokenConstants.OP_MENIG, yytext());}
    "::=" {return new Symbol(TokenConstants.ASIG_TIPO, yytext());}
    ":=" {return new Symbol(TokenConstants.ASIG_VAR, yytext());}
    "BEGIN" {return new Symbol(TokenConstants.BEGIN, yytext());}
    "END" {return new Symbol(TokenConstants.END, yytext());}
    "WHILE" {return new Symbol(TokenConstants.WHILE, yytext());}
    "DO" {return new Symbol(TokenConstants.DO, yytext());}
    "IF" {return new Symbol(TokenConstants.IF, yytext());}
    "THEN" {return new Symbol(TokenConstants.THEN, yytext());}
    "ELSE" {return new Symbol(TokenConstants.ELSE, yytext());}
    "WRITE" {return new Symbol(TokenConstants.WRITE, yytext());}
    "PERCENT" {return new Symbol(TokenConstants.PERCENT, yytext());}
    "AND" {return new Symbol(TokenConstants.AND, yytext());}
    "OR" {return new Symbol(TokenConstants.OR, yytext());}
    "DECLARE.SECTION" {return new Symbol(TokenConstants.SEC_DEC, yytext());}
    "ENDDECLARE.SECTION" {return new Symbol(TokenConstants.SEC_END, yytext());}
    "PROGRAM.SECTION" {return new Symbol(TokenConstants.SEC_PROG, yytext());}
    "ENDPROGRAM.SECTION" {return new Symbol(TokenConstants.SEC_ENDPROG, yytext());}
    "FLOAT" {return new Symbol(TokenConstants.ASIG_FL, yytext());}
    "INT" {return new Symbol(TokenConstants.ASIG_INT, yytext());}
    "STRING" {return new Symbol(TokenConstants.ASIG_STR, yytext());}
    "," {return new Symbol(TokenConstants.COMA, yytext());}
    {ID} {return new Symbol(TokenConstants.ID, yytext());}
    {CTE_ENT} {Symbol Symbol =  new Symbol(TokenConstants.CTE_ENT, yytext());
        try {
                    short valorShort = Short.parseShort(yytext());
                    return Symbol;
                } catch (NumberFormatException e) {
                    throw new ErrorEnt("Rango entero no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                }

    }
    {COMENTARIO} {/* NADA NADA NADA*/}
    {ESPACIO} {/* NADA NADA NADA*/}
    {CTE_REA} {Symbol Symbol = new Symbol(TokenConstants.CTE_REA, yytext());
        try {
                    float valorFloat = Float.parseFloat(yytext());
                    // Validar si está dentro del rango de float
                    if (valorFloat >= -Float.MAX_VALUE && valorFloat <= Float.MAX_VALUE && !Float.isNaN(valorFloat) && !Float.isInfinite(valorFloat)) {
                        return Symbol;
                    } else {
                        throw new ErrorReal("Rango real no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                    }
                } catch (NumberFormatException e) {
                    throw new ErrorReal("Rango real no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                }
    }
    {CTE_BIN} {return new Symbol(TokenConstants.CTE_BIN, yytext());}
    {CTE_STR} {Symbol Symbol = new Symbol(TokenConstants.CTE_STR, yytext());
                    //String str = Symbol.getLexeme();
                    if(str.length() <= 32){//queda 32 porque se cuentan ambas comillas y el limite de string queda en 30
                        return Symbol;
                    }else{
                        throw new ErrorString("Rango String no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                    }
               }
  }
  [^] {throw new Error("Caracter no permitido: <" + yytext() + "> en la linea " + (yyline+1));}


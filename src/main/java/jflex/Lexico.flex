package jflex;
import java_cup.runtime.*;
import equipo6.*;
import jcup.*;

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
   return new Symbol(sym.EOF, null);
%eofval}

%%
<YYINITIAL>{
    "(" {return new Symbol(sym.PAR_ABR, yytext());}
    ")" {return new Symbol(sym.PAR_CIE, yytext());}
    "[" {return new Symbol(sym.COR_ABR, yytext());}
    "]" {return new Symbol(sym.COR_CIE, yytext());}
    "+" {return new Symbol(sym.OP_SUM, yytext());}
    "-" {return new Symbol(sym.OP_RES, yytext());}
    "/" {return new Symbol(sym.OP_DIV, yytext());}
    "*" {return new Symbol(sym.OP_MUL, yytext());}
    "<" {return new Symbol(sym.OP_MEN, yytext());}
    ">" {return new Symbol(sym.OP_MAY, yytext());}
    "!=" {return new Symbol(sym.OP_DIST, yytext());}
    "==" {return new Symbol(sym.OP_IGU, yytext());}
    ">=" {return new Symbol(sym.OP_MAYIG, yytext());}
    "<=" {return new Symbol(sym.OP_MENIG, yytext());}
    "::=" {return new Symbol(sym.ASIG_TIPO, yytext());}
    ":=" {return new Symbol(sym.ASIG_VAR, yytext());}
    "BEGIN" {return new Symbol(sym.BEGIN, yytext());}
    "END" {return new Symbol(sym.END, yytext());}
    "WHILE" {return new Symbol(sym.WHILE, yytext());}
    "DO" {return new Symbol(sym.DO, yytext());}
    "IF" {return new Symbol(sym.IF, yytext());}
    "ENDIF" {return new Symbol(sym.ENDIF, yytext());}
    "THEN" {return new Symbol(sym.THEN, yytext());}
    "ELSE" {return new Symbol(sym.ELSE, yytext());}
    "WRITE" {return new Symbol(sym.WRITE, yytext());}
    "PERCENT" {return new Symbol(sym.PERCENT, yytext());}
    "AND" {return new Symbol(sym.AND, yytext());}
    "OR" {return new Symbol(sym.OR, yytext());}
    "DECLARE.SECTION" {return new Symbol(sym.SEC_DEC, yytext());}
    "ENDDECLARE.SECTION" {return new Symbol(sym.SEC_END, yytext());}
    "PROGRAM.SECTION" {return new Symbol(sym.SEC_PROG, yytext());}
    "ENDPROGRAM.SECTION" {return new Symbol(sym.SEC_ENDPROG, yytext());}
    "FLOAT" {return new Symbol(sym.ASIG_FL, yytext());}
    "INT" {return new Symbol(sym.ASIG_INT, yytext());}
    "STRING" {return new Symbol(sym.ASIG_STR, yytext());}
    "," {return new Symbol(sym.COMA, yytext());}
    {ID} {return new Symbol(sym.ID, yytext());}
    {CTE_ENT} {Symbol Symbol =  new Symbol(sym.CTE_ENT, yytext());
        try {
                    short valorShort = Short.parseShort(yytext());
                    return Symbol;
                } catch (NumberFormatException e) {
                    throw new ErrorEnt("Rango entero no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                }

    }
    {COMENTARIO} {/* NADA NADA NADA*/}
    {ESPACIO} {/* NADA NADA NADA*/}
    {CTE_REA} {Symbol Symbol = new Symbol(sym.CTE_REA, yytext());
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
    {CTE_BIN} {return new Symbol(sym.CTE_BIN, yytext());}
    {CTE_STR} {Symbol Symbol = new Symbol(sym.CTE_STR, yytext());
                    String str = (String) Symbol.value;
                    if(str.length() <= 32){//queda 32 porque se cuentan ambas comillas y el limite de string queda en 30
                        return Symbol;
                    }else{
                        throw new ErrorString("Rango String no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                    }
               }
  }
  [^] {throw new Error("Caracter no permitido: <" + yytext() + "> en la linea " + (yyline+1));}


package jflex;
import equipo6.TokenConstants;
import equipo6.Token;
import java_cup.runtime.*;

%%

%public
%class Lexico
%line
%column
%char
%type Token
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
   return new Token(TokenConstants.EOF, null);
%eofval}

%%
<YYINITIAL>{
    "(" {return new Token(TokenConstants.PAR_ABR, yytext());}
    ")" {return new Token(TokenConstants.PAR_CIE, yytext());}
    "[" {return new Token(TokenConstants.COR_ABR, yytext());}
    "]" {return new Token(TokenConstants.COR_CIE, yytext());}
    "+" {return new Token(TokenConstants.OP_SUM, yytext());}
    "-" {return new Token(TokenConstants.OP_RES, yytext());}
    "/" {return new Token(TokenConstants.OP_DIV, yytext());}
    "*" {return new Token(TokenConstants.OP_MUL, yytext());}
    "<" {return new Token(TokenConstants.OP_MEN, yytext());}
    ">" {return new Token(TokenConstants.OP_MAY, yytext());}
    "!=" {return new Token(TokenConstants.OP_DIST, yytext());}
    "==" {return new Token(TokenConstants.OP_IGU, yytext());}
    ">=" {return new Token(TokenConstants.OP_MAYIG, yytext());}
    "<=" {return new Token(TokenConstants.OP_MENIG, yytext());}
    "::=" {return new Token(TokenConstants.ASIG_TIPO, yytext());}
    ":=" {return new Token(TokenConstants.ASIG_VAR, yytext());}
    "BEGIN" {return new Token(TokenConstants.BEGIN, yytext());}
    "END" {return new Token(TokenConstants.END, yytext());}
    "WHILE" {return new Token(TokenConstants.WHILE, yytext());}
    "DO" {return new Token(TokenConstants.DO, yytext());}
    "IF" {return new Token(TokenConstants.IF, yytext());}
    "THEN" {return new Token(TokenConstants.THEN, yytext());}
    "ELSE" {return new Token(TokenConstants.ELSE, yytext());}
    "WRITE" {return new Token(TokenConstants.WRITE, yytext());}
    "PERCENT" {return new Token(TokenConstants.PERCENT, yytext());}
    "AND" {return new Token(TokenConstants.AND, yytext());}
    "OR" {return new Token(TokenConstants.OR, yytext());}
    "DECLARE.SECTION" {return new Token(TokenConstants.SEC_DEC, yytext());}
    "ENDDECLARE.SECTION" {return new Token(TokenConstants.SEC_END, yytext());}
    "PROGRAM.SECTION" {return new Token(TokenConstants.SEC_PROG, yytext());}
    "ENDPROGRAM.SECTION" {return new Token(TokenConstants.SEC_ENDPROG, yytext());}
    "FLOAT" {return new Token(TokenConstants.ASIG_FL, yytext());}
    "INT" {return new Token(TokenConstants.ASIG_INT, yytext());}
    "STRING" {return new Token(TokenConstants.ASIG_STR, yytext());}
    "," {return new Token(TokenConstants.COMA, yytext());}
    {ID} {return new Token(TokenConstants.ID, yytext());}
    {CTE_ENT} {Token token =  new Token(TokenConstants.CTE_ENT, yytext());
        try {
                    short valorShort = Short.parseShort(yytext());
                    return token;
                } catch (NumberFormatException e) {
                    throw new ErrorEnt("Rango entero no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                }

    }
    {COMENTARIO} {/* NADA NADA NADA*/}
    {ESPACIO} {/* NADA NADA NADA*/}
    {CTE_REA} {Token token = new Token(TokenConstants.CTE_REA, yytext());
        try {
                    float valorFloat = Float.parseFloat(yytext());
                    // Validar si está dentro del rango de float
                    if (valorFloat >= -Float.MAX_VALUE && valorFloat <= Float.MAX_VALUE && !Float.isNaN(valorFloat) && !Float.isInfinite(valorFloat)) {
                        return token;
                    } else {
                        throw new ErrorReal("Rango real no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                    }
                } catch (NumberFormatException e) {
                    throw new ErrorReal("Rango real no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                }
    }
    {CTE_BIN} {return new Token(TokenConstants.CTE_BIN, yytext());}
    {CTE_STR} {Token token = new Token(TokenConstants.CTE_STR, yytext());
                    String str = token.getLexeme();
                    if(str.length() <= 32){//queda 32 porque se cuentan ambas comillas y el limite de string queda en 30
                        return token;
                    }else{
                        throw new ErrorString("Rango String no permitido: <" + yytext() + "> en la linea " + (yyline+1));
                    }
               }
  }
  [^] {throw new Error("Caracter no permitido: <" + yytext() + "> en la linea " + (yyline+1));}


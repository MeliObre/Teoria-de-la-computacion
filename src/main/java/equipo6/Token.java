package equipo6;
import jcup.*;

public class Token  {
    private String type;
    private String lexeme;

    public Token(String type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return " Token "+ type +" encontrado, Lexema "+ lexeme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

}

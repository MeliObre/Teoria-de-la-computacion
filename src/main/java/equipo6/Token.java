package equipo6;

public class Token  {
    private TokenConstants type;
    private String lexeme;

    public Token(TokenConstants type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    @Override
    public String toString() {
        return "Type es:"+type+" lexeme es:"+lexeme;
    }

    public TokenConstants getType() {
        return type;
    }

    public void setType(TokenConstants type) {
        this.type = type;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

}

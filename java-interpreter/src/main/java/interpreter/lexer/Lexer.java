package interpreter.lexer;

import interpreter.token.Token;

public interface Lexer {
    public void readChar();
    public Token nextToken();
    public String readIndentifier();
    public void skipWhitespace();
    public String readNumber();
    public Character peekChar();

    public void reset(String input);
}

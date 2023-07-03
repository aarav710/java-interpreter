package interpreter.lexer;

import interpreter.token.Token;

public interface Lexer {
    public void readChar();
    public Token nextChar();
}
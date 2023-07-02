package interpreter.lexer;

import interpreter.token.Token;
import interpreter.token.TokenType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lexer {
    private String input;
    // position is pointing to the currentChar, and readPosition points to the next char of currentChar
    private Integer position;
    private Character currentChar;
    private Integer readPosition;

    public Lexer(String input) {
        this.input = input;
        this.readChar();
    }

    public void readChar() {
        if (readPosition >= input.length()) {
        currentChar = 0;
        } else {
        currentChar = input.charAt(readPosition);
        }
        position = readPosition;
        readPosition++;
    }

    public Token nextChar() {
        Token token = new Token();

        switch (currentChar) {
            case '=':
                token.setType(TokenType.ASSIGN);
                token.setValue(Character.toString(currentChar));
            case ';':
                token.setType(TokenType.SEMICOLON);
                token.setValue(Character.toString(currentChar));
            case '+':
                token.setType(TokenType.PLUS);
                token.setValue(Character.toString(currentChar));
        }

        readChar();
        return token;
    }
}

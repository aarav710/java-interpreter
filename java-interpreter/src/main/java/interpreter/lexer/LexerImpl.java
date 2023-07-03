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
public class LexerImpl implements Lexer {
    private String input;
    // position is pointing to the currentChar, and readPosition points to the next char of currentChar
    private Integer position = 0;
    private Character currentChar;
    private Integer readPosition = 0;

    public LexerImpl(String input) {
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
            case ';':
                token.setType(TokenType.SEMICOLON);
            case '+':
                token.setType(TokenType.PLUS);
            case '(':
                token.setType(TokenType.LPAREN);
            case ')':
                token.setType(TokenType.RPAREN);
            case '{':
                token.setType(TokenType.LBRACE);
            case '}':
                token.setType(TokenType.RBRACE);
            case ',':
                token.setType(TokenType.COMMA);
            case 0:
                token.setType(TokenType.EOF);
        }

        if (token.getType() == TokenType.EOF) {
            token.setValue("");
        } else {
            token.setValue(Character.toString(currentChar));
        }

        readChar();
        return token;
    }
}

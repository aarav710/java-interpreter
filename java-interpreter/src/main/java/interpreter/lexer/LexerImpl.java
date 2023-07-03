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

        skipWhitespace();

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
            case '-':
                token.setType(TokenType.MINUS);
            case '!':
                token.setType(TokenType.BANG);
            case '>':
                token.setType(TokenType.GT);
            case '<':
                token.setType(TokenType.LT);
            case '*':
                token.setType(TokenType.ASTERISK);
            case '/':
                token.setType(TokenType.SLASH);
            case 0:
                token.setType(TokenType.EOF);
            default:
                if (Character.isLetter(currentChar)) {
                    token.setValue(readIndentifier());
                    token.setType(Token.lookupIdent(token.getValue()));
                    return token;
                } else if (Character.isDigit(currentChar)) {
                    token.setType(TokenType.INT);
                    token.setValue(readNumber());
                    return token;
                } else {
                    token.setType(TokenType.ILLEGAL);
                }

        }

        if (token.getType() == TokenType.EOF) {
            token.setValue("");
        } else {
            token.setValue(Character.toString(currentChar));
        }

        readChar();
        return token;
    }

    public String readIndentifier() {
        var tempPosition = position;
        while(Character.isLetter(currentChar)) {
            readChar();
        }
        return input.substring(tempPosition, position);
    }

    public void skipWhitespace() {
        while (currentChar == ' ' || currentChar == '\t' || currentChar == '\n' || currentChar == '\r') {
            readChar();
        }
    }

    public String readNumber() {
        var tempPosition = position;
        while (Character.isDigit(currentChar)) {
            readChar();
        }
        return input.substring(tempPosition, position);
    }

    public Character peekChar() {
        if (readPosition >= input.length()) {
            return 0;
        } else {
            return input.charAt(readPosition);
        }
    }
}

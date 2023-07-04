package interpreter.lexer;

import com.google.inject.Inject;
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

    public void readChar() {
        currentChar = readPosition >= input.length() ? 0 : input.charAt(readPosition);
        position = readPosition;
        readPosition++;
    }

    public Token nextToken() {
        Token token = new Token();

        skipWhitespace();
        switch (currentChar) {
            case '=':
                if (peekChar() == '=') {
                    var ch = currentChar;
                    readChar();
                    token.setType(TokenType.EQ);
                    token.setValue(Character.toString(ch) + Character.toString(currentChar));
                } else {
                    token.setType(TokenType.ASSIGN);
                    token.setValue(Character.toString(currentChar));
                }
                break;
            case ';':
                token.setType(TokenType.SEMICOLON);
                token.setValue(Character.toString(currentChar));
                break;
            case '+':
                token.setType(TokenType.PLUS);
                token.setValue(Character.toString(currentChar));
                break;
            case '(':
                token.setType(TokenType.LPAREN);
                token.setValue(Character.toString(currentChar));
                break;
            case ')':
                token.setType(TokenType.RPAREN);
                token.setValue(Character.toString(currentChar));
                break;
            case '{':
                token.setType(TokenType.LBRACE);
                token.setValue(Character.toString(currentChar));
                break;
            case '}':
                token.setType(TokenType.RBRACE);
                token.setValue(Character.toString(currentChar));
                break;
            case ',':
                token.setType(TokenType.COMMA);
                token.setValue(Character.toString(currentChar));
                break;
            case '-':
                token.setType(TokenType.MINUS);
                token.setValue(Character.toString(currentChar));
                break;
            case '!':
                if (peekChar() == '=') {
                    var ch = currentChar;
                    readChar();
                    token.setType(TokenType.NOT_EQ);
                    token.setValue(Character.toString(ch) + Character.toString(currentChar));
                } else {
                    token.setValue(Character.toString(currentChar));
                    token.setType(TokenType.BANG);
                }
                break;
            case '>':
                token.setType(TokenType.GT);
                token.setValue(Character.toString(currentChar));
                break;
            case '<':
                token.setType(TokenType.LT);
                token.setValue(Character.toString(currentChar));
                break;
            case '*':
                token.setType(TokenType.ASTERISK);
                token.setValue(Character.toString(currentChar));
                break;
            case '/':
                token.setType(TokenType.SLASH);
                token.setValue(Character.toString(currentChar));
                break;
            case 0:
                token.setType(TokenType.EOF);
                token.setValue("");
                break;
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
                    token.setValue(Character.toString(currentChar));
                }
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

    public void reset(String input) {
        this.input = input;
        this.readPosition = 0;
        this.position = 0;
        readChar();
    }
}

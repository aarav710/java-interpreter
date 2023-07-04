package interpreter.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Token {
    private TokenType type;
    private String value;

    static final public HashMap<String, TokenType> KEYWORDS = new HashMap<>() {{
        put("let", TokenType.LET);
        put("fn", TokenType.FUNCTION);
        put("false", TokenType.FALSE);
        put("true", TokenType.TRUE);
        put("if", TokenType.IF);
        put("else", TokenType.ELSE);
        put("return", TokenType.RETURN);
    }};

    static public TokenType lookupIdent(String ident) {
        if (KEYWORDS.containsKey(ident)) {
            return KEYWORDS.get(ident);
        }
        return TokenType.IDENT;
    }
}

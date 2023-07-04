package interpreter.Repl;

import com.google.inject.Inject;
import interpreter.lexer.Lexer;
import interpreter.lexer.LexerImpl;
import interpreter.token.TokenType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.*;

@Setter
@Getter
public class ReplImpl implements Repl {
    private final Lexer lexer;

    @Inject
    public ReplImpl(Lexer lexer) {
        this.lexer = lexer;
    }

    public void start() throws IOException {
        PrintStream printStream = System.out;

        final String PROMPT = ">>";
        while (true) {
            printStream.println(PROMPT);
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(streamReader);
            String line = reader.readLine();
            lexer.reset(line);
            var token = lexer.nextToken();
            while (token.getType() != TokenType.EOF) {
                System.out.println(token.getType());
                token = lexer.nextToken();
            }
        }
    }
}

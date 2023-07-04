package interpreter.Repl;

import com.google.common.base.Charsets;
import com.google.common.base.Utf8;
import com.google.common.io.CharStreams;
import interpreter.lexer.Lexer;
import interpreter.lexer.LexerImpl;
import interpreter.token.Token;
import interpreter.token.TokenType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.*;
import java.util.Scanner;

@NoArgsConstructor
@Setter
@Getter
public class ReplImpl implements Repl {

    public void start() throws IOException {
        PrintStream printStream = System.out;

        final String PROMPT = ">>";
        while (true) {
            printStream.println(PROMPT);
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(streamReader);
            String line = reader.readLine();
            Lexer lexer = new LexerImpl(line);
            var token = lexer.nextToken();
            while (token.getType() != TokenType.EOF) {
                System.out.println(token.getType());
                token = lexer.nextToken();
            }
        }
    }
}

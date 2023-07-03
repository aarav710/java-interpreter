package interpreter.Repl;

import com.google.inject.Inject;
import com.google.inject.Provider;
import interpreter.lexer.Lexer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.InputStream;
import java.io.PrintStream;

@NoArgsConstructor
@Setter
@Getter
public class ReplImpl implements Repl {

    public void start() {
        InputStream inputStream = System.in;
        PrintStream printStream = System.out;
        final String PROMPT = ">>";
        printStream.println(PROMPT);
    }
}

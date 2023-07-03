package interpreter.Repl;

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

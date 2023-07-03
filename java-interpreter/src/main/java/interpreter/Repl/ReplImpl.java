package interpreter.Repl;

import com.google.inject.Inject;

import java.io.InputStream;
import java.io.PrintStream;

public class ReplImpl implements Repl {
    private final String PROMPT = ">>";
    private final InputStream inputStream;
    private final PrintStream printStream;

    @Inject
    public ReplImpl(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
    }

    public void start() {

    }
}

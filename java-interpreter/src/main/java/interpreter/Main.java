package interpreter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import interpreter.Repl.Repl;
import interpreter.Repl.ReplModule;

import java.io.InputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ReplModule());
        Repl repl = injector.getInstance(Repl.class);
        repl.start();
    }
}

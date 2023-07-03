package interpreter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import interpreter.Repl.Repl;
import interpreter.Repl.ReplModule;

import java.io.InputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        PrintStream printStream = System.out;
        Injector injector = Guice.createInjector(new ReplModule());
        injector.injectMembers(inputStream);
        injector.injectMembers(printStream);
        Repl repl = injector.getInstance(Repl.class);
        repl.start();
    }
}

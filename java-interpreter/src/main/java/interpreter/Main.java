package interpreter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import interpreter.Repl.Repl;
import interpreter.Repl.ReplModule;
import interpreter.lexer.LexerModule;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ReplModule(), new LexerModule());
        Repl repl = injector.getInstance(Repl.class);
        try {
            repl.start();
        } catch (IOException exception) {
            System.out.println("Error occured.");
            System.exit(1);
        }
    }
}

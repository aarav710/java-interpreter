package interpreter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import interpreter.Repl.Repl;
import interpreter.Repl.ReplModule;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ReplModule());
        Repl repl = injector.getInstance(Repl.class);
        try {
            repl.start();
        } catch (IOException exception) {
            System.out.println("Error occured.");
            System.exit(1);
        }
    }
}

package interpreter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import interpreter.lexer.LexerModule;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new LexerModule());
        System.out.println("Hello world!");
    }
}

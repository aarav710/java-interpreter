package interpreter.Repl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import interpreter.lexer.Lexer;
import interpreter.lexer.LexerImpl;

public class ReplModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Repl.class).to(ReplImpl.class);
    }
}

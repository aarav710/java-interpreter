package interpreter.lexer;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class LexerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Lexer.class).to(LexerImpl.class).in(Singleton.class);
    }
}

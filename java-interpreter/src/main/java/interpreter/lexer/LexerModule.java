package interpreter.lexer;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class LexerModule extends AbstractModule {

    @Override
    public void configure() {
        bind(Lexer.class).to(LexerImpl.class).in(Singleton.class);
    }
}

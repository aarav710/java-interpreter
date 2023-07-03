package interpreter.Repl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ReplModule extends AbstractModule {

    @Override
    public void configure() {
        bind(Repl.class).to(ReplImpl.class).in(Singleton.class);
    }
}

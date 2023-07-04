package interpreter.Repl;

import com.google.inject.AbstractModule;

public class ReplModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Repl.class).to(ReplImpl.class);
    }
}

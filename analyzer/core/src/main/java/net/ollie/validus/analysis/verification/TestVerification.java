package net.ollie.validus.analysis.verification;

import javax.annotation.Nonnull;
import java.net.URL;

public record TestVerification(String testClassName, String testName) implements Verification {

    @Nonnull
    @Override
    public URL link() {
        throw new UnsupportedOperationException(); //TODO
    }

}

package net.ollie.validus.analysis.verification;

import javax.annotation.Nonnull;
import java.net.URL;

public sealed interface Verification permits TestVerification {

    @Nonnull
    URL link();

}

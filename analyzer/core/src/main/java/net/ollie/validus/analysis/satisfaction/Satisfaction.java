package net.ollie.validus.analysis.satisfaction;

import javax.annotation.Nonnull;
import java.net.URL;

public sealed interface Satisfaction permits ClassMethodSatisfaction {

    @Nonnull
    URL link();

}

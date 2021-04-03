package net.ollie.validus.project.java;

import net.ollie.validus.project.Project;

import javax.annotation.Nonnull;
import java.net.URL;

public interface JavaProject extends Project {

    @Nonnull
    URL resolveUrl(JavaMethod method);

}

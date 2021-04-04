package net.ollie.validus.project.java;

import net.ollie.validus.project.Project;

import javax.annotation.Nonnull;
import java.net.URL;

public sealed interface JavaProject extends Project permits LocalJavaProject, RemoteJavaProject {

    @Nonnull
    URL resolveUrl(JavaMethod method);

}

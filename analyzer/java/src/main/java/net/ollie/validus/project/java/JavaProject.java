package net.ollie.validus.project.java;

import net.ollie.validus.project.Project;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.net.URL;

public sealed interface JavaProject extends Project permits LocalJavaProject, RemoteJavaProject {

    @CheckForNull
    URL resolveUrl(JavaMethod method);

}

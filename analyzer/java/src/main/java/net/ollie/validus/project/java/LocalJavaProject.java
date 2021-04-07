package net.ollie.validus.project.java;

import net.ollie.validus.project.LocalProject;

import java.io.File;
import java.net.URL;

public record LocalJavaProject(File root, RemoteJavaProject remote) implements JavaProject, LocalProject {

    @Override
    public URL resolveUrl(final JavaMethod method) {
        return remote.resolveUrl(method);
    }

}

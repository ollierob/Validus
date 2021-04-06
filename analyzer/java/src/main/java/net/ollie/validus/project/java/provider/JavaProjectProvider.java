package net.ollie.validus.project.java.provider;

import com.google.inject.ImplementedBy;
import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.java.RemoteJavaProject;
import net.ollie.validus.project.provider.ProjectProvider;

import javax.annotation.Nonnull;

@ImplementedBy(DefaultJavaProjectProvider.class)
public interface JavaProjectProvider extends ProjectProvider<RemoteJavaProject> {

    @Nonnull
    RemoteJavaProject edit(ProjectId id, JavaProjectSpec spec, int version);

}

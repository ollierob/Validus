package net.ollie.validus.project.provider;

import com.google.inject.ImplementedBy;
import net.ollie.validus.project.RemoteProject;

@ImplementedBy(InMemoryRemoteProjectProvider.class)
public interface RemoteProjectProvider extends ProjectProvider<RemoteProject> {

    <P extends RemoteProject> P edit(P project, int version);

}

package net.ollie.validus.project.provider;

import com.google.common.collect.Maps;
import net.ollie.validus.project.ProjectId;
import net.ollie.validus.project.RemoteProject;

import javax.annotation.Nonnull;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Optional;

@Singleton
public class InMemoryRemoteProjectProvider implements RemoteProjectProvider {

    private final Map<ProjectId, RemoteProject> projects = Maps.newConcurrentMap();

    @Nonnull
    @Override
    public Optional<RemoteProject> get(final ProjectId id) {
        return Optional.ofNullable(projects.get(id));
    }

    @Override
    public <P extends RemoteProject> P edit(final P project, final int version) {
        return (P) projects.compute(project.id(), (id, current) -> this.replace(current, project, version));
    }

    private <P extends RemoteProject> P replace(final RemoteProject prev, final P next, final int version) {
        if (version != (prev == null ? 0 : prev.version())) throw new IllegalArgumentException();
        return next;
    }

}

package net.ollie.validus.project;

import net.ollie.protobuf.BuildsProto;
import net.ollie.validus.ProjectProto;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public interface Project extends BuildsProto<ProjectProto.Project> {

    @Nonnull
    ProjectId id();

    @Nonnull
    CompletableFuture<? extends LocalProject> toLocalProject();

    @Nonnull
    @Override
    default ProjectProto.Project toProto() {
        return this.toProtoBuilder().build();
    }

    @Nonnull
    default ProjectProto.Project.Builder toProtoBuilder() {
        return ProjectProto.Project.newBuilder();
    }

}
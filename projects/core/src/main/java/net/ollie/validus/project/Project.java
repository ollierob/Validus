package net.ollie.validus.project;

import net.ollie.protobuf.BuildsProto;
import net.ollie.validus.ProjectProto;

import javax.annotation.Nonnull;

public interface Project extends BuildsProto<ProjectProto.Project> {

    @Nonnull
    ProjectId id();

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
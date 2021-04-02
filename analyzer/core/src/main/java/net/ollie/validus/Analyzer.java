package net.ollie.validus;

import net.ollie.validus.analysis.ProjectAnalysis;
import net.ollie.validus.project.LocalProject;

import javax.annotation.Nonnull;

public interface Analyzer<P extends LocalProject> {

    @Nonnull
    ProjectAnalysis analyze(P project);

}

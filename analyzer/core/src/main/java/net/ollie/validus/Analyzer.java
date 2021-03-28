package net.ollie.validus;

import net.ollie.validus.analysis.ProjectAnalysis;
import net.ollie.validus.project.LocalProject;
import net.ollie.validus.project.Project;

import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

public interface Analyzer {

    @Nonnull
    ProjectAnalysis analyze(LocalProject project) throws AnalyzerException;

    @Nonnull
    default CompletableFuture<ProjectAnalysis> analyze(final Project project) {
        return project.toLocalProject().thenApply(this::analyzeUnexceptionally);
    }

    private ProjectAnalysis analyzeUnexceptionally(final LocalProject project) {
        try {
            return this.analyze(project);
        } catch (AnalyzerException e) {
            throw new RuntimeException(e);
        }
    }

}

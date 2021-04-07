package net.ollie.validus.analyzer.java;

import com.github.javaparser.StaticJavaParser;
import net.ollie.validus.Analyzer;
import net.ollie.validus.analysis.ProjectAnalysis;
import net.ollie.validus.analysis.ProjectAnalysisBuilder;
import net.ollie.validus.project.java.LocalJavaProject;
import net.ollie.validus.project.java.RemoteJavaProject;
import net.ollie.validus.specification.SpecificationProvider;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.CompletableFuture;

@Singleton
public class JavaAnalyzer implements Analyzer<LocalJavaProject> {

    private final SpecificationProvider specificationProvider;

    @Inject
    JavaAnalyzer(final SpecificationProvider specificationProvider) {
        this.specificationProvider = specificationProvider;
    }

    @Nonnull
    public CompletableFuture<ProjectAnalysis> analyze(final RemoteJavaProject project) {
        //FIXME dir
        return project.toLocalProject().thenApply(this::analyze);
    }

    @Nonnull
    public ProjectAnalysis analyze(final LocalJavaProject project) {
        try {
            final var builder = new ProjectAnalysisBuilder(project.remote(), specificationProvider);
            final var root = project.root();
            final var visitor = new ProjectAnalysisVisitor(project);
            this.visit(visitor, root, builder);
            return builder.build();
        } catch (final Exception ex) {
            throw new RuntimeException("Error analyzing " + project, ex);
        }
    }

    private void visit(final ProjectAnalysisVisitor visitor, final File file, final ProjectAnalysisBuilder builder) {
        try {
            if (file.isDirectory()) {
                final var listed = file.listFiles();
                if (listed == null) return;
                for (final var subfile : listed) {
                    this.visit(visitor, subfile, builder);
                }
            } else if (file.getName().endsWith(".java")) {
                final var compilationUnit = StaticJavaParser.parse(file);
                compilationUnit.accept(visitor, builder);
            }
        } catch (final FileNotFoundException ex) {
            //Ignore
        } catch (final VisitException ex) {
            throw ex;
        } catch (final Exception ex) {
            throw new VisitException("Error analyzing " + file, ex);
        }
    }

    private static class VisitException extends RuntimeException {

        VisitException(final String message, final Throwable cause) {
            super(message, cause);
        }

    }

}

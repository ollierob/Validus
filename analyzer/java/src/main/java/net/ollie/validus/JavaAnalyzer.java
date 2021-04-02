package net.ollie.validus;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.visitor.VoidVisitor;
import net.ollie.validus.analysis.ProjectAnalysis;
import net.ollie.validus.analysis.ProjectAnalysisBuilder;
import net.ollie.validus.project.LocalProject;
import net.ollie.validus.specification.SpecificationProvider;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;
import java.io.FileNotFoundException;

@Singleton
public class JavaAnalyzer implements Analyzer {

    private static final VoidVisitor<ProjectAnalysisBuilder> VISITOR = new ProjectAnalysisVisitor();

    private final SpecificationProvider specificationProvider;

    @Inject
    JavaAnalyzer(final SpecificationProvider specificationProvider) {
        this.specificationProvider = specificationProvider;
    }

    @Nonnull
    @Override
    public ProjectAnalysis analyze(final LocalProject project) {
        try {
            final var builder = new ProjectAnalysisBuilder(project.source(), specificationProvider);
            final var root = project.root().toFile();
            this.visit(root, builder);
            return builder.build();
        } catch (final Exception ex) {
            throw new RuntimeException("Error analyzing " + project, ex);
        }
    }

    private void visit(final File file, final ProjectAnalysisBuilder builder) {
        try {
            if (file.isDirectory()) {
                final var listed = file.listFiles();
                if (listed == null) return;
                for (final var subfile : listed) {
                    this.visit(subfile, builder);
                }
            } else if (file.getName().endsWith(".java")) {
                final var compilationUnit = StaticJavaParser.parse(file);
                compilationUnit.accept(VISITOR, builder);
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

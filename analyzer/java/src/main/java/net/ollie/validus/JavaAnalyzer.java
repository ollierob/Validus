package net.ollie.validus;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.visitor.VoidVisitor;
import net.ollie.validus.analysis.ProjectAnalysis;
import net.ollie.validus.analysis.ProjectAnalysisBuilder;
import net.ollie.validus.project.LocalProject;

import javax.annotation.Nonnull;

public class JavaAnalyzer implements Analyzer {

    private static final VoidVisitor<ProjectAnalysisBuilder> VISITOR = new ProjectAnalysisVisitor();

    @Nonnull
    @Override
    public ProjectAnalysis analyze(final LocalProject project) {
        try {
            final var compilationUnit = StaticJavaParser.parse(project.root());
            final var builder = new ProjectAnalysisBuilder(project);
            compilationUnit.accept(VISITOR, builder);
            return builder.build();
        } catch (final Exception ex) {
            throw new RuntimeException("Error analyzing " + project, ex);
        }
    }

}

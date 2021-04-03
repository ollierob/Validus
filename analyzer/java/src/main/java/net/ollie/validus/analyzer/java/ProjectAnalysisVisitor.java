package net.ollie.validus.analyzer.java;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.ArrayInitializerExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import net.ollie.validus.analysis.ProjectAnalysisBuilder;
import net.ollie.validus.analysis.satisfaction.ClassMethodSatisfaction;
import net.ollie.validus.analysis.satisfaction.Satisfaction;
import net.ollie.validus.analysis.verification.TestVerification;
import net.ollie.validus.analysis.verification.Verification;
import net.ollie.validus.annotation.Satisfies;
import net.ollie.validus.annotation.Verifies;
import net.ollie.validus.project.java.JavaMethod;
import net.ollie.validus.project.java.LocalJavaProject;
import net.ollie.validus.specification.SpecificationId;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class ProjectAnalysisVisitor extends VoidVisitorAdapter<ProjectAnalysisBuilder> {

    private final LocalJavaProject project;

    ProjectAnalysisVisitor(LocalJavaProject project) {
        this.project = project;
    }

    @Override
    public void visit(final MethodDeclaration m, final ProjectAnalysisBuilder builder) {
        //Ignore super and only get annotation
        var expr = m.getAnnotationByClass(Satisfies.class).orElse(null);
        if (expr != null) this.add(this.getSatisfaction(m), this.getSpecificationIds(expr), builder);
        expr = m.getAnnotationByClass(Verifies.class).orElse(null);
        if (expr != null) this.add(this.getVerification(m), this.getSpecificationIds(expr), builder);
    }

    private Set<SpecificationId> getSpecificationIds(final AnnotationExpr annotationExpression) {
        final var valueNode = annotationExpression.getChildNodes().get(1);
        if (valueNode instanceof StringLiteralExpr) {
            return Collections.singleton(new SpecificationId(((StringLiteralExpr) valueNode).getValue()));
        }
        if (valueNode instanceof ArrayInitializerExpr) {
            final var ids = new HashSet<SpecificationId>();
            final var arrayNode = (ArrayInitializerExpr) valueNode;
            for (final var expr : arrayNode.getValues()) {
                final var strNode = (StringLiteralExpr) expr;
                ids.add(new SpecificationId(strNode.getValue()));
            }
            return ids;
        }
        throw new UnsupportedOperationException("Cannot extract specifications from " + annotationExpression);
    }

    private Satisfaction getSatisfaction(final MethodDeclaration methodDeclaration) {
        final var method = JavaMethod.resolve(methodDeclaration);
        final var url = project.resolveUrl(method);
        return new ClassMethodSatisfaction(method.packageName(), method.className(), method.methodName(), url);
    }

    private void add(final Satisfaction satisfaction, final Set<SpecificationId> ids, final ProjectAnalysisBuilder builder) {
        for (final var id : ids) {
            builder.add(id, satisfaction);
        }
    }

    private Verification getVerification(final MethodDeclaration methodDeclaration) {
        final var method = JavaMethod.resolve(methodDeclaration);
        final var url = project.resolveUrl(method);
        return new TestVerification(method.className(), methodDeclaration.getNameAsString(), url);
    }

    private void add(final Verification verification, final Set<SpecificationId> ids, final ProjectAnalysisBuilder builder) {
        for (final var id : ids) {
            builder.add(id, verification);
        }
    }

}

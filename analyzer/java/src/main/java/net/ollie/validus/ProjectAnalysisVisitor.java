package net.ollie.validus;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import net.ollie.validus.analysis.ProjectAnalysisBuilder;
import net.ollie.validus.analysis.satisfaction.Satisfaction;
import net.ollie.validus.analysis.verification.Verification;
import net.ollie.validus.annotation.Satisfies;
import net.ollie.validus.annotation.Verifies;
import net.ollie.validus.specification.SpecificationId;

class ProjectAnalysisVisitor extends VoidVisitorAdapter<ProjectAnalysisBuilder> {

    @Override
    public void visit(final MethodDeclaration m, final ProjectAnalysisBuilder builder) {
        //Ignore super and only get annotation
        var expr = m.getAnnotationByClass(Satisfies.class).orElse(null);
        if (expr != null) this.add(this.getSatisfaction(m), this.getSatisfies(expr), builder);
        expr = m.getAnnotationByClass(Verifies.class).orElse(null);
        if (expr != null) this.add(this.getVerification(m), this.getVerifies(expr), builder);
    }

    private Satisfies getSatisfies(final AnnotationExpr expr) {
        throw new UnsupportedOperationException();
    }

    private Satisfaction getSatisfaction(final MethodDeclaration method) {
        //return new ClassMethodSatisfaction(method.getNameAsString());
        throw new UnsupportedOperationException();
    }

    private void add(final Satisfaction satisfaction, final Satisfies satisfies, final ProjectAnalysisBuilder builder) {
        if (satisfies == null || satisfaction == null) return;
        final var v = satisfies.value();
        for (int i = 0; i < v.length; i++) {
            builder.add(new SpecificationId(v[i]), satisfaction);
        }
    }

    private Verification getVerification(MethodDeclaration m) {
        throw new UnsupportedOperationException();
    }

    private Verifies getVerifies(final AnnotationExpr expr) {
        throw new UnsupportedOperationException();
    }

    private void add(final Verification verification, final Verifies verifies, final ProjectAnalysisBuilder builder) {
        throw new UnsupportedOperationException();
    }

}

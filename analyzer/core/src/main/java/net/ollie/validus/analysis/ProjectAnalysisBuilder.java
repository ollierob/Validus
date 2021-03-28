package net.ollie.validus.analysis;

import net.ollie.validus.analysis.satisfaction.Satisfaction;
import net.ollie.validus.analysis.verification.Verification;
import net.ollie.validus.project.Project;
import net.ollie.validus.specification.SpecificationId;

import java.util.HashMap;
import java.util.Map;

public class ProjectAnalysisBuilder {

    private final Project project;
    private final Map<SpecificationId, SpecificationAnalysis> specifications = new HashMap<>();

    public ProjectAnalysisBuilder(final Project project) {
        this.project = project;
    }

    public void add(final SpecificationId id, final Satisfaction satisfaction) {
        specifications.compute(id, (i, curr) -> this.add(i, curr, satisfaction));
    }

    private SpecificationAnalysis add(final SpecificationId id, final SpecificationAnalysis current, final Satisfaction satisfaction) {
        return new GenericSpecificationAnalysis(id, satisfaction).and(current);
    }

    public void add(final SpecificationId id, final Verification verification) {
        specifications.compute(id, (i, curr) -> this.add(i, curr, verification));
    }

    private SpecificationAnalysis add(final SpecificationId id, final SpecificationAnalysis current, final Verification verification) {
        return new GenericSpecificationAnalysis(id, verification).and(current);
    }

    public ProjectAnalysis build() {
        return new GenericProjectAnalysis(project, new HashMap<>(specifications));
    }

}

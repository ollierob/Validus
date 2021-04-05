package net.ollie.validus.analysis;

import net.ollie.validus.analysis.satisfaction.Satisfaction;
import net.ollie.validus.analysis.verification.Verification;
import net.ollie.validus.project.RemoteProject;
import net.ollie.validus.specification.SpecificationId;
import net.ollie.validus.specification.SpecificationProvider;

import java.util.HashMap;
import java.util.Map;

public class ProjectAnalysisBuilder {

    private final RemoteProject project;
    private final SpecificationProvider provider;
    private final Map<SpecificationId, SpecificationAnalysis> specifications = new HashMap<>();

    public ProjectAnalysisBuilder(final RemoteProject project, final SpecificationProvider provider) {
        this.project = project;
        this.provider = provider;
    }

    public void add(final SpecificationId id, final Satisfaction satisfaction) {
        specifications.compute(id, (i, curr) -> this.add(i, curr, satisfaction));
    }

    private SpecificationAnalysis add(final SpecificationId id, final SpecificationAnalysis current, final Satisfaction satisfaction) {
        final var spec = current == null ? provider.require(id) : current.specification();
        return new GenericSpecificationAnalysis(spec, satisfaction).and(current);
    }

    public void add(final SpecificationId id, final Verification verification) {
        specifications.compute(id, (i, curr) -> this.add(i, curr, verification));
    }

    private SpecificationAnalysis add(final SpecificationId id, final SpecificationAnalysis current, final Verification verification) {
        final var spec = current == null ? provider.require(id) : current.specification();
        return new GenericSpecificationAnalysis(spec, verification).and(current);
    }

    public ProjectAnalysis build() {
        return new GenericProjectAnalysis(project, new HashMap<>(specifications));
    }

}

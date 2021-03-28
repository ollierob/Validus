package net.ollie.validus.analysis;

import net.ollie.validus.project.Project;
import net.ollie.validus.specification.SpecificationId;

import javax.annotation.Nonnull;
import java.util.Map;

public non-sealed interface ProjectAnalysis extends Analysis {

    @Nonnull
    Project project();

    @Nonnull
    Map<SpecificationId, SpecificationAnalysis> specifications();

}

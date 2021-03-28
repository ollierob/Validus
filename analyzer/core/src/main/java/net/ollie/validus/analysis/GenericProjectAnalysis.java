package net.ollie.validus.analysis;

import net.ollie.validus.project.Project;
import net.ollie.validus.specification.SpecificationId;

import java.util.Map;

public record GenericProjectAnalysis(Project project, Map<SpecificationId, SpecificationAnalysis> specifications) implements ProjectAnalysis {

}

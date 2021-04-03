package net.ollie.validus.analysis;

import net.ollie.validus.project.RemoteProject;
import net.ollie.validus.specification.SpecificationId;

import java.util.Map;

public record GenericProjectAnalysis(RemoteProject project, Map<SpecificationId, SpecificationAnalysis> specifications) implements ProjectAnalysis {

}

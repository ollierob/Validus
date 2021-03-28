package net.ollie.validus;

import net.ollie.validus.analysis.ProjectAnalysis;
import net.ollie.validus.project.Project;

public interface Analyzer {

    ProjectAnalysis analyze(Project project);

}

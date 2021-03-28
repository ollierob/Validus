package net.ollie.validus;

import net.ollie.validus.analysis.Analysis;
import net.ollie.validus.project.Project;

public interface Analyzer {

    Analysis analyze(Project project);

}

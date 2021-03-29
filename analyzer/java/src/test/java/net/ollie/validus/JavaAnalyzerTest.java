package net.ollie.validus;

import net.ollie.validus.project.LocalProject;
import net.ollie.validus.project.Project;
import net.ollie.validus.project.ProjectId;
import net.ollie.validus.specification.SpecificationId;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class JavaAnalyzerTest {

    @Test
    void shouldAnalyzeTestPackage() {

        final var mockSource = mock(Project.class);
        final var root = Paths.get(new File(".").getAbsolutePath());
        final var project = new LocalProject(new ProjectId("test"), root, mockSource);

        final var analyzer = new JavaAnalyzer();

        final var analysis = analyzer.analyze(project);

        assertEquals(mockSource, analysis.project());
        assertTrue(analysis.hasSpecifications());

        final var specs = analysis.specifications();

        final var a1 = specs.get(new SpecificationId("A-1"));
        assertNotNull(a1);
        assertEquals(2, a1.satisfactions().size(), "Should be satisfied twice");

        final var b2 = specs.get(new SpecificationId("B-2"));
        assertNotNull(b2);
        assertEquals(1, b2.satisfactions().size());

    }

}
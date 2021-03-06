package net.ollie.validus.analyzer.java;

import net.ollie.validus.project.java.LocalJavaProject;
import net.ollie.validus.project.java.RemoteJavaProject;
import net.ollie.validus.specification.SpecificationId;
import net.ollie.validus.specification.SpecificationProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class JavaAnalyzerTest {

    @Mock
    private SpecificationProvider mockSpecProvider;

    @BeforeEach
    void beforeEach() {
        mockSpecProvider = mock(SpecificationProvider.class, Mockito.RETURNS_MOCKS);
    }

    @Disabled
    @Test
    void shouldAnalyzeTestPackage() {

        final var selfPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile();
        final var sampleClass = new File(selfPath, "SampleClass.java");

        final var mockSource = mock(RemoteJavaProject.class);
        final var project = new LocalJavaProject(sampleClass, mockSource);

        final var analyzer = new JavaAnalyzer(mockSpecProvider);

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
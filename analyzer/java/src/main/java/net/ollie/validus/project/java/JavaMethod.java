package net.ollie.validus.project.java;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.google.common.base.Splitter;

import java.nio.file.Path;
import java.util.Collections;

/**
 * @param packageName     separated by {@code .}
 * @param outerClassName
 * @param innerClassNames separated by {@code #}
 * @param methodName
 */
public record JavaMethod(String packageName, String outerClassName, String innerClassNames, String methodName) {

    public JavaMethod(final String packageName, final String outerClassName, final String methodName) {
        this(packageName, outerClassName, null, methodName);
    }

    private static final Splitter PACKAGE_SPLITTER = Splitter.on('.');

    public static JavaMethod resolve(final MethodDeclaration methodDeclaration) {
        final var classDeclaration = getClassDeclaration(methodDeclaration);
        final var packageName = getPackageName(classDeclaration);
        return new JavaMethod(packageName, classDeclaration.getNameAsString(), methodDeclaration.getNameAsString());
    }

    public Path filePath() {
        var path = Path.of("");
        for (final var p : this.packagePath()) {
            path = path.resolve(p);
        }
        return path.resolve(outerClassName + ".java");
    }

    Iterable<String> packagePath() {
        if (packageName == null) return Collections.emptyList();
        return PACKAGE_SPLITTER.split(packageName);
    }

    private static ClassOrInterfaceDeclaration getClassDeclaration(final MethodDeclaration method) {
        return method.getParentNode().map(n -> (ClassOrInterfaceDeclaration) n).get();
    }

    private static String getPackageName(final ClassOrInterfaceDeclaration classOrInterface) {
        return null; //TODO read parent
    }

}

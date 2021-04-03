package net.ollie.validus.project.java;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public record JavaMethod(String packageName, String className, String methodName) {

    public static JavaMethod resolve(final MethodDeclaration methodDeclaration) {
        final var classDeclaration = getClassDeclaration(methodDeclaration);
        final var packageName = getPackageName(classDeclaration);
        return new JavaMethod(packageName, classDeclaration.getNameAsString(), methodDeclaration.getNameAsString());
    }

    private static ClassOrInterfaceDeclaration getClassDeclaration(final MethodDeclaration method) {
        return method.getParentNode().map(n -> (ClassOrInterfaceDeclaration) n).get();
    }

    private static String getPackageName(final ClassOrInterfaceDeclaration classOrInterface) {
        return null; //TODO read parent
    }

}

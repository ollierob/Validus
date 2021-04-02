package net.ollie.validus.analysis.satisfaction;

import java.net.URL;

public record ClassMethodSatisfaction(String packageName, String className, String methodName, URL link) implements Satisfaction {

}

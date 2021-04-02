package net.ollie.validus.analysis.satisfaction;

import java.net.URL;

public record ClassMethodSatisfaction(String packageName, String className, String methodName) implements Satisfaction {

    @Override
    public URL link() {
        throw new UnsupportedOperationException(); //TODO
    }

}

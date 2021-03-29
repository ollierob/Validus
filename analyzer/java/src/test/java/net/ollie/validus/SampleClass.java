package net.ollie.validus;

import net.ollie.validus.annotation.Satisfies;
import net.ollie.validus.annotation.Verifies;

class SampleClass {

    @Satisfies("A-1")
    String oneBar() {
        return null;
    }

    @Satisfies({"A-1", "B-2"})
    String twoBar() {
        return null;
    }

    @Verifies("B-2")
    String testBar() {
        return null;
    }

}

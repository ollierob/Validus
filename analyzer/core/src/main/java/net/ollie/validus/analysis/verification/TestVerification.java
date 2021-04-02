package net.ollie.validus.analysis.verification;

import java.net.URL;

public record TestVerification(String testClassName, String testName, URL link) implements Verification {

}

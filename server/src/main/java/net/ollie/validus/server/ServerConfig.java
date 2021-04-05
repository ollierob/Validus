package net.ollie.validus.server;

import java.util.Properties;

class ServerConfig {

    private final Properties props;

    ServerConfig(final Properties props) {
        this.props = props;
    }

    int port() {
        return Integer.parseInt((String) props.getOrDefault("port", "9080"));
    }

}

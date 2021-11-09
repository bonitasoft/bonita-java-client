package org.bonitasoft.testcontainers;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import static java.lang.String.format;
import static java.util.Collections.singletonList;

public class BonitaContainer extends GenericContainer<BonitaContainer> {

    public static final String BONITA_PATH = "/bonita";
    public static final String BONITA_VERSION = "bonita.version";

    public BonitaContainer() {
        this("bonita:" + System.getProperty(BONITA_VERSION, "latest"));
    }

    public BonitaContainer(String dockerImageName) {
        super(dockerImageName);
        this.setExposedPorts(singletonList(8080));
        this.setWaitStrategy(Wait.forHttp(BONITA_PATH));
    }

    public String getPortalUrl() {
        String host = this.getHost();
        Integer port = this.getFirstMappedPort();
        return format("http://%s:%s" + BONITA_PATH, host, port);
    }
}

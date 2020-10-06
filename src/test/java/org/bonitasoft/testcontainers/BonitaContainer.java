package org.bonitasoft.testcontainers;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import static java.util.Collections.singletonList;

public class BonitaContainer extends GenericContainer<BonitaContainer> {

    public BonitaContainer() {
        this("latest");
    }

    public BonitaContainer(String version) {
        super("bonita:" + version);
        this.setExposedPorts(singletonList(8080));
        this.setWaitStrategy(Wait.forHttp("/bonita"));
    }

    public String getPortalUrl() {
        String host = this.getHost();
        Integer port = this.getFirstMappedPort();
        return String.format("http://%s:%s/bonita", host, port);
    }
}

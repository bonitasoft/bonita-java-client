package org.bonitasoft.web.client.exception.process;

import lombok.Getter;
import org.bonitasoft.web.client.exception.ClientException;

public class ProcessException extends ClientException {

    @Getter
    protected String processName;
    @Getter
    protected String processVersion;

    public ProcessException(String message, String processName, String processVersion) {
        super(message);
        this.processName = processName;
        this.processVersion = processVersion;
    }

    public ProcessException(String message, Exception cause, String processName, String processVersion) {
        super(message, cause);
        this.processName = processName;
        this.processVersion = processVersion;
    }
}

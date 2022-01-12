package org.bonitasoft.web.client.exception.process;

import org.bonitasoft.web.client.exception.ClientException;

import lombok.Getter;

public class ProcessActivationException extends ClientException {

    private static final String MESSAGE_TEMPLATE = "Process '%s' in version '%s' can not be activated.";

    @Getter
    private final String processName;
    @Getter
    private final String processVersion;

    public ProcessActivationException(String message, String processName, String processVersion) {
        super(String.format(MESSAGE_TEMPLATE, processName, processVersion) + " " + message);
        this.processName = processName;
        this.processVersion = processVersion;
    }
}

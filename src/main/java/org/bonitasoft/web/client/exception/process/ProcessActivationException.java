package org.bonitasoft.web.client.exception.process;

public class ProcessActivationException extends ProcessException {

    private final static String MESSAGE_TEMPLATE = "Process '%s' in version '%s' can not be activated.";

    public ProcessActivationException(String message, String processName, String processVersion) {
        super(String.format(MESSAGE_TEMPLATE, processName, processVersion) + " " + message, processName, processVersion);
    }
}

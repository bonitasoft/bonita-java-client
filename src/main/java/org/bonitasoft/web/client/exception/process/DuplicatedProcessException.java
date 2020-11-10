package org.bonitasoft.web.client.exception.process;

public class DuplicatedProcessException extends ProcessException {

    private final static String MESSAGE_TEMPLATE = "Process '%s' in version '%s' already exists.";

    public DuplicatedProcessException(String message, String processName, String processVersion) {
        super(String.format(MESSAGE_TEMPLATE, processName, processVersion) + " " + message, processName, processVersion);
    }
}

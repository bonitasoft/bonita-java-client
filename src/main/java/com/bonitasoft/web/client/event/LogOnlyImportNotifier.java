/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.event;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogOnlyImportNotifier implements ImportNotifier {

    @Override
    public void post(ImportWarningEvent event) {
        log.warn(event.getMessage());
    }

}

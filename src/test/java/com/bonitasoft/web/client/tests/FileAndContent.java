package com.bonitasoft.web.client.tests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FileAndContent {
    private final String fileName;
    private final byte[] content;
}

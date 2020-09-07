/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.zafarkhaja.semver.Version;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.substringAfterLast;
import static org.apache.commons.lang3.StringUtils.substringBeforeLast;

/**
 * @author Laurent Leseigneur
 */
public class RestApiConverter {

    public final static RestApiConverter INSTANCE = new RestApiConverter();

    private static final String VERSION = "version";

    private final ObjectMapper objectMapper;

    private RestApiConverter() {
        objectMapper = new ObjectMapper()
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
    }

    public <T> List<T> listFromJson(String json, Class<T> elementClass) throws IOException {
        return objectMapper.readValue(json,
                objectMapper.getTypeFactory().constructCollectionType(List.class, elementClass));
    }

    public <T> T fromJson(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }

    public Version versionFromSessionJson(String json) throws IOException {
        MapLikeType type = objectMapper.getTypeFactory().constructMapLikeType(Map.class, String.class, String.class);
        Map<String, String> responseMap = objectMapper.readValue(json, type);
        String bonitaVersion = responseMap.get(VERSION);
        // manage our weekly versions. In that case, we do not always follow semver, versions look like 7.7.0.W07
        // semver compliant would be 7.7.0-W07. So without this extra step, we get the following error
        // "Unexpected character 'DOT(.)' at position '5', expecting '[HYPHEN, PLUS, EOI]'"
        String endOfTheVersion = substringAfterLast(bonitaVersion, ".");
        if (!endOfTheVersion.isEmpty()) {
            char first = endOfTheVersion.charAt(0);
            if ((int) first < 48 || (int) first > 57) { // not between 0 and 9, i.e not a number -> .alpha, .W89 ...
                bonitaVersion = substringBeforeLast(bonitaVersion, ".");
            }
        }
        Version rawVersion = new Version.Builder(bonitaVersion).build();
        // in case the raw version contains '-SNAPSHOT' or '-alpha' ...
        return new Version.Builder(rawVersion.getNormalVersion()).build();
    }

    public String buildSimpleJson(String parameterName, String parameterValue) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put(parameterName, parameterValue);
        return buildJson(map);
    }

    public String buildJson(Map<String, ?> map) throws IOException {
        return objectMapper.writer().writeValueAsString(map);
    }

    public String buildSimpleJson(List<String> parameterValue) throws IOException {
        return objectMapper.writer().writeValueAsString(parameterValue);
    }

}

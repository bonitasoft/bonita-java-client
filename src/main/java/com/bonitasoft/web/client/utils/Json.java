package com.bonitasoft.web.client.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Json {

    public static final ObjectMapper DEFAULT_MAPPER = new ObjectMapper().findAndRegisterModules();

    public static Map<String, Serializable> asMap(String parameterName, Serializable parameterValue) {
        Map<String, Serializable> map = new HashMap<>();
        map.put(parameterName, parameterValue);
        return map;
    }
}

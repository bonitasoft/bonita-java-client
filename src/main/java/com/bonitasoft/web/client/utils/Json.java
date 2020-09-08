package com.bonitasoft.web.client.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Json {

    public static Map<String, Serializable> asMap(String parameterName, Serializable parameterValue) {
        Map<String, Serializable> map = new HashMap<>();
        map.put(parameterName, parameterValue);
        return map;
    }
}

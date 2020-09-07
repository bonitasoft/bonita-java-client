/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.converters;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.github.zafarkhaja.semver.Version;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @author Baptiste Mesta.
 */
public class RetrofitRestApiConverter extends Converter.Factory {

    private final RestApiConverter restApiConverter;

    public RetrofitRestApiConverter() {
        restApiConverter = RestApiConverter.INSTANCE;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (isParameterizedList(type)) {
            return (Converter<ResponseBody, List<?>>) responseBody -> restApiConverter
                    .listFromJson(responseBody.string(), getClassArgumentFromParameterizedList(type));
        }

        if (type.equals(Version.class)) {
            return (Converter<ResponseBody, Version>) responseBody -> restApiConverter
                    .versionFromSessionJson(responseBody.string());
        }
        // General case
        if (type instanceof Class<?>) {
            return responseBody -> restApiConverter.fromJson(responseBody.string(), (Class<?>) type);
        }

        return null;
    }

    private static boolean isParameterizedList(Type type) {
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            return rawType.equals(List.class);
        }
        return false;
    }

    private static Class<?> getClassArgumentFromParameterizedList(Type type) {
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        return (Class<?>) actualTypeArguments[0];
    }

}

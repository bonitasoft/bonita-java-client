/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.converters;

import static com.bonitasoft.web.client.internal.converters.RestApiConverterTest.toDoubleQuote;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import  com.bonitasoft.web.client.model.Application;
import  com.bonitasoft.web.client.model.Page;
import  com.bonitasoft.web.client.model.Process;
import  com.bonitasoft.web.client.model.Profile;
import com.github.zafarkhaja.semver.Version;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;
import retrofit2.Converter;

/**
 * @author Baptiste Mesta.
 */
public class RetrofitRestApiConverterTest {

    @Rule
    public JUnitSoftAssertions softly = new JUnitSoftAssertions();

    private RetrofitRestApiConverter retrofitRestApiConverter = new RetrofitRestApiConverter();

    @Test
    public void should_convert_list_of_application() throws IOException {
        Converter<ResponseBody, ?> responseBodyConverter = responseBodyConverter(
                new ListParameterizedType(Application.class));
        List<Application> applications = (List<Application>) responseBodyConverter.convert(newResponseBody("[{" +
                "'displayName':'application display name'" +
                ",'id':'2'" +
                "}]"));
        softly.assertThat(applications).extracting(Application::getId).containsExactly(2L);
        softly.assertThat(applications).extracting(Application::getDisplayName)
                .containsExactly("application display name");
    }

    @Test
    public void should_convert_list_of_profiles() throws IOException {
        Converter<ResponseBody, ?> responseBodyConverter = responseBodyConverter(
                new ListParameterizedType(Profile.class));
        List<Profile> profiles = (List<Profile>) responseBodyConverter.convert(newResponseBody("[{" +
                "'name':'Administrator'" +
                ",'id':'2'" +
                "}]"));
        softly.assertThat(profiles).extracting(Profile::getId).containsExactly(2L);
        softly.assertThat(profiles).extracting(Profile::getName).containsExactly("Administrator");
    }

    @Test
    public void should_convert_list_of_page() throws IOException {
        Converter<ResponseBody, ?> responseBodyConverter = responseBodyConverter(new ListParameterizedType(Page.class));
        List<Page> pages = (List<Page>) responseBodyConverter.convert(newResponseBody("[{" +
                "'description':'page description'" +
                ",'id':'2'" +
                "}]"));
        softly.assertThat(pages).extracting(Page::getId).containsExactly(2L);
        softly.assertThat(pages).extracting(Page::getDescription).containsExactly("page description");
    }

    @Test
    public void should_convert_process() throws IOException {
        Converter<ResponseBody, ?> responseBodyConverter = responseBodyConverter(Process.class);
        Process process = (Process) responseBodyConverter.convert(newResponseBody("{" +
                "'id':'8216934689697197160'" +
                ",'name':'process name'" +
                "}"));

        softly.assertThat(process.getId()).isEqualTo(8216934689697197160l);
        softly.assertThat(process.getName()).isEqualTo("process name");
    }

    @Test
    public void should_convert_session_to_version() throws IOException {
        Converter<ResponseBody, ?> responseBodyConverter = responseBodyConverter(Version.class);
        Version version = (Version) responseBodyConverter.convert(newResponseBody("{" +
                "'user_id':'4'" +
                ",'session_id':'-3417256225131984474'" +
                ",'version':'7.5.4'" +
                "}"));

        assertThat(version).isEqualTo(Version.valueOf("7.5.4"));
    }

    // =================================================================================================================
    // UTILS
    // =================================================================================================================

    private Converter<ResponseBody, ?> responseBodyConverter(Type type) {
        return retrofitRestApiConverter.responseBodyConverter(type, null, null);
    }

    private static class ListParameterizedType implements ParameterizedType {

        private Class<?> listType;

        public ListParameterizedType(Class<?> listType) {
            this.listType = listType;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[] { listType };
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }

    private static ResponseBody newResponseBody(String singleQuoteJson) {
        return ResponseBody.create(MediaType.parse("application/json"), toDoubleQuote(singleQuoteJson));
    }

}

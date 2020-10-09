package org.bonitasoft.web.client;

import feign.Request;
import feign.RequestTemplate;
import feign.Response;
import feign.Util;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.bonitasoft.web.client.feign.decoder.DelegatingDecoder;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

class DecoderTest {


    @Test
    void decode() throws Exception {
        Decoder decoder = new DelegatingDecoder().register("application/json", new JacksonDecoder());
        Object decoded = decoder.decode(knownResponse(), String.class);
    }

    private Response knownResponse() {
        String content = "response body";
        InputStream inputStream = new ByteArrayInputStream(content.getBytes(UTF_8));
        Map<String, Collection<String>> headers = new HashMap<String, Collection<String>>();
        headers.put("Content-Type", Collections.singleton("text/plain"));
        return Response.builder()
                .status(200)
                .reason("OK")
                .headers(headers)
                .request(Request.create
                        (Request.HttpMethod.GET,
                                "/api",
                                Collections.emptyMap(),
                                null,
                                Util.UTF_8,
                                new RequestTemplate()
                        )
                )
                .body(inputStream, content.length())
                .build();
    }
}

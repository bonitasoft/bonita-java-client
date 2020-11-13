package org.bonitasoft.web.client.feign.interceptor;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.feign.interceptor.BonitaCharsetBugInterceptor.CONTENT_TYPE_HEADER;
import static org.mockito.Mockito.*;

import feign.RequestTemplate;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;

class BonitaCharsetBugInterceptorTest {

  @ParameterizedTest
  @ValueSource(
      strings = {
        "; charset=utf-8",
        ";charset=utf-8",
        "; charset=UTF-8",
        ";charset=UTF-8",
        "; Charset=utf-8",
        ";Charset=utf-8",
        "; Charset=UTF-8",
        ";Charset=UTF-8"
      })
  void clean_content_type(String charsetPart) {
    // Given
    BonitaCharsetBugInterceptor interceptor = new BonitaCharsetBugInterceptor();
    String baseContentType = "application/json";

    // When
    final String contentType = interceptor.cleanContentType(baseContentType + charsetPart);

    // Then
    assertThat(contentType).isEqualTo(baseContentType);
  }

  @Test
  void request_should_be_cleaned() throws IOException {
    // Given
    BonitaCharsetBugInterceptor interceptor = new BonitaCharsetBugInterceptor();
    final Request mockRequest =
        new Request.Builder()
            .url("http://dummy.org")
            .header(CONTENT_TYPE_HEADER, "application/json; charset=utf8")
            .build();
    Interceptor.Chain chain = mock(Interceptor.Chain.class);
    when(chain.request()).thenReturn(mockRequest);

    final ArgumentCaptor<Request> captor = ArgumentCaptor.forClass(Request.class);

    // When
    interceptor.intercept(chain);

    // Then
    verify(chain).proceed(captor.capture());
    assertThat(captor.getValue()).isNotEqualTo(mockRequest);
  }

  @Test
  void requestTemplate_should_be_cleaned() {
    // Given
    BonitaCharsetBugInterceptor interceptor = new BonitaCharsetBugInterceptor();
    String baseContentType = "application/json";
    RequestTemplate template =
        new RequestTemplate()
            .header(CONTENT_TYPE_HEADER, singletonList(baseContentType + "; charset=UTF-8"));

    // When
    interceptor.apply(template);

    // Then
    assertThat(template.headers().get(CONTENT_TYPE_HEADER)).containsOnly(baseContentType);
  }
}

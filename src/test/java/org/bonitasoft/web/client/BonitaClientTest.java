package org.bonitasoft.web.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BonitaClientTest {

    private BonitaClient client;

    @BeforeEach
    void setUp() {
        client = BonitaClient.newFeignBuilder("http://somewhere.org").build();
    }

    @Test
    void should() {
        // TODO
        assertThat(true).isTrue();
    }
}
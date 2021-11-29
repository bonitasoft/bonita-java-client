package org.bonitasoft.web.client.services.impl;

import java.io.File;

import org.bonitasoft.web.client.exception.ClientException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.bonitasoft.web.client.TestUtils.getClasspathFile;

@ExtendWith(MockitoExtension.class)
class BusinessArchiveInfoTest {

    @Test
    void should_extract_process_info() throws Exception {
        // Given
        File processFile = getClasspathFile("/bconf/Pool-1.0.bar");

        // When
        final BusinessArchiveInfo archiveInfo = BusinessArchiveInfo.readFrom(processFile);

        // Then
        assertThat(archiveInfo.getArchive()).isEqualTo(processFile);
        assertThat(archiveInfo.getProcessName()).isEqualTo("Pool");
        assertThat(archiveInfo.getProcessVersion()).isEqualTo("1.0");
    }

    @Test
    void should_throw_ClientException__on_bad_archive() throws Exception {
        // Given
        File bdmFile = getClasspathFile("/bdm.zip");

        // When
        assertThatThrownBy(() -> BusinessArchiveInfo.readFrom(bdmFile))
                .isInstanceOf(ClientException.class);
    }
}

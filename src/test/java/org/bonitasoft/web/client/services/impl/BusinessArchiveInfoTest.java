/** 
 * Copyright (C) 2023 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.bonitasoft.web.client.TestUtils.getClasspathFile;

import java.io.File;

import org.bonitasoft.web.client.exception.ClientException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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

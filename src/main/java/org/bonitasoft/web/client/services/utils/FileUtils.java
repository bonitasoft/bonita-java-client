/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client.services.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/** @author Baptiste Mesta. */
public final class FileUtils {

	private FileUtils() {
		// Utility class
	}

	public static byte[] getFileFromZip(File zip, String filePath) throws IOException {
		try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zip))) {
			ZipEntry zipEntry;
			while ((zipEntry = zipInputStream.getNextEntry()) != null) {
				if (zipEntry.getName().equals(filePath) && !zipEntry.isDirectory()) {
					return readFully(zipInputStream);
				}
			}
			throw new FileNotFoundException(String.format("Entry %s not found in zip", filePath));
		}
	}

	public static byte[] readFully(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n;
		while ((n = in.read(buf)) > 0) {
			out.write(buf, 0, n);
		}
		return out.toByteArray();
	}
}

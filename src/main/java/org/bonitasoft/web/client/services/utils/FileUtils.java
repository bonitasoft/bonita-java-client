/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client.services.utils;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.*;
import java.nio.file.*;
import java.nio.file.FileSystem;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/** @author Baptiste Mesta. */
public final class FileUtils {

  private FileUtils() {
    // Utility class
  }

  public static byte[] getFileFromZip(File zip, String filePath) throws IOException {
    try (InputStream inputStream = new FileInputStream(zip)) {
      return getFileFromZip(inputStream, filePath);
    }
  }

  public static void updateFileContent(File zip, String filePath, InputStream newContent)
      throws IOException {
    Path zipFilePath = zip.toPath();
    try (FileSystem fs = FileSystems.newFileSystem(zipFilePath, null)) {
      Path source = fs.getPath(filePath);
      Path temp = fs.getPath("./temp_" + UUID.randomUUID().toString());
      Files.write(temp, readFully(newContent), StandardOpenOption.CREATE_NEW);
      Files.move(temp, source, REPLACE_EXISTING);
    }
  }

  public static byte[] getFileFromZip(InputStream inputStream, String filePath) throws IOException {
    try (ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
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

  public static String read(File file) throws IOException {
    try (InputStream inputStream = new FileInputStream(file)) {
      return new String(readFully(inputStream), UTF_8);
    }
  }

  public static byte[] readFully(File file) throws IOException {
    try (InputStream inputStream = new FileInputStream(file)) {
      return readFully(inputStream);
    }
  }

  public static boolean isBarFile(File file) {
    return file.getName().endsWith(".bar");
  }

  public static boolean isXmlFile(File file) {
    return file.getName().endsWith(".xml");
  }

  public static boolean isZipFile(File file) {
    return file.getName().endsWith(".zip");
  }
}

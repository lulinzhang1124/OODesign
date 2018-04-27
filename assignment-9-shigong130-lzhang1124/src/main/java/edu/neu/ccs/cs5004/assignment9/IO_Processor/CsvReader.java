package edu.neu.ccs.cs5004.assignment9.IO_Processor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * Represents a csv reader class.
 */
public class CsvReader {

  /**
   * Read files and return the whole file msg as a string.
   *
   *
   * @param file - file path.
   * @return - a string represents all the content inside the file.
   * @throws IOException -
   */
  public static String fileReader(String file) throws IOException {
    StringBuilder sb = new StringBuilder();

    InputStream in = new FileInputStream(file);
    Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
    BufferedReader br = new BufferedReader(reader);
    String line;
    try {
      while ((line = br.readLine()) != null) {
        sb.append(line);
        sb.append(System.getProperty("line.separator"));
      }
    } finally {
      br.close();
    }

    return sb.toString();
  }
}

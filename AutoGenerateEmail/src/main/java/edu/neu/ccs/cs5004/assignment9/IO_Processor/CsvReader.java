package edu.neu.ccs.cs5004.assignment9.IO_Processor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class CsvReader {

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

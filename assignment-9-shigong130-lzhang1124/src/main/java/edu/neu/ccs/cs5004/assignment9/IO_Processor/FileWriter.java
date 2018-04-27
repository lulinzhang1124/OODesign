package edu.neu.ccs.cs5004.assignment9.IO_Processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class FileWriter {
  /**
   * Writes the string to the file.
   * @param file the file where the string is written.
   * @param str a string
   */
  public static void writeStringToFile(File file, String str) throws IOException {
    OutputStream out = new FileOutputStream(file);
    Writer writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
    BufferedWriter bw = new BufferedWriter(writer);
    try {
      bw.write(str);
    } finally {
      bw.flush();
      bw.close();
    }
  }
}

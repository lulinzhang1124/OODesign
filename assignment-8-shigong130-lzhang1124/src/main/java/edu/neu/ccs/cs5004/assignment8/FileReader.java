package edu.neu.ccs.cs5004.assignment8;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a file reader class.
 */
public class FileReader {

  /**
   * This method is used to read the data.
   *
   * @param filepath name of the file
   * @return a list of string that all lines in the file is added
   */
  public static List<String> readFileLines(String filepath) {
    List<String> list = new ArrayList<>();
    try {
      InputStream inputStream = new FileInputStream(filepath);
      Reader temp = new InputStreamReader(inputStream, "UTF-8");
      BufferedReader reader = new BufferedReader(temp);

      String line = reader.readLine();

      while (line != null) {
        list.add(line);
        line = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Error on reading file " + filepath);
    }
    return list;
  }


}

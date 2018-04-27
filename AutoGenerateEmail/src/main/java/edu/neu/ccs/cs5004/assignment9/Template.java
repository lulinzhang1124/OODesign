package edu.neu.ccs.cs5004.assignment9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.neu.ccs.cs5004.assignment9.IO_Processor.CsvReader;

public class Template implements ITemplate{
  private static final String REGEX = "\\[\\[([^\\]]*)\\]\\]"; // regex to find the placeholders
  private final String templateText;
  private final List<String> placeholders;

  /**
   * Constructs a Template object. Converts the email template text file to a string,
   * and finds placeholders in the email template.
   *
   * @param templateFileName a filename that holds the email template
   */
  public Template(String templateFileName) throws IOException {
    templateText = CsvReader.fileReader(templateFileName);
    placeholders = findPlaceholders(templateText);
  }

  private List<String> findPlaceholders(String templateText) {
    List<String> placeholders = new ArrayList<>();
    Pattern pattern = Pattern.compile(REGEX);
    Matcher matcher = pattern.matcher(templateText);
    while (matcher.find()) {
      placeholders.add(matcher.group(1));
    }
    return placeholders;
  }

  /**
   * Replaces the placeholders by information provided by the Processor object.
   *
   * @param processor an Processor
   * @return an Email object that contains the email to the passenger
   */
  @Override
  public Idocument toDocument(Processor processor) {
    String file = templateText;
    for (String placeholder : placeholders) {
      String value = processor.getValue(placeholder);
      if (value == null) {
        throw new IllegalArgumentException("Cannot determine placeholder information: "
            + placeholder);
      }
      file = file.replaceAll("\\[\\[" + placeholder + "\\]\\]", value);
    }
    return new Document(file);
  }
}

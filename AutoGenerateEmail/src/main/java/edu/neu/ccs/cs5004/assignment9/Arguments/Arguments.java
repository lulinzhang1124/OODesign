package edu.neu.ccs.cs5004.assignment9.Arguments;

import java.util.HashMap;
import java.util.Map;

public class Arguments implements Iarguments{
  private static final String EMAIL = "--email";
  private static final String EMAIL_TEMPLATE = "--email-template";
  private static final String OUTPUT_DIR = "--output-dir";
  private static final String CSV_FILE = "--csv-file";

  private static final String USAGE_MSG =
      "Usage: \n\n"
          + "--email                   only generate email messages\n\n"
          + "--email-template <file>   accepts a filename that holds the email template\n"
          + "                          Required if --email is used\n\n"
         // + "--letter                  only generate letters\n\n"
         //  + "--letter-template <file>  accepts a filename that holds the letter template\n"
         // + "                          Required if --email is used\n\n"
          + "--output-dir <path>       accepts the name of a folder, all output is placed\n"
          + "                          in this folder\n\n"
          + "--csv-file <path>         accepts the name of the csv file to process\n\n"

          + "For example:\n"
          + "--email --email-template email-template.txt --output-dir emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir letters --csv-file customer.csv\n";



  private final Map<String, String> userInput; // stores the user-input arguments
  private final StringBuilder errorMsg; // stores error message

  /**
   * Constructs a new Argument with the given String array. Initializes the userInput as
   * a HashMap that stores user input information with attributes as keys. Initializes
   * the errorMsg as an empty StringBuilder. Parses the arguments and stores information
   * in userInput map.
   *
   * @param args a String array
   */
  public Arguments(String[] args) {
    userInput = new HashMap<>();
    userInput.put(EMAIL,null);
    userInput.put(EMAIL_TEMPLATE, null);
    userInput.put(OUTPUT_DIR, null);
    userInput.put(CSV_FILE, null);

    errorMsg = new StringBuilder();

    parseArgs(args);
  }

  // parses the arguments and puts them in map if arguments are in legal format.
  private void parseArgs(String[] args) {
    int i = 0;

    while (i < args.length) {

      String arg = args[i++];

      // if this arg is not a header, continue
      if (!isHeader(arg)) continue;

      // if this arg is a header but can not be recognized,
      // appends error message and continue
      if (!isRecognizable(arg)) {
        errorMsg.append(arg);
        errorMsg.append(" cannot be recognized\n");
        continue;
      }

      // if this argument is the last argument,
      // or if next argument is also a header, appends error message and continue
      if (i >= args.length || isHeader(args[i])) {
        errorMsg.append(arg);
        errorMsg.append(" was given without providing appropriate argument\n");
        continue;
      }

      // validates the format of argument and puts it in user input map
      if (validate(arg, args[i])) {
        userInput.put(arg, args[i++]);
      } else {
        i++;
      }
    }
  }

  // returns true if the argument starts with "--"
  private boolean isHeader(String arg) {
    return arg.startsWith("--");
  }

  // returns true if the argument is one of the keys in user input map
  private boolean isRecognizable(String arg) {
    return userInput.containsKey(arg);
  }

  private boolean validate(String header, String arg) {
    if (header.equals(EMAIL_TEMPLATE)) {
      return validateEmailTemplate(arg);
    }
   //

    return true;
  }

  // returns true if the provided email template is a text file,
  // returns false and appends error message otherwise
  private boolean validateEmailTemplate(String template) {
    if (template.endsWith(".txt")) {
      return true;
    } else {
      errorMsg.append(EMAIL_TEMPLATE);
      errorMsg.append(" argument does not provide a text filename\n");
      return false;
    }
  }




  /**
   * Returns true if the required information -- email template, output directory,
   * csv file and event detail -- are provided in legal format.
   *
   * @return true if arguments are in legal format and false otherwise.
   */
  @Override
  public boolean isLegalFormat() {
    return userInput.get(EMAIL) != null
        && userInput.get(EMAIL_TEMPLATE) != null
        && userInput.get(OUTPUT_DIR) != null
        && userInput.get(CSV_FILE) != null;
  }

  /**
   * Returns the error message.
   *
   * @return the error message if arguments are in illegal format; null if arguments are in
   * legal format.
   */
  @Override
  public String getErrorMessage() {
    if (isLegalFormat()) return null;
    if (errorMsg.toString().equals("")) {
      errorMsg.append("Some required arguments are missing! Please see the example below.\n");
    }
    return "Error:\n\n" + errorMsg.toString() + "\n" + USAGE_MSG;
  }

  /**
   * Returns a filename that holds the email template; null if arguments are not in legal format.
   *
   * @return a filename that holds the email template; null if arguments are not in legal format.
   */
  @Override
  public String getTemplate() {
    if (!isLegalFormat()) return null;
    return userInput.get(EMAIL_TEMPLATE);
  }

  /**
   * Returns the name of a folder that will store all output; null if arguments are
   * not in legal format.
   * @return the name of a folder that will store all output; null if arguments are
   * not in legal format.
   */
  @Override
  public String getOutputDir() {
    if (!isLegalFormat()) return null;
    return userInput.get(OUTPUT_DIR);
  }

  /**
   * Returns the name of csv file; null if arguments are not in legal format
   *
   * @return the name of csv file; null if arguments are not in legal format
   */
  @Override
  public String getCsvFile() {
    if (!isLegalFormat()) return null;
    return userInput.get(CSV_FILE);
  }



}

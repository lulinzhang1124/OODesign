package edu.neu.ccs.cs5004.assignment9.Arguments;

import java.util.HashMap;
import java.util.Map;

public abstract class AbsArguments implements Iarguments{

  private static final String OUTPUT_DIR = "--output-dir";
  private static final String CSV_FILE = "--csv-file";

  private static final String USAGE_MSG =
      "Usage: \n\n"
          + "--email                   only generate email messages\n\n"
          + "--email-template <file>   accepts a filename that holds the email template\n"
          + "                          Required if --email is used\n\n"
          + "--letter                  only generate letters\n\n"
          + "--letter-template <file>  accepts a filename that holds the letter template\n"
          + "                          Required if --email is used\n\n"
          + "--output-dir <path>       accepts the name of a folder, all output is placed\n"
          + "                          in this folder\n\n"
          + "--csv-file <path>         accepts the name of the csv file to process\n\n"

          + "For example:\n"
          + "--email --email-template email-template.txt --output-dir emails --csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir letters --csv-file customer.csv\n";



  private final Map<String, String> userInput; // stores the user-input arguments
  private final StringBuilder errorMsg; // stores error message

  public AbsArguments(String[] args) {
    userInput = new HashMap<>();

    userInput.put(OUTPUT_DIR, null);
    userInput.put(CSV_FILE, null);

    errorMsg = new StringBuilder();

    parseArgs(args);
  }

  void parseArgs(String[] args) {
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

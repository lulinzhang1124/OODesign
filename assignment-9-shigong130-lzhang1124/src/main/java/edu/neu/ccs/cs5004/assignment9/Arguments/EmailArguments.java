//package edu.neu.ccs.cs5004.assignment9.Arguments;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class EmailArguments extends Arguments {
//  private static final String EMAIL = "--email";
//  private static final String EMAIL_TEMPLATE = "--email-template";
//
//
//  /**
//   * Gets the usage message based on different concrete class.
//   *
//   * @return - a string served as usage message.
//   */
//  @Override
//  protected String usageMsg() {
//    return "Usage: \n\n"
//            + "--email                   only generate email messages\n\n"
//            + "--email-template <file>   accepts a filename that holds the email template\n"
//            + "                          Required if --email is used\n\n"
//            + "--output-dir <path>       accepts the name of a folder, all output is placed\n"
//            + "                          in this folder\n\n"
//            + "--csv-file <path>         accepts the name of the csv file to process\n\n"
//            + "For example:\n"
//            + "--email --email-template email-template.txt " +
//            "--output-dir emails --csv-file customer.csv\n"
//            + "--letter --letter-template letter-template.txt " +
//            "--output-dir letters --csv-file customer.csv\n";
//  }
//
//  /**
//   * Constructs a new Argument with the given String array. Initializes the userInput as
//   * a HashMap that stores user input information with attributes as keys. Initializes
//   * the errorMsg as an empty StringBuilder. Parses the arguments and stores information
//   * in userInput map.
//   *
//   * @param args a String array
//   */
//  public EmailArguments(String[] args) {
//
//    super(args);
//
//    super.userInput.put(EMAIL, null);
//    super.userInput.put(EMAIL_TEMPLATE, null);
//
//    parseArgs(args);
//  }
//
//
//  /**
//   * Returns true if the required information -- email template, output directory,
//   * csv file and event detail -- are provided in legal format.
//   *
//   * @return true if arguments are in legal format and false otherwise.
//   */
//  @Override
//  public boolean isLegalFormat() {
//    return userInput.get(EMAIL) != null
//            && userInput.get(EMAIL_TEMPLATE) != null
//            && super.isLegalFormat();
//  }
//
//
//  /**
//   * Returns a filename that holds the email template; null if arguments are not in legal format.
//   *
//   * @return a filename that holds the email template; null if arguments are not in legal format.
//   */
//  @Override
//  public String getTemplate() {
//    if (!isLegalFormat()) return null;
//    return userInput.get(EMAIL_TEMPLATE);
//  }
//
//
//}

package edu.neu.ccs.cs5004.assignment9.Arguments;

public interface Iarguments {

  /**
   * Returns true if the required information -- request, template, output directory,
   * and csv file -- are provided in legal format.
   *
   * @return true if arguments are in legal format and false otherwise.
   */
  boolean isLegalFormat();

  /**
   * Returns the error message if arguments are in illegal format; null if arguments are in
   * legal format.
   *
   * @return the error message if arguments are in illegal format; null if arguments are in
   * legal format.
   */
  String getErrorMessage();

  /**
   * Returns a filename that holds the email template.
   *
   * @return a filename that holds the email template. null if arguments are not in legal format.
   */
  String getTemplate();

  /**
   * Returns the name of a folder that will store all output.
   *
   * @return the name of a folder that will store all output. null if arguments are
   * not in legal format.
   */
  String getOutputDir();

  /**
   * Returns the name of csv file.
   *
   * @return the name of csv file. null if arguments are not in legal format.
   */
  String getCsvFile();

}

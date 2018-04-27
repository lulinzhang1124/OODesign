package edu.neu.ccs.cs5004.assignment10;

/**
 * Represents the interface of a cmd argument.
 */
public interface ICmdArgument {

  /**
   * Return true if the input arguments are valid.
   *
   * @return true if the input arguments are valid, false otherwise.
   */
  boolean isValid();

  /**
   * Returns the error message if the input arguments are invalid.
   *
   * @return the error message if the input arguments are invalid.
   */
  String getErrorMessage();

  /**
   * Returns the number of distinct bank clients.
   *
   * @return the number of distinct bank clients.
   */
  int getNumClients();

  /**
   * Returns the number of verifications.
   *
   * @return the number of verifications.
   */
  int getNumVerifications();

  /**
   * Returns the fraction of invalid messages.
   *
   * @return the fraction of invalid messages.
   */
  double getFraction();

  /**
   * Returns the output file name.
   *
   * @return the output file name.
   */
  String getOutputDir();
}

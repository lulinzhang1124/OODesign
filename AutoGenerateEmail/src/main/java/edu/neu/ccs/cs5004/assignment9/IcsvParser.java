package edu.neu.ccs.cs5004.assignment9;

import java.util.List;

public interface IcsvParser {

  /**
   * Returns a list of lists of string, the strings are tokens in the original csv file.
   * @return a list of lists of string
   */
  List<List<String>> getTokens();
}

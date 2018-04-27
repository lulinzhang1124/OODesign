package edu.neu.ccs.cs5004.assignment9;

import java.util.List;

public interface Idata {
  /**
   * Returns the headers in csv file.
   * @return headers in csv file
   */
  List<String> getHeaders();

  /**
   * Returns true if there exists next passenger.
   * @return true if there exists next passenger, false otherwise
   */
  boolean hasNext();

  /**
   * Returns a list of string that contains information of next passenger.
   * @return a list of string that contains information of next passenger.
   */
  List<String> nextLine();

}

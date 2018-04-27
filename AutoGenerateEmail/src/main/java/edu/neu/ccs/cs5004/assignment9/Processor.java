package edu.neu.ccs.cs5004.assignment9;

import java.util.List;

public interface Processor {

  /**
   * Returns the value to the corresponding placeholder.
   * @param placeholder a string
   * @return the value
   */
  String getValue(String placeholder);

  void updateProcessor(List<String> headers, List<String> info);

}

package edu.neu.ccs.cs5004.assignment7.problem3;

import java.util.List;
import java.util.Map;

/**
 * Represents an interface for skill index.
 */
public interface IskillIndex {

  /**
   * Given a map, swap its key and its value.
   *
   * @param map - a map that has a string as its key and a list of integers as it values.
   * @return - a new map with its keys and values swapped.
   */
  Map<Integer, List<String>> convert(Map<String, List<Integer>> map);
}

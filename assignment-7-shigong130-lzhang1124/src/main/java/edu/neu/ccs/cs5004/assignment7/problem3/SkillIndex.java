package edu.neu.ccs.cs5004.assignment7.problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a skill index class.
 */
public class SkillIndex implements IskillIndex{

  /**
   * Given a map, swap its key and its value.
   *
   * @param map - a map that has a string as its key and a list of integers as it values.
   * @return - a new map with its keys and values swapped.
   */
  public Map<Integer, List<String>> convert(Map<String, List<Integer>> map) {
    Map<Integer, List<String>> res = new HashMap<>();

    for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
      for (Integer val : entry.getValue()) {
        if (!res.containsKey(val)) {

          List<String> list = new ArrayList<>();
          list.add(entry.getKey());
          res.put(val, list);
        } else {
          List<String> list = res.get(val);
          list.add(entry.getKey());
        }
      }
    }
    return res;
  }
}

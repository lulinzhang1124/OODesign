package edu.neu.ccs.cs5004.assignment4.problem2;

/**
 * Represents a set.
 */

public interface Set {

  /**
   * Create an empty set.
   *
   * @return an empty set.
   */
  static Set emptySet() {
    return new EmptySet();
  }

  /**
   * Indicate if a set is empty or not.
   *
   * @return true is set is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Add an integer in the set.
   *
   * @param num the integer to be added.
   * @return the update set
   */
  Set add(Integer num);

  /**
   * Indicate if the set contains an integer or not.
   *
   * @param num the integer used to check
   * @return true if the set has the integer, false otherwise.
   */
  Boolean contains(Integer num);

  /**
   * Remove element from the set.
   * If set doesn't contain the element, return the original set.
   *
   * @param ele the element to be removed.
   * @return the update set with the element removed.
   */
  Set remove(Integer ele);

  /**
   * Get the size of the set.
   *
   * @return the size of the set.
   */
  Integer size();

  /**
   * Get the set union.
   *
   * @param set given set
   * @return the new set which is the set union of the original set and given set {@code set}.
   */
  Set union(Set set);

  /**
   * Get the intersection union.
   *
   * @param set given set
   * @return the new set which is the intersection union of the original set and the given set.
   */
  Set intersection(Set set);

  /**
   * Get the set symmetric difference.
   *
   * @param set given set
   * @return the new set which is the set difference of the original set and the given set.
   */
  Set difference(Set set);

  /**
   * Indicate the original set is the subset of {@code set} or not.
   *
   * @param set given set
   * @return true if the original set is the subset of {@code set}, false otherwise.
   */
  Boolean subset(Set set);


}

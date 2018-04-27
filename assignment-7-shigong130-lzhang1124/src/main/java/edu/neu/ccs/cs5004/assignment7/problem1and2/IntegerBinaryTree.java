package edu.neu.ccs.cs5004.assignment7.problem1and2;

/**
 * Represents an Integer Binary Tree.
 */
public interface IntegerBinaryTree {

  Integer ONE = 1;

  /**
   * Create an empty integer binary tree.
   *
   * @return an empty integer binary tree.
   */
  static Ibt createEmptyIbt() {
    return new Ibt(null);
  }

  /**
   * Add an integer to new the tree.
   *
   * @param ele the integer to be added.
   * @return the updated ibt.
   */
  IntegerBinaryTree add(Integer ele);

  /**
   * Indicate if the ibt is empty or not.
   *
   * @return true if the tree is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Indicate if the ibt contains the given integer or not.
   *
   * @param ele the given integer.
   * @return true if the ibt contains the given integer, false otherwise.
   */
  Boolean contains(Integer ele);

  /**
   * Indicate if the ibt is a valid binary search tree.
   *
   * @return true if the ibt is a valid binary search tree, false otherwise.
   */
  Boolean isBst();
}

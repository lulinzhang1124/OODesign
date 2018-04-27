package edu.neu.ccs.cs5004.assignment7.problem1and2;

/**
 * Represents an integer binary search tree.
 */
public interface IntegerBinarySearchTree extends IntegerBinaryTree {

  /**
   * Delete the given integer in the tree.
   *
   * @param element the integer to be deleted.
   * @return the updated ibst.
   */
  IntegerBinarySearchTree deleteNode(Integer element);

  /**
   * Get the mirror binary tree.
   *
   * @return an ibt which is the mirror of the original ibst.
   */
  IntegerBinaryTree mirror();

  /**
   * Get the ibst's iterator by inorder.
   *
   * @return the inorder iterator.
   */
  InorderIterator inorderIterator();

  /**
   * Get the ibst's iterator by preorder.
   *
   * @return the preorder iterator.
   */
  PreorderIterator preorderIterator();

  /**
   * Get the ibst's iterator by postorder.
   *
   * @return the postorder iterator.
   */
  PostorderIterator postorderIterator();


}

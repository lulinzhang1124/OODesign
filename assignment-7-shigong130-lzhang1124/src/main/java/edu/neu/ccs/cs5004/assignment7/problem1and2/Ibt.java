package edu.neu.ccs.cs5004.assignment7.problem1and2;

import java.util.Objects;

/**
 * Represents an integer binary tree.
 */
public class Ibt implements IntegerBinaryTree {

  protected TreeNode root;


  public Ibt(TreeNode root) {
    this.root = root;
  }

  /**
   * Add the given integer to given treenode.
   *
   * @param current given treenode.
   * @param value   given integer.
   * @return the updated treenode.
   */
  private TreeNode addRecursive(TreeNode current, int value) {
    if (current == null) {
      return new TreeNode(value);
    }

    if (value < current.val) {
      current.left = addRecursive(current.left, value);
    } else if (value > current.val) {
      current.right = addRecursive(current.right, value);
    } else {
      // value already exists
      return current;
    }

    return current;
  }

  @Override
  public IntegerBinaryTree add(Integer ele) {
    root = addRecursive(root, ele);
    return this;
  }

  @Override
  public Boolean isEmpty() {
    return root == null;
  }

  /**
   * Indicated if the given treenode has the given integer or not.
   *
   * @param current the given treenode.
   * @param value   the given integer.
   * @return true if the treenode has the given integer, false otherwise.
   */
  private boolean containsNodeRecursive(TreeNode current, int value) {
    if (current == null) {
      return false;
    }
    if (value == current.val) {
      return true;
    }
    if (root.val > value) {
      return containsNodeRecursive(current.left, value);
    } else {
      return containsNodeRecursive(current.right, value);
    }
  }

  @Override
  public Boolean contains(Integer ele) {

    return containsNodeRecursive(root, ele);

  }

  @Override
  public Boolean isBst() {
    return isBstRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  /**
   * Indicates if the given treenode is a binary search tree or not.
   *
   * @param root the given treenode.
   * @return true if given treenode is a valid bst, false otherwise.
   */
  private boolean isBstRecursive(TreeNode root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.val > max || root.val < min) {
      return false;
    }

    return isBstRecursive(root.left, min, root.val - ONE)
        && isBstRecursive(root.right, root.val + ONE, max);

  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Ibt ibt = (Ibt) obj;
    return Objects.equals(root, ibt.root);
  }

  @Override
  public int hashCode() {

    return Objects.hash(root);
  }

  @Override
  public String toString() {
    return "Ibt{" + "root=" + root + '}';
  }
}

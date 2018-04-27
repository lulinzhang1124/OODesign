package edu.neu.ccs.cs5004.assignment7.problem1and2;

/**
 * Represents an integer binary search tree.
 */
public class Ibst extends Ibt implements IntegerBinarySearchTree {

  public Ibst(TreeNode root) {
    super(root);
  }

  @Override
  public IntegerBinarySearchTree deleteNode(Integer element) {
    if (contains(element)) {
      return new Ibst(deleteRecursive(root, element));
    }
    return this;
  }

  /**
   * Delete the given value's node.
   *
   * @param current the current node.
   * @param value   the integer to be deleted.
   * @return the updated treenode.
   */
  private TreeNode deleteRecursive(TreeNode current, int value) {
    if (current == null) {
      return null;
    }

    if (value == current.val) {
      if (current.left == null && current.right == null) {
        return null;
      }
      if (current.right == null) {
        return current.left;
      }
      if (current.left == null) {
        return current.right;
      }

      int smallestValue = leftMost(current.right);
      current.val = smallestValue;
      current.right = deleteRecursive(current.right, smallestValue);
      return current;

    }

    if (value < current.val) {
      current.left = deleteRecursive(current.left, value);
      return current;
    } else {
      current.right = deleteRecursive(current.right, value);
      return current;
    }
  }

  /**
   * Get the left most node of the given treenode.
   *
   * @param root the given treenode.
   * @return the left most treenode.
   */
  private int leftMost(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root.val;
  }

  @Override
  public IntegerBinaryTree mirror() {
    TreeNode mirrorRoot = root;
    mirrorHelper(mirrorRoot);

    return new Ibt(mirrorRoot);

  }

  /**
   * Get the mirror treenode of the given treenode.
   *
   * @param mirrorRoot given treenode.
   * @return the mirror treenode of given treenode.
   */
  private TreeNode mirrorHelper(TreeNode mirrorRoot) {

    if (mirrorRoot == null) {
      return mirrorRoot;
    }

    TreeNode left = mirrorHelper(mirrorRoot.left);
    TreeNode right = mirrorHelper(mirrorRoot.right);

    mirrorRoot.left = right;
    mirrorRoot.right = left;

    return mirrorRoot;
  }

  @Override
  public Boolean isBst() {
    return true;
  }

  @Override
  public InorderIterator inorderIterator() {
    return new InorderIterator(root);
  }

  @Override
  public PreorderIterator preorderIterator() {
    return new PreorderIterator(root);
  }

  @Override
  public PostorderIterator postorderIterator() {
    return new PostorderIterator(root);
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return "Ibst{" + "root=" + root + '}';
  }

}

package edu.neu.ccs.cs5004.assignment7.problem1and2;

/**
 * Represents an inorder iterator.
 */
public class InorderIterator extends AbsIterator {

  public InorderIterator(TreeNode root) {
    super();
    inorder(root);
  }

  /**
   * Traverse the tree by inorder.
   *
   * @param root the treenode to be traversed.
   */
  private void inorder(TreeNode root) {
    if (root != null) {
      inorder(root.left);
      list.add(root);
      inorder(root.right);
    }
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
    return "InorderIterator{" + "list=" + list
        + ", index=" + index
        + '}';
  }
}

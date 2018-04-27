package edu.neu.ccs.cs5004.assignment7.problem1and2;

/**
 * Represents a preorder iterator.
 */
public class PreorderIterator extends AbsIterator {

  public PreorderIterator(TreeNode root) {
    super();
    preorder(root);
  }

  /**
   * Traverse the given treenode by preorder.
   *
   * @param root the given treenode.
   */
  private void preorder(TreeNode root) {
    if (root != null) {
      list.add(root);
      preorder(root.left);
      preorder(root.right);
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
    return "PreorderIterator{"
        + "list=" + list + ", index=" + index
        + '}';
  }
}

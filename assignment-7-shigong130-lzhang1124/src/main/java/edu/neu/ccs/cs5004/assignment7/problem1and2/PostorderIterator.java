package edu.neu.ccs.cs5004.assignment7.problem1and2;

/**
 * Represents a postorder iterator.
 */
public class PostorderIterator extends AbsIterator {

  public PostorderIterator(TreeNode root) {
    super();
    postorder(root);
  }

  /**
   * Traverse the treenode by postorder.
   *
   * @param root the treenode to be traversed.
   */
  private void postorder(TreeNode root) {
    if (root != null) {
      postorder(root.left);
      postorder(root.right);
      list.add(root);
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
    return "PostorderIterator{"
        + "list=" + list + ", index=" + index + '}';
  }
}

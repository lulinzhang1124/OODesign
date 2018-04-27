package edu.neu.ccs.cs5004.assignment7.problem1and2;

import java.util.Objects;

/**
 * Represents a treenode.
 */
public class TreeNode {
  protected int val;
  protected TreeNode left;
  protected TreeNode right;

  public TreeNode(Integer val) {
    this.val = val;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    TreeNode treeNode = (TreeNode) obj;
    return val == treeNode.val
        && Objects.equals(left, treeNode.left)
        && Objects.equals(right, treeNode.right);
  }

  @Override
  public int hashCode() {

    return Objects.hash(val, left, right);
  }

  @Override
  public String toString() {
    return "TreeNode{" + "val=" + val + ", left="
        + left + ", right=" + right + '}';
  }
}

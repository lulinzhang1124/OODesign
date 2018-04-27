package edu.neu.ccs.cs5004.assignment7.problem1and2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PreorderIteratorTest {

  private PreorderIterator preorderIterator;
  private PreorderIterator sameRefpreorderIterator;
  private PreorderIterator sameStatepreorderIterator;
  private TreeNode t4;
  private TreeNode t1;
  private TreeNode t2;
  private TreeNode t3;
  private TreeNode t6;

  @Before
  public void setUp() throws Exception {
    t4 = new TreeNode(4);
    t2 = t4.left = new TreeNode(2);
    t6 = t4.right = new TreeNode(6);
    t3 = t4.left.right = new TreeNode(3);
    t1 = t4.left.left = new TreeNode(1);
    preorderIterator = new PreorderIterator(t4);
    sameRefpreorderIterator = preorderIterator;

    TreeNode node = new TreeNode(4);
    node.left = new TreeNode(2);
    node.right = new TreeNode(6);
    node.left.left = new TreeNode(1);
    node.left.right = new TreeNode(3);
    sameStatepreorderIterator = new PreorderIterator(node);
  }

  @Test
  public void equals() {
    PreorderIterator diffIterator = new PreorderIterator(new TreeNode(4));
    assertTrue(preorderIterator.equals(preorderIterator));
    assertTrue(preorderIterator.equals(sameRefpreorderIterator));
    assertTrue(preorderIterator.equals(sameStatepreorderIterator));
    assertFalse(preorderIterator.equals(null));
    assertFalse(preorderIterator.equals(5));
    assertFalse(preorderIterator.equals(diffIterator));
    sameStatepreorderIterator.next();
    assertFalse(preorderIterator.equals(sameStatepreorderIterator));
  }

  @Test
  public void hashCodeTest() {
    assertTrue(preorderIterator.hashCode() == sameRefpreorderIterator.hashCode());
    assertTrue(preorderIterator.hashCode() == sameStatepreorderIterator.hashCode());
  }

  @Test
  public void toStringTest() {
    String string = "PreorderIterator{"
        + "list=" + preorderIterator.list + ", index=" + preorderIterator.index
        + '}';
    assertEquals(string, preorderIterator.toString());
  }
}
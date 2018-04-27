package edu.neu.ccs.cs5004.assignment7.problem1and2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNodeTest {
  private TreeNode t1;
  private TreeNode t2;
  private TreeNode t3;
  private TreeNode sameStateAsT1;
  private TreeNode sameRefAsT1;

  @Before
  public void setUp() throws Exception {
    t1 = new TreeNode(1);
    t2 = new TreeNode(2);
    t3 = new TreeNode(3);
    t1.left = t2;
    t1.right = t3;
    sameRefAsT1 = t1;
    sameStateAsT1 = new TreeNode(1);
    sameStateAsT1.left = new TreeNode(2);
    sameStateAsT1.right = new TreeNode(3);

  }


  @Test
  public void equals() {
    assertTrue(t1.equals(t1));
    assertTrue(t1.equals(sameRefAsT1));
    assertFalse(t1.equals(null));
    assertFalse(t1.equals(2));

    assertTrue(t1.equals(sameStateAsT1));
    assertFalse(t1.equals(t2));

  }

  @Test
  public void hashCodetest() {
    assertTrue(t1.hashCode() == sameStateAsT1.hashCode());
    assertTrue(t1.hashCode() == sameRefAsT1.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "TreeNode{" + "val=" + t1.val +
        ", left=" + t1.left.toString() +
        ", right=" + t1.right.toString() +
        '}';
    assertEquals(temp,t1.toString());
  }
}
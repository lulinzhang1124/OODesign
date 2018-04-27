package edu.neu.ccs.cs5004.assignment7.problem1and2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InorderIteratorTest {
  private InorderIterator inorderIterator;
  private InorderIterator sameRefinorderIterator;
  private InorderIterator sameStateinorderIterator;
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
    inorderIterator = new InorderIterator(t4);
    sameRefinorderIterator = inorderIterator;

    TreeNode node = new TreeNode(4);
    node.left = new TreeNode(2);
    node.right = new TreeNode(6);
    node.left.left = new TreeNode(1);
    node.left.right = new TreeNode(3);
    sameStateinorderIterator = new InorderIterator(node);
  }

  @Test
  public void equals() {
    InorderIterator diffIterator = new InorderIterator(new TreeNode(4));
    assertTrue(inorderIterator.equals(inorderIterator));
    assertTrue(inorderIterator.equals(sameRefinorderIterator));
    assertTrue(inorderIterator.equals(sameStateinorderIterator));
    assertFalse(inorderIterator.equals(null));
    assertFalse(inorderIterator.equals(5));
    assertFalse(inorderIterator.equals(diffIterator));
    sameStateinorderIterator.next();
    assertFalse(inorderIterator.equals(sameStateinorderIterator));
  }

  @Test
  public void hashCodeTest() {
    assertTrue(inorderIterator.hashCode() == sameRefinorderIterator.hashCode());
    assertTrue(inorderIterator.hashCode() == sameStateinorderIterator.hashCode());
  }


  @Test
  public void toStringTest() {
    String string = "InorderIterator{" + "list="
        + inorderIterator.list + ", index=" + inorderIterator.getIndex()
        + '}';
    assertEquals(string,inorderIterator.toString());
  }
}
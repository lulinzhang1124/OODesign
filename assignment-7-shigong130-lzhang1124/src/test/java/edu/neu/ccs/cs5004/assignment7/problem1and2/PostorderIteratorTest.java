package edu.neu.ccs.cs5004.assignment7.problem1and2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostorderIteratorTest {

  private PostorderIterator postorderIterator;
  private PostorderIterator sameRefpostorderIterator;
  private PostorderIterator sameStatepostorderIterator;
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
    postorderIterator = new PostorderIterator(t4);
    sameRefpostorderIterator = postorderIterator;

    TreeNode node = new TreeNode(4);
    node.left = new TreeNode(2);
    node.right = new TreeNode(6);
    node.left.left = new TreeNode(1);
    node.left.right = new TreeNode(3);
    sameStatepostorderIterator = new PostorderIterator(node);
  }

  @Test
  public void equals() {
    PostorderIterator diffIterator = new PostorderIterator(new TreeNode(4));
    assertTrue(postorderIterator.equals(postorderIterator));
    assertTrue(postorderIterator.equals(sameRefpostorderIterator));
    assertTrue(postorderIterator.equals(sameStatepostorderIterator));
    assertFalse(postorderIterator.equals(null));
    assertFalse(postorderIterator.equals(5));
    assertFalse(postorderIterator.equals(diffIterator));
    sameStatepostorderIterator.next();
    assertFalse(postorderIterator.equals(sameStatepostorderIterator));
  }

  @Test
  public void hashCodeTest() {
    assertTrue(postorderIterator.hashCode() == sameRefpostorderIterator.hashCode());
    assertTrue(postorderIterator.hashCode() == sameStatepostorderIterator.hashCode());
  }


  @Test
  public void toStringTest() {
    String string = "PostorderIterator{"
        + "list=" + postorderIterator.list + ", index=" + postorderIterator.index + '}';

    assertEquals(string, postorderIterator.toString());
  }
}
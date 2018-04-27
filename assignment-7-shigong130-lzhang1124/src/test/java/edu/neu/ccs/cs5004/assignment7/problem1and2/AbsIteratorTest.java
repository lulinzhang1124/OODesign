package edu.neu.ccs.cs5004.assignment7.problem1and2;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class AbsIteratorTest {
  private AbsIterator absIterator;
  private AbsIterator absIterator2;
  private AbsIterator absIterator3;
  private AbsIterator sameRefAbsIterator;
  private AbsIterator sameStateAbsIterator;
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
    absIterator = new InorderIterator(t4);
    absIterator2 = new PreorderIterator(t4);
    absIterator3 = new PostorderIterator(t4);
    sameRefAbsIterator = absIterator;

    TreeNode node = new TreeNode(4);
    node.left = new TreeNode(2);
    node.right = new TreeNode(6);
    node.left.left = new TreeNode(1);
    node.left.right = new TreeNode(3);
    sameStateAbsIterator = new InorderIterator(node);

  }

  @Test
  public void getIndex() {
    assertEquals(0,absIterator.getIndex());
  }

  @Test
  public void hasNext() {
    AbsIterator temp = new InorderIterator(new TreeNode(1));
    temp.next();
    assertFalse(temp.hasNext());
    assertTrue(absIterator.hasNext());
  }

  @Test
  public void next() {
    assertEquals(new Ibst(t1), absIterator.next());
    assertEquals(new Ibst(t2),absIterator.next());
    assertEquals(new Ibst(t4), absIterator2.next());
    assertEquals(new Ibst(t1), absIterator3.next());
  }

  @Test
  public void remove() {
    absIterator.next();
    absIterator.next();
    absIterator.remove();
    List<TreeNode> temp = new LinkedList<>();
    temp.add(t1);
    temp.add(t3);
    temp.add(t4);
    temp.add(t6);

    assertEquals(temp,absIterator.list);
  }

  @Test
  public void equals() {
    AbsIterator diffIterator = new InorderIterator(new TreeNode(4));
    assertTrue(absIterator.equals(absIterator));
    assertTrue(absIterator.equals(sameRefAbsIterator));
    assertTrue(absIterator.equals(sameStateAbsIterator));
    assertFalse(absIterator.equals(null));
    assertFalse(absIterator.equals(5));
    assertFalse(absIterator.equals(diffIterator));
    sameStateAbsIterator.next();
    assertFalse(absIterator.equals(sameStateAbsIterator));
  }

  @Test
  public void hashCodeTest() {
    assertTrue(absIterator.hashCode() == sameRefAbsIterator.hashCode());
    assertTrue(absIterator.hashCode() == sameStateAbsIterator.hashCode());
  }
}
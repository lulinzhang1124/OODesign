package edu.neu.ccs.cs5004.assignment7.problem1and2;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class IbstTest {
  private Ibst ibst;
  private Ibst ibst2;
  private Ibst sameRefIbst;
  private Ibst sameStateIbst;
  private TreeNode t1;
  private TreeNode t2;
  private TreeNode t3;
  private TreeNode t4;

  @Before
  public void setUp() throws Exception {
    t1 = new TreeNode(3);
    t2 = new TreeNode(5);
    t3 = new TreeNode(6);
    t4 = new TreeNode(7);

    t1.right = t3;
    t3.left = t2;
    t3.right = t4;
    ibst = new Ibst(t1);
    ibst2 = new Ibst(null);
    sameRefIbst = ibst;
    sameStateIbst = new Ibst(null);
    sameStateIbst.add(3);
    sameStateIbst.add(6);
    sameStateIbst.add(7);
    sameStateIbst.add(5);

  }

  @Test
  public void deleteNode() {
    assertEquals(ibst,ibst.deleteNode(4));
    assertEquals(ibst2,ibst2.deleteNode(4));
    assertEquals(new Ibst(t3),ibst.deleteNode(3));
    ibst2.add(3);
    ibst2.add(7);
    ibst2.add(5);
    assertEquals(ibst2,ibst.deleteNode(6));
    Ibst temp = new Ibst(new TreeNode(3));
    temp.add(5);
    assertEquals(temp,ibst.deleteNode(7));
    ibst2.add(9);
    ibst2.add(8);
    ibst2.add(10);
    Ibst temp2 = new Ibst(new TreeNode(3));
    temp2.add(8);
    temp2.add(5);
    temp2.add(9);
    temp2.add(10);
    assertEquals(temp2, ibst2.deleteNode(7));

  }


  @Test
  public void mirror() {
    assertEquals(new Ibt(null),ibst2.mirror());

    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(6);
    root.left.left = new TreeNode(7);
    root.left.right = new TreeNode(5);
    Ibt ibt1 = new Ibt(root);
    assertEquals(ibt1,ibst.mirror());
    TreeNode root1 = new TreeNode(3);
    Ibt ibt2 = new Ibt(root1);
    ibst2.add(3);
    assertEquals(ibt2,ibst2.mirror());
  }

  @Test
  public void isBst() {
    assertTrue(ibst.isBst());
  }

  @Test
  public void equals() {
    assertTrue(ibst.equals(ibst));
    assertTrue(ibst.equals(sameRefIbst));

    assertFalse(ibst.equals(null));
    assertFalse(ibst.equals(3));
    assertTrue(ibst.equals(sameStateIbst));
    ibst2.add(3);
    assertFalse(ibst.equals(ibst2));
    ibst2.add(6);
    assertFalse(ibst.equals(ibst2));
    ibst2.add(5);
    assertFalse(ibst.equals(ibst2));
  }

  @Test
  public void hashCodeTest() {
    assertTrue(ibst.hashCode() == sameRefIbst.hashCode());
    assertTrue(ibst.hashCode() == sameStateIbst.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "Ibst{"
        + "root=" + ibst.root.toString() + '}';

    assertEquals(temp,ibst.toString());

  }

  @Test
  public void inorderIterator() {
    List<TreeNode> list = new LinkedList<>();
    list.add(t1);
    list.add(t2);
    list.add(t3);
    list.add(t4);

    assertEquals(list,ibst.inorderIterator().list);
  }

  @Test
  public void preorderIterator() {

    List<TreeNode> list = new LinkedList<>();
    list.add(t1);
    list.add(t3);
    list.add(t2);
    list.add(t4);

    assertEquals(list, ibst.preorderIterator().list);

  }

  @Test
  public void postorderIterator() {
    List<TreeNode> list = new LinkedList<>();
    list.add(t2);
    list.add(t4);
    list.add(t3);
    list.add(t1);

    assertEquals(list, ibst.postorderIterator().list);

  }
}
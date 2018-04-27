package edu.neu.ccs.cs5004.assignment7.problem1and2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IbtTest {
  private Ibt ibt;
  private Ibt ibt2;
  private Ibt sameRefIbt;
  private Ibt sameStateIbt;


  @Before
  public void setUp() throws Exception {
    ibt = IntegerBinaryTree.createEmptyIbt();

    ibt.add(3);
    ibt.add(6);
    ibt.add(2);
    sameRefIbt = ibt;
    sameStateIbt = IntegerBinaryTree.createEmptyIbt();
    sameStateIbt.add(3);
    sameStateIbt.add(2);
    sameStateIbt.add(6);

    ibt2 = IntegerBinaryTree.createEmptyIbt();

  }


  @Test
  public void add() {
    ibt2.add(3);
    ibt2.add(2);
    assertEquals(ibt,ibt2.add(6));
  }

  @Test
  public void isEmpty() {
    assertTrue(ibt2.isEmpty());
    assertFalse(ibt.isEmpty());
  }

  @Test
  public void contains() {
    assertFalse(ibt2.contains(3));
    assertFalse(ibt.contains(4));
    assertFalse(ibt.contains(1));
    assertTrue(ibt.contains(6));
  }

  @Test
  public void isBst() {
    assertTrue(ibt2.isBst());
    ibt2.add(3);
    assertTrue(ibt2.isBst());
    ibt2.add(2);
    assertTrue(ibt2.isBst());
    ibt2.root.right = new TreeNode(1);
    assertFalse(ibt2.isBst());
    ibt2.root.right = new TreeNode(7);
    ibt2.root.right.left = new TreeNode(1);
    assertFalse(ibt2.isBst());
    assertTrue(ibt.isBst());
    ibt.add(4);
    assertTrue(ibt.isBst());
    assertFalse(ibt2.isBst());
  }

  @Test
  public void equals() {

    assertTrue(ibt.equals(ibt));
    assertTrue(ibt.equals(sameRefIbt));

    assertFalse(ibt.equals(null));
    assertFalse(ibt.equals(3));
    assertTrue(ibt.equals(sameStateIbt));
    ibt2.add(3);
    assertFalse(ibt.equals(ibt2));
    ibt2.add(2);
    assertFalse(ibt.equals(ibt2));
    ibt2.add(5);
    assertFalse(ibt.equals(ibt2));

  }

  @Test
  public void hashCodeTest() {
    assertEquals(ibt.equals(sameRefIbt), ibt.hashCode() == sameRefIbt.hashCode());
    assertEquals(ibt.equals(sameStateIbt), ibt.hashCode() == sameStateIbt.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "Ibt{"
        + "root=" + ibt.root.toString() + '}';

    assertEquals(temp,ibt.toString());
  }


}
package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FifoDequeTest {
  private FifoDeque FifoDeque;
  private FifoDeque sameRefFifoDeque;
  private FifoDeque sameStateAsFifoDeque;

  @Before
  public void setUp() throws Exception {
    FifoDeque = new FifoDeque(1, new FifoDeque(2, new FifoDeque(3, Deque.emptyFifoDeque())));
    sameRefFifoDeque = FifoDeque;
    sameStateAsFifoDeque = new FifoDeque(1, new FifoDeque(2,
        new FifoDeque(3, Deque.emptyFifoDeque())));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void addFirst() throws Exception {
    FifoDeque.addFirst(4);
  }

  @Test
  public void addLast() {
    Deque temp = new FifoDeque(1, new FifoDeque(2, new FifoDeque(3,
        new FifoDeque(4, Deque.emptyFifoDeque()))));
    assertEquals(temp, FifoDeque.addLast(4));
  }

  @Test
  public void equals() {
    FifoDeque nullFifoDeque = null;
    FifoDeque diffYFifoDeque = new FifoDeque(2, new FifoDeque(2, new FifoDeque(3,
        Deque.emptyFifoDeque())));
    FifoDeque diffYFifoDeque2 = new FifoDeque(1, new FifoDeque(3, Deque.emptyFifoDeque()));

    assertTrue(FifoDeque.equals(FifoDeque));
    assertTrue(FifoDeque.equals(sameRefFifoDeque));
    assertTrue(FifoDeque.equals(sameStateAsFifoDeque));
    assertFalse(FifoDeque.equals(nullFifoDeque));
    assertFalse(FifoDeque.equals(new FifoDeque(10, Deque.emptyFifoDeque())));

    assertFalse(FifoDeque.equals(diffYFifoDeque));
    assertFalse(FifoDeque.equals(diffYFifoDeque2));

  }

  @Test
  public void hashCodeTest() {
    assertEquals(FifoDeque.equals(sameRefFifoDeque), FifoDeque.hashCode() == sameRefFifoDeque
        .hashCode()); //same objects have the same hashCode
    assertEquals(FifoDeque.equals(sameStateAsFifoDeque), FifoDeque.hashCode()
        == sameStateAsFifoDeque.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "FifoDeque{"
        + "first=" + FifoDeque.first
        + ", rest=" + FifoDeque.rest
        + '}';
    assertEquals(temp, FifoDeque.toString());

  }
}
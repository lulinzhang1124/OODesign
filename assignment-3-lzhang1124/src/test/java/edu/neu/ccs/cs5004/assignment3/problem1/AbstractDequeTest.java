package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AbstractDequeTest {
  private AbstractDeque absDeque;
  private AbstractDeque sameRefAbsDeque;
  private AbstractDeque sameStateAsAbsDeque;

  @Before
  public void setUp() throws Exception {
    absDeque = new FifoDeque(1, new FifoDeque(2, new FifoDeque(3, Deque.emptyFifoDeque())));
    sameRefAbsDeque = absDeque;
    sameStateAsAbsDeque = new FifoDeque(1, new FifoDeque(2,
        new FifoDeque(3, Deque.emptyFifoDeque())));
  }

  @Test
  public void getFirst() {
    assertEquals(new Integer(1), absDeque.getFirst());
  }

  @Test
  public void getRest() {
    AbstractDeque temp = new FifoDeque(2, new FifoDeque(3, Deque
        .emptyFifoDeque()));
    assertEquals(temp, absDeque.getRest());
  }

  @Test
  public void isEmpty() {
    assertFalse(absDeque.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(new Integer(3), absDeque.size());
  }

  @Test
  public void removeFirst() {
    AbstractDeque temp = new FifoDeque(2, new FifoDeque(3, Deque.emptyFifoDeque()));
    assertTrue(temp.equals(absDeque.removeFirst()));
  }

  @Test
  public void peek() {
    assertEquals(new Integer(1), absDeque.peek());
  }

  @Test
  public void equals() {
    AbstractDeque nullAbsDeque = null;
    AbstractDeque diffYAbsDeque = new FifoDeque(2, new FifoDeque(2, new FifoDeque(3,
        Deque.emptyFifoDeque())));
    AbstractDeque diffYAbsDeque2 = new FifoDeque(1, new FifoDeque(3, Deque.emptyFifoDeque()));

    assertTrue(absDeque.equals(absDeque));
    assertTrue(absDeque.equals(sameRefAbsDeque));
    assertTrue(absDeque.equals(sameStateAsAbsDeque));
    assertFalse(absDeque.equals(nullAbsDeque));
    assertFalse(absDeque.equals(new FifoDeque(10, Deque.emptyFifoDeque())));

    assertFalse(absDeque.equals(diffYAbsDeque));
    assertFalse(absDeque.equals(diffYAbsDeque2));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(absDeque.equals(sameRefAbsDeque), absDeque.hashCode() == sameRefAbsDeque
        .hashCode()); //same objects have the same hashCode
    assertEquals(absDeque.equals(sameStateAsAbsDeque), absDeque.hashCode()
        == sameStateAsAbsDeque.hashCode());
  }
}
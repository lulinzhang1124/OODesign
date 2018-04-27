package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmptyFifoDequeTest {
  private EmptyFifoDeque empty;
  private EmptyFifoDeque sameRefempty;
  private EmptyFifoDeque sameStateAsempty;

  @Before
  public void setUp() throws Exception {
    empty = new EmptyFifoDeque();
    sameRefempty = empty;
    sameStateAsempty = new EmptyFifoDeque();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void addFirst() throws Exception {
    empty.addFirst(4);
  }

  @Test
  public void addLast() {
    Deque temp = new FifoDeque(4, Deque.emptyFifoDeque());
    assertEquals(temp, empty.addLast(4));
  }

  @Test
  public void equals() {
    EmptyFifoDeque nullempty = null;
    EmptyFiloDeque diffYempty = new EmptyFiloDeque();

    assertTrue(empty.equals(empty));
    assertTrue(empty.equals(sameRefempty));
    assertTrue(empty.equals(sameStateAsempty));
    assertFalse(empty.equals(nullempty));
    assertFalse(empty.equals(new FifoDeque(10, Deque.emptyFifoDeque())));

    assertFalse(empty.equals(diffYempty));

  }

  @Test
  public void hashCodeTest() {
    assertEquals(empty.equals(sameRefempty), empty.hashCode() == sameRefempty
        .hashCode()); //same objects have the same hashCode
    assertEquals(empty.equals(sameStateAsempty), empty.hashCode()
        == sameStateAsempty.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "EmptyFifoDeque{}";
    assertEquals(temp, empty.toString());
  }
}
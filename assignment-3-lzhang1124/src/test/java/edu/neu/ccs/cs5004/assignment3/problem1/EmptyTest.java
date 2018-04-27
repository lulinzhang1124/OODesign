package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class EmptyTest {
  private Empty empty;
  private Empty sameRefempty;
  private Empty sameStateAsempty;

  @Before
  public void setUp() throws Exception {
    empty = new EmptyFifoDeque();
    sameRefempty = empty;
    sameStateAsempty = new EmptyFifoDeque();
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(new Integer(0), empty.size());
  }

  @Test(expected = IllegalOperationException.class)
  public void removeFirst() throws Exception {
    empty.removeFirst();
  }

  @Test
  public void peek() throws Error {
    empty.peek();
  }

  @Test
  public void equals() {
    Empty nullempty = null;
    Empty diffYempty = new EmptyFiloDeque();

    assertTrue(empty.equals(empty));
    assertTrue(empty.equals(sameRefempty));
    assertTrue(empty.equals(sameStateAsempty));
    assertFalse(empty.equals(nullempty));
    assertFalse(empty.equals(new FifoDeque(10, Deque.emptyFifoDeque())));

    assertFalse(empty.equals(diffYempty));

  }

  @Test
  public void testhashCode() {
    assertEquals(empty.equals(sameRefempty), empty.hashCode() == sameRefempty
        .hashCode()); //same objects have the same hashCode
    assertEquals(empty.equals(sameStateAsempty), empty.hashCode()
        == sameStateAsempty.hashCode());
  }


}
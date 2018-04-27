package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmptyFiloDequeTest {
  private EmptyFiloDeque empty;
  private EmptyFiloDeque sameRefempty;
  private EmptyFiloDeque sameStateAsempty;

  @Before
  public void setUp() throws Exception {
    empty = new EmptyFiloDeque();
    sameRefempty = empty;
    sameStateAsempty = new EmptyFiloDeque();
  }

  @Test
  public void addFirst() {
    Deque temp = new FiloDeque(2, Deque.emptyFiloDeque());
    assertEquals(temp, empty.addFirst(2));

  }

  @Test(expected = UnsupportedOperationException.class)
  public void addLast() {
    empty.addLast(2);
  }

  @Test
  public void equals() {
    EmptyFiloDeque nullempty = null;
    EmptyFifoDeque diffYempty = new EmptyFifoDeque();

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
    assertEquals("EmptyFiloDeque{}", empty.toString());
  }


}
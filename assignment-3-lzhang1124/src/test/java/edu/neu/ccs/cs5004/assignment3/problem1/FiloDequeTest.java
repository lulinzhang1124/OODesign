package edu.neu.ccs.cs5004.assignment3.problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FiloDequeTest {
  FiloDeque deque;
  private FiloDeque sameRefFiloDeque;
  private FiloDeque sameStateAsFiloDeque;

  @Before
  public void setUp() throws Exception {
    deque = new FiloDeque(1, Deque.emptyFiloDeque());
    sameRefFiloDeque = deque;
    sameStateAsFiloDeque = new FiloDeque(1, Deque.emptyFiloDeque());
  }

  @Test
  public void addFirst() {
    FiloDeque temp = new FiloDeque(2, new FiloDeque(1, Deque.emptyFiloDeque()));
    assertEquals(temp, deque.addFirst(2));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void addLast() throws Exception {
    deque.addLast(2);
  }

  @Test
  public void equals() {
    FiloDeque nullFiloDeque = null;
    FiloDeque diffYFiloDeque = new FiloDeque(2, new FiloDeque(2, new FiloDeque(3,
        Deque.emptyFiloDeque())));
    FiloDeque diffYFiloDeque2 = new FiloDeque(1, new FiloDeque(3, Deque.emptyFiloDeque()));

    assertTrue(deque.equals(deque));
    assertTrue(deque.equals(sameRefFiloDeque));
    assertTrue(deque.equals(sameStateAsFiloDeque));
    assertFalse(deque.equals(nullFiloDeque));
    assertFalse(deque.equals(new FifoDeque(10, Deque.emptyFiloDeque())));

    assertFalse(deque.equals(diffYFiloDeque));
    assertFalse(deque.equals(diffYFiloDeque2));

  }

  @Test
  public void hashCodeTest() {
    assertEquals(deque.equals(sameRefFiloDeque), deque.hashCode() == sameRefFiloDeque
        .hashCode()); //same objects have the same hashCode
    assertEquals(deque.equals(sameStateAsFiloDeque), deque.hashCode()
        == sameStateAsFiloDeque.hashCode());
  }

  @Test
  public void toStringTest() {
    String temp = "FiloDeque{"
        + "first=" + deque.first
        + ", rest=" + deque.rest
        + '}';
    assertEquals(temp, deque.toString());

  }
}
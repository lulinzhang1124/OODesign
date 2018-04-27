package edu.neu.ccs.cs5004.assignment4.problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmptySetTest {
  private EmptySet emptySet;
  private EmptySet sameStateEmptySet;
  private EmptySet sameRefEmptySet;
  private Aset set1;

  @Before
  public void setUp() throws Exception {
    emptySet = new EmptySet();
    sameRefEmptySet = emptySet;
    sameStateEmptySet = new EmptySet();
    set1 = new Cons(1, new Cons(2, Set.emptySet()));
  }

  @Test
  public void isEmpty() {
    assertTrue(emptySet.isEmpty());
  }

  @Test
  public void contains() {
    assertFalse(emptySet.contains(4));
  }

  @Test
  public void remove() {
    assertEquals(emptySet, emptySet.remove(3));
  }

  @Test
  public void size() {
    assertEquals(new Integer(0), emptySet.size());
  }

  @Test
  public void union() {
    assertEquals(set1, emptySet.union(set1));
  }

  @Test
  public void intersection() {
    assertEquals(emptySet, emptySet.intersection(set1));
  }


  @Test
  public void difference() {
    assertEquals(set1, emptySet.difference(set1));
  }

  @Test
  public void subset() {
    assertTrue(emptySet.subset(set1));
  }

  @Test
  public void equals() {
    EmptySet nullset = null;
    EmptySet yetAnotherSet = new EmptySet();


    assertTrue(emptySet.equals(emptySet));
    assertTrue(emptySet.equals(sameRefEmptySet));
    assertTrue(emptySet.equals(sameStateEmptySet));

    assertFalse(emptySet.equals(nullset));
    assertFalse(emptySet.equals(new Integer(9)));

    assertEquals(emptySet.equals(sameStateEmptySet), sameStateEmptySet.equals(emptySet));
    assertEquals(emptySet.equals(sameStateEmptySet) && sameStateEmptySet.equals(yetAnotherSet),
        yetAnotherSet.equals(emptySet));
    assertFalse(emptySet.equals(set1));
  }

  @Test
  public void hashCodeTest() {
    assertEquals(emptySet.equals(sameRefEmptySet), emptySet.hashCode() == sameRefEmptySet.hashCode());
    assertEquals(emptySet.equals(sameStateEmptySet), emptySet.hashCode() == sameStateEmptySet.hashCode());
  }

  @Test
  public void toStringTest() {
    assertEquals("EmptySet{}", emptySet.toString());
  }
}
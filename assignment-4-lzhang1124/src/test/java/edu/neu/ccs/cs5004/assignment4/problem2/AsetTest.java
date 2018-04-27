package edu.neu.ccs.cs5004.assignment4.problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AsetTest {
  private Aset emptySet;
  private Aset sameStateEmptySet;
  private Aset sameRefEmptySet;

  @Before
  public void setUp() throws Exception {
    emptySet = new EmptySet();
    sameRefEmptySet = emptySet;
    sameStateEmptySet = new EmptySet();

  }

  @Test
  public void add() {
    assertEquals(new Cons(1, Set.emptySet()), emptySet.add(1));
  }

  @Test
  public void equals() {
    Aset nullset = null;
    Aset yetAnotherSet = new EmptySet();
    Aset set1 = new Cons(1, Set.emptySet());


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
}
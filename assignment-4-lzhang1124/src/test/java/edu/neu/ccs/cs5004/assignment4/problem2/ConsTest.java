package edu.neu.ccs.cs5004.assignment4.problem2;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConsTest {
  private Cons set;
  private Cons set1;
  private Cons set2;
  private EmptySet empty;
  private Cons sameStateSet;
  private Cons sameRefSet;

  @Before
  public void setUp() throws Exception {
    set = new Cons(1, new Cons(2, new Cons(3, Set.emptySet())));
    sameRefSet = set;
    empty = new EmptySet();
    sameStateSet = new Cons(2, new Cons(1, new Cons(3, Set.emptySet())));
    set1 = new Cons(4, new Cons(2, new Cons(3, Set.emptySet())));
    set2 = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Set.emptySet()))));
  }

  @Test
  public void getFirst() {
    assertEquals(new Integer(1), set.getFirst());
  }

  @Test
  public void getRest() {
    Set temp = new Cons(2, new Cons(3, Set.emptySet()));
    assertEquals(temp, set.getRest());
  }

  @Test
  public void isEmpty() {
    assertFalse(set.isEmpty());
  }


  @Test
  public void contains() {
    assertTrue(set.contains(3));
    assertFalse(set.contains(6));
  }

  @Test
  public void remove() {
    assertEquals(set, set2.remove(4));
  }

  @Test
  public void size() {
    assertEquals(new Integer(3), set.size());
  }

  @Test
  public void union() {
    Set set1 = new Cons(4, new Cons(2, new Cons(3, Set.emptySet())));
    Set set2 = new Cons(1, new Cons(2, new Cons(3,
        new Cons(4, Set.emptySet()))));
    assertEquals(set2, set.union(set1));
  }

  @Test
  public void intersection() {
    Set temp = new Cons(2, new Cons(3, Set.emptySet()));
    assertEquals(temp, set.intersection(set1));

  }

  @Test
  public void difference() {
    Set temp = new Cons(1, new Cons(4, Set.emptySet()));
    assertEquals(temp, set.difference(set1));
  }

  @Test
  public void subset() {
    Set temp = new Cons(2, Set.emptySet());
    assertTrue(temp.subset(set));
    assertFalse(set.subset(temp));
    assertTrue((new Cons(1, Set.emptySet())).subset(set));
    assertFalse((new Cons(1,new Cons(5, Set.emptySet()))).subset(set));
  }

  @Test
  public void equals() {
    Cons nullset = null;
    Cons yetAnotherSet = new Cons(1, new Cons(2, new Cons(3, Set.emptySet())));


    assertTrue(set.equals(set));
    assertTrue(set.equals(sameRefSet));
    assertTrue(set.equals(sameStateSet));

    assertFalse(set.equals(nullset));
    assertFalse(set.equals(new Integer(9)));

    assertEquals(set.equals(sameStateSet), sameStateSet.equals(set));
    assertEquals(set.equals(sameStateSet) && sameStateSet.equals(yetAnotherSet),
        yetAnotherSet.equals(set));
    assertFalse(set.equals(set1));

  }

  @Test
  public void hashCodeTest() {
    assertEquals(set.equals(sameRefSet), set.hashCode() == sameRefSet.hashCode());
    assertEquals(set.equals(sameStateSet), set.hashCode() == sameStateSet.hashCode());

  }

  @Test
  public void toStringTest() {
    String string = "Cons{" +
        "first=" + set.first +
        ", rest=" + set.rest +
        '}';
    assertEquals(string, set.toString());
  }


}
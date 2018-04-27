package edu.neu.ccs.cs5004.blackbox;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment4.problem2.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SetTest {
  private Set emptySet;
  private Set set1;
  private Set set2;
  private Set sameStateSet1;
  private Set sameRefSet1;

  @Before
  public void setUp() throws Exception {
    emptySet = Set.emptySet();
    set1 = Set.emptySet().add(1);
    set2 = set1.add(2);
    sameRefSet1 = set1;
    sameStateSet1 = Set.emptySet().add(1);
  }

  @Test
  public void emptySet() {
    assertEquals(Set.emptySet(), emptySet);
  }

  @Test
  public void isEmpty() {
    assertTrue(emptySet.isEmpty());
    assertFalse(set1.isEmpty());
  }

  @Test
  public void add() {
    assertEquals(set1, emptySet.add(1));
  }

  @Test
  public void contains() {
    assertFalse(emptySet.contains(3));
    assertTrue(set1.contains(1));
  }

  @Test
  public void remove() {
    assertEquals(emptySet, emptySet.remove(3));
    assertEquals(emptySet, set1.remove(1));
  }

  @Test
  public void size() {
    assertEquals(new Integer(0), emptySet.size());
    assertEquals(new Integer(1), set1.size());
  }

  @Test
  public void union() {
    assertEquals(set1, emptySet.union(set1));
    assertEquals(set2, set1.union(set2));
  }

  @Test
  public void intersection() {
    assertEquals(emptySet, emptySet.intersection(set2));
    assertEquals(set1, set1.intersection(set2));
  }

  @Test
  public void difference() {
    assertEquals(set1, emptySet.difference(set1));
    assertEquals(emptySet.add(2), set1.difference(set2));
  }

  @Test
  public void subset() {
    assertTrue(emptySet.subset(set2));
    assertTrue(set1.subset(set2));
  }

  @Test
  public void equalsTest() {
    Set nullset = null;
    Set yetAnotherSet1 = Set.emptySet().add(1);

    assertTrue(emptySet.equals(emptySet));
    assertTrue(set1.equals(set1));
    assertTrue(set1.equals(sameRefSet1));
    assertTrue(set1.equals(sameStateSet1));

    assertFalse(set1.equals(nullset));
    assertFalse(set1.equals(new Integer(9)));

    assertEquals(set1.equals(sameStateSet1), sameStateSet1.equals(set1));
    assertEquals(set1.equals(sameStateSet1) && sameStateSet1.equals(yetAnotherSet1),
        yetAnotherSet1.equals(set1));
    assertFalse(set1.equals(set2));

  }
}
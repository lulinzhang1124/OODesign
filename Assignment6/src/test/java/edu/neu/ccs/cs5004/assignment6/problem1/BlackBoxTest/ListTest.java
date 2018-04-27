package edu.neu.ccs.cs5004.assignment6.problem1.BlackBoxTest;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment6.problem1.List;

import static org.junit.Assert.*;

public class ListTest {
  private List<Integer> empty;
  private List<Integer> list2;
  private List<Integer> list3;
  private List<Integer> sameRefList;
  private List <Integer> sameStateAsList;

  @Before
  public void setUp() throws Exception {
    empty = List.creatlEmptyList();
    list2 = List.creatlEmptyList();
    list2.add(1);
    list3 = List.creatlEmptyList();
    list3.add(1);
    list3.add(2);
    sameRefList = list2;
    sameStateAsList = List.creatlEmptyList();
    sameStateAsList.add(1);
  }

  @Test
  public void add() {
    empty.add(1);
    assertEquals(empty, list2);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void add1() {
    empty.add(3,3);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void add3() {
    empty.add(-1,3);
  }

  @Test
  public void add2() {
    list2.add(0, 2);//2-1
    assertEquals(list3,list2);

    List<Integer> temp = list3;
    temp.add(2);//2-2-1
    list3.add(1,2);//2-2-1
    assertEquals(temp,list3);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void get() {
    empty.get(1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void get1() {
    empty.get(-2);
  }

  @Test
  public void get2() {
    assertEquals(new Integer(1),list2.get(0));
    assertEquals(new Integer(1),list3.get(1));

  }

  @Test
  public void indexOf() {
    assertEquals(-1,empty.indexOf(2));
    assertEquals(0,list2.indexOf(1));
    assertEquals(-1,list3.indexOf(3));
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(list2.isEmpty());
  }

  @Test
  public void remove() {
    empty.add(2);
    list3.remove(1);
    assertEquals(empty,list3);

    empty.remove(0);
    list2.remove(0);
    assertEquals(empty,list2);

  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void remove1() {
    empty.remove(0);

  }
  @Test(expected = IndexOutOfBoundsException.class)
  public void remove2() {
    list2.remove(-3);
  }

  @Test
  public void size() {
    assertEquals(0,empty.size());
  }

  @Test
  public void contains() {
    assertFalse(empty.contains(1));
    assertTrue(list2.contains(1));
  }

  @Test
  public void testEquals() throws Exception{
    assertTrue(list2.equals(list2));
    assertTrue(list2.equals(sameRefList));
    assertFalse(list2.equals(null));


    assertFalse(list2.equals(new Integer(10)));
    assertFalse(list2.equals(empty));
    assertFalse(list2.equals(list3));
  }

  @Test
  public void testHashCode() throws Exception {
    assertEquals(list2.equals(sameRefList), list2.hashCode() == sameRefList.hashCode()); //same
    // objects have the same hashCode
    assertEquals(list2.equals(sameStateAsList), list2.hashCode() == sameStateAsList.hashCode()); //equal objects have the same hashCode
  }

  @Test
  public void testToString() {
    String temp = "LinkedList{" + "head=" + "ListNode{val=1, next=null}" + '}';
    assertEquals(temp,list2.toString());
  }

}
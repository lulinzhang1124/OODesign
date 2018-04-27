package edu.neu.ccs.cs5004.assignment6.problem2.BlackboxTest;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment6.problem2.PriorityQueue;

import static org.junit.Assert.*;

public class PriorityQueueTest {
  private PriorityQueue<Integer> queue;
  private PriorityQueue<Integer> empty;
  private PriorityQueue<Integer> queue1;
  private PriorityQueue<Integer> sameRefQueue;
  private PriorityQueue<Integer> sameStateAsQueue;

  @Before
  public void setUp() throws Exception {
    queue = PriorityQueue.createEmptyPriorityQueue();
    queue.insert(2);
    empty = PriorityQueue.createEmptyPriorityQueue();
    queue1 = PriorityQueue.createEmptyPriorityQueue();
    queue1.insert(2);
    queue1.insert(1);//2-1
    sameRefQueue = queue;
    sameStateAsQueue = PriorityQueue.createEmptyPriorityQueue();
    sameStateAsQueue.insert(2);

  }

  @Test
  public void insert() {
    empty.insert(2);
    assertEquals(empty,queue);
    queue.insert(1);
    assertEquals(queue, queue1);
    queue.insert(5);
    queue1.insert(5);
    assertEquals(queue,queue1);
  }

  @Test
  public void remove() {
    queue.remove();
    assertEquals(empty, queue);
  }

  @Test(expected = NullPointerException.class)
  public void remove1() {
    empty.remove();
  }

  @Test
  public void front() {
    assertEquals(new Integer(2),queue1.front());
  }

  @Test(expected =  NullPointerException.class)
  public void front1() {
    empty.front();
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(queue.isEmpty());
  }

  @Test
  public void size() {
    assertEquals((long)new Integer(0),empty.size());
    assertEquals((long)new Integer(1),queue.size());
  }

  @Test
  public void toStringTest(){
    String temp = "Pq{" +
        "list=LinkedList{head=ListNode{val=2, next=null}}" +
        '}';

    assertEquals(temp,queue.toString());
  }

  @Test
  public void testEquals() throws Exception{
    assertTrue(queue.equals(queue));
    assertTrue(queue.equals(sameRefQueue));
    assertTrue(queue.equals(sameStateAsQueue));
    assertFalse(queue.equals(null));


    assertFalse(queue.equals(new Integer(10)));
    assertFalse(queue.equals(empty));
    assertFalse(queue.equals(queue1));
  }

  @Test
  public void testHashCode() throws Exception {
    assertEquals(queue.equals(sameRefQueue), queue.hashCode() == sameRefQueue.hashCode()); //same
    // objects have the same hashCode
    assertEquals(queue.equals(sameStateAsQueue), queue.hashCode() == sameStateAsQueue.hashCode()); //equal objects have the same hashCode
  }
}
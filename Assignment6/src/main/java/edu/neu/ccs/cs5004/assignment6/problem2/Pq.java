package edu.neu.ccs.cs5004.assignment6.problem2;

import edu.neu.ccs.cs5004.assignment6.problem1.List;

import java.util.Objects;

/**
 * Represents a priority queue class.
 *
 * @param <E> - generic type.
 */
public class Pq<E extends Comparable<E>> implements PriorityQueue<E> {


  private List<E> list;

  /**
   * Creates a new priority queue.
   */
  public Pq() {
    list = List.creatlEmptyList();
  }

  /**
   * insert the element in the queue. O(n^2).
   *
   * @param element - an element to be inserted into the priority queue.
   */
  @Override
  public void insert(E element) {

    if (list.size() == 0) {
      list.add(element);
      return;
    }

    for (int i = 0; i < size(); i++) {
      if (list.get(i).compareTo(element) < 0) {
        list.add(i, element);
        return;
      }
    }
    list.add(list.size(), element);

  }

  /**
   * Removes the object from the front. O(1).
   * Throw an appropriate exception if the Priority Queue is empty.
   */
  @Override
  public void remove() {
    if (isEmpty()) {
      throw new NullPointerException("remove for an empty queue.");
    }

    list.remove(0);

  }

  /**
   * Gets the element at the front of the queue. O(1).
   *
   * @return the object at the front without changing the Priority Queue.
   */
  @Override
  public E front() {
    if (isEmpty()) {
      throw new NullPointerException("remove for an empty queue.");
    }
    return list.get(0);
  }

  /**
   * Checks if the queue is empty. O(1).
   *
   * @return true if it is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }


  /**
   * Gets the size of the queue. O(n).
   *
   * @return the size of the queue.
   */
  @Override
  public int size() {
    return list.size();
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Pq<?> priorityQ = (Pq<?>) obj;
    return Objects.equals(list, priorityQ.list);
  }

  @Override
  public int hashCode() {

    return Objects.hash(list);
  }

  @Override
  public String toString() {
    return "Pq{"
        +
        "list="
        + list
        +
        '}';
  }
}

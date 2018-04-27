package edu.neu.ccs.cs5004.assignment6.problem2;

/**
 * Represents a priority queue interface.
 *
 * @param <E> - generic type.
 */
public interface PriorityQueue<E> {

  /**
   * Creates an empty priority queue.
   *
   * @return an empty priority queue.
   */
  static PriorityQueue createEmptyPriorityQueue() {
    return new Pq();
  }

  /**
   * insert the element in the queue.
   *
   * @param element - an element to be inserted into the priority queue.
   */
  void insert(E element);

  /**
   * removes the object from the front.
   * Throw an appropriate exception if the Priority Queue is empty.
   */
  void remove();

  /**
   * Gets the element at the front of the queue.
   *
   * @return the object at the front without changing the Priority Queue.
   */
  E front();

  /**
   * Checks if the queue is empty.
   *
   * @return true if it is empty, false otherwise.
   */
  boolean isEmpty();


  /**
   * Gets the size of the queue.
   *
   * @return the size of the queue.
   */
  int size();

}

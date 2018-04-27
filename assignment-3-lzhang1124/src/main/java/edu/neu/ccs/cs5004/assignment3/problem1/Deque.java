package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents a Deque of Integers.
 */
public interface Deque {

  /**
   * Creates an empty FIFO deque.
   *
   * @return new empty FIFO deque
   */
  static Empty emptyFifoDeque() {
    return new EmptyFifoDeque();
  }

  /**
   * Create an empty FILO deque.
   *
   * @return new empty FILO deque
   */
  static Empty emptyFiloDeque() {
    return new EmptyFiloDeque();
  }

  /**
   * Check if the deque id empty.
   *
   * @return true if deque is empty, false otherwise
   */
  Boolean isEmpty();

  /**
   * The number of element in deque.
   *
   * @return 0 for empty deque; number of elements in non empty deque
   */
  Integer size();

  /**
   * Add {@code n} to the head of the deque.
   *
   * @param element the new integer to be added
   * @return same deque with n added
   * @throws UnsupportedOperationException with appropriate message if calling on a non empty
   *                                       FIFO deque or an empty FIFO deque
   */
  Deque addFirst(Integer element) throws UnsupportedOperationException;

  /**
   * Add {@code n}to rhe tail of the deque.
   *
   * @param element the new integer to be added
   * @return same deque with n added
   * @throws UnsupportedOperationException with appropriate message if calling on an empty LIFO
   *                                       deque or a non empty LIFO deque
   */
  Deque addLast(Integer element) throws UnsupportedOperationException;

  /**
   * Remove the first integer of a deque.
   *
   * @return the same deque with the first element removed
   * @throws IllegalOperationException if calling on any empty deque
   */
  Deque removeFirst() throws IllegalOperationException;

  /**
   * Get the deque's first element.
   *
   * @return the first element of the deque
   * @throws Error if calling on any empty deque
   */
  Integer peek() throws Error;

}

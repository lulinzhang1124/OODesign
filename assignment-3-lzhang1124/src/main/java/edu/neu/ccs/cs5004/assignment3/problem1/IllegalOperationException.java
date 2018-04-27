package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents an illegal operation on a Deque.
 */
public class IllegalOperationException extends RuntimeException {
  public IllegalOperationException(String msg) {
    super(msg);
  }
}

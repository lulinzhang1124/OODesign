package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents an abstract empty deque.
 */
public abstract class Empty implements Deque {
  public Empty() {
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Deque removeFirst() throws IllegalOperationException {
    throw new IllegalOperationException("Empty Deque!");
  }

  @Override
  public Integer peek() throws Error {
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return 41;
  }




}

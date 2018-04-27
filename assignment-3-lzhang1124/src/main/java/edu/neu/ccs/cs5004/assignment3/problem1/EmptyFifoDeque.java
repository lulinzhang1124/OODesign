package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents an empty FIFO deque.
 */
public class EmptyFifoDeque extends Empty {
  public EmptyFifoDeque() {
  }

  @Override
  public Deque addFirst(Integer element) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Can't use addFirst() on FIFODeque!");
  }

  @Override
  public Deque addLast(Integer element) {
    return new FifoDeque(element, this);
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + 31;
    return result;
  }

  @Override
  public String toString() {
    return "EmptyFifoDeque{}";
  }
}

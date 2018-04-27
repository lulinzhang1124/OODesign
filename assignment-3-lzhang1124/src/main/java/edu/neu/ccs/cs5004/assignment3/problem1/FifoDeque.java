package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents a non empty FIFO deque.
 */
public class FifoDeque extends AbstractDeque {

  public FifoDeque(Integer first, Deque rest) {
    super(first, rest);
  }

  @Override
  public Deque addFirst(Integer element) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Can't use addFirst() on a FifoDeque!");
  }

  @Override
  public Deque addLast(Integer element) {
    if (this.getRest().equals(Deque.emptyFifoDeque())) {
      return new FifoDeque(this.getFirst(), new FifoDeque(element, Deque.emptyFifoDeque()));
    }
    return new FifoDeque(this.getFirst(), this.getRest().addLast(element));
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 13 * result + 13;
    return result;
  }

  @Override
  public String toString() {
    return "FifoDeque{"
        + "first=" + first
        + ", rest=" + rest
        + '}';
  }
}
package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents a non empty FILO deque.
 */
public class FiloDeque extends AbstractDeque {

  public FiloDeque(Integer first, Deque rest) {
    super(first, rest);
  }

  @Override
  public Deque addFirst(Integer element) {
    return new FiloDeque(element, this);
  }

  @Override
  public Deque addLast(Integer element) {
    throw new UnsupportedOperationException("Can't addFirst() for a FIFODeque.");
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
    return "FiloDeque{"
        + "first=" + first
        + ", rest=" + rest + '}';
  }
}
package edu.neu.ccs.cs5004.assignment3.problem1;

/**
 * Represents an empty FILO deque.
 */
public class EmptyFiloDeque extends Empty {
  public EmptyFiloDeque() {
  }

  @Override
  public Deque addFirst(Integer element) {
    return new FiloDeque(element, Deque.emptyFiloDeque());
  }

  @Override
  public Deque addLast(Integer element) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Can't use addLsat() for a FILODeque!");
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
    return "EmptyFiloDeque{}";
  }
}

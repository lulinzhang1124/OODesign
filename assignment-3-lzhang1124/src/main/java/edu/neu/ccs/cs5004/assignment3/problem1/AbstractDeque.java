package edu.neu.ccs.cs5004.assignment3.problem1;

import java.util.Objects;

/**
 * Represents an abstract non-empty deque.
 */
public abstract class AbstractDeque implements Deque {
  protected Integer first;
  protected Deque rest;

  public AbstractDeque(Integer first, Deque rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Getter for 'first'.
   *
   * @return the first integer of the deque
   */
  public Integer getFirst() {
    return first;
  }

  /**
   * Getter for 'rest'.
   *
   * @return the same deque without the first element
   */
  public Deque getRest() {
    return rest;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public Integer size() {
    return 1 + this.getRest().size();
  }

  @Override
  public Deque removeFirst() {
    return this.getRest();
  }

  @Override
  public Integer peek() {
    return this.getFirst();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractDeque that = (AbstractDeque) obj;
    return Objects.equals(first, that.first)
        && Objects.equals(rest, that.rest);
  }

  @Override
  public int hashCode() {

    return Objects.hash(first, rest);
  }
}

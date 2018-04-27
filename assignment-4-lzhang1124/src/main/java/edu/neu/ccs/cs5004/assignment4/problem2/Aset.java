package edu.neu.ccs.cs5004.assignment4.problem2;

/**
 * Represents an abstract set.
 */
public abstract class Aset implements Set {

  @Override
  public Set add(Integer num) {
    return new Cons(num, this);
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
    return 23;
  }
}

package edu.neu.ccs.cs5004.assignment4.problem2;

/**
 * Represents a non-empty set.
 */
public class Cons extends Aset {
  protected Integer first;
  protected Set rest;

  public Cons(Integer first, Set rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Getter of 'first'.
   *
   * @return value of first.
   */
  public Integer getFirst() {
    return first;
  }

  /**
   * Getter of 'rest'.
   *
   * @return value of rest.
   */
  public Set getRest() {
    return rest;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public Boolean contains(Integer num) {
    return this.first.equals(num) || rest.contains(num);
  }

  @Override
  public Set remove(Integer ele) {
    if (this.first.equals(ele)) {
      return rest;
    }
    return new Cons(this.first, rest.remove(ele));
  }

  @Override
  public Integer size() {
    return 1 + rest.size();
  }

  @Override
  public Set union(Set set) {
    if (!set.contains(this.first)) {
      return new Cons(this.first, this.rest.union(set));
    } else {
      return this.rest.union(set);
    }
  }

  @Override
  public Set intersection(Set set) {
    if (set.contains(this.first)) {
      return new Cons(this.first, set.intersection(this.rest));
    } else {
      return set.intersection(this.rest);
    }
  }

  @Override
  public Set difference(Set set) {
    if (set.contains(this.first)) {
      return this.rest.difference(set.remove(this.first));
    }
    return new Cons(this.first, this.rest.difference(set));

  }

  @Override
  public Boolean subset(Set set) {

    return set.contains(this.first) && this.rest.subset(set);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Cons cons = (Cons) obj;
    if (!this.size().equals(cons.size())) {
      return false;
    }
    return cons.subset(this) && this.subset(cons);
  }

  @Override
  public int hashCode() {
    return first * rest.hashCode();
  }

  @Override
  public String toString() {
    return "Cons{" + "first=" + first + ", rest=" + rest + '}';
  }
}


package edu.neu.ccs.cs5004.assignment4.problem2;

/**
 * Represents an empty set.
 */
public class EmptySet extends Aset {

  public EmptySet() {
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public Boolean contains(Integer num) {
    return false;
  }

  @Override
  public Set remove(Integer ele) {
    return this;
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Set union(Set set) {
    Set res = set;
    return res;
  }

  @Override
  public Set intersection(Set set) {
    return new EmptySet();
  }


  @Override
  public Set difference(Set set) {
    Set res = set;
    return res;
  }

  @Override
  public Boolean subset(Set set) {
    return true;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return 23;
  }


  @Override
  public String toString() {
    return "EmptySet{}";
  }
}

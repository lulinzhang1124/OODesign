package edu.neu.ccs.cs5004.assignment3.problem2;

import java.util.Objects;

/**
 * Represents a name for our program.
 */
public class Name {

  private String first;
  private String last;

  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  /**
   * Getter fot 'first'.
   *
   * @return the first name
   */
  public String getFirst() {
    return first;
  }

  /**
   * Getter fot 'last'.
   *
   * @return the last name
   */
  public String getLast() {
    return last;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Name name = (Name) obj;
    return Objects.equals(first, name.first)
        && Objects.equals(last, name.last);
  }

  @Override
  public int hashCode() {

    return Objects.hash(first, last);
  }

  @Override
  public String toString() {
    return "Name{" + first + " " + last + '}';
  }
}

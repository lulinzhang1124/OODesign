package edu.neu.ccs.cs5004.assignment6.midtermq2;

import java.util.Objects;

/**
 * Represents a name class.
 */
public class Name {

  String first;
  String last;

  /**
   * Creates a name.
   *
   * @param first - first name of a person.
   * @param last  - last name of a person.
   */
  public Name(String first, String last) {
    this.first = first;
    this.last = last;
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
        &&
        Objects.equals(last, name.last);
  }

  @Override
  public int hashCode() {

    return Objects.hash(first, last);
  }

  @Override
  public String toString() {
    return "Name{"
        +
        "first='"
        + first
        + '\''
        +
        ", last='"
        + last
        + '\''
        +
        '}';
  }
}

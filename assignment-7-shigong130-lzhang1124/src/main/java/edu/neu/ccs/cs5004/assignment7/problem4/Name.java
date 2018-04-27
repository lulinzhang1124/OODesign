package edu.neu.ccs.cs5004.assignment7.problem4;

import java.util.Objects;

/**
 * Represents the name class.
 */
public class Name {
  private String first;
  private String last;

  /**
   * Creates a name.
   *
   * @param first - first name.
   * @param last  - last name.
   */
  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  /**
   * Getter.
   *
   * @return - the value for property 'first'.
   */
  public String getFirst() {
    return first;
  }

  /**
   * Getter.
   *
   * @return - the value for property 'last'.
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
    return Objects.equals(getFirst(), name.getFirst())
            &&
            Objects.equals(getLast(), name.getLast());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getFirst(), getLast());
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

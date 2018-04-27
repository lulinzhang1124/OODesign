package edu.neu.ccs.cs5004.assignment7.problem4;

import java.util.Objects;

/**
 * Represents a director.
 */
public class Director {
  private Name name;

  /**
   * Creates a director
   *
   * @param name - name of the director.
   */
  public Director(Name name) {
    this.name = name;
  }

  /**
   * Getter.
   *
   * @return - the value for property 'name'.
   */
  public Name getName() {
    return name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Director director = (Director) obj;
    return Objects.equals(getName(), director.getName());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getName());
  }

  @Override
  public String toString() {
    return "Director{"
            +
            "name="
            + name
            +
            '}';
  }
}

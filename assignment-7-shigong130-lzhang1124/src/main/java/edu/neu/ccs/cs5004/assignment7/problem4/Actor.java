package edu.neu.ccs.cs5004.assignment7.problem4;

import java.util.Objects;

/**
 * Represents an actor.
 */
public class Actor {
  private Name name;

  /**
   * Creates an actor.
   *
   * @param name - name of the actor.
   */
  public Actor(Name name) {
    this.name = name;
  }

  /**
   * Getter.
   *
   * @return - value for property 'name'.
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
    Actor actor = (Actor) obj;
    return Objects.equals(getName(), actor.getName());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getName());
  }

  @Override
  public String toString() {
    return "Actor{"
            +
            "name="
            + name
            +
            '}';
  }
}

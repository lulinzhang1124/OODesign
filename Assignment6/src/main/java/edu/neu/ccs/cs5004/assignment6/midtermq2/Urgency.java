package edu.neu.ccs.cs5004.assignment6.midtermq2;

import java.util.Objects;

/**
 * Represents the urgency class in the emergency queue program.
 */
public class Urgency {
  Integer value;

  /**
   * Creates an urgency.
   *
   * @param value - value of urgency.
   */
  public Urgency(Integer value) {
    this.value = value;
  }

  /**
   * compares two urgency values. O(1).
   *
   * @param otherUrgency to compare with (assumed to be not null)
   * @return 1 if this urgency value is bigger than other urgency value.
   *        -1 if this urgency value if smaller than other urgency value.
   *         0 if both urgency values are equal.
   */
  public int compareTo(Urgency otherUrgency) {

    return this.value.compareTo(otherUrgency.value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Urgency urgency = (Urgency) obj;
    return Objects.equals(value, urgency.value);
  }

  @Override
  public int hashCode() {

    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Urgency{"
        +
        "value="
        + value
        +
        '}';
  }
}

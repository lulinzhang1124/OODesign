package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represents the miss result of an attack.
 */

public class Miss implements AttackResult {

  @Override
  public String attackResult() {
    return "Miss";
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

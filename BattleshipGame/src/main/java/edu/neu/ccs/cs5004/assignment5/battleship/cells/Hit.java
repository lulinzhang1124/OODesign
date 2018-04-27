package edu.neu.ccs.cs5004.assignment5.battleship.cells;

/**
 * Represents hit result of a cell.
 */

public class Hit implements AttackResult {

  /**
   * Get the attack result for a cell.
   *
   * @return a string represent the attack result, in this case, is "Hit".
   */
  @Override
  public String attackResult() {
    return "Hit";
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

  @Override
  public String toString() {
    return "Hit";
  }
}

package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represent sunk of a cell.
 */
public class Sunk implements MarkSunk {

  @Override
  public String isSunk() {
    return "Sunk";
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
    return 41;
  }

}

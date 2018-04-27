package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represents a cruiser.
 */
public class Cruiser extends AbstractShip {

  public Cruiser(Integer size, Integer numberHitCells) {
    super(size, numberHitCells);
    this.size = 3;
  }

  @Override
  public String toString() {
    return "Cruiser{" + "size=" + size + ", numberHitCells=" + numberHitCells + '}';
  }
}



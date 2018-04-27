package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represents a destoryer.
 */
public class Destoryer extends AbstractShip {

  public Destoryer(Integer size, Integer numberHitCells) {
    super(size, numberHitCells);
    this.size = 1;
  }

  @Override
  public String toString() {
    return "Destoryer{" + "size=" + size + ", numberHitCells=" + numberHitCells + '}';
  }
}

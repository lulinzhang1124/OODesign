package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represent a battleship for the game program.
 */

public class Battleship extends AbstractShip {

  public Battleship(Integer size, Integer numberHitCells) {
    super(size, numberHitCells);
    this.size = 4;
  }

  @Override
  public String toString() {
    return "Battleship{" + "size=" + size
        + ", numberHitCells=" + numberHitCells + '}';
  }
}

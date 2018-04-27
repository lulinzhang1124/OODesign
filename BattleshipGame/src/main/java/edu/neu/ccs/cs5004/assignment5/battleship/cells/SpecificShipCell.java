package edu.neu.ccs.cs5004.assignment5.battleship.cells;


import edu.neu.ccs.cs5004.assignment5.battleship.ships.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;


/**
 * Represents a specific ship cell.
 */

public class SpecificShipCell extends AbstractShipCell implements IspecificShipCell {
  private Ship ship;

  /**
   * Creates a specific ship cell.
   *
   * @param isHit - if the cell has been hit.
   * @param markSunk - cell has been sunk or not sunk.
   * @param ship - the ship inside specific ship cell.
   */
  public SpecificShipCell(Boolean isHit, MarkSunk markSunk, Ship ship) {
    super(isHit, markSunk);
    this.ship = ship;
  }

  /**
   * Getter.
   *
   * @return the markSunk value.
   */
  @Override
  public MarkSunk getMarkSunk() {
    if (ship.isSunk()) {
      return new Sunk();
    }
    return new NotSunk();
  }

  /**
   * Print the cell.
   *
   * @param printer - a printer which is the instance of the ConsolePrinter class.
   */
  @Override
  public void prettyPrint(Printer printer) {
    printer.toConsole(this);
  }

  /**
   * Getter.
   *
   * @return the ship which placed on the cell.
   */
  public Ship getShip() {
    return ship;
  }

  /**
   * Get the attack result for a cell.
   *
   * @return a attack result.
   */
  @Override
  public AttackResult attackResult() {
    if (this.ship.isSunk()) {
      return new ResultSunk();
    } else {
      return new Hit();
    }
  }

  /**
   * Attacks the cell.
   *
   * @return the same cell but with the filed isHitShip marked as true.
   */
  @Override
  public Cell attack() {
    this.isHit = true;
    this.ship = ship.hitShip();
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }

    SpecificShipCell that = (SpecificShipCell) obj;

    return ship != null ? ship.equals(that.ship) : that.ship == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (ship != null ? ship.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SpecificShipCell{"
            + "ship="
            + ship
            + ", markSunk="
            + markSunk
            + ", isHitShip="
            + isHit
            + '}';
  }
}

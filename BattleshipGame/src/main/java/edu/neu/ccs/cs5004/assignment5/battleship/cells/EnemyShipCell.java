package edu.neu.ccs.cs5004.assignment5.battleship.cells;

import edu.neu.ccs.cs5004.assignment5.battleship.ships.Ship;
import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

/**
 * Represents an abstract ship cell.
 */
public class EnemyShipCell extends AbstractShipCell implements IenemyShipCell {
  private Boolean sunkShip;//an attribute that indicates if it belongs to a sunk ship or not.

  /**
   * Creates a enemy ship cell.
   *
   * @param isHit - indicate if the cell has been hit.
   * @param markSunk - indicate the cell is sunk or not sunk.
   * @param sunkShip - indicate if the cell belongs to a sunk ship.
   */
  public EnemyShipCell(Boolean isHit, MarkSunk markSunk, Boolean sunkShip) {
    super(isHit, markSunk);
    this.sunkShip = sunkShip;
  }


  /**
   * Getter.
   *
   * @return true if the cell is belong to a sunk ship, false otherwise.
   */
  public Boolean getSunkShip() {
    return sunkShip;
  }


  /**
   * Updates the cells which belong to the ship using observer pattern.
   *
   * @param observable - a ship serves as the observable in observer pattern.
   */
  @Override
  public void update(Ship observable) {
    this.sunkShip = observable.isSunk();
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
   * Get the attack result for a cell.
   *
   * @return a attack result
   */
  @Override
  public AttackResult attackResult() {
    return new Miss();
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
    EnemyShipCell that = (EnemyShipCell) obj;
    return sunkShip != null ? sunkShip.equals(that.sunkShip) : that.sunkShip == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (sunkShip != null ? sunkShip.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "EnemyShipCell{" + "sunkShip=" + sunkShip
        + ", markSunk=" + markSunk + ", isHitShip=" + isHit + '}';
  }
}

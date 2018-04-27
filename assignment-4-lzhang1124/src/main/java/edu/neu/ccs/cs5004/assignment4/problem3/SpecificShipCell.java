package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represents a specific ship cell.
 */

public class SpecificShipCell extends AbstractShipCell {
  private Ship ship;

  public SpecificShipCell(Boolean isHit, MarkSunk markSunk, Ship ship) {
    super(isHit, markSunk);
    this.ship = ship;
  }

  /**
   * Getter.
   *
   * @return the ship which placed on the cell
   */
  public Ship getShip() {
    return ship;
  }

  @Override
  public AttackResult attackResult() {
    if (this.ship.isSunk()) {
      return new ResultSunk();
    } else {
      return new Hit();
    }
  }

  @Override
  public Cell attack() {
    this.isHit = true;
    this.ship.hitShip();
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
        + "ship=" + ship
        + ", markSunk=" + markSunk
        + ", isHit=" + isHit + '}';
  }
}

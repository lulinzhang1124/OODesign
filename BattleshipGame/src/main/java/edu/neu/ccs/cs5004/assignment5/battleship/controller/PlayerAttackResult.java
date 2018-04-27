package edu.neu.ccs.cs5004.assignment5.battleship.controller;

import edu.neu.ccs.cs5004.assignment5.battleship.enums.Coordinate;

/**
 * Represents a playerAttackResult.
 */
public class PlayerAttackResult {

  private Coordinate coordinate;
  private boolean hitShip;
  private boolean shipSunk;
  private int sunkCount;

  /**
   * Constructor of player attack result.
   *
   * @param coordinate - the coordinate player choose.
   * @param hitShip      - if the coordinate has been hit.
   * @param shipSunk - if the coordinate belongs to a sunk ship.
   * @param sunkCount  - the total sunk ship.
   */

  public PlayerAttackResult(Coordinate coordinate, boolean hitShip, boolean shipSunk,
                            int sunkCount) {
    this.coordinate = coordinate;
    this.hitShip = hitShip;
    this.shipSunk = shipSunk;
    this.sunkCount = sunkCount;
  }

  /**
   * Getter for coordinate.
   *
   * @return coordinate for the cell
   */
  public Coordinate getCoordinate() {
    return coordinate;
  }

  /**
   * Getter for isHitShip
   *
   * @return boolean indicate the cell isHitShip or not.
   */
  public boolean isHitShip() {
    return hitShip;
  }

  /**
   * Getter for isShipSunk
   *
   * @return boolean indicate if the ship is sunk or not.
   */
  public boolean isShipSunk() {
    return shipSunk;
  }

  /**
   * Getter fot the sunkCount.
   *
   * @return the sunk ship number.
   */
  public int getSunkCount() {
    return sunkCount;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    PlayerAttackResult that = (PlayerAttackResult) obj;

    if (isHitShip() != that.isHitShip()) {
      return false;
    }
    if (isShipSunk() != that.isShipSunk()) {
      return false;
    }
    if (getSunkCount() != that.getSunkCount()) {
      return false;
    }
    return getCoordinate() != null ? getCoordinate().equals(that.getCoordinate()) :
            that.getCoordinate() == null;
  }

  @Override
  public int hashCode() {
    int result = getCoordinate() != null ? getCoordinate().hashCode() : 0;
    result = 31 * result + (isHitShip() ? 1 : 0);
    result = 31 * result + (isShipSunk() ? 1 : 0);
    result = 31 * result + getSunkCount();
    return result;
  }

  @Override
  public String toString() {
    return "PlayerAttackResult{"
            +
            "coordinate="
            + coordinate
            +
            ", isHitShip="
            + hitShip
            +
            ", isShipSunk="
            + shipSunk
            +
            ", sunkCount="
            + sunkCount
            +
            '}';
  }
}
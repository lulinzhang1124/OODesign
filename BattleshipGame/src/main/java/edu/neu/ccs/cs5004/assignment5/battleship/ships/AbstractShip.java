package edu.neu.ccs.cs5004.assignment5.battleship.ships;


import edu.neu.ccs.cs5004.assignment5.battleship.cells.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents an abstract ship.
 */
public abstract class AbstractShip implements Ship {

  protected Integer size;
  protected Integer numberHitCells;
  private List<Cell> observers;

  /**
   * Constructor of a ship.
   *
   * @param size           - the number of cells a ship needs.
   * @param numberHitCells - the number of cells has been hit.
   */
  public AbstractShip(Integer size, Integer numberHitCells) {
    this.size = size;
    this.numberHitCells = numberHitCells;
    observers = new ArrayList<>();
  }

  /**
   * add observer to a list of observers.
   *
   * @param observer to register to the observable.
   */
  @Override
  public void registerObserver(Cell observer) {
    observers.add(observer);
    observer.update(this);
  }

  /**
   * notify observer if a model was changed.
   */
  @Override
  public void notifyObservers() {
    for (Cell obs : observers) {
      obs.update(this);
    }
  }

  /**
   * remove observer from a list of observers.
   *
   * @param observer to remove.
   */
  @Override
  public void removeObserver(Cell observer) {
    observers.remove(observer);
  }


  /**
   * Get getSize of the ship.
   *
   * @return getSize of the ship.
   */
  @Override
  public Integer getSize() {
    return this.size;
  }


  /**
   * Getter.
   *
   * @return the number of cells hit.
   */
  public Integer getNumberHitCells() {
    return numberHitCells;
  }


  /**
   * Indicates a ship is sunk or not.
   *
   * @return true if the ship is sunk, false otherwise.
   */
  @Override
  public Boolean isSunk() {
    return this.numberHitCells.equals(this.size);
  }

  /**
   * Indicate if the ship is hit or not.
   *
   * @return the updated ship after it was hit.
   */
  @Override
  public Ship hitShip() {
    this.numberHitCells++;
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
    AbstractShip that = (AbstractShip) obj;
    return Objects.equals(size, that.size)
            && Objects.equals(numberHitCells, that.numberHitCells);
  }

  @Override
  public int hashCode() {

    return Objects.hash(size, numberHitCells);
  }
}

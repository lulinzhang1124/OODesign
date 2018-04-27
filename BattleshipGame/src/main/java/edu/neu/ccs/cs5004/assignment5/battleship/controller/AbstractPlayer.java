package edu.neu.ccs.cs5004.assignment5.battleship.controller;


import edu.neu.ccs.cs5004.assignment5.battleship.maps.BattleMap;
import edu.neu.ccs.cs5004.assignment5.battleship.maps.FleetMap;
import edu.neu.ccs.cs5004.assignment5.battleship.maps.IbattleMap;
import edu.neu.ccs.cs5004.assignment5.battleship.maps.IfleetMap;
import edu.neu.ccs.cs5004.assignment5.battleship.strategy.Strategy;

/**
 * Represents an abstract player.
 */
public abstract class AbstractPlayer implements Player {

  protected IfleetMap ifleetMap;
  protected IbattleMap ibattleMap;
  private Strategy strategy;


  /**
   * Constructor of an abstract player.
   */
  public AbstractPlayer() {

    this.ifleetMap = new FleetMap();
    this.ibattleMap = new BattleMap();

  }

  /**
   * Getter for strategy.
   *
   * @return the strategy for the player.
   */
  public Strategy getStrategy() {
    return strategy;
  }

  /**
   * Setter for the strategy.
   *
   * @param strategy the strategy value to be set.
   */
  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Get the fleet map for the player.
   *
   * @return the fleet map.
   */
  @Override
  public IfleetMap getIfleetMap() {
    return ifleetMap;
  }

  /**
   * Get the battle map for the player.
   *
   * @return the battle map.
   */
  @Override
  public IbattleMap getIbattleMap() {
    return ibattleMap;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    AbstractPlayer that = (AbstractPlayer) obj;

    if (getIfleetMap() != null ? !getIfleetMap().equals(that.getIfleetMap())
            : that.getIfleetMap() != null) {
      return false;
    }
    if (getIbattleMap() != null ? !getIbattleMap().equals(that.getIbattleMap())
            : that.getIbattleMap() != null) {
      return false;
    }
    return getStrategy() != null ? getStrategy().equals(that.getStrategy())
            : that.getStrategy() == null;
  }

  @Override
  public int hashCode() {
    int result = getIfleetMap() != null ? getIfleetMap().hashCode() : 0;
    result = 31 * result + (getIbattleMap() != null ? getIbattleMap().hashCode() : 0);
    result = 31 * result + (getStrategy() != null ? getStrategy().hashCode() : 0);
    return result;
  }
}


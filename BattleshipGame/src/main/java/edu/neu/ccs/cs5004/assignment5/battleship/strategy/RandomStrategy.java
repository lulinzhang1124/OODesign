package edu.neu.ccs.cs5004.assignment5.battleship.strategy;

import edu.neu.ccs.cs5004.assignment5.battleship.enums.Column;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Coordinate;
import edu.neu.ccs.cs5004.assignment5.battleship.enums.Row;
import edu.neu.ccs.cs5004.assignment5.battleship.maps.IbattleMap;

import java.util.Random;

/**
 * Represents the random strategy of the game.
 */
public class RandomStrategy implements Strategy {

  private IbattleMap myBattleMap;

  /**
   * Creates a random strategy.
   *
   * @param myBattleMap - guess map.
   */
  public RandomStrategy(IbattleMap myBattleMap) {
    this.myBattleMap = myBattleMap;
  }

  /**
   * Gets the coordinate of attack for this time.
   *
   * @param isPreviousHit     - indicate if the coordinate has been previously hit.
   * @param isPreviousHitSunk - indicate if previous hit result in a sunk ship.
   * @return - the coordinate of attack for this time.
   */
  @Override
  public Coordinate generateAttackCoordinate(boolean isPreviousHit, boolean isPreviousHitSunk) {
    Row row;
    Column col;
    Coordinate coordinate = null;
    while (coordinate == null) {
      Random rand = new Random();
      row = Row.values()[rand.nextInt(10)];
      col = Column.values()[rand.nextInt(10)];

      if (myBattleMap.getMap(row, col).getIsHit()) {
        continue;
      }

      coordinate = new Coordinate(col, row);
    }
    return coordinate;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    RandomStrategy that = (RandomStrategy) obj;

    if (myBattleMap != null) {
      return myBattleMap.equals(that.myBattleMap);
    } else {
      return that.myBattleMap == null;
    }
  }

  @Override
  public int hashCode() {
    return myBattleMap != null ? myBattleMap.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "RandomStrategy{"
            +
            "myBattleMap="
            + myBattleMap
            +
            '}';
  }
}

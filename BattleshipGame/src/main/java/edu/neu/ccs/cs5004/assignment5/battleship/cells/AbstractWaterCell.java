package edu.neu.ccs.cs5004.assignment5.battleship.cells;


import edu.neu.ccs.cs5004.assignment5.battleship.viewer.Printer;

/**
 * Represent an abstract water cell.
 */
public abstract class AbstractWaterCell extends AbstractCell implements WaterCell {

  /**
   * Creates a abstract water cell.
   *
   * @param isHit - if the cell has been hit.
   */
  public AbstractWaterCell(Boolean isHit) {
    super(isHit);
  }


  /**
   * Gets attack result.
   *
   * @return a instance of Miss since there is no ship in the cell.
   */
  @Override
  public AttackResult attackResult() {
    return new Miss();
  }

  /**
   * Print the cell using method defined in Printer interface.
   *
   * @param printer - a instance of Printer.
   */
  @Override
  public void prettyPrint(Printer printer) {
    printer.toConsole(this);
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }

    if (this == other) {
      return true;
    }
    if (!super.equals(other)) {
      return false;
    }

    return this.getClass() == other.getClass();
  }


  @Override
  public int hashCode() {
    return 37;
  }



}

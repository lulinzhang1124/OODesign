package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represent an abstract water cell.
 */
public abstract class AbstractWaterCell extends AbstractCell implements WaterCell {

  public AbstractWaterCell(Boolean isHit) {
    super(isHit);
  }

  @Override
  public AttackResult attackResult() {
    return new Miss();
  }


}

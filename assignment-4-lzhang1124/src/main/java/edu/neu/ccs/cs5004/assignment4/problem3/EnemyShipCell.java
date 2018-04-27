package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represents an abstract ship cell.
 */
public class EnemyShipCell extends AbstractShipCell {
  private Boolean sunkShip;//an attribute that indicates if it belongs to a sunk ship or not.

  public EnemyShipCell(Boolean isHit, MarkSunk markSunk, Boolean sunkShip) {
    super(isHit, markSunk);
    this.sunkShip = sunkShip;
  }

  /**
   * Getter.
   *
   * @return true if the cell is belong to a sunk ship, false otherwise
   */
  public Boolean getSunkShip() {
    return sunkShip;
  }


  @Override
  public Cell attack() {
    return super.attack();
  }


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
        + ", markSunk=" + markSunk + ", isHit=" + isHit + '}';
  }
}

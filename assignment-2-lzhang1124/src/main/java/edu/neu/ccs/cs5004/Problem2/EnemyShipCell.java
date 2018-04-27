package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

public class EnemyShipCell extends AbstractShipCell {
    private Boolean sunkShip;//an attribute that indicates if it belongs to a sunk ship or not.

    public EnemyShipCell(Boolean isHit, markSunk markSunk, Boolean sunkShip) {
        super(isHit,markSunk);
        this.sunkShip = sunkShip;
    }

    /**
     * getter
     *
     * @return true if the cell is belong to a sunk ship, false otherwise
     */
    public Boolean getSunkShip() {
        return sunkShip;
    }

    /**
     * attack a cell
     * since we don't know this cell has a ship or not, let's assume it doesn't have a ship for now
     * @return the cell after attack
     */
    @Override
    public Cell attack() {
        return super.attack();
    }

    /**
     * get the attack result of a cell
     * since we don't know this cell has a ship or not, let's assume it doesn't have a ship for now
     * @return the attack result
     */
    @Override
    public attackResult attackResult() {
        return new Miss();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EnemyShipCell that = (EnemyShipCell) o;

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
        return "EnemyShipCell{" +
                "sunkShip=" + sunkShip +
                ", markSunk=" + markSunk +
                ", isHit=" + isHit +
                '}';
    }
}

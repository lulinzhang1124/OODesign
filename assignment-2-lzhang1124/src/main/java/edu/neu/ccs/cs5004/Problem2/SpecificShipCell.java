package edu.neu.ccs.cs5004.Problem2;

public class SpecificShipCell extends AbstractShipCell {
    private Ship ship;

    public SpecificShipCell(Boolean isHit, markSunk markSunk, Ship ship) {
        super(isHit,markSunk);
        this.ship = ship;
    }

    /**
     * getter
     *
     * @return the ship which palced on the cell
     */
    public Ship getShip() {
        return ship;
    }

    @Override
    public attackResult attackResult() {
        if (this.ship.isSunk()) return new ResultSunk();
        else return new Hit();
    }

    @Override
    public Cell attack() {
        this.isHit = true;
        this.ship.hitShip();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SpecificShipCell that = (SpecificShipCell) o;

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
        return "SpecificShipCell{" +
                "ship=" + ship +
                ", markSunk=" + markSunk +
                ", isHit=" + isHit +
                '}';
    }
}

package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

public abstract class AbstractShipCell extends AbstractCell implements ShipCell{
    protected markSunk markSunk;

    public AbstractShipCell(Boolean isHit, markSunk markSunk) {
        super(isHit);
        this.markSunk = markSunk;

    }

    /**
     * getter
     *
     * @return the markSunk value
     */
    public markSunk getMarkSunk() {
        return markSunk;
    }


    @Override
    public Boolean canPlacedShip() {
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AbstractShipCell that = (AbstractShipCell) o;

        return markSunk != null ? markSunk.equals(that.markSunk) : that.markSunk == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (markSunk != null ? markSunk.hashCode() : 0);
        return result;
    }
}

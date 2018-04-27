package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

public abstract class AbstractCell implements Cell {

    protected Boolean isHit;

    public AbstractCell(Boolean isHit) {
        this.isHit = isHit;
    }

    /**
     * getter
     *
     * @return true if the cell is hit, false otherwise
     */
    public Boolean getIsHit() {
        return isHit;
    }


    @Override
    public Cell attack() {
        this.isHit = true;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractCell that = (AbstractCell) o;

        return isHit != null ? isHit.equals(that.isHit) : that.isHit == null;
    }

    @Override
    public int hashCode() {
        return isHit != null ? isHit.hashCode() : 0;
    }
}

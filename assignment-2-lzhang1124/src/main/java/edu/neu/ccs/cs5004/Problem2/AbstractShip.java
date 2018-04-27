package edu.neu.ccs.cs5004.Problem2;

import java.util.Objects;

public abstract class
AbstractShip implements Ship {

    protected Integer size;
    protected Integer numberHitCells;

    public AbstractShip(Integer size, Integer numberHitCells) {
        this.size = size;
        this.numberHitCells = numberHitCells;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getNumberHitCells() {
        return numberHitCells;
    }

    @Override
    public Boolean isSunk() {
        return this.numberHitCells.equals(this.size);
    }

    @Override
    public Ship hitShip() {
        this.numberHitCells++;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractShip that = (AbstractShip) o;
        return Objects.equals(size, that.size) &&
                Objects.equals(numberHitCells, that.numberHitCells);
    }

    @Override
    public int hashCode() {

        return Objects.hash(size, numberHitCells);
    }
}

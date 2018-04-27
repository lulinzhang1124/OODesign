package edu.neu.ccs.cs5004.Problem2;

public class OpenSeaCell extends AbstractWaterCell {

    public OpenSeaCell(Boolean isHit) {
        super(isHit);
    }

    @Override
    public Boolean canPlacedShip() {
        return true;
    }

    @Override
    public String toString() {
        return "OpenSeaCell{" +
                "isHit=" + isHit +
                '}';
    }
}

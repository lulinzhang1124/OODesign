package edu.neu.ccs.cs5004.Problem2;

public class GapCell extends AbstractWaterCell {

    public GapCell(Boolean isHit){
        super(isHit);
    }

    @Override
    public Boolean canPlacedShip() {
        return false;
    }


    @Override
    public String toString() {
        return "GapCell{" +
                "isHit=" + isHit +
                '}';
    }
}

package edu.neu.ccs.cs5004.Problem2;

public class Submarine extends AbstractShip {
    public Submarine(Integer size, Integer numberHitCells) {
        super(size, numberHitCells);
        this.size = 2;
    }

    @Override
    public String toString() {
        return "Submarine{" +
                "size=" + size +
                ", numberHitCells=" + numberHitCells +
                '}';
    }
}

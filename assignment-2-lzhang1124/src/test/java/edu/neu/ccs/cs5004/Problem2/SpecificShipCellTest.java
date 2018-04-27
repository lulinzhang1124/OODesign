package edu.neu.ccs.cs5004.Problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpecificShipCellTest {
    SpecificShipCell specificShipCell;
    Ship ship;
    markSunk markSunk;

    @Before
    public void setUp() throws Exception {
        ship = new Battleship(4, 2);
        markSunk = new NotSunk();
        specificShipCell = new SpecificShipCell(false, true, ship, markSunk);
    }

    @Test
    public void toStringTest() {
        String temp = "SpecificShipCell{" +
                "ship=" + specificShipCell.ship +
                ", markSunk=" + specificShipCell.markSunk +
                ", isHit=" + specificShipCell.isHit +
                ", hasShip=" + specificShipCell.hasShip +
                '}';
        assertEquals(temp, specificShipCell.toString());
    }
}
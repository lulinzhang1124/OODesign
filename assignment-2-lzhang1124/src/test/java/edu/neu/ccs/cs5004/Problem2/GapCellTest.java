package edu.neu.ccs.cs5004.Problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GapCellTest {

    GapCell gapCell;

    @Before
    public void setUp() throws Exception {
        gapCell = new GapCell(true, false, true);
    }

    @Test
    public void toStringTest() {
        String temp = "GapCell{" +
                "hasAdjacentCell=" + gapCell.hasAdjacentCell +
                ", isHit=" + gapCell.isHit +
                ", hasShip=" + gapCell.hasShip +
                '}';
        assertEquals(temp, gapCell.toString());
    }
}
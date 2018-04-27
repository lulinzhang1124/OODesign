package edu.neu.ccs.cs5004.Problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OpenSeaCellTest {

    OpenSeaCell OpenSeaCell;

    @Before
    public void setUp() throws Exception {
        OpenSeaCell = new OpenSeaCell(false, false, false);
    }


    @Test
    public void toStringTest() {
        String temp = "OpenSeaCell{" +
                "hasAdjacentCell=" + OpenSeaCell.hasAdjacentCell +
                ", isHit=" + OpenSeaCell.isHit +
                ", hasShip=" + OpenSeaCell.hasShip +
                '}';
        assertEquals(temp, OpenSeaCell.toString());
    }
}
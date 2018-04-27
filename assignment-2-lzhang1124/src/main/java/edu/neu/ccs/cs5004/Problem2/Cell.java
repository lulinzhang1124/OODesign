package edu.neu.ccs.cs5004.Problem2;

public interface Cell {
    /**
     * Get the attack result for a cell
     *
     * @return a attack result
     */
    attackResult attackResult();

    /**
     * a ship can/cannot be placed on this cell
     *
     * @return true if a ship can place on this cell, false otherwise
     */
    Boolean canPlacedShip();

    /**
     * attack the cell
     *
     * @return the updated cell after the attack
     */
    Cell attack();

}

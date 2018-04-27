package edu.neu.ccs.cs5004.Problem2;

public interface Ship {
    /**
     *
     * @return the upadated ship after it was hit
     */
    Ship hitShip();

    /**
     * indicates a ship is sunk or not
     *
     * @return true if the ship is sunk, false otherwise
     */
    Boolean isSunk();
}

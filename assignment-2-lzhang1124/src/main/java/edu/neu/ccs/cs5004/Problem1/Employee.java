/**
 * Represents a Shape in our shapes program.
 */
package edu.neu.ccs.cs5004.Problem1;

public interface Employee {


    /**
     * Move this shape by {@code dy} units in the y-direction.
     *
     * @param bonus units to move in the y-direction
     * @return new shape with its y-coordinate moved dy units
     */
    Integer addBonus(Integer bonus);

    /**
     * Get the area of this shape.
     *
     * @return area of this shape
     */
    String uniqueBehavior();

    /**
     * Get the circumference of this shape.
     *
     * @return circumference of this shape
     */
    Integer extraVacation(Integer servedYear);


}
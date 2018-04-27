package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represents a row in the map.
 */
public enum Row {

  ROW1, ROW2, ROW3, ROW4, ROW5, ROW6, ROW7, ROW8, ROW9, ROW10;

  /**
   * Covert an integer to the corresponding enum.
   *
   * @param index the integer to be covert
   * @return the corresponding enum
   * @throws IndexOutOfBoundsException when there is no such enum represent this integer.
   */
  static Row valueOf(int index) throws IndexOutOfBoundsException {
    switch (index) {
      case 0:
        return ROW1;
      case 1:
        return ROW2;
      case 2:
        return ROW3;
      case 3:
        return ROW4;
      case 4:
        return ROW5;
      case 5:
        return ROW6;
      case 6:
        return ROW7;
      case 7:
        return ROW8;
      case 8:
        return ROW9;
      case 9:
        return ROW10;
      default:
        throw new IndexOutOfBoundsException("Row index out of boundary.");
    }
  }

  @Override
  public String toString() {
    return "Row{}";
  }
}
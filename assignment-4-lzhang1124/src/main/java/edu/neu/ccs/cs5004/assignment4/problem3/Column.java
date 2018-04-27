package edu.neu.ccs.cs5004.assignment4.problem3;

/**
 * Represent a column in the map.
 */

public enum Column {

  A, B, C, D, E, F, G, H, I, J;

  /**
   * Covert an integer to the corresponding enum.
   *
   * @param index the integer to be covert
   * @return the corresponding enum
   * @throws IndexOutOfBoundsException when there is no such enum represent this integer.
   */
  static Column valueOf(int index) throws IndexOutOfBoundsException {
    switch (index) {
      case 0:
        return A;
      case 1:
        return B;
      case 2:
        return C;
      case 3:
        return D;
      case 4:
        return E;
      case 5:
        return F;
      case 6:
        return G;
      case 7:
        return H;
      case 8:
        return I;
      case 9:
        return J;
      default:
        throw new IndexOutOfBoundsException("Column index out of boundary.");
    }
  }

  @Override
  public String toString() {
    return "Column{}";
  }
}

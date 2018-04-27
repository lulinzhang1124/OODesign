package edu.neu.ccs.cs5004.assignment5.battleship.enums;

/**
 * Represents a coordinate.
 */
public class Coordinate {
  private Column column;
  private Row row;

  /**
   * Constructor for coordinate.
   *
   * @param column - the column value.
   * @param row    - the row value.
   */
  public Coordinate(Column column, Row row) {
    this.column = column;
    this.row = row;
  }

  /**
   * Getter for property 'Column'.
   *
   * @return value for property 'Column'.
   */
  public Column getColumn() {
    return column;
  }

  /**
   * Getter for property 'Row'.
   *
   * @return value for property 'Row'.
   */
  public Row getRow() {
    return row;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Coordinate that = (Coordinate) obj;

    if (getColumn() != that.getColumn()) {
      return false;
    }
    return getRow() == that.getRow();
  }

  @Override
  public int hashCode() {
    int result = getColumn() != null ? getColumn().hashCode() : 0;
    result = 31 * result + (getRow() != null ? getRow().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Coordinate [column="
            + column
            + ", row="
            + row
            + "]";
  }


}

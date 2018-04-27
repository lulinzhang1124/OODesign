package edu.neu.ccs.cs5004.assignment3.problem2.pkg1;

import java.util.Objects;

/**
 * Represents the salary of an employee.
 */
public class Salary {
  private Integer dollar;

  public Salary(Integer salary) {
    this.dollar = salary;
  }

  /**
   * Getter fot 'dollar'.
   *
   * @return the dollar value.
   */
  public Integer getDollar() {
    return dollar;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Salary salary1 = (Salary) obj;
    return Objects.equals(dollar, salary1.dollar);
  }

  @Override
  public int hashCode() {

    return Objects.hash(dollar);
  }

  @Override
  public String toString() {

    return "Salary{" + "salary=" + dollar + '}';
  }
}
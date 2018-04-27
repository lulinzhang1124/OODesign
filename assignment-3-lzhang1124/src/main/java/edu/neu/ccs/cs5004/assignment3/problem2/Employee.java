package edu.neu.ccs.cs5004.assignment3.problem2;

import edu.neu.ccs.cs5004.assignment3.problem2.pkg1.Salary;

/**
 * Represents an employee in a law firm.
 */

public interface Employee {

  /**
   * Getter for property 'Name'.
   *
   * @return Value for property 'Name'.
   */
  Name getName();

  /**
   * Getter fot the property "Workload".
   *
   * @return workload value.
   */
  Integer getWorkload();

  /**
   * Getter fot the property "PaidVacation".
   *
   * @return paid vacation days value.
   */
  Integer getPaidVacation();

  /**
   * Getter fot the property "employeeId".
   *
   * @return employee ID
   */
  String getEmployeeId();

  /**
   * Get the unique behavior of an employee
   *
   * @return a string represented the unique behavior of an employee.
   */
  String uniqueBehavior();

  /**
   * Getter fot the property 'ServedYear'..
   *
   * @return served years in this company
   */
  Integer getServedYear();

  /**
   * Get the extra vacation an employee can have.
   * Lawyer, HR Manager and Legal Secretary can get 2 more vacation days pei served in this company.
   * General Secretary don't have extra vacations.
   *
   * @return the extra vacation days for employee
   */
  Integer extraVacation();

  /**
   * Add bonus to an employee's salary.
   * Employee can requested to HR Manager of increasing salary. If agreed, the salary will
   * increase by{@code amt}.If not, the salary remains the same.
   *
   * @param amt the amount need to be increased
   * @return the salary after an increase salary request
   */
  Salary addBonus(Integer amt);

  /**
   * Add bonus to several employees'{@code employees} salaries.
   * Employee can requested to HR Manager of increasing salary. If agreed, the salary of all
   * employees will increase by{@code amt}.If not, the salary remains the same.
   *
   * @param employees array of several employees
   * @param amt       the amount need to be increased
   * @return the array of salary after an increase salary request
   */
  Salary[] addBonusEmployees(Employee[] employees, Integer amt);


  /**
   * Get an employee's salary.
   *
   * @return the salary of an employee
   */
  Salary getEmployeeSalary();


}
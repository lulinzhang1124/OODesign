package edu.neu.ccs.cs5004.assignment3.problem2;

import edu.neu.ccs.cs5004.assignment3.problem2.pkg1.HrManager;
import edu.neu.ccs.cs5004.assignment3.problem2.pkg1.Salary;

import java.util.Objects;

/**
 * Represents the common properties of an employee.
 */
public abstract class AbstractEmployee implements Employee {

  protected Name name;
  protected Salary salary;
  protected Integer paidVacation;
  protected Integer workload;
  protected String employeeId;
  protected Integer servedYear;

  /**
   * Create an abstract employee.
   *
   * @param name         name of the employee.
   * @param workload     workload hours per week.
   * @param paidVacation paid vacation days per year.
   * @param employeeId   a String represent the unique employee ID.
   * @param servedYear   the year of the employee served in the company
   */
  public AbstractEmployee(Name name, Integer workload, Integer paidVacation,
                          String employeeId, Integer servedYear) {
    this.name = name;
    this.workload = workload;
    this.paidVacation = paidVacation;
    this.employeeId = employeeId;
    this.servedYear = servedYear;
    this.salary = getEmployeeSalary();
  }

  @Override
  public Name getName() {
    return name;
  }

  @Override
  public Integer getWorkload() {
    return workload;
  }


  @Override
  public Integer getPaidVacation() {
    return paidVacation;
  }

  @Override
  public String getEmployeeId() {
    return employeeId;
  }

  @Override
  public Integer getServedYear() {
    return servedYear;
  }

  @Override
  public Integer extraVacation() {
    return 2 * servedYear;
  }

  @Override
  public Salary getEmployeeSalary() {
    return HrManager.employeeSalary(this);
  }

  @Override
  public Salary addBonus(Integer amt) {
    if (HrManager.requestSalaryIncrease(this, amt).equals("Yes.")) {
      return new Salary(amt + this.getEmployeeSalary().getDollar());
    }
    return this.salary;
  }

  @Override
  public Salary[] addBonusEmployees(Employee[] employees, Integer amt) {
    Salary[] updateSalary = new Salary[employees.length];
    if (HrManager.requestSeveralSalaryIncrease(employees, amt).equals("Yes.")) {

      for (int i = 0; i < employees.length; i++) {
        updateSalary[i] = new Salary(amt + employees[i].getEmployeeSalary().getDollar());
      }
    } else {
      for (int i = 0; i < employees.length; i++) {
        updateSalary[i] = employees[i].getEmployeeSalary();
      }
    }
    return updateSalary;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AbstractEmployee that = (AbstractEmployee) obj;
    return Objects.equals(name, that.name)
        && Objects.equals(workload, that.workload)
        && Objects.equals(salary, that.salary)
        && Objects.equals(paidVacation, that.paidVacation)
        && Objects.equals(employeeId, that.employeeId)
        && Objects.equals(servedYear, that.servedYear);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, workload, salary, paidVacation, employeeId, servedYear);
  }
}



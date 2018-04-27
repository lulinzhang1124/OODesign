package edu.neu.ccs.cs5004.assignment3.problem2.pkg1;

import edu.neu.ccs.cs5004.assignment3.problem2.AbstractEmployee;
import edu.neu.ccs.cs5004.assignment3.problem2.Employee;
import edu.neu.ccs.cs5004.assignment3.problem2.GeneralSecretary;
import edu.neu.ccs.cs5004.assignment3.problem2.Lawyer;
import edu.neu.ccs.cs5004.assignment3.problem2.Name;


import java.util.Objects;


/**
 * Represents a HR Manager in our program..
 */
public class HrManager extends AbstractEmployee implements IhrManager {
  private static final Integer BASE_SALARY = 40000;
  private static final Integer HR_SALARY_FACTOR = 5000;
  private static final Integer LAWYER_SALARY_FACTOR = 2;
  private static final Integer LEGAL_SECRETARY_FACTOR = 10000;

  private Integer recruited;

  /**
   * Created a HR Manager.
   *
   * @param name         name of the employee.
   * @param workload     workload hours per week.
   * @param paidVacation paid vacation days per year.
   * @param employeeId   a String represent the unique employee ID.
   * @param servedYear   the year of the employee served in the company.
   * @param recruited    the number of employees this HR Manager recruited.
   */
  public HrManager(Name name, Integer workload, Integer paidVacation,
                   String employeeId, Integer servedYear, Integer recruited) {
    super(name, workload, paidVacation, employeeId, servedYear);
    this.recruited = recruited;
    this.salary = new Salary(BASE_SALARY + HR_SALARY_FACTOR * recruited);
    this.paidVacation = super.paidVacation + this.extraVacation() + 7;
  }

  /**
   * Get the salary of an employee type by{@code type}.
   * Lawyer's salary is 2 times of the basic salary.
   * HR Manager get extra 5000 per recruited.
   * Legal Secretary get extra 10000.
   *
   * @param type the employee type
   * @return the salary of an employee type.
   */
  public static Salary employeeSalary(Employee type) {
    if (type.getClass().equals(Lawyer.class)) {
      return new Salary(BASE_SALARY * LAWYER_SALARY_FACTOR);
    } else if (type.getClass().equals(HrManager.class)) {
      return type.getEmployeeSalary();
    } else if (type.getClass().equals(GeneralSecretary.class)) {
      return new Salary(BASE_SALARY);
    } else {
      return new Salary(BASE_SALARY + LEGAL_SECRETARY_FACTOR);
    }
  }

  /**
   * Indicate if an {@code amt}increase salary request by{@code employee} can be approved.
   *
   * @param employee the employee who requested an salary increase.
   * @param amt      the amount requested to increase.
   * @return String 'Yes.' if the request is approved, String "No." if not.
   */
  public static String requestSalaryIncrease(Employee employee, Integer amt) {
    if (amt <= 10000) {
      return "Yes.";
    } else {
      return "No.";
    }
  }


  /**
   * Indicate if an {@code amt}increase salary request by{@code employee} can be approved.
   *
   * @param employees several employees as an array.
   * @param amt       the amount requested to increase.
   * @return String 'Yes.' if the request is approved, String "No." if not.
   */
  public static String requestSeveralSalaryIncrease(Employee[] employees, Integer amt) {
    if (amt < 10000) {
      return "Yes.";
    } else {
      return "No.";
    }
  }

  @Override
  public Salary getEmployeeSalary() {
    return salary;
  }

  @Override
  public String huntTalents() {
    return "Let's hunt talents!";
  }

  @Override
  public String uniqueBehavior() {
    return this.huntTalents();
  }

  /**
   * Getter for 'recruited'.
   *
   * @return the recruited number.
   */
  public Integer getRecruited() {
    return recruited;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    HrManager hrManager = (HrManager) obj;
    return Objects.equals(recruited, hrManager.recruited);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), recruited);
  }

  @Override
  public String toString() {
    return "HrManager{" + "recruited="
        + recruited + ", name=" + name
        + ", salary=" + salary
        + ", paidVacation=" + paidVacation + '}';
  }
}
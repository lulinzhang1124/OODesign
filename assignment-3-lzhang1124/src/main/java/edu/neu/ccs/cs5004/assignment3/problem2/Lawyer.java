package edu.neu.ccs.cs5004.assignment3.problem2;

/**
 * Represents a lawyer in our program.
 */
public class Lawyer extends AbstractEmployee implements ILawyer {

  /**
   * Create a lawyer in company.
   *
   * @param name         name of the employee.
   * @param workload     workload hours per week.
   * @param paidVacation paid vacation days per year.
   * @param employeeId   a String represent the unique employee ID.
   * @param servedYear   the year of the employee served in the company.
   */
  public Lawyer(Name name, Integer workload, Integer paidVacation,
                String employeeId, Integer servedYear) {
    super(name, workload, paidVacation, employeeId, servedYear);
    this.salary = getEmployeeSalary();
    this.paidVacation = super.paidVacation + this.extraVacation();
  }

  @Override
  public String sue() {
    return "Let's sue!";
  }

  @Override
  public String uniqueBehavior() {
    return this.sue();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + 31;
    return result;
  }


  @Override
  public String toString() {
    return "Lawyer{" + "name=" + name
        + ", workload=" + this.getWorkload()
        + ", salary=" + salary
        + ", paidVacation=" + paidVacation
        + ", employeeId='" + this.getEmployeeId() + '\''
        + ", servedYear=" + this.getServedYear() + '}';
  }


}

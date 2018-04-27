package edu.neu.ccs.cs5004.assignment3.problem2;


/**
 * Represents a legal secretary for our program.
 */

public class LegalSecretary extends AbstractSecretary implements ILegalSecretary {

  /**
   * Create a legal secretary in company.
   *
   * @param name         name of the employee.
   * @param workload     workload hours per week.
   * @param paidVacation paid vacation days per year.
   * @param employeeId   a String represent the unique employee ID.
   * @param servedYear   the year of the employee served in the company.
   */
  public LegalSecretary(Name name, Integer workload, Integer paidVacation,
                        String employeeId, Integer servedYear) {
    super(name, workload, paidVacation, employeeId, servedYear);
    this.paidVacation = super.paidVacation + this.extraVacation();
    this.salary = getEmployeeSalary();

  }

  @Override
  protected AbstractSecretary copyFactory(AbstractSecretary as1) {
    return new LegalSecretary(this.name, this.getWorkload(), 14,
        this.getEmployeeId(), this.getServedYear());
  }

  @Override
  public String prepareLegalDoc() {
    return "Let's prepare legal documents!";
  }

  @Override
  public String uniqueBehavior() {
    return super.uniqueBehavior() + " " + this.prepareLegalDoc();
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
    return "LegalSecretary{"
        + " name=" + name
        + ", workload=" + this.getWorkload()
        + ", salary=" + this.getEmployeeSalary()
        + ", paidVacation=" + paidVacation
        + ", employeeId='" + this.getEmployeeId() + '\''
        + ", servedYear=" + this.getServedYear()
        + '}';
  }
}
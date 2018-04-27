package edu.neu.ccs.cs5004.assignment3.problem2;

/**
 * Represents a general secretary for our program..
 */
public class GeneralSecretary extends AbstractSecretary implements IGeneralSecretary {

  public GeneralSecretary(Name name, Integer workload, Integer paidVacation,
                          String employeeId, Integer servedYear) {
    super(name, workload, paidVacation, employeeId, servedYear);
    this.salary = getEmployeeSalary();
  }

  @Override
  public Integer extraVacation() {
    return 0;
  }

  @Override
  protected AbstractSecretary copyFactory(AbstractSecretary as1) {
    return new LegalSecretary(this.name, this.getWorkload(), this.paidVacation,
        this.getEmployeeId(), this.getServedYear());
  }

  @Override
  public Secretary promote(GeneralSecretary gs1) {
    return copyFactory(gs1);
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
    return "GeneralSecretary{"
        + "name=" + name
        + ", workload=" + this.getWorkload()
        + ", salary=" + salary
        + ", paidVacation=" + paidVacation
        + ", employeeId='" + this.getEmployeeId() + '\''
        + ", servedYear=" + this.getServedYear()
        + '}';
  }
}

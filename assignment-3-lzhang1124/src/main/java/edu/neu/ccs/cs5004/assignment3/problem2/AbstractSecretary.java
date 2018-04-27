package edu.neu.ccs.cs5004.assignment3.problem2;

/**
 * Represents the common properties of a secretary.
 */
public abstract class AbstractSecretary extends AbstractEmployee implements Secretary {

  /**
   * Create an abstract secretary.
   *
   * @param name         name of the employee.
   * @param workload     workload hours per week.
   * @param paidVacation paid vacation days per year.
   * @param employeeId   a String represent the unique employee ID.
   * @param servedYear   the year of the employee served in the company.
   */
  public AbstractSecretary(Name name, Integer workload, Integer paidVacation,
                           String employeeId, Integer servedYear) {
    super(name, workload, paidVacation, employeeId, servedYear);
    this.salary = getEmployeeSalary();

  }

  @Override
  public String scheduleMeeting() {
    return "Let's schedule meetings.";
  }

  @Override
  public String uniqueBehavior() {
    return this.scheduleMeeting();
  }

  /**
   * Change the secretary type from one to another.
   *
   * @param as1 the secretary type
   * @return the new secretary type
   */
  protected abstract AbstractSecretary copyFactory(AbstractSecretary as1);

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + 31;
    return result;
  }


}

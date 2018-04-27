package edu.neu.ccs.cs5004.Problem1;

/**
 * Represents a Circle in our shapes program.
 */
public class GeneralSecretary extends AbstractSecretary {

    public GeneralSecretary(Name name, Integer workload, Integer salary, Integer paidVacation,
                            String employeeID, Integer servedYear) {
        super(name, workload, salary, paidVacation, employeeID, servedYear);

    }

    @Override
    public Integer extraVacation(Integer servedYear) {
        return 0;
    }

    //promote an existing General Secretary to Legal Secretary role.

    protected AbstractSecretary promote(GeneralSecretary gs) {
        return new LegalSecretary(this.name, this.workload, this.salary, this.paidVacation,
                this.employeeID, this.servedYear);
    }

    @Override
    public String toString() {
        return "GeneralSecretary{" +
                "name=" + name +
                ", workload=" + workload +
                ", salary=" + salary +
                ", paidVacation=" + paidVacation +
                ", employeeID='" + employeeID + '\'' +
                ", servedYear=" + servedYear +
                '}';
    }
}

package edu.neu.ccs.cs5004.Problem1;

public class LegalSecretary extends AbstractSecretary {

    public LegalSecretary(Name name, Integer workload, Integer salary, Integer paidVacation,
                          String employeeID, Integer servedYear) {
        super(name, workload, salary, paidVacation, employeeID, servedYear);
        this.salary = 10000 + super.salary;
        this.paidVacation = super.paidVacation + this.extraVacation(this.servedYear);
    }

    @Override
    protected AbstractSecretary promote(GeneralSecretary gs) {
        return new LegalSecretary(this.name, this.workload, this.salary, this.paidVacation,
                this.employeeID, this.servedYear);
    }

    @Override
    public String uniqueBehavior() {
        return super.uniqueBehavior() + " Let's prepare legal documents!";
    }

    @Override
    public String toString() {
        return "LegalSecretary{" +
                "name=" + name +
                ", workload=" + workload +
                ", salary=" + salary +
                ", paidVacation=" + paidVacation +
                ", employeeID='" + employeeID + '\'' +
                ", servedYear=" + servedYear +
                '}';
    }
}
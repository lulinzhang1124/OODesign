package edu.neu.ccs.cs5004.Problem1;

public abstract class AbstractSecretary extends AbstractEmployee {

    public AbstractSecretary(Name name, Integer workload, Integer salary, Integer paidVacation,
                             String employeeID, Integer servedYear) {
        super(name, workload, salary, paidVacation, employeeID, servedYear);

    }

    public String uniqueBehavior() {
        return "Let's schedule meetings.";
    }

    protected abstract AbstractSecretary promote(GeneralSecretary gs);

}

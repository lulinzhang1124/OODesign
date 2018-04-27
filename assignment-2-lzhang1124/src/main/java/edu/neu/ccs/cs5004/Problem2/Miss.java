package edu.neu.ccs.cs5004.Problem2;

public class Miss implements attackResult {

    @Override
    public String attackResult() {
        return "Miss";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 23;
    }
}

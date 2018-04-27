package edu.neu.ccs.cs5004.Problem1;

import java.util.Objects;

public class Name {

    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(first, name.first) &&
                Objects.equals(last, name.last);
    }

    @Override
    public int hashCode() {

        return Objects.hash(first, last);
    }

    @Override
    public String toString() {
        return "Name{" + first + " " + last + '}';
    }
}

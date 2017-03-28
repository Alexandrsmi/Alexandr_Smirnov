package ru.job4j.bank;

/**
 * @author Aleksandr Smirnov.
 */
public class Account extends Accounts {
    private double values;
    private int requisites;

    public Account(double values, int requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public int getRequisites() {
        return requisites;
    }

    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }

    @Override
    public String toString() {
        return "Account{" +
                "values=" + values +
                ", requisites=" + requisites +
                '}';
    }

}

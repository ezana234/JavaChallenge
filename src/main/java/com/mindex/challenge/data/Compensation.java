package com.mindex.challenge.data;

/**
 * Compensation Class
 */
public class Compensation {
    private Employee employee;
    private double salary;
    private String effectiveDate;

    /**
     * Empty Constructor
     */
    public Compensation() {
    }

    /**
     * Sets an Employee Object to the local private employee variable
     * @param employee an employee object
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * This function returns the employee
     * @return employee object
     */
    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * This function sets the salary to the local private salary
     * @param salary double value
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * This function returns the salary variable
     * @return salary value
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * This function sets effectiveDate to the local private effectiveDate
     * @param effectiveDate a date value
     */
    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * This function returns the effectiveDate variable
     * @return effectiveDate value
     */
    public String getEffectiveDate() {
        return this.effectiveDate;
    }
}

package com.mindex.challenge.data;

/**
 * CompensationBody Class: Used to parse the Compensation Post request body
 */
public class CompensationBody {
    private String employeeId;
    private double salary;
    private String effectiveDate;

    /**
     * Empty Constructor
     */
    public CompensationBody() {
    }

    /**
     * This function sets the employeeId variable
     * @param employeeId an employee's id
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * This function returns employeeId value
     * @return employeeId value
     */
    public String getEmployeeId() {
        return this.employeeId;
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

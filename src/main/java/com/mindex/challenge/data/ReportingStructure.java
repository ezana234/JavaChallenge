package com.mindex.challenge.data;

/**
 * ReportingStructure Class
 */
public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;

    /**
     * Empty Constructor
     */
    public ReportingStructure() {
    }

    /**
     * This function sets an employee object to the local private employee variable
     * @param employee an Employee object
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * This function returns the class' employee object
     * @return Employee object
     */
    public Employee getEmployee() {
        return this.employee;
    }

    /**
     * This function sets the number of reports to the local private numberOfReports variable
     * @param numberOfReports integer value for the numberOfReports
     */
    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    /**
     * This function returns the class' numberOfReports
     * @return numberOfReports integer value
     */
    public int getNumberOfReports() {
        return this.numberOfReports;
    }
}

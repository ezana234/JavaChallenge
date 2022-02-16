package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This function tests routes associated with the ReportingStructure class
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest {

    private String reportIdUrl;
    private String employeeUrl;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * This sets up needed url variables beforehand
     */
    @Before
    public void setup() {
        employeeUrl = "http://localhost:" + port + "/employee";
        reportIdUrl = "http://localhost:" + port + "/report/{id}";
    }

    /**
     * This function tests the read routes of the ReportingStructure route
     */
    @Test
    public void testRead() {
        // Create Test Employee
        Employee testEmployee1= new Employee();
        testEmployee1.setFirstName("Jane");
        testEmployee1.setLastName("Doe");
        testEmployee1.setDepartment("Engineering");
        testEmployee1.setPosition("Developer");

        Employee testEmployee2 = new Employee();
        testEmployee2.setFirstName("John");
        testEmployee2.setLastName("Doe");
        testEmployee2.setDepartment("Engineering");
        testEmployee2.setPosition("Developer");

        Employee testEmployee3 = new Employee();
        testEmployee2.setFirstName("Dale");
        testEmployee2.setLastName("Doe");
        testEmployee2.setDepartment("Engineering");
        testEmployee2.setPosition("Developer");

        Employee testEmployee = new Employee();
        testEmployee.setFirstName("George");
        testEmployee.setLastName("Doe");
        testEmployee.setDepartment("Engineering");
        testEmployee.setPosition("Developer");

        // Add employees under John
        List<Employee> listEmployees1 = new ArrayList<Employee>();
        listEmployees1.add(testEmployee3);
        testEmployee2.setDirectReports(listEmployees1);

        // Add employees under George
        List<Employee> listEmployees = new ArrayList<Employee>();
        listEmployees.add(testEmployee1);
        listEmployees.add(testEmployee2);
        testEmployee.setDirectReports(listEmployees);
        
        // Create Employee
        Employee createdEmployee = restTemplate.postForEntity(employeeUrl, testEmployee, Employee.class).getBody();

        // Create Report
        ReportingStructure createdReport = new ReportingStructure();
        createdReport.setEmployee(testEmployee);
        createdReport.setNumberOfReports(3);

        // Read checks
        ReportingStructure readReport = restTemplate.getForEntity(reportIdUrl, ReportingStructure.class, createdEmployee.getEmployeeId()).getBody();
        assertNotNull(readReport.getEmployee().getEmployeeId());
        assertCompensationEquivalence(createdReport, readReport);
        assertEquals(createdReport.getNumberOfReports(), readReport.getNumberOfReports());
    }
    /**
     * Compares whether two compensation objects are equal 
     * 
     * @param expected The expected compensation object
     * @param actual The actual compensation object
     */
    private static void assertCompensationEquivalence(ReportingStructure expected, ReportingStructure actual) {
        assertEquals(expected.getNumberOfReports(), actual.getNumberOfReports());
    }
}

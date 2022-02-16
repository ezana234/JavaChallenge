package com.mindex.challenge.service.impl;
import java.util.List;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ReportingStructureServiceImpl Class: This class stores all function related
 * to ReportingStructure
 */
@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    private int num = 0;
    /**
     * This function gets a reporting structure from the database by the employee ID
     * @param id an employee id
     * @return a Reporting Structure object
     */
    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Getting reporting structure with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);
        ReportingStructure report = null;

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        } else {
            report = new ReportingStructure();
            report.setEmployee(employee);
            num=0;
            // call iterate function to iterate and count all direct reports and
            // store it in the num variable
            iterate(employee.getDirectReports());
            report.setNumberOfReports(num);
        }

        return report;

    }

    /**
     * This function takes a list of employees and iterates over
     * each direct report under each employee recursively
     * @param employees List of employees 
     */
    public void iterate(List<Employee> employees) {
        if (employees == null || employees.size() == 0) {
            return;
        }
        int length = employees.size();
        for (int i = 0; i < length; i++) {
            num+=1;
            iterate(employees.get(i).getDirectReports());
        }

    }

}
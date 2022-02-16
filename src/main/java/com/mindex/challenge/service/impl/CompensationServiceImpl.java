package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.CompensationBody;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.validations.impl.DateValidatorImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class stores service functions related to the Compensation Object
 */
@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * This function creates a compensation object in the database
     * if the employee exists, if the compensation object doesn't already exist for the employee
     * and the date is formatted correctly.
     * @param compensationBody the request for the compensation route
     * @return a Compensation Object
     */
    @Override
    public Compensation create(CompensationBody compensationBody) {
        LOG.debug("Creating compensation [{}]", compensationBody);
        Employee employee = employeeRepository.findByEmployeeId(compensationBody.getEmployeeId());
        // Check if employee exists
        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + compensationBody.getEmployeeId());
        }
        // check if compensation exists
        Compensation checkCompensation = compensationRepository.findByEmployeeEmployeeId(compensationBody.getEmployeeId());
        if (checkCompensation != null) {
            throw new RuntimeException("Compensation already exists with employee with id: " + compensationBody.getEmployeeId());
        }
        // check if date is formatted correctly
        DateValidatorImpl dateValidator = new DateValidatorImpl();
        boolean isFormatted = dateValidator.validFormat(compensationBody.getEffectiveDate());
        LOG.debug("is Formatted", isFormatted);
        if (isFormatted != true) {
            throw new RuntimeException("Invalid effectiveDate format, must be 'MM/dd/yyyy': " + compensationBody.getEmployeeId());
        }

        // Create compensation object and load into the mongodb
        Compensation compensation = new Compensation();
        compensation.setEmployee(employee);
        compensation.setEffectiveDate(compensationBody.getEffectiveDate());
        compensation.setSalary(compensationBody.getSalary());

        // insert into repository
        compensationRepository.insert(compensation);

        return compensation;
    }

    /**
     * This function gets a compensation from the database by the employee id
     * @param id a string representing the employee id
     * @return a Compensation Object
     */
    @Override
    public Compensation read(String id) {
        LOG.debug("Reading compensation with employee id [{}]", id);
        Compensation compensation = compensationRepository.findByEmployeeEmployeeId(id);
        if (compensation == null) {
            throw new RuntimeException("Can't get compensation with invalid employeeId: " + id);
        }
        return compensation;
    }
}

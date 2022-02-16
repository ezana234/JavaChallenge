package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.CompensationBody;

/**
 * CompensationService Interface: Contains all required functions for 
 * CompensationServiceImpl 
 */
public interface CompensationService {
    Compensation create(CompensationBody compensation);
    Compensation read(String id);
}

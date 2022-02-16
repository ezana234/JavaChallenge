package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.CompensationBody;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private CompensationService compensationService;

    /**
     * This function creates a post route at '/compenation' 
     * parses the post body into CompensationBody
     * and inserts the compensation information into the database
     * 
     * @param CompensationBody a class that is used to parse this body
     * @return the created compensation object
     */
    @PostMapping("/compensation")
    public Compensation create(@RequestBody CompensationBody compensation) {
        LOG.debug("Received compensation create request for [{}]", compensation);

        return compensationService.create(compensation);
    }

    /**
     *  This function creates a get route at "/compensation/"
     *  abd returns a compensation object 
     * @param id
     * @return
     */
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received compensation read request for id [{}]", id);

        return compensationService.read(id);
    }

}

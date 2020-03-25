package com.ami.pcf.dcp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ami.pcf.dcp.common.ServiceContext;
import com.ami.pcf.dcp.domain.DataCollectionPlan;
import com.ami.pcf.dcp.error.AppException;
import com.ami.pcf.dcp.service.DcpValidatorService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/dcp-validator")
@Api(value = "Data Validator Service")
@Slf4j
public class DcpValidatorController {

    private DcpValidatorService service;

    @Autowired
    public DcpValidatorController(DcpValidatorService service) {
        this.service = service;
    }

    @RequestMapping(path = "/validate", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DataCollectionPlan validate(@RequestBody final DataCollectionPlan dcp) {
        log.info("Validate DCP = {}", dcp);
        if (null == dcp) {
            throw new AppException("Expected not null DataCollectionPlan instance");
        }
        if (null != dcp.getId()) {
            throw new AppException("Expected new DCP ID is not null");
        }

        ServiceContext context = new ServiceContext();
        return this.service.validate(context, dcp);
    }
}

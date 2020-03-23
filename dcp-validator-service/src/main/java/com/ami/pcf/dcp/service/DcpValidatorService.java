package com.ami.pcf.dcp.service;

import org.springframework.stereotype.Service;

import com.ami.pcf.dcp.common.ServiceContext;
import com.ami.pcf.dcp.domain.DataCollectionPlan;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DcpValidatorService {

    public DataCollectionPlan validate(ServiceContext context, DataCollectionPlan dcp) {
        log.info("Process save new DCP to database with context = {}", context);
        return  dcp;
    }
}

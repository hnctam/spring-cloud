package com.ami.pcf.dcp.service;

import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ami.pcf.dcp.common.ServiceContext;
import com.ami.pcf.dcp.domain.DataCollectionPlan;
import com.ami.pcf.dcp.dto.PageResponse;
import com.ami.pcf.dcp.repository.DcpRepo;
import com.ami.pcf.dcp.util.AppUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DcpValidatorService {

    public DataCollectionPlan validate(ServiceContext context, DataCollectionPlan dcp) {
        log.info("Process save new DCP to database with context = {}", context);
        return  dcp;
    }
}

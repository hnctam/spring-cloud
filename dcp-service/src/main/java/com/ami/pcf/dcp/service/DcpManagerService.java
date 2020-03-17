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
public class DcpManagerService {

    @Autowired
    private DcpRepo dcpRepo;

    public PageResponse<DataCollectionPlan> getDcps(ServiceContext context) {
        log.info("Process getPostsCreatedBy() with context = {}", context);
        int page = context.getPage();
        int size = context.getPageSize();
        AppUtils.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size);
        Page<DataCollectionPlan> dcps = this.dcpRepo.findAll(pageable);
        if (dcps.getNumberOfElements() == 0) {
            return new PageResponse<>(Collections.emptyList(), page, size,
                    dcps.getTotalElements(), dcps.getTotalPages(), dcps.isLast());
        }
        return new PageResponse<>(dcps.stream().collect(Collectors.toList()),
                page, size,
                dcps.getTotalElements(), dcps.getTotalPages(), dcps.isLast());
    }

    public DataCollectionPlan create(ServiceContext context, DataCollectionPlan dcp) {
        log.info("Process save new DCP to database with context = {}", context);
        return this.dcpRepo.save(dcp);
    }

}

package com.ami.pcf.dcp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ami.pcf.dcp.common.ServiceContext;
import com.ami.pcf.dcp.domain.DataCollectionPlan;
import com.ami.pcf.dcp.dto.PageResponse;
import com.ami.pcf.dcp.error.AppException;
import com.ami.pcf.dcp.service.DcpManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/dcp")
@Api(value = "Data Collection Manager Service")
@Slf4j
public class DcpManagerController {

    @Autowired
    private DcpManagerService service;

    @GetMapping(params = { "page", "size" })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find the list of data collection plans", response = PageResponse.class)
    PageResponse<DataCollectionPlan> findAll(@RequestParam("page") int page,
            @RequestParam("size") int size) {
        log.info("Find all DCPs page={}, size={}", page, size);
        ServiceContext context = new ServiceContext(page, size);
        return this.service.getDcps(context);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DataCollectionPlan create(@RequestBody final DataCollectionPlan dcp) {
        log.info("Create new DCP={} with mode = {}", dcp);
        if (null == dcp) {
            throw new AppException("Expected not null DataCollectionPlan instance");
        }
        if (null != dcp.getId()) {
            throw new AppException("Expected new DCP ID is not null");
        }

        ServiceContext context = new ServiceContext();
        return this.service.create(context, dcp);
    }
}

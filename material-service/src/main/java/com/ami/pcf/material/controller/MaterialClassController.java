package com.ami.pcf.material.controller;

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
import com.ami.pcf.dcp.dto.PageResponse;
import com.ami.pcf.dcp.error.AppException;
import com.ami.pcf.material.domain.MaterialClass;
import com.ami.pcf.material.dto.MaterialClassDto;
import com.ami.pcf.material.service.MaterialClassService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/material-class")
@Api(value = "Material Class Service")
@Slf4j
public class MaterialClassController {

    @Autowired
    private MaterialClassService service;

    @GetMapping(params = { "page", "size" })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find the list of material classes", response = PageResponse.class)
    PageResponse<MaterialClassDto> findAll(@RequestParam("page") int page,
            @RequestParam("size") int size) {
        log.info("Find all material classes with page={}, size={}", page, size);
        ServiceContext context = new ServiceContext(page, size);
        return this.service.sxFindAll(context);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Create a new material class", response = PageResponse.class)
    public MaterialClassDto create(@RequestBody final MaterialClass materialClass) {
        log.info("Create new material class = {} with mode = {}", materialClass);
        if (null == materialClass) {
            throw new AppException("Expected not null material class instance");
        }
        if (null != materialClass.getId()) {
            throw new AppException("Expected new material class ID is not null");
        }

        return this.service.convert(materialClass);
    }
}

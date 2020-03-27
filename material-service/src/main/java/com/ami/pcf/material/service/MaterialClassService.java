package com.ami.pcf.material.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ami.pcf.dcp.common.ServiceContext;
import com.ami.pcf.dcp.service.BaseService;
import com.ami.pcf.material.domain.MaterialClass;
import com.ami.pcf.material.dto.MaterialClassDto;
import com.ami.pcf.material.repository.MaterialClassRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MaterialClassService extends BaseService<MaterialClass, MaterialClassDto> {

    @Autowired
    private MaterialClassRepo materialClassRepo;

    @Override
    public Page<MaterialClass> findAll(ServiceContext context) {
        log.info("Find material classes context=[{}]", context);
        Pageable pageable = PageRequest.of(context.getPage(), context.getPageSize());
        return this.materialClassRepo.findAll(pageable);
    }

    @Override
    public MaterialClassDto convert(MaterialClass entity) {
        MaterialClassDto matClassDto = new MaterialClassDto();
        matClassDto.setId(entity.getId());
        matClassDto.setIdentifier(entity.getIdentifier());
        matClassDto.setDescription(entity.getDescription());
        return matClassDto;
    }

}

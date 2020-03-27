package com.ami.pcf.dcp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.ami.pcf.dcp.common.ServiceContext;
import com.ami.pcf.dcp.dto.PageResponse;

public abstract class BaseService<E, O> {

    public PageResponse<O> sxFindAll(ServiceContext context) {
        Page<E> entities = this.findAll(context);

        List<O> items = entities.getContent()
                .stream().map(e -> this.convert(e))
                .collect(Collectors.toList());
        return new PageResponse<>(items,
                context.getPage(),
                context.getPageSize(),
                entities.getTotalElements(),
                entities.getTotalPages(),
                entities.isLast());
    }

    public abstract Page<E> findAll(ServiceContext context);

    public abstract O convert(E entity);
}

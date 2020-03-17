package com.ami.pcf.dcp.common;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceContext {

    private int pageSize;
    private int page;
    private Date startTime;

    public ServiceContext() {
        this.startTime = new Date();
    }

    public ServiceContext(int page, int pageSize) {
        this();
        this.page = page;
        this.pageSize = pageSize;
    }
}

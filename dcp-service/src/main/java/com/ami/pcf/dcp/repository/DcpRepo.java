package com.ami.pcf.dcp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ami.pcf.dcp.domain.DataCollectionPlan;

@Repository
public interface DcpRepo extends PagingAndSortingRepository<DataCollectionPlan, Long> {

}

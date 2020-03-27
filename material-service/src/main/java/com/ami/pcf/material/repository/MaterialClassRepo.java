package com.ami.pcf.material.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ami.pcf.material.domain.MaterialClass;

@Repository
public interface MaterialClassRepo extends PagingAndSortingRepository<MaterialClass, Long> {

}

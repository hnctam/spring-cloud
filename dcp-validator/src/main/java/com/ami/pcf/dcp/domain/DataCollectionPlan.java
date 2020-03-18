package com.ami.pcf.dcp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "FBDCP")
@Data
public class DataCollectionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Data Collection Plan ID cannot be null")
    @Column(name = "DCP_ID", nullable = false, length = 64)
    private String dcpID;

    @NotNull(message = "Data Collection Plan Name cannot be null")
    @Column(name = "NAME", nullable = false, length = 128)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false, length = 512)
    private String description;

    @Column(name = "INT_IN_MIN", nullable = false)
    private int intervalInMinutes;

    @Column(name = "IS_PERSISTENT", nullable = false)
    private boolean isPersistent;
}

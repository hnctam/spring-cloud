package com.ami.pcf.material.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "FMMATCLS")
@Data
public class MaterialClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IDENT", nullable = false, length = 64)
    private String identifier;

    @Column(name = "DESCRIPTION", nullable = false, length = 512)
    private String description;

    @OneToMany(mappedBy = "materialClass", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaterialClassProperty> properties = new LinkedList<>();
}

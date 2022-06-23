package com.world.countries.data.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class Country {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column
    private String countryName;

}

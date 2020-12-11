package com.xib.assessment.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@EqualsAndHashCode
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    private Manager manager1;
    @OneToOne
    private Manager manager2;
}

package com.xib.assessment.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@EqualsAndHashCode
public class Agent {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String idNumber;
    @ManyToOne
    private Team team;
    @ManyToOne
    private Manager manager;

    public void setManager(Manager manager) {
        if (manager.getTeams().contains(team)) {
            this.manager = manager;
        }
    }
}

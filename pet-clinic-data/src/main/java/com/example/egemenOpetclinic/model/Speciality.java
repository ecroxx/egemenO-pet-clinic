package com.example.egemenOpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "Specialities")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;
/*
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 */
}

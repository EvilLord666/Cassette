/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.cassette.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BrokerType")
public class BrokerTypeEntity extends BaseEntity {
    
    public BrokerTypeEntity() {
        
    }
    
    public BrokerTypeEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name = "name", nullable = false, length = 128, unique = true)
    private String name;
    @Column(name = "description", nullable = true, length = 512, unique = false)
    private String description;
}

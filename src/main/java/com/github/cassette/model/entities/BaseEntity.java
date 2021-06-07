/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.cassette.model.entities;

import javax.persistence.*;


@MappedSuperclass
public abstract class BaseEntity {
    
    public BaseEntity() {
        
    }
    
    public BaseEntity(Long id) {
        this.id = id;
    }
     
    public Long getId() {
        return this.id;
    }
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

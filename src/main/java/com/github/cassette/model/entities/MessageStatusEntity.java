package com.github.cassette.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "message_status")
public class MessageStatusEntity extends BaseEntity {

    public MessageStatusEntity() {
        
    }
    
    public MessageStatusEntity(String name, Long code) {
        this.name = name;
        this.code = code;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getCode() {
        return this.code;
    }
    
    public void setCode(Long code) {
        this.code = code;
    }
    
    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private Long code;

}

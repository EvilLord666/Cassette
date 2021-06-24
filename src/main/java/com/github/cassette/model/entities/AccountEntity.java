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
@Table(name = "Account")
public class AccountEntity extends BaseEntity {
    
    public AccountEntity() {
        
    }
    
    public AccountEntity(String userName, String passwordHash) {
        this.userName = userName;
        this.passwordHash = passwordHash;
    }
    
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPasswordHash() {
        return this.passwordHash;
    }
    
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    @Column(name = "username", nullable = false, length = 256, unique = true)
    private String userName;
    
    @Column(name = "password_hash", nullable = false, length = 4096, unique = false)
    private String passwordHash;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.cassette.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "Broker")
public class BrokerEntity extends BaseEntity {
    public BrokerEntity() {

    }

    public BrokerEntity(String name, String address, String description, BrokerTypeEntity brokerType, AccountEntity account) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.brokerType = brokerType;
        this.account = account;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAdress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public BrokerTypeEntity BrokerType() {
        return this.brokerType;
    }

    public void setBrokerType(BrokerTypeEntity brokerType) {
        this.brokerType = brokerType;
    }
    public AccountEntity getAccount() {
        return this.account;
    }

    public void setAccountId(AccountEntity account) {
        this.account = account;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="broker_type_id", nullable = false)
    private BrokerTypeEntity brokerType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_id", nullable = true)
    private AccountEntity account;

    @Column(name = "name", nullable = false, length = 128, unique = true)
    private String name;

    @Column(name = "address", nullable = false, length = 255, unique = true)
    private String address;

    @Column(name = "description", nullable = true, length = 512, unique = false)
    private String description;
}

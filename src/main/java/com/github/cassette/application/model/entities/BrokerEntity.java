package com.github.cassette.application.model.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "broker")
public class BrokerEntity {

    public BrokerEntity() {

    }

    public BrokerEntity(Long Id, String Name, String Adress, String Description, BrokerTypeEntity BrokerType, AccountEntity Account) {
        this.Id = Id;
        this.Name = Name;
        this.Adress = Adress;
        this.Description = Description;
        this.BrokerType = BrokerType;
        this.Account = Account;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    public BrokerTypeEntity BrokerType() {
        return BrokerType;
    }

    public void setBrokerType(BrokerTypeEntity BrokerType) {
        this.BrokerType = BrokerType;
    }
    public AccountEntity getAccount() {
        return Account;
    }

    public void setAccountId(AccountEntity Account) {
        this.Account = Account;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="broker_type_id")
    private BrokerTypeEntity BrokerType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_id")
    private AccountEntity Account;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name", nullable = false, length = 128, unique = true)
    private String Name;

    @Column(name = "adress", nullable = false, length = 255, unique = false)
    private String Adress;

    @Column(name = "description", nullable = true, length = 512, unique = false)
    private String Description;
}

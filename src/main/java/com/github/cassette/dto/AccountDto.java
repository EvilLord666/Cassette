package com.github.cassette.dto;

public class AccountDto {
    public AccountDto() {

    }

    public AccountDto(Long id, String userName, String passwordHash) {
        this.id = id;
        this.userName = userName;
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    private Long id;
    private String userName;
    private String passwordHash;
}

package com.github.cassette.dto;

public class ApplicationInfoDto {

    public ApplicationInfoDto() {
    }

    public ApplicationInfoDto(String environment, String dbDriver, String dbUrl, String bdName) {
        this.environment = environment;
        this.dbDriver = dbDriver;
        this.dbUrl = dbUrl;
        this.bdName = bdName;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getDbDriver() {
        return this.dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbUrl() {
        return this.dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getBdName() {
        return this.bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    private String environment;
    private String dbDriver;
    private String dbUrl;
    private String bdName;
}

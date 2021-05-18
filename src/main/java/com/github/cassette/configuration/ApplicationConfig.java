package com.github.cassette.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    public ApplicationConfig() {
    }

    public ApplicationConfig(String environment, String dbDriver, String dbUrl, String dbName) {
        this.environment = environment;
        this.dbDriver = dbDriver;
        this.dbUrl = dbUrl;
        this.dbName = dbName;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Value("${appConfig.environment}")
    private String environment;

    @Value("${appConfig.dbDriver}")
    private String dbDriver;

    @Value("${appConfig.dbUrl}")
    private String dbUrl;

    @Value("${appConfig.dbName}")
    private String dbName;
}

package com.github.cassette.configuration;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {

    public ApplicationConfig getAppConfig(){
        return this.applicationConfig;
    }

    @Autowired
    private ApplicationConfig applicationConfig;
}

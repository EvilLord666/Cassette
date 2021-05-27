package com.github.cassette.controllers.api;

import com.github.cassette.configuration.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {

    public ApplicationConfig getAppConfig(){
        return this.applicationConfig;
    }

    @Autowired
    private ApplicationConfig applicationConfig;
}

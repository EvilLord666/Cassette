package com.github.cassette.controllers.api;


import com.github.cassette.configuration.ApplicationConfig;
import com.github.cassette.dto.ApplicationInfoDto;
import com.github.cassette.factories.ApplicationInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/api/info")
    public ApplicationInfoDto get(){
        return ApplicationInfoFactory.create(applicationConfig);
    }

    @Autowired
    private ApplicationConfig applicationConfig;
}

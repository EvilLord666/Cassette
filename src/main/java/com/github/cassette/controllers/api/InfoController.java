package com.github.cassette.controllers.api;


import com.github.cassette.configuration.BaseController;
import com.github.cassette.dto.ApplicationInfoDto;
import com.github.cassette.factories.ApplicationInfoFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController extends BaseController {

    @GetMapping("/api/info")
    public ApplicationInfoDto get(){
        return ApplicationInfoFactory.create(getAppConfig());
    }

}

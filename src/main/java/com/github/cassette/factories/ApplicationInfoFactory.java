package com.github.cassette.factories;

import com.github.cassette.configuration.ApplicationConfig;
import com.github.cassette.dto.ApplicationInfoDto;

public final class ApplicationInfoFactory {
    public static ApplicationInfoDto create(ApplicationConfig applicationConfig){
        return new ApplicationInfoDto(applicationConfig.getEnvironment(),
                applicationConfig.getDbDriver(),
                applicationConfig.getDbUrl(),
                applicationConfig.getDbName());
    }
}

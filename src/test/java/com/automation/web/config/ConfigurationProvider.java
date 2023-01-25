package com.automation.web.config;

import com.automation.web.exceptions.StopTestException;
import com.google.inject.Provider;

/**
 * ConfigurationProvider class implements Provider to provide the configuration instance
 */
public class ConfigurationProvider implements Provider<Configuration> {
    @Override
    public Configuration get() {
        try {
            return Configuration.getConfiguration();
        } catch (StopTestException e) {
            e.printStackTrace();
        }

        return null;
    }
}

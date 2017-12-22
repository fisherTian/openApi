package com.haoyun.core.utils;

import java.util.Properties;

public class AppConfig {

    private static final String UNFILTERED_URI = "UNFILTERED.URI";
    
    private static Properties p = new Properties();

    static {
        try {
            p.load(AppConfig.class.getResourceAsStream("/appconfig.properties"));
        } catch (Exception e) {
        }
    }

    public static String getUnfilteredURIs() {
        return p.getProperty(UNFILTERED_URI);
    }
    
}

package com.example.shorturl.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan("com.example.shorturl.common.properties")
public class PropertiesScanConfig {
}

package com.example.shorturl.common.properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(ServerUrlProperties.class)
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
class ServerUrlPropertiesYmlFileTest {

    @Autowired
    private ServerUrlProperties serverUrlProperties;

    @Test
    void givenNothing_whenPropertiesGetServerUrl_thenReturnServerUrl() {
        // When
        String serverUrl = serverUrlProperties.getServerUrl();

        // Then
        assertThat(serverUrl).isEqualTo("http://localtest.com:8080");
    }
}
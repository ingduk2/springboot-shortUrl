package com.example.shorturl.common.properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(ServerUrlProperties.class)
@TestPropertySource(properties =
        {
                "server.protocol=http",
                "server.domain=test.com",
                "server.port=8080",
        }
)
class ServerUrlPropertiesTest {

    @Autowired
    private ServerUrlProperties serverUrlProperties;

    @Test
    void givenNothing_whenPropertiesGetServerUrl_thenReturnServerUrl() {
        // When
        String serverUrl = serverUrlProperties.getServerUrl();

        // Then
        assertThat(serverUrl).isEqualTo("http://test.com:8080");
    }
}
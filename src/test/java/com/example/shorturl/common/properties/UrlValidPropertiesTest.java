package com.example.shorturl.common.properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(UrlValidProperties.class)
@TestPropertySource(properties =
        {
                "url.valid.connectTimeout=1234",
                "url.valid.readTimeout=5678"
        }
)
class UrlValidPropertiesTest {
    @Autowired
    private UrlValidProperties properties;

    @Test
    void givenNothing_whenGetValue_thenLoadProperties() {
        // When & Then
        assertThat(properties.connectTimeout()).isEqualTo(1234);
        assertThat(properties.readTimeout()).isEqualTo(5678);
    }
}
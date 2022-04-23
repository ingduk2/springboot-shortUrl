package com.example.shorturl.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("url.valid")
public record UrlValidProperties(
        int connectTimeout,
        int readTimeout) {

}

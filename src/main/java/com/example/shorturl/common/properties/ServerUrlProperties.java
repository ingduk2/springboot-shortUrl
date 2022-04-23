package com.example.shorturl.common.properties;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("server")
@RequiredArgsConstructor
public class ServerUrlProperties {
    private final String protocol;
    private final String domain;
    private final String port;

    public String getServerUrl() {
        return protocol + "://" + domain + ":" + port;
    }
}

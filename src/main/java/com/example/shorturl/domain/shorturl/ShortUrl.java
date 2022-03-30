package com.example.shorturl.domain.shorturl;

import com.example.shorturl.domain.TimeBaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShortUrl extends TimeBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String fullUrl;

    @Builder
    public ShortUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }
}

package com.example.shorturl.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    BUSINESS_ERROR("Business Exception"),
    UNEXPECTED_ERROR("Unexpected Exception"),
    HANDLER_NO_FOUND_EXCEPTION("잘못된 접근 입니다.");

    private final String errorMessage;
}

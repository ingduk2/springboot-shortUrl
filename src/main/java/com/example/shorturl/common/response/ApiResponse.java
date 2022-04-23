package com.example.shorturl.common.response;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private static final String EMPTY_STRING = "";

    private Boolean success;
    private String errorCode;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .errorCode(EMPTY_STRING)
                .message(EMPTY_STRING)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> fail(ErrorCode errorCode) {
        return ApiResponse.<T>builder()
                .success(false)
                .errorCode(errorCode.name())
                .message(errorCode.getErrorMessage())
                .data(null)
                .build();
    }

    public static <T> ApiResponse<T> fail(ErrorCode errorCode, String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .errorCode(errorCode.name())
                .message(message)
                .data(null)
                .build();
    }
}

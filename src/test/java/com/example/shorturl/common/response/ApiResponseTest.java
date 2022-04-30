package com.example.shorturl.common.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class ApiResponseTest {

    @Test
    @DisplayName("data 가 주어지면 success시, data를 포함한 성공 응답을 생성한다.")
    void givenStringData_whenSuccessResponse_thenReturnSuccessResponse() {
        // Given
        String data = "data";

        // When
        ApiResponse<String> success = ApiResponse.success(data);

        // Then
        assertThat(success)
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", "")
                .hasFieldOrPropertyWithValue("message", "")
                .hasFieldOrPropertyWithValue("data", data);
    }

    @ParameterizedTest
    @EnumSource(ErrorCode.class)
    @DisplayName("fail시, 실패 응답을 생성한다.")
    void givenNoData_whenFailResponse_then(ErrorCode errorCode) {
        // Given
        // When
        ApiResponse fail = ApiResponse.fail(errorCode);

        // Then
        assertThat(fail)
                .hasFieldOrPropertyWithValue("success", false)
                .hasFieldOrPropertyWithValue("errorCode", errorCode.name())
                .hasFieldOrPropertyWithValue("message", errorCode.getErrorMessage())
                .hasFieldOrPropertyWithValue("data", null);
    }
}
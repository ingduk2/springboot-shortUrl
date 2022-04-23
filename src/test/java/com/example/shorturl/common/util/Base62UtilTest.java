package com.example.shorturl.common.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class Base62UtilTest {

    @ParameterizedTest
    @ValueSource(longs = {1, 123, 4484689, 99911125, Integer.MAX_VALUE, Long.MAX_VALUE})
    void givenBase62EncodeId_whenBase62Decode_thenDecodeIdIsEqualToParamId(long id) {
        // Given
        String encodeId = Base62Util.encode(id);

        // When
        long decodeId = Base62Util.decode(encodeId);

        // Then
        assertThat(decodeId).isEqualTo(id);
    }
}
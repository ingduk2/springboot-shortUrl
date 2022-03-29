package com.example.shorturl.common.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Base62UtilTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 123, 4484689, 99911125, Integer.MAX_VALUE})
    void giveBase62EncodeId_whenBase62Decode_thenDecodeIdIsEqualToParamId(int id) {
        // Given
        String encodeId = Base62Util.encode(id);

        // When
        int decodeId = Base62Util.decode(encodeId);

        // Then
        assertThat(decodeId).isEqualTo(id);
    }
}
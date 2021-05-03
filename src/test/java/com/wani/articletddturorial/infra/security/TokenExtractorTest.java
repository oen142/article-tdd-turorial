package com.wani.articletddturorial.infra.security;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TokenExtractorTest {

    @DisplayName("토큰만들어내는 얘든 리턴을 앰프티")
    @Test
    void should_null_extract_return_empty() {
        TokenExtractor extractor = new TokenExtractor(null);

        Optional<String> result = extractor.extract();

        assertThat(result.isEmpty()).isTrue();
    }

    @DisplayName("")
    @Test
    void should_empty_string_extract_return_empty() {
        TokenExtractor extractor = new TokenExtractor("");

        Optional<String> result = extractor.extract();

        assertThat(result.isEmpty()).isTrue();
    }

    @Test
    void should_shor_string_extract_return_empty() {
        TokenExtractor extractor = new TokenExtractor("dddd");

        Optional<String> result = extractor.extract();

        assertThat(result.isEmpty()).isTrue();
    }

    @Test
    void should_header_extract_return_string() {
        TokenExtractor extractor = new TokenExtractor("Token header");

        Optional<String> result = extractor.extract();

        assertThat(result.isEmpty()).isFalse();
        assertThat(result.get()).isEqualTo("header");
    }
}

package com.github.hubertwo.playground.java15.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    @Test
    @DisplayName("Text Blocks")
    void text_blocks() {
        String concatenatedString = "No more escaping and concatenation needed!\n" +
                "Hurray!";

        var actualString = """
                No more escaping and concatenation needed!
                Hurray!""";

        assertThat(actualString).isEqualTo(concatenatedString);


    }
}

package com.github.hubertwo.playground.java15.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextBlocksTest {

    /**
     * {@see <a href="https://openjdk.java.net/jeps/378>More</a>}
     */
    @Test
    @DisplayName("Text Blocks")
    void textBlocks() {
        String concatenatedString = "No more quote escaping \", \\n and concatenation needed!\n" +
                "Hurray!";

        var actualString = """
                No more quote escaping ", \\n and concatenation needed!
                Hurray!""";

        assertThat(actualString).isEqualTo(concatenatedString);
    }
}

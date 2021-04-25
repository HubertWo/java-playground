package com.github.hubertwo.playground.java15.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextBlocksTest {

    /**
     * {@see <a href="https://openjdk.java.net/jeps/378>More</a>}
     */
    @Test
    @DisplayName("Multiline text block")
    void multilineTextBlock() {
        String concatenatedString = "No more quote escaping \", \\n and concatenation needed!\n" +
                "Hurray!";

        var actualString = """
                No more quote escaping ", \\n and concatenation needed!
                Hurray!""";

        assertThat(actualString).isEqualTo(concatenatedString);
    }

    @Test
    @DisplayName("Do not add line breaks to result string")
    void doNotAddLineBreaks() {
        String expectedString = "This is one line of text.";

        // Try to remove slashes at the end of lines.
        String actualString = """
                This is one line\
                 of\
                 text.""";

        assertThat(actualString).isEqualTo(expectedString);
    }

}

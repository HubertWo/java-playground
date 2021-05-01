package com.github.hubertwo.playground.java11.string;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringTest {

    @Test
    void isBlank() {
        assertThat("   ".isBlank()).isTrue();
        assertThat("".isBlank()).isTrue();
        assertThat("""
                    
                """.isBlank()).isTrue();
    }

    @Test
    void lines() {
        String givenString = """ 
                This is multiline String.
                That will be co converted 
                to Stream of lines and joined by space.     
                """;

        String actualString = givenString.lines()
                .collect(Collectors.joining(" "));

        assertThat(actualString).isEqualTo("""
                This is multiline String. \
                That will be co converted to Stream of lines and joined by space.""");
    }

    @Test
    void repeat() {
        assertThat("X".repeat(0)).isEqualTo("");
        assertThat("X".repeat(1)).isEqualTo("X");
        assertThat("X".repeat(2)).isEqualTo("XX");
        assertThrows(IllegalArgumentException.class,
                () -> "X".repeat(-1)
        );
    }

    @Test
    void strip() {
        assertThat("  XXX  ".strip()).isEqualTo("XXX");
    }
}

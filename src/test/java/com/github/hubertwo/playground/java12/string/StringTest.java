package com.github.hubertwo.playground.java12.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    @Test
    @DisplayName("String.indent")
    void indent() {
        // @formatter:off
        String givenString = """
                 This text has           
                  spaces at the beginning and end of each line. Next line contains 18 spaces only.  
                                  
                     We want to have (5) 
                  each line 
                indented.     """;

        String expectedString = """
               This text has
               spaces at the beginning and end of each line. Next line contains 18 spaces only.
                
               We want to have (5)
               each line
               indented.
               """;
        // @formatter:on

        String actualString = givenString.indent(/*leadingWhiteSpaceCharacters*/ -5);

        assertThat(actualString).isEqualTo(expectedString);
    }
}

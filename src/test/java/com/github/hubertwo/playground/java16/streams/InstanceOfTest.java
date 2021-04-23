package com.github.hubertwo.playground.java16.streams;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

class InstanceOfTest {

    @Test
    @DisplayName("JEP 394: Pattern Matching for instanceof")
    public void patternMatchingForInstanceOf() {
        Object givenObject = "Let's guess the type";

        // Check instanceOf and assign to variable in single line
        if (givenObject instanceof Integer actualObject) {
            assertThat(actualObject).isInstanceOf(String.class);
        } else if (givenObject instanceof String actualObject) {
            assertThat(actualObject)
                    .isInstanceOf(String.class)
                    .isEqualTo(givenObject.toString());
        } else {
            fail("No instance of match!");
        }
    }
}

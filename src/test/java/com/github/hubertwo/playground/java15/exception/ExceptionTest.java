package com.github.hubertwo.playground.java15.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    @Test
    @DisplayName("Code details in exception messages")
    public void descriptiveNullPointerException() {
        Kettle kettle = new Kettle(/*isPluggedIn*/ true, /*isFilled*/ null);

        NullPointerException actialException = assertThrows(NullPointerException.class, kettle::boilWater);

        assertThat(actialException).hasMessage("""
                Cannot invoke "java.lang.Boolean.booleanValue()" because "this.isFilled" is null""");
    }

    private static class Kettle {
        private final Boolean isPluggedIn;
        private final Boolean isFilled;

        public Kettle(Boolean isPluggedIn, Boolean isFilled) {
            this.isPluggedIn = isPluggedIn;
            this.isFilled = isFilled;
        }

        public void boilWater() {
            if (Boolean.logicalAnd(isFilled, isPluggedIn)) {
                // boil the water
            }
            // Some logic
        }
    }

}

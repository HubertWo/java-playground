package com.github.hubertwo.playground.java16.swtichexpression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@see <a href="https://openjdk.java.net/jeps/361">JEP 361</a>}
 */
class SwitchExpressionTest {

    @Test
    @DisplayName("Arrow labels in switch expressions")
    void arrowLabels() {
        EnergySource givenEnergySource = EnergySource.WIND;

        // Assigning switch statement result directly to value
        boolean isEco = switch (givenEnergySource) {
            case WIND, SOLAR, WATER -> true /* implicit return */;
            case COAL, OIL -> false;
            default -> throw new IllegalArgumentException("It depends");
        };

        assertThat(isEco).isTrue();
    }

    @Test
    @DisplayName("Yield statement in switch expression")
    void yieldStatement() {
        EnergySource givenEnergySource = EnergySource.WIND;

        /**
         * Try to remove "String actualCategory = "
         * What's the difference between switch statement and switch expression?
         * {@link #SwitchExpressionTest#switchStatement}
         */

        String actualCategory = switch (givenEnergySource) {
            case WIND:
            case SOLAR, WATER:
                // Works as return but in scope of switch expression
                // Will return work here?
                yield "renewable";
            case NUCLEAR:
            case COAL:
            case OIL: {
                yield "nonrenewable";
            }
        };

        assertThat(actualCategory).isEqualTo("renewable");
    }

    @Test
    @DisplayName("Switch statement")
    void switchStatement() {
        EnergySource givenEnergySource = EnergySource.WIND;

        String actualCategory = null;
        switch (givenEnergySource) {
            case WIND:
            case SOLAR, WATER:
                // Will yield work here?
                actualCategory = "renewable";
                break;
            case NUCLEAR:
            case COAL:
            case OIL: {
                actualCategory = "nonrenewable";
                break;
            }
        }

        assertThat(actualCategory)
                .isNotNull()
                .isEqualTo("renewable");
    }
}

package com.github.hubertwo.playground.java16.record;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

class VehicleTest {
    
    @Test
    void createRecord() {
        var vehicle = new Vehicle("Bike");

        assertThat(vehicle.name()).isEqualTo("Bike");
    }

    @Test
    @DisplayName("Implicit inherits from Record class")
    void recordInheritsFromRecord() {
        var vehicle = new Vehicle("Car");

        assertThat(vehicle).isInstanceOf(Record.class);
    }

    @Test
    @DisplayName("Records might be defined in local scope")
    void localRecord() {
        record Fruit(String name) {
        }

        var localRecord = new Fruit("Pineapple");

        assertThat(localRecord).isInstanceOf(Record.class);
        assertThat(localRecord.name()).isEqualTo("Pineapple");
    }
}
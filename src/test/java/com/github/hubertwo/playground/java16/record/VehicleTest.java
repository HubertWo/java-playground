package com.github.hubertwo.playground.java16.record;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VehicleTest {

    @Test
    @DisplayName("Create new instance")
    void createRecord() {
        var vehicle = new Vehicle("Bike", "Legs", true);

        assertThat(vehicle.name()).isEqualTo("Bike");
    }

    @Test
    @DisplayName("Compact constructor")
    void record_compactConstructor() {
        ImmutableList<String> givenPassengers = null;

        Throwable actualException = catchThrowable(
                // Check the declaration of Vehicle constructor
                () -> new Vehicle("Bike", "Legs", true, givenPassengers)
        );

        assertThat(actualException).isInstanceOf(NullPointerException.class)
                .hasMessage("Passengers can not be null");
    }

    @Test
    @DisplayName("Implicit inherits from Record class")
    void recordInheritsFromRecord() {
        var vehicle = new Vehicle("Car", "Battery", true);

        assertThat(vehicle).isInstanceOf(Record.class);
    }

    @Test
    @DisplayName("Records might be defined in local scope")
    void localRecord() {
        // Local definition of Record
        record Fruit(String name) {
            String makeSalad() {
                return this.name + " salad";
            }
        }

        var localRecord = new Fruit("Pineapple");

        assertThat(localRecord).isInstanceOf(Record.class);
        assertThat(localRecord.makeSalad()).isEqualTo("Pineapple salad");
    }

    @Test
    @DisplayName("Equals is implemented")
    void equals_isImplemented() {
        var electricBike = new Vehicle("Bike", "Battery", true);
        var electricBike2 = new Vehicle("Bike", "Battery", true);
        var simpleBike = new Vehicle("Bike", "Legs", true);

        assertThat(electricBike).isEqualTo(electricBike2);
        assertThat(electricBike).isNotEqualTo(simpleBike);
    }

    @Test
    @DisplayName("HashCode is implemented")
    void hashCode_isImplemented() {
        var electricCar = new Vehicle("Car", "Battery", true);
        var electricCar2 = new Vehicle("Car", "Battery", true);
        var conventionalCar = new Vehicle("Car", "Gasoline", false);

        assertThat(electricCar.hashCode()).isEqualTo(electricCar2.hashCode());

        // Just for learning purposes.
        // It may happen that two objects have the same hashCode.
        // Learn more: Java hashCode() equals() contract.
        assertThat(electricCar.hashCode()).isNotEqualTo(conventionalCar.hashCode());
        assertThat(electricCar.toString().hashCode()).isNotEqualTo(electricCar.hashCode());
    }

    @Test
    @DisplayName("toString() is implemented")
    void toString_isImplemented() {
        var velomobile = new Vehicle(
                "Velomobile",
                "Legs", true
        );

        assertThat(velomobile.toString()).isEqualTo(
                "Vehicle[name=Velomobile, energySource=Legs, isEco=true, passengers=[]]");
    }

}
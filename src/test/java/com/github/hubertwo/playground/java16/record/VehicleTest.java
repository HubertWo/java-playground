package com.github.hubertwo.playground.java16.record;

import com.google.common.collect.ImmutableList;
import org.assertj.core.util.Files;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VehicleTest {

    @Test
    @DisplayName("Create new instance")
    void createRecord() {
        var vehicle = new Vehicle("Bike", "Legs", true, /*price*/ BigDecimal.ONE);

        assertThat(vehicle.name()).isEqualTo("Bike");
    }

    @Test
    @DisplayName("Compact constructor")
    void record_compactConstructor() {
        ImmutableList<String> givenPassengers = null;

        Throwable actualException = catchThrowable(
                // Check the declaration of Vehicle constructor
                () -> new Vehicle(
                        "Bike",
                        "Legs",
                        /*isEco*/true,
                        /*price*/ BigDecimal.ONE,
                        givenPassengers
                ));

        assertThat(actualException).isInstanceOf(NullPointerException.class)
                .hasMessage("Passengers can not be null");
    }

    @Test
    public void record_serialize() throws IOException, ClassNotFoundException {
        File givenFile = Files.newTemporaryFile();
        final var electricBike = new Vehicle("Bike", "Battery", true, /*price*/ BigDecimal.ONE);

        // Write record to file
        try (FileOutputStream fileOutputStream = new FileOutputStream(givenFile)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(electricBike);
        }

        // Read record from file
        final Vehicle deserializedElectricBike;
        try(FileInputStream fileInputStream = new FileInputStream(givenFile)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserializedElectricBike = (Vehicle) objectInputStream.readObject();
        }

        assertThat(deserializedElectricBike).isNotNull();
        assertThat(deserializedElectricBike).isEqualTo(electricBike);
    }


    @Test
    @DisplayName("Implicit inherits from Record class")
    void recordInheritsFromRecord() {
        var vehicle = new Vehicle("Car", "Battery", true, /*price*/ BigDecimal.ONE);

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
        var electricBike = new Vehicle("Bike", "Battery", true, /*price*/ BigDecimal.ONE);
        var electricBike2 = new Vehicle("Bike", "Battery", true, /*price*/ BigDecimal.ONE);
        var simpleBike = new Vehicle("Bike", "Legs", true, /*price*/ BigDecimal.ONE);

        assertThat(electricBike).isEqualTo(electricBike2);
        assertThat(electricBike).isNotEqualTo(simpleBike);
    }

    @Test
    @DisplayName("HashCode is implemented")
    void hashCode_isImplemented() {
        var electricCar = new Vehicle("Car", "Battery", true, /*price*/ BigDecimal.ONE);
        var electricCar2 = new Vehicle("Car", "Battery", true, /*price*/ BigDecimal.ONE);
        var conventionalCar = new Vehicle("Car", "Gasoline", false, /*price*/ BigDecimal.ONE);

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
                "Legs",
                /*isEco*/true,
                /*price*/ BigDecimal.ONE
        );

        assertThat(velomobile.toString()).isEqualTo(
                "Vehicle[name=Velomobile, energySource=Legs, isEco=true, price=1, passengers=[]]");
    }

}
package com.github.hubertwo.playground.javaold.serialization;

import com.google.common.collect.ImmutableList;
import org.assertj.core.api.AssertionsForClassTypes;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SerializationTest {

    @Test
    @DisplayName("Throw IAException when price is less than 0")
    void oldVehicle_throwIllegalArgumentException_priceIsLessThanZero() {
        final BigDecimal givenPrice = BigDecimal.valueOf(-1);

        IllegalArgumentException actualException = assertThrows(
                IllegalArgumentException.class,
                () -> new OldVehicle("Bike", "Legs", /* isEco */ true, givenPrice, ImmutableList.of())
        );

        assertThat(actualException).hasMessage("Price cannot be smaller than 0.");
    }

    @Test
    @DisplayName("Serialize and deserialize POJO")
    void serializePojo() throws IOException, ClassNotFoundException {
        File givenFile = Files.newTemporaryFile();
        final var electricBike = new OldVehicle("Bike", "Legs", /* isEco */ true, BigDecimal.valueOf(1), ImmutableList.of());

        // Write record to file
        try (FileOutputStream fileOutputStream = new FileOutputStream(givenFile)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(electricBike);
        }

        // Read record from file
        final OldVehicle deserializedElectricBike;
        try (FileInputStream fileInputStream = new FileInputStream(givenFile)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserializedElectricBike = (OldVehicle) objectInputStream.readObject();
        }

        AssertionsForClassTypes.assertThat(deserializedElectricBike).isNotNull();
        AssertionsForClassTypes.assertThat(deserializedElectricBike).isEqualTo(electricBike);
    }

    @Test
    @DisplayName("Deserialize manipulated serialized POJO allows manipulated values")
    void pojo_deserializeManipulatedPojo() throws Exception {
        // Serialized POJO in the provided file has price set to -1.
        // which is not allowed by the Vehicle constructor - check constructor test in this file.
        final File givenFile =
                new File("src/test/resources/javaold/serialization/ManipulatedSerializedPojo.txt");
        assertTrue(givenFile.exists());

        final OldVehicle actualOldVehicle;
        try (FileInputStream fileInputStream = new FileInputStream(givenFile)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            actualOldVehicle = (OldVehicle) objectInputStream.readObject();
        }

        // Price is set to -1 which is not allowed by OldVehicle
        assertThat(actualOldVehicle.getPrice()).isEqualTo(BigDecimal.valueOf(-1));
    }
}

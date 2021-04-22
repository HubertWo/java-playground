package com.github.hubertwo.playground.javaold.serialization;

import com.google.common.collect.ImmutableList;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class OldVehicle implements Serializable {

    @Serial
    private static final long serialVersionUID = -8768588090385373495L;


    private final String name;
    private final String energySource;
    private final boolean isEco;
    private final BigDecimal price;
    private final ImmutableList<String> passengers;

    public OldVehicle(String name, String energySource, boolean isEco, BigDecimal price, ImmutableList<String> passengers) {
        // Validation
        Objects.requireNonNull(passengers, "Passengers can not be null");
        if (Objects.isNull(price) || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be smaller than 0.");
        }

        this.name = name;
        this.energySource = energySource;
        this.isEco = isEco;
        this.price = price;
        this.passengers = ImmutableList.copyOf(passengers);
    }

    public String getName() {
        return name;
    }

    public String getEnergySource() {
        return energySource;
    }

    public boolean isEco() {
        return isEco;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ImmutableList<String> getPassengers() {
        return passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldVehicle that = (OldVehicle) o;
        return isEco == that.isEco && Objects.equals(name, that.name) && Objects.equals(energySource, that.energySource) && Objects.equals(price, that.price) && Objects.equals(passengers, that.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, energySource, isEco, price, passengers);
    }
}

package com.github.hubertwo.playground.java16.record;

import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


public record Vehicle(
        String name,
        String energySource,
        boolean isEco,
        BigDecimal price,
        ImmutableList<String> passengers) implements Serializable {

    /**
     * Compact constructor.
     * Always called.
     */
    public Vehicle {
        Objects.requireNonNull(passengers, "Passengers can not be null");
        if (Objects.isNull(price) || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be smaller than 0.");
        }
    }

    /**
     * Custom constructor must always  call canonical constructor.
     */
    public Vehicle(String name, String energySource, boolean isEco, BigDecimal price) {
        this(name, energySource, isEco, price, ImmutableList.of());
    }
}

package com.github.hubertwo.playground.java16.record;

import com.google.common.collect.ImmutableList;

import java.util.Objects;

/**
 * @see <a href="https://docs.oracle.com/en/java/javase/16/language/records.html">Record Classes</a>
 */
public record Vehicle(String name, String energySource, boolean isEco, ImmutableList<String> passengers) {

    /**
     * Compact constructor.
     * Always called.
     */
    public Vehicle {
        Objects.requireNonNull(passengers, "Passengers can not be null");
    }

    /**
     * Custom constructor must always  call canonical constructor.
     */
    public Vehicle(String name, String energySource, boolean isEco) {
        this(name, energySource, isEco, ImmutableList.of());
    }
}

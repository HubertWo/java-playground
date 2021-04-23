package com.github.hubertwo.playground.java16.streams;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class StreamTest {

    @Test
    @DisplayName("New method Stream.toList produces UnmodifiableList")
    void toList() {
        ImmutableList<Integer> expectedEvenNumbers = ImmutableList.of(0, 2, 4, 6, 8);

        List<Integer> actualNumbers = IntStream.range(0, 10)
                .filter(i -> i % 2 == 0)
                .boxed()
                // Try to use Java 8 Collector.toList
                // .collect(Collectors.toList());
                .toList();

        assertThat(actualNumbers).containsExactlyElementsOf(expectedEvenNumbers);
        assertThrows(UnsupportedOperationException.class, () -> actualNumbers.add(10));
    }

}


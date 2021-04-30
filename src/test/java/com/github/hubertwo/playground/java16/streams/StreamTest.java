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
                // Try to use.collect(Collectors.toList());
                .toList();

        assertThat(actualNumbers).containsExactlyElementsOf(expectedEvenNumbers);
        assertThrows(UnsupportedOperationException.class, () -> actualNumbers.add(10));
    }


    @Test
    @DisplayName("Stream.mapMulti and Stream.flatMap - combine lists")
    @SuppressWarnings({"Convert2MethodRef", "FunctionalExpressionCanBeFolded"}) /* For example readability */
    void mapMulti_lists() {
        List<String> expectedList = List.of("A", "B", "C", "D");

        List<List<String>> givenListOfLists = ImmutableList.of(
                List.of("A", "B"),
                List.of("C", "D")
        );

        // multiMap
        List<String> multiMapResult = givenListOfLists.stream()
                .<String>mapMulti((list, downstream) -> {
                    // Add each element to downstream
                    // The point here is we decide how to add elements to downstream.
                    // That might be helpful when converting element to Stream directly is hard to achieve.
                    list.forEach(letter -> downstream.accept(letter));
                })
                .toList();

        // flatMap
        List<String> flatMapResult = givenListOfLists.stream()
                // Convert each list to Stream and let flatMap combine them
                .flatMap(list -> list.stream())
                .toList();

        assertThat(multiMapResult).containsExactlyElementsOf(expectedList);
        assertThat(flatMapResult).containsExactlyElementsOf(expectedList);
    }
}


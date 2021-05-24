package com.github.hubertwo.playground.java9.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamsTest {

    @Test
    void dropWhile() {
        List<Integer> actualList = IntStream.range(0, 10)
                .dropWhile(i -> i < 5)
                .boxed()
                .toList();

        assertThat(actualList).containsExactly(5, 6, 7, 8, 9);
    }

    @Test
    void takeWhile() {
        List<Integer> actualList = IntStream.range(0, 10)
                .takeWhile(i -> i < 5)
                .boxed()
                .toList();

        assertThat(actualList).containsExactly(0, 1, 2, 3, 4);
    }

    @Test
    void iterateWithPredicate() {
        List<Integer> actualList = Stream
                .iterate(0, i -> i < 10, i -> i + 2)
                .toList();

        assertThat(actualList).containsExactly(0, 2, 4, 6, 8);
    }

}

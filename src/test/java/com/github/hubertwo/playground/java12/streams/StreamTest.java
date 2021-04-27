package com.github.hubertwo.playground.java12.streams;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class StreamTest {

    @Test
    @DisplayName("Collectors teeing")
    void collectors_teeing() {
        ImmutableList<Integer> givenList = ImmutableList.of(1, 2, 3, 4, 5, 6);
        ImmutableList<List<Integer>> expectedGroupedIntegers = ImmutableList.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
        );

        // The same might be achieved by groupBy
        ImmutableList<List<Integer>> actualGroupedIntegers = givenList.stream()
                .collect(Collectors.teeing(
                        // Putting all Ints < 4 into list
                        Collectors.filtering((i) -> i < 4, Collectors.toList()),
                        // Putting all Ints >= 4 into second list
                        Collectors.filtering((i) -> i >= 4, Collectors.toList()),
                        // Combining both lists
                        (l1, l2) -> ImmutableList.of(l1, l2)
                ));

        assertThat(actualGroupedIntegers).isEqualTo(expectedGroupedIntegers);
    }
}

package com.github.hubertwo.playground.java12.files;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class FilesTests {

    @Test
    void mismatch() throws IOException {
        // ABCD
        Path path1 = Paths.get("src/test/resources/java12/files/mismatch/File1.txt");
        // ABED
        Path path2 = Paths.get("src/test/resources/java12/files/mismatch/File2.txt");

        long actualMismatchPosition = Files.mismatch(path1, path2);

        // Confirm that files have the same size
        assertThat(Files.size(path1))
                .isGreaterThan(0)
                .isEqualTo(Files.size(path2));

        assertThat(actualMismatchPosition).isEqualTo(2);
    }
}

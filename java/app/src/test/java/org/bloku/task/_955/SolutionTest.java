package org.bloku.task._955;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        this.solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String[] strs, int expected) {
        // given

        // when
        int actual = solution.minDeletionSize(strs);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new String[] {"rbbbbaaaa", "rbbbbaaac", "zaaaaaaaa"}, 0),
                Arguments.of(new String[] {"xga", "xfb", "yfa"}, 1));
    }
}

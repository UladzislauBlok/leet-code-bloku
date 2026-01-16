package org.bloku.task._2975;

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
    void solutionReturnsExpectedResult(int m, int n, int[] hFences, int[] vFences, int expected) {
        // given

        // when
        int actual = solution.maximizeSquareArea(m, n, hFences, vFences);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(6, 7, new int[] {2}, new int[] {4}, -1),
                Arguments.of(1000000000, 1000000000, new int[] {2}, new int[] {4}, 64));
    }
}

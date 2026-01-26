package org.bloku.task._1200;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        this.solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] arr, List<List<Integer>> expected) {
        // given

        // when
        List<List<Integer>> actual = solution.minimumAbsDifference(arr);

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(
                        new int[] {3, 8, -10, 23, 19, -4, -14, 27},
                        List.of(List.of(-14, -10), List.of(19, 23), List.of(23, 27))),
                Arguments.of(
                        new int[] {4, 2, 1, 3},
                        List.of(List.of(1, 2), List.of(2, 3), List.of(3, 4))));
    }
}

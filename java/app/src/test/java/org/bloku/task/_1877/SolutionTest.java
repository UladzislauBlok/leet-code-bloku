package org.bloku.task._1877;

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
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.minPairSum(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(
                        new int[] {5, 9, 8, 6, 8, 5, 10, 2, 2, 9, 7, 3, 6, 3, 8, 7, 1, 2, 9, 10},
                        13),
                Arguments.of(new int[] {4, 1, 5, 1, 2, 5, 1, 5, 5, 4}, 8));
    }
}

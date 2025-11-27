package org.bloku.task._3381;

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
    void solutionReturnsExpectedResult(int[] nums, int k, long expected) {
        // given

        // when
        long actual = solution.maxSubarraySum_fromLeetCode(nums, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[] {-1, -2, -3, -4, -5}, 4, -10),
                Arguments.of(
                        new int[] {
                            -5, 1, 2, -3, 4, 45, 34, 523, 4534, 5645, 74, 56, 75654, 34565, 776,
                            345, 654, 34, 32, 413, 534, -5678, -980, 87, -98, -8, 787, -7, -6795, 7,
                            4, 56345, 656, 73, 48, 79, -5, -34, -5, 34, -5, -3
                        },
                        5,
                        168442));
    }
}

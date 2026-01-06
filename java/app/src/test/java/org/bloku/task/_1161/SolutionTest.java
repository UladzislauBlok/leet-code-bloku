package org.bloku.task._1161;

import static org.assertj.core.api.Assertions.assertThat;

import org.bloku.domain.TreeNode;
import org.bloku.util.TreeUtil;
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
    void solutionReturnsExpectedResult(TreeNode root, int expected) {
        // given

        // when
        int actual = solution.maxLevelSum(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(TreeUtil.buildTreeNode(List.of(1, 7, 0, 7, -8, -1, -1)), 2),
                Arguments.of(
                        TreeUtil.buildTreeNode(
                                List.of(989, -1, 10250, 98693, -89388, -1, -1, -1, -32127)),
                        2));
    }
}

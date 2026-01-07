package org.bloku.task._1339;

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
        int actual = solution.maxProduct(root);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(TreeUtil.buildTreeNode(List.of(1, 2, 3, 4, 5, 6)), 110),
                Arguments.of(
                        TreeUtil.buildTreeNode(
                                List.of(1, -1, 2, -1, -1, 3, 4, -1, -1, -1, -1, -1, -1, 5, 6)),
                        90));
    }
}

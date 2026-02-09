package org.bloku.task._1382;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bloku.util.TreeUtil.buildTreeNode;

import java.util.List;
import java.util.stream.Stream;
import org.bloku.domain.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() {
    this.solution = new Solution();
  }

  @ParameterizedTest
  @MethodSource
  void solutionReturnsExpectedResult(TreeNode root, TreeNode expected) {
    // given

    // when
    TreeNode actual = solution.balanceBST(root);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(buildTreeNode(List.of(2, 1, 3)), buildTreeNode(List.of(2, 1, 3))),
        Arguments.of(
            buildTreeNode(List.of(1, -1, 2, -1, -1, -1, 3)), buildTreeNode(List.of(2, 1, 3))));
  }
}

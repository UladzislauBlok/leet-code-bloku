package org.bloku.task._1022;

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
  void solutionReturnsExpectedResult(TreeNode root, int expected) {
    // given

    // when
    int actual = solution.sumRootToLeaf(root);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  static Stream<Arguments> solutionReturnsExpectedResult() {
    return Stream.of(
        Arguments.of(buildTreeNode(List.of(1, 0, 1, 0, 1, 0, 1)), 22),
        Arguments.of(buildTreeNode(List.of(0)), 0));
  }
}

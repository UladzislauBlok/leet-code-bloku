package org.bloku.task._3484;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void tc1() {
    Solution.Spreadsheet uut = new Solution.Spreadsheet(3);

    assertThat(uut.getValue("=5+7")).isEqualTo(12);

    uut.setCell("A1", 10);

    assertThat(uut.getValue("=A1+6")).isEqualTo(16);

    uut.setCell("B2", 15);

    assertThat(uut.getValue("=A1+B2")).isEqualTo(25);

    uut.resetCell("A1");

    assertThat(uut.getValue("=A1+B2")).isEqualTo(15);
  }
}

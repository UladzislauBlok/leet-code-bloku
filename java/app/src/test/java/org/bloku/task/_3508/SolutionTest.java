package org.bloku.task._3508;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void tc1() {
    Solution.Router uut = new Solution.Router(3);

    assertThat(uut.addPacket(1, 4, 90)).isTrue();

    assertThat(uut.addPacket(2, 5, 90)).isTrue();

    assertThat(uut.addPacket(1, 4, 90)).isFalse();

    assertThat(uut.addPacket(3, 5, 95)).isTrue();

    assertThat(uut.addPacket(4, 5, 105)).isTrue();

    assertThat(uut.forwardPacket()).containsExactly(2, 5, 90);

    assertThat(uut.addPacket(5, 2, 110)).isTrue();

    assertThat(uut.getCount(5, 100, 110)).isEqualTo(1);
  }

  @Test
  void tc2() {
    Solution.Router uut = new Solution.Router(2);

    assertThat(uut.addPacket(7, 4, 90)).isTrue();

    assertThat(uut.forwardPacket()).containsExactly(7, 4, 90);

    assertThat(uut.forwardPacket()).containsExactly();
  }
}

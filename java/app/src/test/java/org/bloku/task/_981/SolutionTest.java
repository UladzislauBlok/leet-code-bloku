package org.bloku.task._981;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void tc1() {
    Solution.TimeMap timeMap = new Solution.TimeMap();

    timeMap.set("foo", "bar", 1);

    assertThat(timeMap.get("foo", 1)).isEqualTo("bar");
    assertThat(timeMap.get("foo", 3)).isEqualTo("bar");

    timeMap.set("foo", "bar2", 4);

    assertThat(timeMap.get("foo", 4)).isEqualTo("bar2");
    assertThat(timeMap.get("foo", 5)).isEqualTo("bar2");
  }

  @Test
  void tc2() {
    Solution.TimeMap timeMap = new Solution.TimeMap();

    timeMap.set("foo", "bar", 1);
    timeMap.set("foo", "toilet", 5);
    timeMap.set("foo", "bucket", 10);
    timeMap.set("foo", "bar2", 20);

    assertThat(timeMap.get("foo", 15)).isEqualTo("bucket");
  }
}

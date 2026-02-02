package org.bloku.task._2353;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void tc1() {
    String[] food = new String[] {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
    String[] cuisines =
        new String[] {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
    int[] ratings = new int[] {9, 12, 8, 1, 14, 7};
    Solution.FoodRatings uut = new Solution.FoodRatings(food, cuisines, ratings);

    assertThat(uut.highestRated("korean")).isEqualTo("kimchi");

    assertThat(uut.highestRated("japanese")).isEqualTo("ramen");

    uut.changeRating("sushi", 16);

    assertThat(uut.highestRated("japanese")).isEqualTo("sushi");

    uut.changeRating("ramen", 16);

    assertThat(uut.highestRated("japanese")).isEqualTo("ramen");
  }
}

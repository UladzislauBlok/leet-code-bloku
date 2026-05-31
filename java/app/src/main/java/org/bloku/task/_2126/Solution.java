package org.bloku.task._2126;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Destroying Asteroids")
@Topics({ARRAY, GREEDY, SORTING})
class Solution {

  /**
   * Evaluates reachability using a Greedy Sorting approach.
   *
   * <p>Time Complexity: O(n log n) due to sorting. Space Complexity: O(1) auxiliary space (or O(n)
   * depending on primitive sort internals).
   */
  public boolean asteroidsDestroyedUsingSorting(int initialMass, int[] asteroids) {
    Arrays.sort(asteroids);
    long currentMass = initialMass;

    for (int asteroid : asteroids) {
      if (currentMass < asteroid) {
        return false;
      }
      currentMass += asteroid;
    }

    return true;
  }

  /**
   * Evaluates reachability using an optimized Counting Bucket strategy to bypass sorting overhead.
   *
   * <p>Time Complexity: O(n + max_asteroid_value) Space Complexity: O(max_asteroid_value) for the
   * frequency mapping table.
   */
  public boolean asteroidsDestroyedUsingCounting(int initialMass, int[] asteroids) {
    int minimumAsteroid = Integer.MAX_VALUE;
    int maximumAsteroid = 0;

    for (int asteroid : asteroids) {
      maximumAsteroid = Math.max(asteroid, maximumAsteroid);
      minimumAsteroid = Math.min(asteroid, minimumAsteroid);
    }

    int[] asteroidFrequencies = new int[maximumAsteroid + 1];
    long currentMass = initialMass;

    for (int asteroid : asteroids) {
      if (asteroid > currentMass) {
        asteroidFrequencies[asteroid]++;
      } else {
        currentMass += asteroid;
      }
    }

    if (currentMass >= maximumAsteroid) {
      return true;
    }

    for (int massBucket = minimumAsteroid; massBucket <= maximumAsteroid; massBucket++) {
      if (currentMass < massBucket && asteroidFrequencies[massBucket] > 0) {
        return false;
      }
      currentMass += (long) massBucket * asteroidFrequencies[massBucket];
    }

    return true;
  }
}

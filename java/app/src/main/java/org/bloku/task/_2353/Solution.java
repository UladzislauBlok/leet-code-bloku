package org.bloku.task._2353;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Design a Food Rating System")
@Topics({HASH_TABLE, RBT, DESIGN})
class Solution {

  static class FoodRatings {

    private final Map<String, Food> foods = new HashMap<>();
    private final Map<String, SortedSet<Food>> cuisines = new HashMap<>();

    FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
      int n = foods.length;
      for (int i = 0; i < n; i++) {
        Food food = new Food(foods[i], cuisines[i], ratings[i]);
        this.foods.put(foods[i], food);
        this.cuisines.putIfAbsent(cuisines[i], new TreeSet<>());
        this.cuisines.get(cuisines[i]).add(food);
      }
    }

    void changeRating(String name, int newRating) {
      Food food = foods.get(name);
      cuisines.get(food.cuisine).remove(food);
      food.rating = newRating;
      cuisines.get(food.cuisine).add(food);
    }

    String highestRated(String cuisine) {
      return cuisines.get(cuisine).getFirst().name;
    }

    private static class Food implements Comparable<Food> {
      private final String name;
      private final String cuisine;
      private int rating;

      private Food(String name, String cuisine, int rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
      }

      @Override
      public int compareTo(Food another) {
        int ratingDiff = another.rating - this.rating;
        if (ratingDiff != 0) return ratingDiff;
        return this.name.compareTo(another.name);
      }

      @Override
      public boolean equals(Object obj) {
        Food another = (Food) obj;
        return this.name.equals(another.name) && this.rating == another.rating;
      }

      @Override
      public int hashCode() {
        return Objects.hash(this.name, this.rating);
      }
    }
  }
}

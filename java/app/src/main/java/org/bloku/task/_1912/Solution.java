package org.bloku.task._1912;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Design Movie Rental System")
@Topics({DESIGN, HASH_TABLE, ORDERED_SET})
class Solution {

  static class MovieRentingSystem {

    private static final Comparator<Movie> COMP_1 =
        (a, b) -> {
          int priceDiff = a.price - b.price;
          if (priceDiff != 0) return priceDiff;
          int shopDiff = a.shop - b.shop;
          if (shopDiff != 0) return shopDiff;
          return a.movie - b.movie;
        };
    private static final Comparator<Movie> COMP_2 =
        (a, b) -> {
          int priceDiff = a.price - b.price;
          if (priceDiff != 0) return priceDiff;
          return a.shop - b.shop;
        };

    private final Map<Long, Movie> movies = new HashMap<>();
    private final Map<Integer, SortedSet<Movie>> unrented = new HashMap<>();
    private final SortedSet<Movie> rented = new TreeSet<>(COMP_1);

    public MovieRentingSystem(int n, int[][] entries) {
      for (int[] entry : entries) {
        Movie mv = new Movie(entry[0], entry[1], entry[2]);
        movies.put(mvHash(entry[0], entry[1]), mv);
        unrented.putIfAbsent(entry[1], new TreeSet<>(COMP_2));
        unrented.get(entry[1]).add(mv);
      }
    }

    public List<Integer> search(int movie) {
      if (!unrented.containsKey(movie)) return List.of();
      SortedSet<Movie> set = unrented.get(movie);
      List<Integer> res = new ArrayList<>();
      Iterator<Movie> it = set.iterator();
      while (res.size() < 5 && it.hasNext()) {
        Movie curr = it.next();
        res.add(curr.shop);
      }
      return res;
    }

    public void rent(int shop, int movie) {
      Movie mv = movies.get(mvHash(shop, movie));
      unrented.get(movie).remove(mv);
      rented.add(mv);
    }

    public void drop(int shop, int movie) {
      Movie mv = movies.get(mvHash(shop, movie));
      rented.remove(mv);
      unrented.get(movie).add(mv);
    }

    public List<List<Integer>> report() {
      List<List<Integer>> res = new ArrayList<>();
      Iterator<Movie> it = rented.iterator();
      while (res.size() < 5 && it.hasNext()) {
        Movie curr = it.next();
        res.add(List.of(curr.shop, curr.movie));
      }
      return res;
    }

    private long mvHash(int shop, int movie) {
      return (((long) shop) << 32) ^ (movie & 0xffffffffL);
    }

    private record Movie(int shop, int movie, int price) {}
  }
}

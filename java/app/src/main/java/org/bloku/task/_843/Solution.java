package org.bloku.task._843;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Guess the Word")
@Topics({MATH, STRING})
class Solution {

  // helps to prevent infinite loop
  private static final int MAX_GUESSES = 30;
  private static final int WORD_LENGTH = 6;

  private final Random rand = new Random(System.nanoTime());

  public void findSecretWord(String[] inputWords, Master master) {
    if (inputWords == null || inputWords.length == 0 || master == null) {
      // or Preconditions with reasonable message
      return;
    }
    List<String> words = new ArrayList<>();
    for (String word : inputWords) {
      words.add(word);
    }
    for (int i = 0; i < MAX_GUESSES; i++) {
      int randIndex = rand.nextInt(words.size());
      int solutionDiff = WORD_LENGTH - master.guess(words.get(randIndex));
      if (solutionDiff == 0) {
        return;
      }
      words = filterWordsWithThreshold(words.get(randIndex), solutionDiff, words);
    }
  }

  private List<String> filterWordsWithThreshold(
      String pattern, int solutionDiff, List<String> words) {
    List<String> filtered = new ArrayList<>();
    for (String word : words) {
      if (countDiff(pattern, word) == solutionDiff) {
        filtered.add(word);
      }
    }
    return filtered;
  }

  private int countDiff(String word1, String word2) {
    int diffCount = 0;
    for (int i = 0; i < word1.length(); i++) {
      if (word1.charAt(i) != word2.charAt(i)) {
        diffCount++;
      }
    }
    return diffCount;
  }

  private interface Master {

    int guess(String str);
  }
}

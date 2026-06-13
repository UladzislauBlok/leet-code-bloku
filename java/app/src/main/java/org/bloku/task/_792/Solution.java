package org.bloku.task._792;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Number of Matching Subsequences")
@Topics({HASH_TABLE, BINARY_SEARCH, TRIE})
class Solution {

  public int numMatchingSubseq(String s, String[] words) {
    if (s == null || words == null) {
      throw new IllegalArgumentException("Inputs cannot be null.");
    }

    int matchCounter = 0;
    Map<Character, List<Node>> buckets = new HashMap<>();

    for (String word : words) {
      if (word == null) {
        continue;
      }
      if (word.isEmpty()) {
        matchCounter++;
        continue;
      }
      char firstChar = word.charAt(0);
      buckets.computeIfAbsent(firstChar, k -> new ArrayList<>()).add(new Node(word));
    }

    for (int i = 0; i < s.length(); i++) {
      char currentFieldChar = s.charAt(i);

      List<Node> currBucket = buckets.get(currentFieldChar);
      if (currBucket == null || currBucket.isEmpty()) {
        continue;
      }

      List<Node> wordsToProcess = new ArrayList<>(currBucket);
      currBucket.clear();

      for (Node node : wordsToProcess) {
        node.wordIndex++;

        if (node.wordIndex == node.word.length()) {
          matchCounter++;
        } else {
          char nextKey = node.word.charAt(node.wordIndex);
          buckets.computeIfAbsent(nextKey, k -> new ArrayList<>()).add(node);
        }
      }
    }

    return matchCounter;
  }

  private static final class Node {
    private final String word;
    private int wordIndex;

    private Node(String word) {
      this.word = word;
      this.wordIndex = 0;
    }
  }
}

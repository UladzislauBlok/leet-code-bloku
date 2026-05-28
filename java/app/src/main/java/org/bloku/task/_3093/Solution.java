package org.bloku.task._3093;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Longest Common Suffix Queries")
@Topics({TRIE, STRING})
class Solution {

  public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
    SuffixTrie trie = new SuffixTrie();
    int shortestWordLength = wordsContainer[0].length();
    int shortestWordPosition = 0;

    for (int i = 0; i < wordsContainer.length; i++) {
      String word = wordsContainer[i];
      if (word.length() < shortestWordLength) {
        shortestWordLength = word.length();
        shortestWordPosition = i;
      }
      trie.insert(word, i);
    }

    int[] result = new int[wordsQuery.length];
    for (int i = 0; i < wordsQuery.length; i++) {
      int bestMatchPosition = trie.findBestPosition(wordsQuery[i]);
      result[i] = (bestMatchPosition != -1) ? bestMatchPosition : shortestWordPosition;
    }

    return result;
  }

  /** A specialized Trie that processes strings from right to left to optimize suffix matching. */
  private static final class SuffixTrie {
    private final TrieNode root;

    SuffixTrie() {
      root = new TrieNode(-1, Integer.MAX_VALUE);
    }

    void insert(String word, int position) {
      TrieNode current = root;
      int wordLength = word.length();

      for (int i = wordLength - 1; i >= 0; i--) {
        int charIndex = word.charAt(i) - 'a';

        if (current.children[charIndex] == null) {
          current.children[charIndex] = new TrieNode(position, wordLength);
        }

        current = current.children[charIndex];

        if (wordLength < current.bestLength) {
          current.bestLength = wordLength;
          current.bestPosition = position;
        }
      }
    }

    int findBestPosition(String suffix) {
      TrieNode current = root;
      int deepMatchPosition = -1;

      for (int i = suffix.length() - 1; i >= 0; i--) {
        int charIndex = suffix.charAt(i) - 'a';
        if (current.children[charIndex] == null) {
          return deepMatchPosition;
        }
        current = current.children[charIndex];
        deepMatchPosition = current.bestPosition;
      }

      return deepMatchPosition;
    }
  }

  /** Individual unit structural block representing a character transition in the SuffixTrie. */
  private static final class TrieNode {
    private final TrieNode[] children;
    private int bestPosition;
    private int bestLength;

    TrieNode(int bestPosition, int bestLength) {
      this.children = new TrieNode[26];
      this.bestPosition = bestPosition;
      this.bestLength = bestLength;
    }
  }
}

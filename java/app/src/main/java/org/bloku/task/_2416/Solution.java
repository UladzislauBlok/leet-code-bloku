package org.bloku.task._2416;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Sum of Prefix Scores of Strings")
@Topics({STRING, TRIE, COUNTING})
class Solution {

  public int[] sumPrefixScores(String[] words) {
    if (words == null) {
      throw new IllegalArgumentException("Input can not be null");
    }
    Trie trie = new Trie();
    for (String word : words) {
      trie.add(word);
    }
    int[] prefixSums = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      prefixSums[i] = trie.getPrefixScore(words[i]);
    }
    return prefixSums;
  }

  private static final class Trie {
    private final Node root;

    private Trie() {
      root = new Node();
    }

    private void add(String str) {
      Node curr = root;
      for (int i = 0; i < str.length(); i++) {
        char currChar = str.charAt(i);
        if (currChar < 'a' || currChar > 'z') {
          throw new IllegalArgumentException(
              "Input string is expected to contains low eng letters only");
        }
        int index = currChar - 'a';
        if (curr.children[index] == null) {
          curr.children[index] = new Node();
        }
        curr = curr.children[index];
        curr.wordCount++;
      }
    }

    private int getPrefixScore(String prefix) {
      int prefixCounter = 0;
      Node curr = root;
      for (int i = 0; i < prefix.length(); i++) {
        char currChar = prefix.charAt(i);
        if (currChar < 'a' || currChar > 'z') {
          throw new IllegalArgumentException(
              "Input string is expected to contains low eng letters only");
        }
        int index = currChar - 'a';
        if (curr.children[index] == null) {
          break;
        }
        curr = curr.children[index];
        prefixCounter += curr.wordCount;
      }
      return prefixCounter;
    }
  }

  private static final class Node {
    private final Node[] children;
    private int wordCount;

    private Node() {
      children = new Node[26];
      wordCount = 0;
    }
  }
}

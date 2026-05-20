package org.bloku.task._900;

import static org.bloku.util.Topic.*;

import java.util.Objects;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("RLE Iterator")
@Topics({ARRAY, DESIGN, COUNTING, BINARY_SEARCH})
class Solution {

  public final class RLEIterator { // Classes designed for extension should be abstract or final

    private final long[] prefixSums;
    private final int[] values;
    private long currentPosition;
    private int searchOffset;

    /**
     * Initializes the iterator with the run-length encoded array.
     *
     * @param encoding An array where even indices represent counts and odd indices represent
     *     values.
     */
    public RLEIterator(int[] encoding) {
      // Defensive programming: Google style favors validating inputs immediately
      Objects.requireNonNull(encoding, "Encoding array cannot be null");

      int encodingLength = encoding.length;
      int pairsCount = encodingLength / 2;

      this.prefixSums = new long[pairsCount];
      this.values = new int[pairsCount];

      if (pairsCount == 0) {
        this.currentPosition = 0;
        this.searchOffset = 0;
        return;
      }

      prefixSums[0] = encoding[0];
      values[0] = encoding[1];

      for (int i = 1; i < pairsCount; i++) {
        int countIndex = i * 2;
        int valueIndex = countIndex + 1;

        prefixSums[i] = prefixSums[i - 1] + encoding[countIndex];
        values[i] = encoding[valueIndex];
      }

      currentPosition = 0;
      searchOffset = 0;
    }

    /**
     * Advances the iterator by n elements and returns the value at that position.
     *
     * @param steps The number of elements to advance.
     * @return The value at the final position, or -1 if the iterator runs out of elements.
     */
    public int next(int steps) {
      int maxIndex = prefixSums.length - 1;
      currentPosition += steps;

      if (currentPosition > prefixSums[maxIndex]) {
        return -1;
      }

      int targetIndex = binarySearch(searchOffset, maxIndex, currentPosition);
      searchOffset = targetIndex;

      return values[targetIndex];
    }

    /**
     * Performs a binary search to find the insertion point.
     *
     * @param low The starting index of the search range.
     * @param high The ending index of the search range.
     * @param target The minimum cumulative position we are looking for.
     * @return The first index where {@code prefixSums[index] >= target}.
     */
    private int binarySearch(int low, int high, long target) {
      while (low <= high) {
        int mid = low + (high - low) / 2;

        if (prefixSums[mid] < target) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }

      return low;
    }
  }

  private final class RLEIteratorLinearTime {
    int[] A;
    int i, q;

    public RLEIteratorLinearTime(int[] A) {
      this.A = A;
      i = q = 0;
    }

    public int next(int n) {
      while (i < A.length) {
        if (q + n > A[i]) {
          n -= A[i] - q;
          q = 0;
          i += 2;
        } else {
          q += n;
          return A[i + 1];
        }
      }

      return -1;
    }
  }
}

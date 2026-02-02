package org.bloku.task._812;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Largest Triangle Area")
@Topics({ARRAY, MATH})
class Solution {

  // 3 <= points.length <= 50
  // let start with brutte force n^3
  public double largestTriangleArea1(int[][] points) {
    int n = points.length;
    double max = -1;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          double a = length(points[i], points[j]);
          double b = length(points[i], points[k]);
          double c = length(points[j], points[k]);
          max = Math.max(max, area(a, b, c));
        }
      }
    }
    return max;
  }

  private double length(int[] a, int[] b) {
    int x = Math.abs(a[0] - b[0]);
    int y = Math.abs(a[1] - b[1]);
    return Math.sqrt(x * x + y * y);
  }

  private double area(double a, double b, double c) {
    double s = (a + b + c) / 2.0;
    double areaSq = s * (s - a) * (s - b) * (s - c);
    if (areaSq < 0) return -1.0;
    return Math.sqrt(areaSq);
  }

  public double largestTriangleArea(int[][] points) {
    int n = points.length;
    double maxArea = 0.0;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          double area = calculateArea(points[i], points[j], points[k]);
          if (area > maxArea) {
            maxArea = area;
          }
        }
      }
    }
    return maxArea;
  }

  private double calculateArea(int[] p1, int[] p2, int[] p3) {
    // Shoelace formula for triangle area
    return 0.5
        * Math.abs(p1[0] * (p2[1] - p3[1]) + p2[0] * (p3[1] - p1[1]) + p3[0] * (p1[1] - p2[1]));
  }
}

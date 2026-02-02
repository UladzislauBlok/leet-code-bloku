package org.bloku.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Node {
  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<>();
  }

  public Node(int val) {
    this.val = val;
    neighbors = new ArrayList<>();
  }

  public Node(int val, ArrayList<Node> neighbors) {
    this.val = val;
    this.neighbors = neighbors;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Node node = (Node) o;
    Map<Integer, List<Integer>> currNeighborsMap = buildNeighborsMap(this);
    Map<Integer, List<Integer>> toCheckNeighborsMap = buildNeighborsMap(node);
    return val == node.val && Objects.equals(currNeighborsMap, toCheckNeighborsMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, buildNeighborsMap(this));
  }

  private Map<Integer, List<Integer>> buildNeighborsMap(Node node) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    dfs(map, node);
    return map;
  }

  private void dfs(Map<Integer, List<Integer>> map, Node node) {
    if (map.containsKey(node.val)) return;
    List<Integer> neighborValues = new ArrayList<>();
    map.put(node.val, neighborValues);
    node.neighbors.forEach(
        neighbor -> {
          neighborValues.add(neighbor.val);
          dfs(map, neighbor);
        });
  }
}

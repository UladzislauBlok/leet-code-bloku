package org.bloku.util;

import java.util.List;
import java.util.stream.IntStream;
import org.bloku.domain.Node;

public class GraphUtil {
  private GraphUtil() {}

  public static Node buildGraph(List<List<Integer>> relations) {
    List<Node> nodes = IntStream.rangeClosed(0, relations.size()).mapToObj(Node::new).toList();
    for (int i = 0; i < relations.size(); i++) {
      Node vertex = nodes.get(i + 1);
      vertex.neighbors = relations.get(i).stream().map(nodes::get).toList();
    }
    return nodes.size() > 1 ? nodes.get(1) : null;
  }
}

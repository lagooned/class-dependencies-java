package com.jaredengler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopologicalSort {

  public List<Integer> topologicalSort(Map<Integer, List<Integer>> graph) {
      var list = dfs(graph).stream().collect(Collectors.toList());
      Collections.reverse(list);
      return list;
  }

  private List<Integer> dfs(Map<Integer, List<Integer>> graph) {
    var parent = new HashMap<Integer, Integer>();
    var order = new ArrayList<Integer>();
    // graph isn't necessarily connected
    for (var entry : graph.entrySet()) {
      var current = entry.getKey();
      if (!parent.containsKey(current)) {
        parent.put(current, null);
        dfsVisit(graph, current, parent, order);
      }
    }
    return order;
  }

  private void dfsVisit(
    Map<Integer, List<Integer>> graph,
    Integer current,
    Map<Integer, Integer> parent,
    List<Integer> order
  ) {
    var adj = graph.get(current);
    for (var destination : adj) {
      if (!parent.containsKey(destination)) {
        parent.put(destination, current);
        dfsVisit(graph, destination, parent, order);
      }
    }
    // record dfs post order
    order.add(current);
  }

}

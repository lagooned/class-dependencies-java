package com.jaredengler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TopologicalSort {

  public List<Integer> topologicalSort(Map<Integer, List<Integer>> graph) {
      var list = dfs(graph).stream().collect(Collectors.toList());
      Collections.reverse(list);
      return list;
  }

  private List<Integer> dfs(Map<Integer, List<Integer>> graph) {
    Map<Integer, Integer> parent = new HashMap<>();
    List<Integer> order = new ArrayList<>();
    // graph isn't necessarily connected
    for (Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      Integer current = entry.getKey();
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
    List<Integer> adj = graph.get(current);
    for (Integer destination : adj) {
      if (!parent.containsKey(destination)) {
        parent.put(destination, current);
        dfsVisit(graph, destination, parent, order);
      }
    }
    // record dfs post order
    order.add(current);
  }

}

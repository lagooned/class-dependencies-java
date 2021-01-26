package com.jaredengler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ClassDependencies {

  String calculatePath(Map<Integer, List<Integer>> classes) {
    String order = dfs(classes).stream()
      .map(i -> i.toString())
      .collect(Collectors.joining(" "));
    return order;
  }

  public List<Integer> dfs(Map<Integer, List<Integer>> classes) {
    Map<Integer, Integer> parent = new HashMap<>();
    List<Integer> order = new ArrayList<>();
    // graph isn't necessarily connected
    for (Entry<Integer, List<Integer>> entry : classes.entrySet()) {
      Integer current = entry.getKey();
      if (!parent.containsKey(current)) {
        parent.put(current, null);
        dfsVisit(classes, current, parent, order);
      }
    }
    return order;
  }

  private void dfsVisit(
    Map<Integer, List<Integer>> classes,
    Integer current,
    Map<Integer, Integer> parent,
    List<Integer> order
  ) {
    List<Integer> adj = classes.get(current);
    for (Integer destination : adj) {
      if (!parent.containsKey(destination)) {
        parent.put(destination, current);
        dfsVisit(classes, destination, parent, order);
      }
    }
    // record dfs post order
    order.add(current);
  }

}

package com.jaredengler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ClassDependencies {

  String calculatePath(Map<Integer, List<Integer>> classes) {
    String order = dfs(classes).stream()
      .map(i -> i.toString())
      .reduce("", (a, b) -> b + " " + a)
      .trim();
    System.out.println(order);
    return order;
  }

  public List<Integer> dfs(Map<Integer, List<Integer>> classes) {
    // System.out.println("classes " + classes);
    Map<Integer, Integer> parent = new HashMap<>();
    List<Integer> order = new ArrayList<>();
    for (Entry<Integer, List<Integer>> entry : classes.entrySet()) {
      Integer current = entry.getKey();
      if (!parent.containsKey(current)) {
        parent.put(current, null);
        dfsVisit(classes, current, parent, order);
      }
    }
    // System.out.println("done " + parent);
    return order;
  }

  private void dfsVisit(
    Map<Integer, List<Integer>> classes,
    Integer current,
    Map<Integer, Integer> parent,
    List<Integer> order
  ) {

    List<Integer> adj = classes.get(current);

    // System.out.println("current => " + current);
    // System.out.println("parent => " + parent);
    // System.out.println("adj(" + current + ") => " + adj);

    for (Integer destination : adj) {
      if (!parent.containsKey(destination)) {
        parent.put(destination, current);
        dfsVisit(classes, destination, parent, order);
      }
    }

    order.add(current);
    // System.out.println("order " + order);

  }

}

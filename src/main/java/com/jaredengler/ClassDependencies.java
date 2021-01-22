package com.jaredengler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassDependencies {

  String calculatePath(Map<Integer, List<Integer>> classes) {
    return dfs(classes, 1).stream()
      .map(i -> i.toString())
      .reduce("", (a, b) -> b + " " + a)
      .trim();
  }

  public List<Integer> dfs(Map<Integer, List<Integer>> classes, Integer start) {
    List<Integer> visited = new ArrayList<>();
    System.out.println("classes " + classes);
    dfs(classes, start, visited);
    return visited;
  }

  private void dfs(Map<Integer, List<Integer>> classes, Integer current, List<Integer> visited) {
    System.out.println("current " + current);
    System.out.println("visited before adding " + visited);
    visited.add(current);
    System.out.println("visited after adding " + visited);
    List<Integer> adj = classes.get(current);
    System.out.println("adj " + adj);

    for (Integer dest : adj) {
      if (!visited.contains(dest)) {
        dfs(classes, dest, visited);
      }
    }
  }

}

package com.jaredengler;

import java.util.List;
import java.util.Map;

public class ClassDependencies {
  public static void main(String[] args) {
  }

  String calculatePath(Map<Integer, List<Integer>> classes) {
    return classes.keySet().stream()
      .map(i -> i.toString())
      .reduce("", (a, b) -> a + b);
  }
}

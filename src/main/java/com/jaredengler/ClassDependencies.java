package com.jaredengler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassDependencies {
  public static void main(String[] args) {
  }

  String calculatePath(Map<Integer, List<Integer>> classes) {
    return classes.keySet().stream()
      .map(i -> i.toString())
      .collect(Collectors.joining(" "));
  }
}

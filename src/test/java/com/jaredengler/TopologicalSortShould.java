package com.jaredengler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

public class TopologicalSortShould {

  TopologicalSort classDependencies = new TopologicalSort();

  @Test
  void createsCorrectTopologicalSort() {

    Map<Integer, List<Integer>> graph = Map.of(
      0, List.of(1, 2),
      1, List.of(3, 2, 4),
      2, List.of(),
      3, List.of(5),
      4, List.of(),
      5, List.of(8, 6, 7),
      6, List.of(),
      7, List.of(8),
      8, List.of(9),
      9, List.of());

    List<Integer> actual = classDependencies.topologicalSort(graph);
    for (Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      for (Integer v : entry.getValue()) {
        assertThat(actual.indexOf(entry.getKey()), is(lessThan(actual.indexOf(v))));
      }
    }
  }

}

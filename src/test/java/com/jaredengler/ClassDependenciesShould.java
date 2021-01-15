package com.jaredengler;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class ClassDependenciesShould {

  ClassDependencies classDependencies = new ClassDependencies();

  @Test
  void returnAString() {

    Map<Integer, List<Integer>> classes = Map.of(0, List.of());
    assertThat(
      classDependencies.calculatePath(classes),
      isA(String.class));

  }

  @Test
  void returnAStringOfSizeOfKeys() {

    Map<Integer, List<Integer>> classes = Map.of(0, List.of());
    assertThat(
      classDependencies.calculatePath(classes).length(),
      is(equalTo(classes.keySet().size())));

  }

}

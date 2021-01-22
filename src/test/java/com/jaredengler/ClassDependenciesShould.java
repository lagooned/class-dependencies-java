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
  void returnAStringOfCorrectSize() {

    Map<Integer, List<Integer>> classes =
      Map.of(0, List.of());

    Map<Integer, List<Integer>> classes2 =
      Map.of(0, List.of(),
             1, List.of(0));

    assertThat(classDependencies.calculatePath(classes).length(), is(equalTo(1)));

    assertThat(classDependencies.calculatePath(classes2).length(), is(equalTo(3)));

  }

  @Test
  void handleOneDependency() {

    Map<Integer, List<Integer>> classes =
      Map.of(0, List.of(),
             1, List.of(0));

    assertThat(
      classDependencies.calculatePath(classes),
      is(equalTo("0 1")));

  }

  @Test
  void handleTwoDependency() {

    Map<Integer, List<Integer>> classes =
      Map.of(0, List.of(),
             1, List.of(0),
             2, List.of(0),
             3, List.of(1, 2));

    assertThat(
      classDependencies.calculatePath(classes),
      is(equalTo("3 1 2 0")));

  }

}

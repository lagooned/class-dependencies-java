package com.jaredengler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TopologicalSort {

  public List<Integer> topologicalSort(Map<Integer, List<Integer>> graph) {
    var list = dfs(graph).stream().collect(Collectors.toList());
    //Collections.reverse(list);
    System.out.println(list);
    return list;
  }

  private List<Integer> dfs(Map<Integer, List<Integer>> graph) {
    Map<Integer, Boolean> visited = new HashMap<>();
    LinkedList<Integer> order = new LinkedList<>();
	  Stack<Integer> stack = new Stack<>();
	  stack.push(0);
	  
	  while (!stack.isEmpty()) {
	    Integer current = stack.pop();
	  
	    if (!visited.containsKey(current)) {
	      order.addFirst(current);
	      visited.put(current, true);
	    }
	  
	    for (Integer destination : graph.get(current)) {
	      if (!visited.containsKey(destination)) 
	        stack.push(destination);
	    }
	  }
	  
	  return order;
  }

}

package com.jaredengler;

public class SudokuSolver {

  int[][] grid;

  SudokuSolver() {
  }

  SudokuSolver(int[][] grid) {
    this.grid = grid;
  }

  SudokuSolver setGrid(int[][] grid) {
    this.grid = grid;
    return this;
  }

  boolean isPossible(int y, int x, int n) {
    return isRowPossible(x, n) && isColPossible(y, n) && isBoxPossible(y, x, n);
  }

  boolean isColPossible(int y, int n) {
    for (var i = 0; i < 9; i++) {
      if (grid[y][i] == n)
        return false;
    }

    return true;
  }

  boolean isRowPossible(int x, int n) {
    for (var i = 0; i < 9; i++)
      if (grid[i][x] == n)
        return false;

    return true;
  }

  boolean isBoxPossible(int y, int x, int n) {
    var x_0 = 3 * (x / 3);
    var y_0 = 3 * (y / 3);

    for (var i = 0; i < 3; i++)
      for (var j = 0; j < 3; j++)
        if (grid[y_0 + i][x_0 + j] == n) 
          return false;

    return true;
  }

}

package com.jaredengler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class SudokuSolverShould {

  SudokuSolver sudokuSolver = new SudokuSolver();

  @Test
  void findIfPossibleByRow() {

    int[][] validRowGrid = new int[][] {
      new int[]{0,1,1,1,1,1,1,1,1},
      new int[]{2,0,2,2,2,2,2,2,2},
      new int[]{3,3,0,3,3,3,3,3,3},
      new int[]{4,4,4,0,4,4,4,4,4},
      new int[]{5,5,5,5,0,5,5,5,5},
      new int[]{6,6,6,6,6,0,6,6,6},
      new int[]{7,7,7,7,7,7,0,7,7},
      new int[]{8,8,8,8,8,8,8,0,8},
      new int[]{9,9,9,9,9,9,9,9,0},
    };

    sudokuSolver.setGrid(validRowGrid);

    for (int y = 0; y < validRowGrid.length; y++) {
      for (int x = 0; x < validRowGrid[y].length; x++) {
        var n = x + 1;
        assertThat(
          sudokuSolver.isRowPossible(y, n),
          is(y == x));
      }
    }

  }

  @Test
  void findIfPossibleByColumn() {

    int[][] validColGrid = new int[][] {
      new int[]{0,2,3,4,5,6,7,8,9},
      new int[]{1,0,3,4,5,6,7,8,9},
      new int[]{1,2,0,4,5,6,7,8,9},
      new int[]{1,2,3,0,5,6,7,8,9},
      new int[]{1,2,3,4,0,6,7,8,9},
      new int[]{1,2,3,4,5,0,7,8,9},
      new int[]{1,2,3,4,5,6,0,8,9},
      new int[]{1,2,3,4,5,6,7,0,9},
      new int[]{1,2,3,4,5,6,7,8,0},
    };

    sudokuSolver.setGrid(validColGrid);

    for (int y = 0; y < validColGrid.length; y++) {
      for (int x = 0; x < validColGrid[y].length; x++) {
        var n = y + 1;
        assertThat(
          sudokuSolver.isColPossible(x, n),
          is(y == x));
      }
    }

  }

  @Test
  void findIfPossibleByBox() {

    int[][] validBoxGrid = new int[][] {
      new int[]{0,2,3,0,1,3,0,2,1},
      new int[]{4,5,6,4,5,6,4,5,6},
      new int[]{7,8,9,7,8,9,7,8,9},
      new int[]{0,2,3,0,2,3,0,2,3},
      new int[]{1,5,6,4,1,6,4,5,1},
      new int[]{7,8,9,7,8,9,7,8,9},
      new int[]{0,2,3,0,2,3,0,2,3},
      new int[]{4,5,6,4,5,6,4,5,6},
      new int[]{1,8,9,7,1,9,7,8,1},
    };

    sudokuSolver.setGrid(validBoxGrid);

    assertThat(sudokuSolver.isBoxPossible(0, 0, 1), is(true));
    assertThat(sudokuSolver.isBoxPossible(0, 3, 2), is(true));
    assertThat(sudokuSolver.isBoxPossible(0, 6, 3), is(true));

    assertThat(sudokuSolver.isBoxPossible(3, 0, 4), is(true));
    assertThat(sudokuSolver.isBoxPossible(3, 3, 5), is(true));
    assertThat(sudokuSolver.isBoxPossible(3, 6, 6), is(true));

    assertThat(sudokuSolver.isBoxPossible(6, 0, 7), is(true));
    assertThat(sudokuSolver.isBoxPossible(6, 3, 8), is(true));
    assertThat(sudokuSolver.isBoxPossible(6, 6, 9), is(true));
  }

}

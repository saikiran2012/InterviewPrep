package test.strings;

import main.string.Matrix;
import org.junit.Test;
import org.testng.Assert;

public class MatrixTest {

  @Test
  public void testMatrix() {
    int[][] matrix1 = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    int[][] matrix1r = {
      {7, 4, 1},
      {8, 5, 2},
      {9, 6, 3}
    };
    Matrix m = new Matrix(matrix1);
    Assert.assertEquals(matrix1r, m.rotateMatrix());
    }

    @Test
    public void zeroMatrix() {
      int[][] matrix1 = {
              {1, 2, 3, 4},
              {4, 5, 6, 0},
              {7, 8, 9, 2}
      };
      int[][] matrix1r = {
              {1, 2, 3, 0},
              {0, 0, 0, 0},
              {0, 0, 0, 0}
      };
      Matrix m = new Matrix(matrix1);
      Assert.assertEquals(matrix1r, m.zeroMatrix(3,4));
    }
}

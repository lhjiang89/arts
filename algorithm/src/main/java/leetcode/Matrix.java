package leetcode;

/**
 * Created by linhjiang on 8/12/18.
 */
public class Matrix {

  static final int[]y = {0, 0, -1, 1};
  static final int[]x = {1, -1, 0, 0};

  public int[][] updateMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        dp(matrix, i, j);
      }
    }

    return matrix;
  }

  private void dp(int[][]matrix, int i, int j) {
    if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 0) {
      return;
    }

    int orig = matrix[i][j];
    int min = Integer.MAX_VALUE;
    for(int k = 0; k < 4; k ++) {
      int m = i + y[k];
      int n = j + x[k];
      if(m >= 0 && n >= 0 && m < matrix.length && n < matrix[0].length) {
        int val = matrix[m][n];
        if(min > val) {
          min = val;
        }
      }
    }
    matrix[i][j] = min + 1;

    if (orig != matrix[i][j]) {
      dp(matrix, i - 1, j);
      dp(matrix, i + 1, j);
      dp(matrix, i, j - 1);
      dp(matrix, i, j + 1);
    }
  }


  public static void main(String[] args) {
    Matrix matrix = new Matrix();

    int[][]a = {{0,1,0,1,1}, {1,1,0,0,1}, {0,0,0,1,0}, {1,0,1,1,1}, {1,0,0,0,1}};
    int[][] result = matrix.updateMatrix(a);
    System.out.println(result);
  }
}

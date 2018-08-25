package leetcode;

/**
 * Created by linhjiang on 8/16/18.
 */
public class FriendCircles {
  public int findCircleNum(int[][] M) {
    int group = 0;
    int[] visited = new int[M.length];

    for(int j = 0; j < M.length; j ++) {
      if(visited[j] == 1) {
        continue;
      }

      dfs(M, j, visited);
      group++;
    }

    return group;
  }

  private void dfs(int[][]m, int n, int[]visited) {
    visited[n] = 1;
    for(int i = 0; i < m.length; i ++) {
      if(visited[i] == 0 && m[n][i] == 1) {
        dfs(m, i, visited);
      }
    }
  }

  public static void main(String[] args) {
//    int[][] m = new int[][] {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
//    System.out.println(new FriendCircles().findCircleNum(m));

    int[][]n = new int[][] {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
    System.out.println(new FriendCircles().findCircleNum(n));
  }

}

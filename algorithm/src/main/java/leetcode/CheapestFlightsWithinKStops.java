package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by linhjiang on 8/19/18.
 */
public class CheapestFlightsWithinKStops{

  class City implements Comparable <City> {
    int id;
    int cost;
    int stop;

    public City(int id, int cost, int stop) {
      this.id = id;
      this.cost = cost;
      this.stop = stop;
    }

    public int compareTo(City o) {
      return this.cost - o.cost;
    }
  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    int[][] m = new int[n][n];

    for(int i = 0; i < flights.length; i ++) {
      int x = flights[i][0];
      int y = flights[i][1];
      m[x][y] = flights[i][2];
    }

    Queue<City> minHeap = new PriorityQueue<City>();
    minHeap.offer(new City(src, 0, -1));

    while(!minHeap.isEmpty()) {
      City c = minHeap.poll();
      if(c.stop > K) {
        continue;
      }
      if(c.id == dst) {
        return c.cost;
      }
      for(int i = 0; i < n; i ++) {
        if(m[c.id][i] != 0) {
          minHeap.offer(new City(i, m[c.id][i] + c.cost, c.stop + 1));
        }
      }

    }

    return -1;

  }


  public static void main(String[] args) {
    int n = 5;
    int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
    int src = 0;
    int dst = 2;
    int k = 2;
    int result = new CheapestFlightsWithinKStops().findCheapestPrice(n, flights, src, dst, k);
    System.out.println(result);
  }

}

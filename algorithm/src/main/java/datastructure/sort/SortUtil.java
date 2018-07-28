package datastructure.sort;

import java.util.Random;

/**
 * Created by linhjiang on 7/28/18.
 */
public class SortUtil {

  private static Random random = new Random(System.currentTimeMillis());

  public static int[] createArray(int n) {
    Random random = new Random(System.currentTimeMillis());
    int a[] = new int[n];
    for (int i = 0; i < a.length; i++) {
      a[i] = random.nextInt(1000000);
    }

    return a;
  }

  public static void print(int[] a) {
    for (int i : a) {
      System.out.print(i + " ");
    }
  }

  public static void swap(int[] a, int i, int j) {
    if(i == j) {
      return;
    }
    a[i] = a[i] + a[j];
    a[j] = a[i] - a[j];
    a[i] = a[i] - a[j];
  }
}

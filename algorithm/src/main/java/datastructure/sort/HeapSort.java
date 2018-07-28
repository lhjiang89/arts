package datastructure.sort;

/**
 * Created by linhjiang on 7/28/18.
 */
public class HeapSort {
  public static void sort(int[] a) {

    for (int i = a.length / 2 - 1; i >= 0; i--) {
      adjust(a, i, a.length - 1);
    }

    for (int i = a.length - 1; i >= 1; i--) {
      // swap biggest one to the i-th position and sort prior nodes again
      SortUtil.swap(a, 0, i);
      adjust(a, 0, i - 1);
    }
  }

  private static void adjust(int[] a, int parent, int last) {

    while(parent * 2 + 1 <= last) {
      // set swap index to left child
      int swap = parent * 2 + 1;
      /**
       * swap + 1 is the right child
       * if there is right child, then compare the left and the right, swap the bigger one with the parent
       */
      if (swap + 1 <= last && a[swap + 1] > a[swap]) {
        swap = swap + 1;
      }

      if (a[parent] < a[swap]) {
        SortUtil.swap(a, parent, swap);
      }

      parent = swap;
    }
  }

  public static void main(String[] args) {
    int a[] = SortUtil.createArray(10000);

    long start = System.currentTimeMillis();
    sort(a);
    long cost = System.currentTimeMillis() - start;

    System.out.println("cost " + cost + "ms");

    SortUtil.print(a);
  }
}

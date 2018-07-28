package datastructure.sort;

/**
 * Created by linhjiang on 7/28/18.
 */
public class QuickSort {

  public static void sort(int[] a) {
    quickSort(a, 0, a.length - 1);
  }

  static void quickSort(int[] a, int l, int r) {

    if (l >= r) {
      return;
    }

    int x = a[l];
    int i = l, j = r;

    while (i < j) {
      while (j > i && a[j] >= x)
        j--;
      while (j > i && a[i] <= x)
        i++;

      if (i < j) {
        SortUtil.swap(a, i, j);
      }
    }

    a[l] = a[i];
    a[i] = x;
    quickSort(a, l, i - 1);
    quickSort(a, i + 1, r);
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

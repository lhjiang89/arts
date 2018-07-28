package datastructure.sort;

/**
 * Created by linhjiang on 7/28/18.
 */
public class MergeSort {

  public static void sort(int[] a) {
    int[] temp = new int[a.length];
    mergeSort(a, 0, a.length - 1, temp);
  }

  private static void mergeSort(int[] a, int l, int r, int[] temp) {

    if(l >= r) {
      return;
    }

    int divide = (l + r) / 2;
    mergeSort(a, l, divide, temp);
    mergeSort(a, divide + 1, r, temp);
    merge(a, l, divide, r, temp);
  }

  private static void merge(int[] a, int l, int m, int r, int[] temp) {
    int i = l, j = m + 1, k = l;
    for (; i <= m & j <= r; k ++) {
      if(a[i] <= a[j]) {
        temp[k] = a[i ++];
      } else {
        temp[k] = a[j ++];
      }
    }
    while(i <= m) {
      temp[k ++] = a[i ++];
    }

    while(j <= r) {
      temp[k ++] = a[j ++];
    }

    for(i = l; i <= r; i ++) {
      a[i] = temp[i];
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

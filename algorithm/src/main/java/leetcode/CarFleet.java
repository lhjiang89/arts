package leetcode;

/**
 * Created by linhjiang on 8/13/18.
 */
public class CarFleet {

  public int carFleet(int target, int[] position, int[] speed) {
    quickSort(position, speed, 0, position.length - 1);
    int result = 0;
    double maxTime[] = new double[position.length];
    for(int i = 0; i < position.length; i ++) {
      double time = (target - position[i]) * 1.0f / speed[i];
      if(i == 0 || time > maxTime[i - 1]) {
        maxTime[i] = time;
        result ++;
      } else {
        maxTime[i] = maxTime[i - 1];
      }

    }
    return result;
  }

  private void quickSort(int[] position, int[] speed, int l, int r) {

    if (l >= r) {
      return;
    }

    int x = position[l];
    int y = speed[l];
    int i = l, j = r;

    while (i < j) {
      while (j > i && position[j] <= x)
        j--;
      while (j > i && position[i] >= x)
        i++;

      if (i < j) {
        swap(position, i, j);
        swap(speed, i, j);
      }
    }

    position[l] = position[i];
    position[i] = x;
    speed[l] = speed[i];
    speed[i] = y;
    quickSort(position, speed, l, i - 1);
    quickSort(position, speed, i + 1, r);

  }

  private void sortByPosition(int[] position, int[] speed) {
    for(int i = 0; i < position.length - 1; i ++) {
      for(int j = 0; j < position.length - 1 - i; j ++) {
        if(position[j] < position[j + 1]) {
          swap(position, j, j + 1);
          swap(speed, j, j + 1);
        }
      }
    }
  }

  private void swap(int[]a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    int []position = {10,8,0,5,3};
    int[] speed = {2,4,1,1,3};
    int target = 12;

    System.out.println(new CarFleet().carFleet(target, position, speed));
  }
}

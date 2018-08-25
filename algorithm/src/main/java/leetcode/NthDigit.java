package leetcode;

import java.util.ArrayList;

/**
 * Created by linhjiang on 8/18/18.
 */
public class NthDigit {

  public int findNthDigit(int n) {
    // 9, 90 * 2, 900 * 3, 9000 * 4
    int i = 1;
    long j = 1;
    int sum = 0;
    while(n > sum + 9 * i * j) {
      sum += 9 * i * j;
      i *= 10;
      j ++;
    }
    int x = n - sum;
    long target = i + (x / j) + (x % j == 0 ? 0 : 1) - 1;
    return findNthFromNumber(target, j, (x - 1) % j);
  }

  public int findNthFromNumber(long number, long j, long idx) {
    return (int)number / (int)Math.pow(10, j - 1 - idx) % 10;
  }

  public static void main(String[] args) {
    System.out.println(new NthDigit().findNthDigit(13));
//    System.out.println(new NthDigit().findNthDigit(3));
//    System.out.println(new NthDigit().findNthDigit(11));
//    System.out.println(new NthDigit().findNthDigit(198));
//    System.out.println(new NthDigit().findNthDigit(200));
//    System.out.println(new NthDigit().findNthDigit(1000000000));
  }
}

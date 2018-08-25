package leetcode;

/**
 * Created by linhjiang on 8/9/18.
 */
public class ValidPerfectSquare {

  public boolean isPerfectSquare(int num) {
    long l = 0, r = num;
    while(l <= r) {
      long mid = (l + r) / 2;
      long pow = mid * mid;
      if(num > pow) {
        l = mid + 1;
      } else if(num < pow) {
        r = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(new ValidPerfectSquare().isPerfectSquare(808201));
  }
}

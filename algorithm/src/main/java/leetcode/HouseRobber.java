package leetcode;

import java.util.Arrays;

/**
 * Created by linhjiang on 8/19/18.
 */
public class HouseRobber {

  public int rob(int[] nums) {
    int[] sum = new int[nums.length];
    Arrays.fill(sum, -1);
    return rob(nums, nums.length - 1, sum);
  }

  private int rob(int[] nums, int i, int[] sum) {
    if (i == 0) {
      sum[i] = nums[i];
    } else if (i < 0) {
      return 0;
    }
    if (sum[i] >= 0) {
      return sum[i];
    }
    sum[i] = Math.max(rob(nums, i - 2, sum) + nums[i], rob(nums, i - 1, sum));
    return sum[i];
  }

  public static void main(String[] args) {
    int[] n = new int[] { 2, 1, 1, 2 };
    System.out.println(new HouseRobber().rob(n));
  }

}

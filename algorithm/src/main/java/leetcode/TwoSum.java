package leetcode;

import java.util.*;

/**
 * Created by linhjiang on 7/15/18.
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      int remain = target - nums[i];
      if(map.containsKey(remain)) {
        return new int[] {map.get(remain), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 7, 11, 15 };
    int target = 9;
    int[] result = new TwoSum().twoSum(nums, target);
    System.out.println(result[0] + " " + result[1]);
  }
}

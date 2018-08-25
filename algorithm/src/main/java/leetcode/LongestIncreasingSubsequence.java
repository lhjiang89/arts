package leetcode;

/**
 * Created by linhjiang on 8/18/18.
 */
public class LongestIncreasingSubsequence {

  public int lengthOfLIS(int[] nums) {
    if(nums==null || nums.length==0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    int res = 0;
    for(int num: nums) {
      int left=0, right=res;
      while(left < right) {
        int mid = left+(right-left)/2;
        if(dp[mid] < num) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      if(left == res) {
        res++;
      }
      dp[left] = num;
    }
    return res;
  }

  public static void main(String[] args) {
    int[]n = {1,3,6,7,9,4,10,5,6};
    System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(n));
  }
}

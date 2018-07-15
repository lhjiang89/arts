import java.util.*;

/**
 * Created by linhjiang on 7/15/18.
 */
public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    for (int i = 0; i < nums.length; i++) {
      Set<Integer> idxes = map.get(nums[i]);
      if (idxes == null) {
        idxes = new LinkedHashSet<Integer>(1);
        map.put(nums[i], idxes);
      }
      idxes.add(i);
    }

    for (int i = 0; i < nums.length; i++) {
      Set<Integer> idxes = map.get(target - nums[i]);
      if (idxes == null) {
        continue;
      } else if (idxes.contains(i) && idxes.size() == 1) {
        continue;
      } else if (idxes.contains(i)) {
        Iterator<Integer> it = idxes.iterator();
        return new int[] { it.next(), it.next() };
      } else {
        return new int[] { i, idxes.iterator().next() };
      }
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

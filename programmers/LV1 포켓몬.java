import java.util.*;

class Solution {

  public int solution(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      set.add(i);
    }
    return nums.length / 2 >= set.size() ? set.size() : nums.length / 2;
  }
}
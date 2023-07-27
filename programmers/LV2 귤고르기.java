import java.util.*;

class Solution {

  public int solution(int k, int[] tangerine) {
    int answer = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int x : tangerine) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }

    List<Integer> list = new ArrayList<>(map.keySet());
    list.sort((x1, x2) -> map.get(x2) - map.get(x1));

    for (Integer key : list) {
      k -= map.get(key);
      answer++;
      if (k <= 0) {
        break;
      }
    }
    return answer;
  }
}
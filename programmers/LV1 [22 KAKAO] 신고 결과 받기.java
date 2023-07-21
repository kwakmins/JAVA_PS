import java.util.*;

class Solution {

  public int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = new int[id_list.length];
    Map<String, Integer> map1 = new HashMap<>();
    Map<String, List<String>> map2 = new HashMap<>();

    for (int i = 0; i < id_list.length; i++) {
      map1.put(id_list[i], i);
      map2.put(id_list[i], new ArrayList<>());
    }

    for (String s : report) {
      String[] temp = s.split(" ");
      if (!map2.get(temp[1]).contains(temp[0])) {
        map2.get(temp[1]).add(temp[0]);
      }
    }

    for (String s : map2.keySet()) {
      if (k <= map2.get(s).size()) {
        for (String s2 : map2.get(s)) {
          answer[map1.get(s2)]++;
        }
      }
    }

    return answer;
  }
}
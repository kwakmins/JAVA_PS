/***
 * 배열 슬라이싱은 매우 비효율
 */

import java.util.*;

class Solution {

  public int solution(int[] topping) {
    int answer = 0;
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < topping.length; i++) {
      map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
    }

    for (int i = 0; i < topping.length; i++) {
      map.put(topping[i], map.getOrDefault(topping[i], 0) - 1);
      set.add(topping[i]);
      if (map.get(topping[i]) == 0) {
        map.remove(topping[i]);
      }
      if (set.size() == map.size()) {
        answer++;
      }
    }
    return answer;
    // 시간초과
    // for(int i=1;i<topping.length-1;i++){
    //     Set<Integer> set1 = new HashSet<>();
    //     Set<Integer> set2 = new HashSet<>();
    //     for(int j=0;j<=i;j++){
    //         set1.add(topping[j]);
    //     }
    //     for(int j=i+1;j<topping.length;j++){
    //         set2.add(topping[j]);
    //     }
    //     if(set1.size()==set2.size()){
    //         answer++;
    //     }
    // }
    // return answer;
  }
}
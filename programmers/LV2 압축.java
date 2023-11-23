import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LV2 압축 https://school.programmers.co.kr/learn/courses/30/lessons/17684
 * 단순 구현 - 문자열에서 사전에 등록된 가장 긴 문자열을 찾고 값 출력, + 다음 문자 합쳐서 새로 등록
 *
 * 반복문에서 가장 긴 문자열이 아닐 때, i--를 해서 구현
 */
class Solution {

  public int[] solution(String msg) {
    List<Integer> answer = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    String[] msgs = msg.split("");
    for (int i = 1; i <= 26; i++) {
      map.put(String.valueOf((char) ('A' - 1 + i)), i);
    }

    String s = "";
    int temp = 0;
    int idx = 27;
    for (int i = 0; i < msgs.length; i++) {
      s += msgs[i];
      int value = map.getOrDefault(s, 0);

      if (value != 0) {
        temp = value;
      } else {
        map.put(s, idx++);
        answer.add(temp);
        i--;
        s = "";
      }
    }
    if (!s.equals("")) {
      map.put(s, idx++);
      answer.add(temp);
    }

    return answer.stream().mapToInt(i -> i).toArray();
  }

}
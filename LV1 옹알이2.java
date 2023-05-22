import java.util.*;

class Solution {

  List<String> li = new ArrayList<>(Arrays.asList("aya", "ye", "woo", "ma"));

  public int solution(String[] babbling) {
    int answer = 0;

    for (String s : babbling) {
      if (s.contains("ayaaya") || s.contains("yeye") || s.contains("woowoo") || s.contains(
          "mama")) {
        continue;
      }

      s = s.replace(li.get(0), " ");
      s = s.replace(li.get(1), " ");
      s = s.replace(li.get(2), " ");
      s = s.replace(li.get(3), " ");
      s = s.replace(" ", "");
      if (s.equals("")) {
        answer += 1;
      }
    }
    return answer;
  }

}
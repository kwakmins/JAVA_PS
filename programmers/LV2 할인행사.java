import java.util.*;

class Solution {

  public int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;
    List<String> li = new ArrayList<>();

    for (int i = 0; i < want.length; i++) {
      while (number[i]-- > 0) {
        li.add(want[i]);
      }
    }

    for (int i = 0; i < discount.length - li.size() + 1; i++) {
      ArrayList<String> l = (ArrayList<String>) ((ArrayList<String>) li).clone();
      for (int j = i; j < i + li.size(); j++) {
        if (l.contains(discount[j])) {
          l.remove(discount[j]);
        } else {
          break;
        }
      }
      answer += l.size() == 0 ? 1 : 0;
    }

    return answer;
  }
}

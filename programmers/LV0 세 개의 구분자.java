import java.util.*;

class Solution {

  public String[] solution(String myStr) {
    String[] answer = myStr.replace("a", "1").replace("b", "1").replace("c", "1").split("1");
    List<String> li = new ArrayList<>();
    for (int i = 0; i < answer.length; i++) {
      if (!answer[i].equals("")) {
        li.add(answer[i]);
      }
    }
    if (li.size() == 0) {
      li.add("EMPTY");
    }
    return li.toArray(new String[0]);
  }
}

class Solution2 {

  public String[] solution(String myStr) {
    String[] arr = Arrays.stream(myStr.split("[abc]+")).filter(str -> !str.isEmpty())
        .toArray(String[]::new);
    return arr.length == 0 ? new String[]{"EMPTY"} : arr;
  }
}

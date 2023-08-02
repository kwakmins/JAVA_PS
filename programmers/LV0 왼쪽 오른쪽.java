import java.util.*;

class Solution {

  public String[] solution(String[] str_list) {
    List<String> list = new ArrayList<>();
    int l = 0, r = 0;
    for (int i = 0; i < str_list.length; i++) {
      if (str_list[i].equals("l")) {
        l = i;
        break;
      } else if (str_list[i].equals("r")) {
        r = i + 1;
        break;
      }
    }
    if (l != 0) {
      for (int i = 0; i < l; i++) {
        list.add(str_list[i]);
      }
    } else if (r != 0) {
      for (int i = r; i < str_list.length; i++) {
        list.add(str_list[i]);
      }
    }
    return list.stream().toArray(String[]::new);
  }
}
import java.util.*;

class Solution {

  public String[] solution(String[] strArr) {

    return Arrays.stream(strArr).filter(s -> s.indexOf("ad") < 0)
        .toArray(String[]::new);//!s.contains도 가능
  }
}
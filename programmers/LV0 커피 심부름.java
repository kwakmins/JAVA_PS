import java.util.*;

class Solution {

  public int solution(String[] order) {
    int answer = 0;
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("iceamericano", 4500);
    map.put("americanoice", 4500);
    map.put("hotamericano", 4500);
    map.put("americanohot", 4500);
    map.put("americano", 4500);
    map.put("anything", 4500);

    map.put("cafelatte", 5000);
    map.put("icecafelatte", 5000);
    map.put("cafelatteice", 5000);
    map.put("hotcafelatte", 5000);
    map.put("cafelattehot", 5000);

    for (String s : order) {
      answer += map.get(s);
    }
    return answer;
  }
}
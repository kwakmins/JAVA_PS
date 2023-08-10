class Solution {

  public int solution(String[] babbling) {
    int answer = 0;
    String[] can = new String[]{"aya", "ye", "woo", "ma"};
    for (String s : babbling) {
      for (String ca : can) {
        s = s.replace(ca, "1");
      }
      s = s.replace("1", "");
      if (s.equals("")) {
        answer++;
      }
    }
    return answer;
  }
}
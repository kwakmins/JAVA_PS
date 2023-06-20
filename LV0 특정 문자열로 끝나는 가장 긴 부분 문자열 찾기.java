class Solution {

  public String solution(String myString, String pat) {
    String answer = "";
    String s = myString.replaceAll(pat, "1");
    String[] sa = s.split("1", -1);
    char c[] = s.toCharArray();
    int x = 1;
    for (int i = 0; i < c.length; i++) {
      if (x < sa.length) {
        if ((c[i] + "").equals("1")) {
          answer += pat;
          x += 1;
        } else {
          answer += c[i];
        }
      } else {
        return answer;
      }
    }
    return answer;
  }
}

class Solution2 {

  public String solution(String myString, String pat) {
    String answer = "";
    
    int idx = myString.lastIndexOf(pat);

    answer = myString.substring(0, idx) + pat;

    return answer;
  }
}
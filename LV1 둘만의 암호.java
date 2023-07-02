class Solution {

  public String solution(String s, String skip, int index) {

    String answer = "";

    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i);
      int count = index;
      while (count != 0) {
        c++;
        if (c > 122) {
          c = 97;
        }

        if (!skip.contains(String.valueOf((char) c))) {
          count--;
        }
      }
      answer += (char) c;
    }
    return answer;
  }
}

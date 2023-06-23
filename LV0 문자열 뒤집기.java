class Solution {

  public String solution(String my_string, int s, int e) {
    String answer = "";
    answer += my_string.substring(0, s);
    String[] temp = my_string.split("");
    for (int i = e; i >= s; i--) {
      answer += temp[i];
    }
    answer += my_string.substring(e + 1, my_string.length());
    return answer;
  }
}
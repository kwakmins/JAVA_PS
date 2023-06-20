class Solution {

  public String solution(String s) {
    String answer = "";
    int[] valid = new int[26];
    for (char c : s.toCharArray()) {
      if (valid[c - 'a'] == 0) {
        valid[c - 'a'] = 1;
      } else if (valid[c - 'a'] == 1) {
        valid[c - 'a'] = 2;
      }
    }
    for (int i = 0; i < 26; i++) {
      if (valid[i] == 1) {
        answer += (char) (i + 'a');
      }
    }
    return answer;
  }
}
class Solution {

  public String solution(String my_string, int[] indices) {
    String answer = "";
    for (int i = 0; i < my_string.length(); i++) {
      if (!have(i, indices)) {
        answer += my_string.charAt(i);
      }
    }
    return answer;
  }

  public Boolean have(int x, int[] indices) {
    for (int i : indices) {
      if (x == i) {
        return true;
      }
    }
    return false;
  }
}
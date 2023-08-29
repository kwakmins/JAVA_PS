class Solution {

  String[] moe = new String[]{"A", "E", "I", "O", "U"};
  String WORD;
  boolean b = false;
  int answer;

  public int solution(String word) {
    answer = 0;
    WORD = word;
    dfs("");
    return answer;
  }

  void dfs(String s) {
    if (b) {
      return;
    }

    if (s.equals(WORD)) {
      b = true;
      return;
    }
    answer++;
    if (s.length() == 5) {
      return;
    }

    for (int i = 0; i < 5; i++) {
      dfs(s + moe[i]);
    }
  }
}
class Solution {

  public int solution(String s) {
    int answer = 0;
    int xCnt = 0, etcCnt = 0;
    char x = ' ';
    for (char c : s.toCharArray()) {
      if (x == ' ') {
        x = c;
        answer++;
        xCnt = 1;
        etcCnt = 0;
        continue;
      } else if (x == c) {
        xCnt++;
      } else {
        etcCnt++;
      }
      if (xCnt == etcCnt) {
        x = ' ';
      }
    }
    return answer;
  }
}
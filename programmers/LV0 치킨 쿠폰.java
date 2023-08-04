class Solution {

  public int solution(int chicken) {
    int answer = chicken / 10;
    int ex = answer + chicken % 10;
    while (ex > 9) {
      answer += ex / 10;
      ex = ex % 10 + ex / 10;
    }
    return answer;
  }
}
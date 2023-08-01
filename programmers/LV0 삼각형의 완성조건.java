class Solution {

  public int solution(int[] sides) {
    int answer = 0;
    int max = 0;
    int min = 0;
    if (sides[0] > sides[1]) {
      max = sides[0];
      min = sides[1];
    } else {
      max = sides[1];
      min = sides[0];
    }
    answer += min - 1;
    answer += max - (max - min);
    return answer;
  }
}
class Solution {

  public int[] solution(int brown, int red) {
    int[] answer = new int[2];
    int sum = brown + red;
    int x = 0;

    for (int i = 1; i < brown; i++) {
      x = sum / i;
      if ((i - 2) * (x - 2) == red) {
        answer[0] = i;
        answer[1] = x;
      }
    }
    return answer;
  }
}

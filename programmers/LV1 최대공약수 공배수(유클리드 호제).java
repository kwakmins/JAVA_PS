class Solution {

  int gdc(int a, int b) {
    while (b != 0) {
      int c = a % b;
      a = b;
      b = c;
    }
    return a;
  }

  public int[] solution(int n, int m) {
    int[] answer = new int[2];
    answer[0] = gdc(n, m);
    answer[1] = n * m / answer[0];
    return answer;
  }
}
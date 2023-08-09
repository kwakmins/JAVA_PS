class Solution {

  public int solution(int[][] lines) {
    int answer = 0;
    int[] arr = new int[200];
    for (int[] line : lines) {
      for (int i = line[0]; i < line[1]; i++) {
        arr[i + 100]++;
      }
    }
    for (int i : arr) {
      if (i >= 2) {
        answer++;
      }
    }
    return answer;
  }
}
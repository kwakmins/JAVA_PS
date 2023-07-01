class Solution {

  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n;

    int[] li = new int[n];

    for (int l : lost) {
      li[l - 1]--;
    }

    for (int r : reserve) {
      li[r - 1]++;
    }

    for (int i = 0; i < li.length; i++) {
      if (li[i] == -1) {
        if (i - 1 >= 0 && li[i - 1] == 1) {
          li[i]++;
          li[i - 1]--;
        } else if (i + 1 < li.length && li[i + 1] == 1) {
          li[i]++;
          li[i + 1]--;
        } else {
          answer--;
        }
      }
    }
    return answer;
  }
}
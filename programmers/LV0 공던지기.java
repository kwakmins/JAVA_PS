class Solution {

  public int solution(int[] numbers, int k) {
    int x = 1, i = 0;
    while (x != k) {
      for (int j = 0; j < 2; j++) {
        i++;
        if (i >= numbers.length) {
          i = 0;
        }
      }
      x++;
    }
    return numbers[i];
  }
}
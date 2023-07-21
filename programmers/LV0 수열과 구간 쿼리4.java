class Solution {

  public int[] solution(int[] arr, int[][] queries) {
    for (int[] arr1 : queries) {
      for (int i = arr1[0]; i <= arr1[1]; i++) {
        if (i % arr1[2] == 0) {
          arr[i]++;
        }
      }
    }
    return arr;
  }
}
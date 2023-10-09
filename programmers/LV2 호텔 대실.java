import java.util.Arrays;

class Solution {

  public int solution(String[][] book_time) {
    int[] sum = new int[2000];
    for (String[] time : book_time) {
      String[] start = time[0].split(":");
      String[] end = time[1].split(":");
      int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
      int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 9;
      for (int i = startTime; i <= endTime; i++) {
        sum[i]++;
      }
    }

    return Arrays.stream(sum).max().orElseThrow();
  }
}
import java.util.*;

class Solution {
  public int[] solution(int[] numlist, int n) {
    Integer[] list = Arrays.stream(numlist).boxed().toArray(Integer[]::new);

    Arrays.sort(list, new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        int distA = Math.abs(a - n);
        int distB = Math.abs(b - n);

        if (distA == distB) {
          return b - a;
        } else {
          return distA - distB;
        }
      }
    });

    return Arrays.stream(list).mapToInt(i->i).toArray();
  }
}

class Solution2 {
  public int[] solution(int[] numList, int n) {
    return Arrays.stream(numList)
        .boxed()
        .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
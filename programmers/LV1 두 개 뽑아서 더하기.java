import java.util.*;

class Solution {

  public int[] solution(int[] numbers) {
    int arr[] = new int[10000];
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        int sum = numbers[i] + numbers[j];
        if (arr[sum] == 0) {
          arr[sum] = sum;
          list.add(sum);
        }
      }
    }
    int[] answer = list.stream().mapToInt(i -> i).sorted().toArray();
    return answer;
  }

  public int[] solution2(int[] numbers) {
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        int sum = numbers[i] + numbers[j];
        set.add(sum);
      }
    }
    int[] answer = set.stream().mapToInt(i -> i).sorted().toArray();
    return answer;
  }
}
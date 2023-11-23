/***
 * O(N^2)은 값이 작지 않은 이상 시간 초과다.
 * 가장 가까이? 이런게 Stack queue라는 힌트
 * 왜 index를 stack에 넣을 생각을 못했찌?? 처음 해보는듯
 *
 * @!!! 배열을 앞에서 부터만 넣는다는 고정관념이 있음.
 */

import java.util.Stack;

class Solution {

  public int[] solution(int[] numbers) {
    int[] answer = new int[numbers.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < numbers.length; i++) {
      while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
        answer[stack.pop()] = numbers[i];
      }
      stack.add(i);
    }

    for (int i : stack) {
      answer[i] = -1;
    }

    return answer;
  }

  public int[] solution2(int[] numbers) {
    int[] answer = new int[numbers.length];
    int max = 0;
    for (int i = 0; i < numbers.length; i++) {
      max = max < numbers[i] ? numbers[i] : max;
    }
    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i] == max) {
        answer[i] = -1;
        continue;
      }
      int temp = 0;
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[i] < numbers[j]) {
          temp = numbers[j];
          break;
        }
      }
      if (temp != 0) {
        answer[i] = temp;
      } else {
        answer[i] = -1;
      }
    }
    answer[numbers.length - 1] = -1;
    return answer;
  }
}
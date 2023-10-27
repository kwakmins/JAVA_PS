import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LV3 이중 우선순위 큐 https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * 우선순위 큐 - 숫자를 넣거나 최대값을 빼거나, 최소값을 빼거나 하는 배열의 최종 최댓값과 최솟값 구하기
 *
 * 우선순위 큐를 2개를 사용해서, deuque처럼 이용한다.
 *
 * @!!! queue에 .reomve(Object)가 있는지 몰라서 해맸다. 스택에는 .remove(index or Object)
 */
class Solution {

  public int[] solution(String[] operations) {
    PriorityQueue<Integer> p1 = new PriorityQueue<>();
    PriorityQueue<Integer> p2 = new PriorityQueue<>(Collections.reverseOrder());
    int[] answer = new int[2];

    for (String s : operations) {
      String[] temp = s.split(" ");
      int num = Integer.parseInt(temp[1]);
      if (temp[0].equals("I")) {
        p1.add(num);
        p2.add(num);
      } else if (p1.size() > 0 && temp[0].equals("D")) {
        if (num == 1) {
          int x = p2.poll();
          p1.remove(x);

        } else {
          int x = p1.poll();
          p2.remove(x);
        }
      }
    }
    if (p1.size() >= 1) {
      answer[1] = p1.poll();
    }
    if (p2.size() >= 1) {
      answer[0] = p2.poll();
    }
    return answer;
  }
}
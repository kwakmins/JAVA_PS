/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 * 아무 10^c 절대값으로 이동할 수 있을 때, 주어진 int에 최소 이동 횟수 구하기
 *
 *
 * 그리드
 * 뒤에서 부터 10의 단위로 만들면서 가는데, 이때 6이상은 + 해주는게 이득이고, 4이하는 - 해주는게 이득.
 * 5일 경우 전의 값이 5이상이면 + 아니면 -.
 *
 * ##틀린 이유
 * 발상은 맞았으나, 다음자리 수가 변해서 영향가는 것을 생각하였음. 만약 전 수가 9면 10으로 되면서 등등..
 * 현실 계산 그대로만 사용하려고 나타나는 문제점.
 *
 * @!!! 다양한 테스트 해보기
 */

import java.util.*;

class Solution {

  public int solution(int storey) {
    int answer = 0;
    String[] s = String.valueOf(storey).split("");
    int[] arr = Arrays.stream(s).mapToInt(ss -> Integer.parseInt(ss)).toArray();

    for (int i = arr.length - 1; i > 0; i--) {
      if (arr[i] < 5) {
        answer += arr[i];
      } else if (arr[i] == 5) {
        if (arr[i - 1] >= 5) {
          arr[i - 1] += 1;
        }
        answer += 5;
      } else if (arr[i] > 5) {
        arr[i - 1] += 1;
        answer += 10 - arr[i];
      }
    }
    answer += arr[0] > 5 ? 10 - arr[0] + 1 : arr[0];

    return answer;
  }
}
//class Solution {
//
//  public int solution(int storey) {
//    int answer = 0;
//    String[] s = String.valueOf(storey).split("");
//    for (int i = s.length - 1; i > 0; i--) {
//      int temp = Integer.parseInt(s[i]);
//      if (temp > 5) {
//        s[i - 1] = String.valueOf(Integer.parseInt(s[i - 1]) + 1);
//        answer += 10 - temp;
//      } else if (temp == 5 && Integer.parseInt(s[i - 1]) >= 5) {
//        answer += 5;
//        s[i - 1] = String.valueOf(Integer.parseInt(s[i - 1]) + 1);
//      } else {
//        answer += temp;
//      }
//    }
//    answer += Integer.parseInt(s[0]) > 5 ?
//        10 - Integer.parseInt(s[0]) + 1 : Integer.parseInt(s[0]);
//
//    return answer;
//  }
//}
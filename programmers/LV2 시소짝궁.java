import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Lv2시소 짝궁 https://school.programmers.co.kr/learn/courses/30/lessons/152996
 * 주어진 배열 값 중 서로 1:1 ,2:3 ,2:4 ,3:4 인 count 수 구하기
 *
 * @Param 배열
 * @return count 수
 *
 * 정렬을 하면, 3:2 등 낮은 숫자에 대한 우려 X, 모든 배열 원소 일일히 확인 -> 시간초과
 *
 * 1. 이분탐색 생각(시간 좀 더 걸리고, 복잡한 구현)
 * - 중복된 수 map으로 관리하여, 중복 제거 후, target을 *2/3,*2,*3/4로 두고 발견하면 중복된 수 만큼 추가
 *
 * 2. map만 사용하여,
 * - map.containsKey()를 통해 중복된 수 만큼 추가
 * @!!! 간단한 연산으로 수 찾기는 이분탐색보단 map을 사용하는게 좋다
 */

class Solution {

  public long solution(int[] weights) {
    Map<Double, Integer> map = new HashMap<>();
    long answer = 0;

    Arrays.sort(weights);

    for (int i : weights) {
      double a = i * 1.0;
      double b = (i * 2.0) / 3.0;
      double c = (i * 1.0) / 2.0;
      double d = (i * 3.0) / 4.0;
      if (map.containsKey(a)) {
        answer += map.get(a);
      }
      if (map.containsKey(b)) {
        answer += map.get(b);
      }
      if (map.containsKey(c)) {
        answer += map.get(c);
      }
      if (map.containsKey(d)) {
        answer += map.get(d);
      }
      map.put((i * 1.0), map.getOrDefault((i * 1.0), 0) + 1);
    }

    return answer;
  }
}
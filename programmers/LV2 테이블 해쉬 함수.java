import java.util.Arrays;

/**
 * LV2 테이블 해쉬 함수 https://school.programmers.co.kr/learn/courses/30/lessons/147354
 * 구현 - 주어진 col로 data 커스텀 정렬 및 XOR 연산.
 *
 * @!!! XOR 연산은 같으면 0을 return 다르면 큰 값 return. num1 ^ num2로 계산 가능
 */
class Solution {

  public int solution(int[][] data, int col, int row_begin, int row_end) {
    int answer = 0;
    col -= 1;
    row_begin -= 1;

    int x = col; //람다는 매개변수 사용못함.
    Arrays.sort(data, (d1, d2) -> {
      if (d1[x] == d2[x]) {
        return d2[0] - d1[0];
      }
      return d1[x] - d2[x];
    });

    for (int i = row_begin; i < row_end; i++) {
      int fi = i + 1;
      int sum = Arrays.stream(data[i])
          .map(j -> j % fi)
          .sum();

      answer = answer ^ sum;
    }

    return answer;
  }
}
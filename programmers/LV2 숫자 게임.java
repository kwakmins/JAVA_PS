import java.util.Arrays;

/**
 * LV2 숫자 게임 https://school.programmers.co.kr/learn/courses/30/lessons/12987
 * 구현 - 숫자 크기 싸움에서 상대 순서를 보고 얻을 수 있는 가장 높은 점수 구하기
 *
 * 큰 수를 몇번 낼 수 있는지만 구하면 된다 -> 정렬 후 클때마다 index 와 cnt를 증가 시키면 됨
 */
class Solution {

  public int solution(int[] A, int[] B) {
    int answer = 0;
    Arrays.sort(A);
    Arrays.sort(B);

    int idx = 0;
    for (int i = 0; i < B.length; i++) {
      if (A[idx] < B[i]) {
        answer++;
        idx++;
      }
    }
    return answer;
  }
}
/**
 * LV2 n^2 배열 자르기 - https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * 구현,수식 - 2차원 배열을 1차원 배열로 바꿀 때, 특정 범위 배열로 구하기.
 *
 * 배열로 직접 바꾸면 메모리 초과 -> 2차원 배열에서 x y 중 큰 값으로 들어가는 것을 확인. -> 계산 가능.
 */
class Solution {

    public int[] solution(int n, long left, long right) {
        int cnt = (int) (right - left + 1);
        int[] answer = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            int x = (int) (left % n + 1);
            int y = (int) (left / n + 1);
            left++;
            answer[i] = Math.max(x, y);
        }

        return answer;
    }
}
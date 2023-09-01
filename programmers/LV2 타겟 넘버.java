class Solution {

  int[] gNumbers;
  int answer = 0, gTarget;

  public int solution(int[] numbers, int target) {
    gNumbers = numbers;
    gTarget = target;
    dfs(0, 0);
    return answer;
  }

  void dfs(int sum, int dep) {
    if (dep == gNumbers.length) {
      if (sum == gTarget) {
        answer++;
      }
      return;
    }
    dfs(sum + gNumbers[dep], dep + 1);
    dfs(sum - gNumbers[dep], dep + 1);
  }
}
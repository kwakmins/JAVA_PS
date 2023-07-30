class Solution {

  public int solution(String my_string) {
    String problem[] = my_string.split(" ");
    int answer = Integer.parseInt(problem[0]);
    for (int i = 1; i < problem.length - 1; i += 2) {
      if (problem[i].equals("+")) {
        answer += Integer.parseInt(problem[i + 1]);
      } else if (problem[i].equals("-")) {
        answer -= Integer.parseInt(problem[i + 1]);
      }
    }
    return answer;
  }
}
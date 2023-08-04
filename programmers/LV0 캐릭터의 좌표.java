class Solution {

  public int[] solution(String[] keyinput, int[] board) {
    int[] answer = new int[2];
    int xLength = (board[0] - 1) / 2;
    int yLength = (board[1] - 1) / 2;
    for (String s : keyinput) {
      if (s.equals("left")) {
        if (--answer[0] < -xLength) {
          answer[0] = -xLength;
        }
        ;
      } else if (s.equals("right")) {
        if (++answer[0] > xLength) {
          answer[0] = xLength;
        }
      } else if (s.equals("up")) {
        if (++answer[1] > yLength) {
          answer[1] = yLength;
        }
      } else if (s.equals("down")) {
        if (--answer[1] < -yLength) {
          answer[1] = -yLength;
        }
      }
    }
    return answer;
  }
}
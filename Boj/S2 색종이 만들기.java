import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * 복사 없이 비교만 해도 되는데 굳이 복사를 할려 했음
 *  -> 제공된 문제 풀이랑 똑같이 풀려함 , 다른 방법을 생각하는 창의성 필요
 */
public class Main {

  static int blueCnt = 0;
  static int whiteCnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      arr[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    cal(arr);
    System.out.println(whiteCnt);
    System.out.println(blueCnt);
  }

  public static void cal(int[][] arr) {
    int color = arr[0][0];
    for (int[] ints : arr) {
      for (int i : ints) {
        if (i != color) {
          int len = arr[0].length;
          int[][] temp = new int[len / 2][len / 2];
          int x = 0, y = 0;
          for (int j = 0; j < len / 2; j++) {
            for (int k = 0; k < len / 2; k++) {
              temp[y][x] = arr[j][k];
              x++;
            }
            x = 0;
            y++;
          }
          cal(temp);
          y = 0;
          for (int j = 0; j < len / 2; j++) {
            for (int k = len / 2; k < len; k++) {
              temp[y][x] = arr[j][k];
              x++;
            }
            x = 0;
            y++;
          }
          cal(temp);
          y = 0;
          for (int j = len / 2; j < len; j++) {
            for (int k = len / 2; k < len; k++) {
              temp[y][x] = arr[j][k];
              x++;
            }
            x = 0;
            y++;
          }
          cal(temp);
          y = 0;
          for (int j = len / 2; j < len; j++) {
            for (int k = 0; k < len / 2; k++) {
              temp[y][x] = arr[j][k];
              x++;
            }
            x = 0;
            y++;
          }
          cal(temp);
          return;
        }
      }
    }
    if (color == 0) {
      whiteCnt++;
    } else {
      blueCnt++;
    }
  }
}

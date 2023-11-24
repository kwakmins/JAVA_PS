import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @G5 치킨 배달 - https://www.acmicpc.net/problem/15686
 * 백트래킹 - 치킨이 M개 폐점될 때, 도시의 치킨 거리의 최솟값 구하기
 *
 * 모든 치킨집이 존재하는 경우의 수로 백트래킹 하여 계산을 하면 됨
 * - 이 때, 지도를 이중 배열이 아닌, list로 관리하여, 계산해야함.
 * -
 * @!!! 백트래킹에 대한 이해도 부족.
 * @!!! 지도가 있으면 무조건 이중 배열로 계산하려고 했음. -> 위치 정보를 list에 담아 사용 가능.
 * @!!! 백트래킹은 visit 없이 start+1로 계산을 할 때 있음.
 * @!!! 백트래킹은 이중리스트로 순환 잘 안함.
 */
public class Main {

  static int[][] maps;
  static int N, M, answer;
  static List<Dot> home = new ArrayList<>(), chicken = new ArrayList<>(), temp = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    N = Integer.parseInt(line[0]);
    M = Integer.parseInt(line[1]);
    maps = new int[N][N];
    answer = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      String[] line2 = bf.readLine().split(" ");
      for (int j = 0; j < line2.length; j++) {
        maps[i][j] = Integer.parseInt(line2[j]);
        if (maps[i][j] == 1) {
          home.add(new Dot(j, i));
        }
        if (maps[i][j] == 2) {
          chicken.add(new Dot(j, i));
        }
      }
    }

    dfs(0, 0);
    System.out.println(answer);
  }

  static void dfs(int start, int cnt) {
    if (cnt == M) {
      int sum = 0;
      for (int i = 0; i < home.size(); i++) {
        Dot dot = home.get(i);
        int r1 = dot.y;
        int c1 = dot.x;
        int tempValue = Integer.MAX_VALUE;
        for (int j = 0; j < temp.size(); j++) {
          Dot dot2 = temp.get(j);
          int r2 = dot2.y;
          int c2 = dot2.x;
          tempValue = Math.min(tempValue, Math.abs(r2 - r1) + Math.abs(c2 - c1));
        }
        sum += tempValue;
      }
      answer = Math.min(answer, sum);
      return;
    }

    for (int i = start; i < chicken.size(); i++) {
      temp.add(chicken.get(i));
      dfs(i + 1, cnt + 1);
      temp.remove(temp.size() - 1);
    }
  }
}

class Dot {

  int x, y;

  public Dot(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
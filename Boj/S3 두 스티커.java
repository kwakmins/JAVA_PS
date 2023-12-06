import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @S3 두 스티커 - https://www.acmicpc.net/problem/16937
 * 구현 - 모눈종이에 2개 스티커를 붙일 수 있을 때, 가장 큰 2개 스티커 넓이 합 구하기
 *
 * 1. 90도 회전한 값을 list에 추가 (id로 같은 스티커를 2번 넣는지 확인)
 * 2. 가로로 배치 - 가로의 두 합 + 세로의 두 크기만 맞으면됨. (세로도 동일)
 * .
 * @!!! 가장 큰 길이를 무조건 가로 세로 중 큰 길이로 맞춘다고 생각함. (도형 문제 연습 부족)
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String[] line = bf.readLine().split(" ");
    int H = Integer.parseInt(line[0]);
    int W = Integer.parseInt(line[1]);
    int N = Integer.parseInt(bf.readLine());
    List<Sticker> stickers = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String[] line2 = bf.readLine().split(" ");
      int x = Integer.parseInt(line2[0]);
      int y = Integer.parseInt(line2[1]);
      stickers.add(new Sticker(x, y, i));
      if (x != y) {
        stickers.add(new Sticker(y, x, i));
      }
    }

    int answer = 0;
    for (int i = 0; i < stickers.size() - 1; i++) {
      Sticker sticker1 = stickers.get(i);

      for (int j = i + 1; j < stickers.size(); j++) {
        Sticker sticker2 = stickers.get(j);
        if (sticker1.i == sticker2.i) {
          continue;
        }
        if (sticker2.y + sticker1.y <= W && Math.max(sticker2.x, sticker1.x) <= H) {
          answer = Math.max(answer, sticker1.getMulti() + sticker2.getMulti());
        } else if (sticker2.x + sticker1.x <= H && Math.max(sticker2.y, sticker1.y) <= W) {
          answer = Math.max(answer, sticker1.getMulti() + sticker2.getMulti());
        }
      }
    }

    System.out.println(answer);
  }

  static class Sticker {

    int x, y, i;

    public Sticker(int a, int b, int idx) {
      x = a;
      y = b;
      i = idx;
    }

    public int getMulti() {
      return x * y;
    }
  }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @G5카드 섞기 - https://www.acmicpc.net/problem/21315
 * 완전탐색 + 구현 - 특정 조건에 맞게 카드를 섞을 때, 다음 카드는 어떻게 섞었는지 구하기
 *
 * 모든 경우의 수로 섞을 때, 특정 모양이 완성되는지 확인.
 * .
 * @!!! 시간복잡도 계산으로 완탐인 것은 알았으나, subString을 사용하려고 했음 (자료 구조 선택 중요)
 * @!!! 앞 뒤 추가할 때는 queue Deck 을 생각하자.
 * @!!! 문자열은 시간이 느림. 필요한 경우만 사용하자.
 */
class Main {

  static int n;
  static int[] arr;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    arr = new int[n + 1];
    for (int i = 0; i < n; i++) {
      arr[i] = scan.nextInt();
    }
    for (int i = 0; i <= 9; i++) {
      if (Math.pow(2, i) >= n) {
        break;
      }
      for (int j = 0; j <= 9; j++) {
        if (Math.pow(2, j) >= n) {
          break;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int k = n; k >= 1; k--) {
          queue.add(k);
        }
        dfs(i, queue);
        dfs(j, queue);
        boolean isOk = true;
        for (int k = n - 1; k >= 0; k--) {
          if (arr[k] != queue.poll()) {
            isOk = false;
            break;
          }
        }
        if (isOk) {
          System.out.println(i + " " + j);
          return;
        }
      }
    }
  }

  static void dfs(int x, Queue<Integer> queue) {
    Queue<Integer> temp = new LinkedList<>();
    int num = (int) Math.pow(2, x);
    for (int i = 0; i < num; i++) {
      temp.add(queue.poll());
    }
    while (num > 1) {
      num /= 2;
      for (int i = 0; i < num; i++) {
        temp.add(temp.poll());
      }
      for (int i = 0; i < num; i++) {
        queue.add(temp.poll());
      }
    }
    queue.add(temp.poll());
  }
}
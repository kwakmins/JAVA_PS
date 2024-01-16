import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @G4 이차원 배열과 연산 - https://www.acmicpc.net/problem/17140
 * 구현,정렬 - 3x3 배열에서 행 열 중 큰 값으로 연산(해당 배열의 등장과 값으로 새로운 배열 생성), 주어진 위치의 값이 일치하는 시점 구하기.
 *
 * 맨 처음부터 최대치 배열 생성 -> 정렬은 Map으로 Count 및 Class로 저장 및 정렬.
 * 100이상 idx 접근 시 종료.
 * .
 * @!!! 계속 변하는 idx라서 2중 List를 생각함 -> 계산에 전혀 필요없음 (0으로 채워도 괜찮음)
 * @!!! 어려운 정렬은 Class로 한다.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        int[][] arr = new int[101][101];

        for (int i = 1; i < 4; i++) {
            line = bf.readLine().split(" ");
            for (int j = 1; j < 4; j++) {
                arr[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

        int time = 0;
        int rowCount = 3;
        int colCount = 3;

        while (true) {
            if (arr[r][c] == k) {
                break;
            }

            if (time == 100) {
                time = -1;
                break;
            }
            time++;

            if (rowCount >= colCount) {
                int curColCount = colCount;
                colCount = 0;
                for (int i = 1; i <= rowCount; i++) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    List<Node> list = new ArrayList<>();

                    for (int j = 1; j <= curColCount; j++) {
                        if (arr[i][j] != 0) {
                            map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                        }
                    }

                    if (map.isEmpty()) {
                        continue;
                    }

                    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                        list.add(new Node(e.getKey(), e.getValue()));
                    }

                    Collections.sort(list, (o1, o2) -> {
                        if (o1.count == o2.count) {
                            return o1.value - o2.value;
                        }
                        return o1.count - o2.count;
                    });

                    int index = 0;
                    for (int j = 0; j < list.size(); j++) {
                        if (j == 50) {
                            break;
                        }
                        int length = (j + 1) * 2;
                        index = length;
                        Node node = list.get(j);
                        arr[i][(j + 1) * 2 - 1] = node.value;
                        arr[i][(j + 1) * 2] = node.count;
                    }

                    colCount = Math.max(colCount, index);

                    for (int j = index + 1; j <= curColCount; j++) {
                        arr[i][j] = 0;
                    }
                }
            } else {

                int curRowCount = rowCount;
                rowCount = 0;

                for (int j = 1; j <= colCount; j++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    List<Node> list = new ArrayList<>();

                    for (int i = 1; i <= curRowCount; i++) {
                        if (arr[i][j] != 0) {
                            map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                        }
                    }

                    if (map.isEmpty()) {
                        continue;
                    }

                    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                        list.add(new Node(e.getKey(), e.getValue()));
                    }

                    Collections.sort(list, (o1, o2) -> {
                        if (o1.count == o2.count) {
                            return o1.value - o2.value;
                        }
                        return o1.count - o2.count;
                    });

                    int index = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if (i == 50) {
                            break;
                        }
                        int length = (i + 1) * 2;
                        index = length;
                        Node node = list.get(i);
                        arr[length - 1][j] = node.value;
                        arr[length][j] = node.count;
                    }

                    rowCount = Math.max(rowCount, index);

                    for (int i = index + 1; i <= curRowCount; i++) {
                        arr[i][j] = 0;
                    }
                }
            }
        }

        System.out.println(time);
    }

    static class Node {

        int value;
        int count;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}

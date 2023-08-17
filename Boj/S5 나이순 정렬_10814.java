import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/***
 * 중복가능이라 map을 쓰면 안됐음. String 배열로 충분히 해결 가능한데, 너무 Map에 의존함
 * Comparator은 0또는 음수면 변경 아님이지만, 내부 로직으로, 0이면 같다는 것을 알아야해서 삼항식(? : ) 사용 삼가
 ***/
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    List<String[]> list = new ArrayList<>();
    int n = Integer.parseInt(bf.readLine());
    for (int i = 0; i < n; i++) {
      String[] line = bf.readLine().split(" ");
      list.add(line);
    }

    list.stream()
        .sorted((a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]))
        .forEach(a -> sb.append(a[0]).append(" ").append(a[1]).append("\n"));

    System.out.println(sb);
  }
}
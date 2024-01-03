import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * G4 N으로 만들기 - https://www.acmicpc.net/problem/17255
 * 구현, 트리(정석)도 가능 - 앞 뒤에 숫자를 추가하여 N을 만드는 경우의 수 구하기
 *
 * N에서 부터 앞을 제외한 substring + 뒤를 제외한 substirng으로 재귀하여 하나의 문자열이 나올 때마다 +1을 해준다.
 * - 나만의 풀이법이고 정석은 left right 두 포인트로 문자열을 추가하고, 끝나면 path를 set으로 저장 후 set.size()
 */
public class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String N = bf.readLine();
        dfs(N);
        System.out.println(answer);
    }

    static void dfs(String n) {
        if (n.length() == 1 || isOnly(n)) {
            answer++;
            return;
        }

        dfs(n.substring(1, n.length()));
        dfs(n.substring(0, n.length() - 1));
    }

    static boolean isOnly(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
// 트리 계산

//        set = new HashSet<>();
//        for(int i=0; i<arr.length; i++) {
//            dfs(i,i, ""+arr[i], ""+arr[i]);
//        }
//        System.out.println(set.size());
//    }
//    static void dfs(int L, int R, String s, String path) {
//        if(L==0 && R==arr.length-1) {
//            set.add(path);
//            return;
//        }
//        if(L-1>=0) {
//            dfs(L-1, R, arr[L-1]+s, path+" "+arr[L-1]+s);
//        }
//        if(R+1<arr.length) {
//            dfs(L, R+1, s+arr[R+1], path+" "+s+arr[R+1]);
//        }
//    }
//    static int stoi(String s) {
//        return Integer.valueOf(s);
//    }
//}

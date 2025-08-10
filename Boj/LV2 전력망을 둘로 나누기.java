import java.util.*;

class Solution {

    boolean[][] visit; // 간선 사용
    boolean[] visitNode; // 방문 노드
    List<Integer>[] list; // 간선
    int sum=0;

    public int solution(int n, int[][] wires) {

        visit = new boolean[n+1][n+1];
        visitNode = new boolean[n+1];
        list = new List[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int[] arr : wires){
            list[arr[0]].add(arr[1]);
            list[arr[1]].add(arr[0]);
        }

        int min = Integer.MAX_VALUE;
        for(int[] arr : wires){
            sum=0;
            visitNode = new boolean[n+1];

            visit[arr[0]][arr[1]] = true;
            visit[arr[1]][arr[0]] = true;

            visitNode[1] = true;
            sum++;
            dfs(1);
            int a = sum;

            sum=0;
            for(int i=2;i<=n;i++) {
                if(!visitNode[i]){
                    visitNode[i] = true;
                    sum++;
                    dfs(i);
                }
            }
            int b = sum;

            min = Math.min(min,Math.abs(a-b));

            visit[arr[0]][arr[1]] = false;
            visit[arr[1]][arr[0]] = false;

        }

        return min;
    }

    public void dfs(int node) {

        for(int i : list[node]){
            if(!visit[node][i] && !visitNode[i]){
                sum++;
                visitNode[i] = true;
                dfs(i);
            }
        }
    }

}
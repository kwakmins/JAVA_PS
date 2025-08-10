import java.util.*;

class Solution {

    int max = 0;
    boolean[][][] visit;
    List<Integer>[] edgeList;
    int[] Info;

    public int solution(int[] info, int[][] edges) {

        Info = info;
        edgeList = new List[info.length];
        for(int i=0;i<edgeList.length;i++){
            edgeList[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            edgeList[edge[0]].add(edge[1]);
            edgeList[edge[1]].add(edge[0]);
        }

        visit = new boolean[info.length][info.length+1][info.length+1];

        dfs(0,0,0);

        return max;
    }

    void dfs(int node, int s, int f){

        if(visit[node][s][f]) return;

        max = Math.max(max,s);

        visit[node][s][f] = true;
        int backup = Info[node];

        int ss = s, ff = f;
        if(Info[node] == 0){
            ss++;
        } else if (Info[node] == 1) {
            ff++;
        }
        Info[node] = -1;

        if(ss>ff){
            for(int next : edgeList[node]){
                dfs(next,ss,ff);
            }

        }

        visit[node][s][f] = false;
        Info[node] = backup;

    }
}
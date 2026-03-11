import java.util.*;

class Solution {

    int dx[] = new int[]{1,-1,0,0};
    int dy[] = new int[]{0,0,1,-1};

    int max = 0, tempSum=0;
    boolean[][] visit;
    int[][] _land;
    int N,M;

    // 미리 계산
    int[][] dp; // nodeNum 저장
    int nodeNum = 1;
    int[] nodeArr;

    public int solution(int[][] land) {

        _land = land;
        N = land.length;
        M = land[0].length;

        visit = new boolean[N][M];
        dp = new int[N][M];
        nodeArr = new int[N*M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){

                if(land[i][j] ==1 && !visit[i][j]){
                    tempSum=0;

                    dfs(j,i);
                    nodeArr[nodeNum] = tempSum;
                    nodeNum++;
                }
            }
        }

        int[] visitNode = new int[nodeNum];
        for(int j=0;j<M;j++){

            //boolean[] visitNode = new boolean[N*M]; 시간 복잡도 낮아짐
            int sum = 0;

            for(int i=0;i<N;i++){

                int node = dp[i][j];

                // if (node !=0 && !visitNode[node]){ 시간 복잡도 낮아짐
                if (node !=0 && visitNode[node]!=j){ // 반복 주체로 확인
                    sum += nodeArr[node];
                    visitNode[node] = j;
                }
            }

            max = Math.max(max,sum);
        }

        return max;
    }

    void dfs(int x,int y){

        tempSum++;
        dp[y][x] = nodeNum;
        visit[y][x] = true;

        for(int i=0;i<4;i++){
            int ax = x+dx[i];
            int ay = y+dy[i];

            if(ax>=0 && ay>=0 && ax<M && ay<N){
                if(!visit[ay][ax] && _land[ay][ax] == 1){
                    dfs(ax,ay);
                }
            }
        }
    }
}
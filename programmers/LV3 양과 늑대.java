import java.util.*;

class Solution {

    List<Integer>[] list;
    int[] info;
    int max = 0;

    public int solution(int[] info, int[][] edges) {
        this.info = info;

        list = new List[info.length+1];
        for(int i=0;i<=info.length;i++){
            list[i] = new ArrayList<>();
        }
        for(int [] edge : edges){
            list[edge[0]].add(edge[1]);
        }

        dfs(0,0,0, new ArrayList<>());

        return max;
    }

    void dfs(int idx, int sheep, int wolf, List<Integer> nextList){

        if(info[idx]==1){
            wolf+=1;
        } else {
            sheep +=1;
        }

        if(sheep<=wolf){
            return;
        }

        max = Math.max(max, sheep);

        // 재귀 중 참조중 리스트 변경되므로 tempList에
        // ConcurrentModificationException
        List<Integer> tempList = new ArrayList<>(nextList);
        tempList.remove(Integer.valueOf(idx));
        tempList.addAll(list[idx]);

        for (int next : tempList) {
            dfs(next, sheep, wolf, new ArrayList<>(tempList));
        }

    }
}
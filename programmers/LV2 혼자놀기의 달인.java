import java.util.*;

class Solution {

    boolean[] visit;
    int[] cards;

    public int solution(int[] cards) {
        this.cards= cards;
        visit = new boolean[cards.length+1];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(b,a));

        for(int i=0;i<cards.length;i++){

            if(!visit[cards[i]]){
                pq.add( dfs(cards[i],0) );
            }
        }

        int a = pq.poll();
        int b = pq.size()>0 ? pq.poll() : 0;

        return a*b;
    }

    int dfs(int x,int sum){

        if(visit[x]){
            return sum;
        }
        visit[x] = true;

        return dfs(cards[x-1],sum+1);
    }
}
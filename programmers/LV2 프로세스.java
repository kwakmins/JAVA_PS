import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        int[] sort = new int[priorities.length];

        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(Integer.compare(b,a)));

        for(int i=0;i<priorities.length; i++){

            q.add(new int[]{i,priorities[i]});
            pq.add(priorities[i]);
        }

        int sortIdx = 1;
        while(!pq.isEmpty()){

            int max = pq.peek();

            if(q.peek()[1]!=max){

                int[] poll = q.poll();
                q.add(poll);
            }
            else {
                pq.poll();
                int[] poll = q.poll();

                sort[poll[0]]=sortIdx;
                sortIdx++;
            }

        }

        return sort[location];
    }
}
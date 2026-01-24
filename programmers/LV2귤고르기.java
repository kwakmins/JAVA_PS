import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i: tangerine){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for( Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(entry.getValue());
        }

        // 이런 방법도 있구나
        // List<Integer> list = new ArrayList<>(map.keySet());
        // list.sort((o1, o2) -> map.get(o2)-map.get(o1));

        int cnt = 0;

        while(!pq.isEmpty()){
            int x = pq.poll();
            cnt++;
            k-=x;

            if(k<=0){
                break;
            }
        }

        return cnt;
    }
}
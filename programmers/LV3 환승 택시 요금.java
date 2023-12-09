import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LV3 https://school.programmers.co.kr/learn/courses/30/lessons/72413
 * 다익스트라 - 노드 s에서 시작해서, 노드 a와 노드 b로 각자 가는 최솟값 구하기.
 *
 * 노드들을 i라고 둘 때, s->i + i->a + i->b 중 가장 작은 값 구하면 된다.
 *
 * @!!! 다익스트라에 대한 이해도 부족
 * @!!! 임의로 큰 값을 줄 때, 좀 더 크게 주자
 */
import java.util.*;

class Solution {
  List<Node>[] board;
  int N;
  public int solution(int n, int s, int a, int b, int[][] fares) {
    int answer = Integer.MAX_VALUE;
    N = n;
    board = new List[n];
    for(int i=0;i<n;i++){
      board[i]=new ArrayList<>();
    }
    for(int i=0;i<fares.length;i++){
      board[fares[i][0]-1].add(new Node(fares[i][1]-1,fares[i][2]));
      board[fares[i][1]-1].add(new Node(fares[i][0]-1,fares[i][2]));
    }

    int[] aDis = dij(a-1);
    int[] bDis = dij(b-1);
    int[] sDis = dij(s-1);

    for(int i=0;i<n;i++){
      int temp = sDis[i] + aDis[i] + bDis[i];
      answer = Math.min(answer,temp);
    }

    return answer;
  }

  int[] dij(int start){
    PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.value-o2.value);
    int[] dis = new int[N];
    for(int i=0;i<N;i++){
      dis[i] = Integer.MAX_VALUE;
    }
    dis[start] = 0;
    pq.add(new Node(start,0));

    while(!pq.isEmpty()){
      Node node = pq.poll();

      if(dis[node.idx]<node.value){
        continue;
      }

      for(Node n : board[node.idx]){
        if(dis[n.idx]>node.value+n.value){
          dis[n.idx] = node.value + n.value;
          pq.add(new Node(n.idx,dis[n.idx]));
        }
      }
    }
    return dis;
  }

  class Node{
    int idx,value;

    public Node(int x, int y){
      idx =x;
      value = y;
    }
  }
}
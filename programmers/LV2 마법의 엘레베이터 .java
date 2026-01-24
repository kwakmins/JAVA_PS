import java.util.*;

class Solution {

    public int solution(int storey) {

        int answer=0;

        while(storey!=0){

            int x = storey % 10;
            storey/=10;

            if(x == 5){
                // storey++가 되면서 6으로 만들거나 5로 유지 둘중 하나이므로 앞자리가 5면 6으로 만드는게 이득임
                if(storey%10 >= 5){
                    storey++;
                    answer+=5;
                } else {
                    answer+=5;
                }
            }

            else if (x>5){
                storey++;
                answer += 10-x;
            }
            else {
                answer += x;
            }
        }

        return answer;
    }

}




//     public int solution(int storey) {
//         int answer = 0;
//         int tempSize = String.valueOf(storey).length()+1;

//         int max = 200000001;
//         int[] elv = new int[max];

//         Queue<Integer> q =new ArrayDeque<>();
//         q.add(storey);

//         while(!q.isEmpty()){

//             int x = q.poll();

//             if(x==0){
//                 return elv[0];
//             }

//             for(int i=0;i<=tempSize;i++){

//                 int pow = (int) Math.pow(10,i);

//                 if(pow+x<=max && elv[pow+x]==0 && pow+x!=storey) {
//                     elv[pow+x] = elv[x]+1;
//                     q.add(pow+x);
//                 }
//                 if(x-pow>=0 && elv[x-pow]==0 && x-pow!=storey){
//                     elv[x-pow] = elv[x]+1;
//                     q.add(x-pow);
//                 }

//             }
//         }

//         return answer;
//     }
// }
package HF_Study.programmers3;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //트럭은 1초에 한칸씩 움직임

        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        int sum = 0; // 다리에 올라가 있는 트럭 무게의 합

        for(int t : truck_weights) {
            // 다리가 비어있을때 트럭을 한대 올림
            while(true) {
                if(q.isEmpty()) {
                    q.offer(t);
                    sum += t;
                    answer++;
                    break;
                    // 다리에 올라가 있는 트럭 수와 최대 올라갈수있는 트럭수가 같을때
                } else if(q.size() == bridge_length) {
                    sum -= q.poll(); // 올라가있는 트럭을 한대빼주고 sum에서 -
                    // 다리에 최대 올라갈 수 있는 트럭수보다 적게 올라가 있을때(0대는 X)
                } else {
                    // sum + 다음 트럭이 최대 무게허용치를 넘어설때
                    if(sum+t > weight) {
                        q.offer(0); // 최대 개수(bridge_length)를 맞추기 위함
                        answer++;
                    } else {
                        q.offer(t); // 다리에 한대 올리고
                        sum += t; // 트럭무게의 합에 더해주고
                        answer++; // 시간추가
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }
}
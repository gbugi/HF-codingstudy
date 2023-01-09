import java.util.LinkedList;
import java.util.Queue;

public class programmers3_3 {
    static class Solution {
        public static int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            //Queue 선언 (다리)
            Queue<Integer> bridge = new LinkedList<>();

            //대기중인 트럭 Queue로 변경
            Queue<Integer> waiting = new LinkedList<>();
            for(int truck : truck_weights) {
                waiting.add(truck);
            }

            int sum_weight = 0; // 다리에 올라간 트럭 무게의 합

            //기다리고 있는 트럭이 모두 다리에 올라갈 때 까지 반복
            while(!waiting.isEmpty()) {
                if(bridge.size() == bridge_length) {
                    //현재 다리에 트럭이 모두 올라가있을 때
                    sum_weight -= bridge.peek();
                    bridge.remove(); //맨 앞 트럭이 다리를 통과함
                }

                if (sum_weight + waiting.peek() <= weight) {
                    //현재 다리에 올라간 트럭의 무게가 다리의 최대 무게보다 작을 때
                    sum_weight += waiting.peek();
                    bridge.add(waiting.poll()); //트럭 올리기
                }else {
                    bridge.add(0); //트럭이 올라갈 수 없으므로 무게는 차지하지 않고 공간만 차지할 수 있도록 0 삽입
                }
                answer++;
            }

//            //다리에 있는 트럭이 모두 내려갈 때까지 반복
            if (!bridge.isEmpty()) {
                while (bridge.size() != 1) {
                    bridge.poll();
                }
                answer += bridge_length;
                bridge.poll();
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(Solution.solution(bridge_length, weight, truck_weights));

    }
}

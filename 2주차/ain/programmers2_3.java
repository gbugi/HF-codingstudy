import java.util.Collections;
import java.util.PriorityQueue;

public class programmers2_3 {

    static class Solution {
        public static int solution(int[] priorities, int location) {
            int answer = 0;

            // 우선순위 큐 생성
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            // 큐 세팅
            for(int i : priorities) {
                priorityQueue.add(i);
            }

            while(!priorityQueue.isEmpty()) {
                for(int i = 0; i < priorities.length; i++) {
                    if (priorityQueue.peek() == priorities[i]) {
                        answer++;
                        priorityQueue.poll();
                        if (i == location) return answer;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(Solution.solution(priorities, location));
    }
}

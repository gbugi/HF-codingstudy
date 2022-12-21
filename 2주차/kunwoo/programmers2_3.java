package HF_Study.programmers2;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution3 {
    public int solution(int[] priorities, int location) {
        /**
         * 숫자가 클 수록 중요도가 높은 작업
         */

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int p : priorities) {
            pq.offer(p);
        }
        System.out.println("first 우선순위 큐: " + pq);
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    if (i == location) return answer;
                }
            }
        }
        return answer;
    }
}


public class programmers2_3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
//        System.out.println(solution.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}

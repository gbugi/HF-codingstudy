package HF_Study.HF_Study6.HF_Study6_2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int solution(int k, int[] tangerine) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();

        int answer = 0;

        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }
        for(int m : map.values()) {
            pq.offer(m);
        }

        while(k > 0) {
            k -= pq.poll();
            answer++;
        }

        return answer;
    }
}

public class HF_Study6_2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }
}

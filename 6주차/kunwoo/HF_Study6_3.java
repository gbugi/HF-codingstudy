package HF_Study.HF_Study6.HF_Study6_3;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long total = 0L;
        long q1_total = 0L;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++) {
            q1_total += queue1[i];
            total += queue1[i] + queue2[i];
            q1.offer(queue1[i]); q2.offer(queue2[i]);
        }
        total /= 2;
        int maxCount = queue1.length * 3;

        while(q1_total != total) {
            if(maxCount == 0) {
                return -1;
            }
            if(q1_total < total) {
                long temp = q2.poll();
                q1_total += temp;
                q1.offer((int)temp);
            } else {
                long temp = q1.poll();
                q1_total -= temp;
                q2.offer((int)temp);
            }

            maxCount --;
        }

        return queue1.length * 3 - maxCount;
    }
}

public class HF_Study6_3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,1}, new int[]{1,5}));
    }
}

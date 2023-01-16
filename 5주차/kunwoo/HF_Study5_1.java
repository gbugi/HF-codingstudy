package HF_Study.HF_Study5;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] people, int limit) {

        Integer[] tmp = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        people = Arrays.stream(tmp).mapToInt(i -> i).toArray();

        int answer = 0;
        int last_index = people.length-1;

        for(int i = 0; i <= last_index; i++) {
            if(people[i] <= limit) {
                if(people[i] + people[last_index] <= limit) {
                    answer++;
                    last_index--;
                } else {
                    answer++;
                }
            }
        }


        return answer;
    }
}

public class HF_Study5_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{70, 80, 50}, 100));
    }
}

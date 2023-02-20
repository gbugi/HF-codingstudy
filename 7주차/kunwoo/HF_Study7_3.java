package HF_Study.HF_Study7;

import java.util.*;

class Solution3 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty()) {
                 int stackIdx = stack.pop();
                 if(numbers[i] > numbers[stackIdx]) {
                     answer[stackIdx] = numbers[i];
                 } else {
                     stack.push(stackIdx);
                     break;
                 }
            }
            stack.push(i);
        }
        return answer;
    }
}
//stackIdx = 2 , i = 3
public class HF_Study7_3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
//        System.out.println(Arrays.toString(solution.solution(new int[]{2,3,3,5})));
        System.out.println(Arrays.toString(solution.solution(new int[]{9, 1, 5, 3, 6, 2})));

    }
}

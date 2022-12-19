package HF_Study.programmers2;

import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        /*
         *  1: 빵
         *  2: 야채
         *  3: 고기
         */
        Stack<Integer> stack = new Stack<>();
        int[] ingreArr = {1,2,3,1};
        int answer = 0;

        for(int ingre : ingredient){
            int[] tempArr = new int[4];
            int j = 0;
            stack.push(ingre);
            if(stack.size() >= 4) {
                for(int i = stack.size()-4; i < stack.size(); i++) {
                    tempArr[j] = stack.get(i);
                    j++;
                    if(Arrays.equals(ingreArr,tempArr)) {
                        stack.pop();
                        stack.pop();
                        stack.pop();
                        stack.pop();
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}

public class programmers2_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2,1,1,2,3,1,2,3,1}));
        System.out.println(solution.solution(new int[]{1,3,2,1,2,1,3,1,2}));
    }
}

import java.util.*;

public class programmers1_3 {
     static class Solution {
        public static String solution(int[] food) {
            String answer = "";
            System.out.println("hi");
            StringBuffer answerBuffer = new StringBuffer();

            for(int i = 1; i < food.length; i++) {
                for(int j = 0; j < (food[i]/2); j++) {
                    answerBuffer.append(i);
                }
            }

            answer += answerBuffer.toString();
            answer += "0";
            answer += answerBuffer.reverse().toString();

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        System.out.println(Solution.solution(food));
    }
}
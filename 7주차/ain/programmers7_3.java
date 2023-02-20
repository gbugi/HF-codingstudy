import java.util.Arrays;
import java.util.Stack;

public class programmers7_3 {
    //  프로그래머스 뒤에 있는 큰 수 찾기
    static class Solution {
        public static int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];

            Arrays.fill(answer, -1);

            Stack<Integer> stack = new Stack<>();

            for (int arrIdx = 0; arrIdx < numbers.length; arrIdx++) {
                while (!stack.isEmpty() && numbers[arrIdx] > numbers[stack.peek()]) {
                    int stkIdx = stack.pop();
                    answer[stkIdx] = numbers[arrIdx];
                }

                stack.push(arrIdx);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
//        int[] numbers = {2, 3, 3, 5};

        int[] numbers = {9, 1, 5, 3, 6, 2};

        int[] answer = Solution.solution(numbers);
        for(int i : answer) {
            System.out.println(i);
        }
    }

}

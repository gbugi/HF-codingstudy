public class programmers7_3_timeout {
    //  프로그래머스 뒤에 있는 큰 수 찾기
    static class Solution {
        public static int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];

            for(int i = 0; i < numbers.length; i++) {
                for(int j = i; j < numbers.length; j++) {
                    if(numbers[i] < numbers[j]) {
                        answer[i] = numbers[j];
                        break;
                    }
                }
                if(answer[i] == 0) answer[i] = -1;
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

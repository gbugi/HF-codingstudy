public class programmers4_1 {

    static class Solution {
        public static int solution(int n) {
            int answer = 0;
            for(int i = 1; i <= n; i++) {
                int sum = 0;
                int count = i;
                while(true) {
                    sum += count;
                    if(sum == n) {
                        answer++;
                        break;
                    }else if(sum > n) {
                        break;
                    }else {
                        count++;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(Solution.solution(n));
    }
}

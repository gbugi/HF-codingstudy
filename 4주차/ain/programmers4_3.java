public class programmers4_3 {

    static class Solution {
        public static int solution(int n) {
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;

            for(int i = 2; i <= n; i++) {
                dp[i] = (dp[i-1]%1234567 + dp[i-2] % 1234567) % 1234567;
            }

            return dp[n];
        }
    }

    public static void main(String[] args) {
        int n = 1500;
        System.out.println(Solution.solution(n));
    }
}

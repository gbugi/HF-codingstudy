public class programmers7_2 {
    //프로그래머스 점프와 순간이동
    static class Solution{
        public static int solotion(int n) {
            int ans = 0;

            while(n!=0) {
                if(n%2==0) {
                    n = n/2;
                }else {
                    n--;
                    ans++;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Solution.solotion(n));
    }
}

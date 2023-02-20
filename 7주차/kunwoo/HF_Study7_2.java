package HF_Study.HF_Study7;

/**
 * 아이언 슈트
 * K칸 앞으로 점프
 * 현재까지 온거리 X 2
 * 순간이동: 건전지 X , K칸 앞으롲 점프 : K만큼의 건전지 사용량 줌
 * 거리 N만큼 떨어져있는 곳 가려함
 * 점프로 이동 최소
 * 건전지 사용량 최소값 return?
 */
class Solution2 {
    public int solution(int n) {
        int ans = 0;
        while(n != 0) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}


public class HF_Study7_2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(5));
    }
}

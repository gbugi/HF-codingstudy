package HF_Study.HF_Study4;

class Solution2 {
    public int solution(int n) {

        int answer = fibo(n);
        return answer;
    }

    public int fibo(int n) {
        int[] cache = new int[n+1];

        cache[0] = 0;
        cache[1] = 1;

        for (int i=2; i<= n; i++){
            // 99999와 같이 큰 수를 넣을 경우 int와 long타입의 범위를 넘어
            // 값들을 문제 조건에 맞게 1234567로 나눈 나머지로 저장
            cache[i] = (cache[i-1] + cache[i-2]) % 1234567;
        }

        return cache[n] % 1234567;
    }
}

public class HF_Study4_3 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(100000));
    }
}

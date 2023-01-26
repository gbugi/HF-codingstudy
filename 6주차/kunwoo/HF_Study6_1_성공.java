package HF_Study.HF_Study6.HF_Study6_1;

class Solution {
    public int solution(int n) {
        int answer = n;
        int count = Integer.bitCount(n); // 2진수로 변환하고 1의 개수 return하는 함수

        while (true) {
            answer++;
            int findCount = Integer.bitCount(answer);
            if (findCount == count) {
                break;
            }
        }
        return answer;
    }
}

public class HF_Study6_1_성공 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(78));
    }
}

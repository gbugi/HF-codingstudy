package HF_Study.HF_Study6.HF_Study6_1;

class Solution_ {
    private StringBuilder sb;
    private boolean yn = false;

    public int solution(int n) {

        int cnt = toBinary(n);
        int answer = 0;

        while(!yn) {
            n += 1;
            answer = theBigger(n, cnt);
        }

        return answer;
    }

    public int toBinary(int n) {
        int cnt = 0;
        sb = new StringBuilder();

        while(n/2 != 0) {
            if(n/2 == 1) {
                sb.append(n%2);
                sb.append(n/2);
            } else {
                sb.append(n%2);
            }
            n /= 2;
        }
        sb.reverse();

        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }

    public int theBigger(int n, int cnt) {
        if(cnt == toBinary(n)) {
            yn = true;
        }
        return n;
    }
}

public class HF_Study6_1_효율성실패 {
    public static void main(String[] args) {
        Solution_ solution = new Solution_();
        System.out.println(solution.solution(78));
//        System.out.println(solution.solution(15));
    }
}

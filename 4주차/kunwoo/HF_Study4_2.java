package HF_Study.HF_Study4;

import java.util.Arrays;

class Solution3 {
    private StringBuilder sb = new StringBuilder();
    private int cnt = 0;
    private int binaryCnt = 0;

    public int[] solution(String s) {

        toBinary(s);

        int[] answer = {binaryCnt, cnt};
        return answer;
    }

    public void toBinary(String s) {
        binaryCnt ++;
        sb = new StringBuilder();
        // 글자에서 0제거
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == '0') {
                cnt++;
            }
        }
        s = sb.toString();
        int size = s.length();

        // 이진 변환
        sb = new StringBuilder();
        while (size >= 1) {
            sb.append(size % 2);
            size = size / 2;
        }
        sb.reverse();
        s = sb.toString();

        if(s.equals("1")) return;
        toBinary(s);
    }
}

public class HF_Study4_2 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(Arrays.toString(solution.solution("110010101001")));
    }
}

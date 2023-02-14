package HF_Study.HF_Study7;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> wordsList = new ArrayList<String>();
        Queue<String> q = new LinkedList<>();
        int fail = -1;
        int cnt = 0;
        boolean isFirst = true;
        char last = ' ';

        for(String word : words) {
            q.offer(word);
        }

        while(fail < 0) {
            for (int i = 1; i <= n; i++) {
                if(!q.isEmpty()) {
                    String word = q.poll();
                    if (!isFirst) {
                        if (word.charAt(0) != last || wordsList.contains(word)) {
                            fail = i;
                            break;
                        }
                    }
                    isFirst = false;
                    wordsList.add(word);
                    last = word.charAt(word.length() - 1);
                } else {
                    fail = 0;
                }
            }
            cnt++;
        }
        if(fail == 0 ) cnt = 0;


        int[] answer = new int[2];
        answer[0] = fail;
        answer[1] = cnt;

        return answer;
    }
}

public class HF_Study7_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
//        System.out.println(Arrays.toString(solution.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
//        System.out.println(Arrays.toString(solution.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}

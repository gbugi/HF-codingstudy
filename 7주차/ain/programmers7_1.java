import java.util.ArrayList;
import java.util.List;

public class programmers7_1 {

    static class Solution {
        // 프로그래머스 영어끝말잇기
        public static int[] solution(int n, String[] words) {
            int[] answer = {0,0};

            List<String> wordList = new ArrayList<>();
            wordList.add(words[0]);

            for(int i = 1; i < words.length; i++) {
                String last = wordList.get(i-1);
                String word = words[i];
                if(last.endsWith(Character.toString(word.charAt(0))) && !wordList.contains(word)) {
                    wordList.add(word);
                }else {
                    answer[0] = i%n + 1;
                    answer[1] = i/n + 1;
                    return answer;
                }

            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int[] answer = Solution.solution(n, words);
        for(int i : answer) {
            System.out.println(i);
        }
    }
}

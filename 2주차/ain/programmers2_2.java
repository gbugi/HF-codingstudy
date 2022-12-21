import java.util.HashMap;
import java.util.Map;

public class programmers2_2 {

    static class Solution {
        public static String solution(String[] survey, int[] choices) {
            String answer = "";

            //각 유형별 점수를 담을 map
            Map<String, Integer> score = new HashMap<>();

            for(int i = 0; i < survey.length; i++) {
                String ans1 = String.valueOf(survey[i].charAt(0));
                String ans2 = String.valueOf(survey[i].charAt(1));
                if(choices[i] < 4) {
                    score.put(ans1, score.getOrDefault(ans1, 0) + (4-choices[i]));
                } else if (choices[i] > 4) {
                    score.put(ans2, score.getOrDefault(ans2, 0) + (choices[i]-4));
                }
            }

            answer += (score.getOrDefault("R", 0) >= score.getOrDefault("T", 0) ? "R" : "T");
            answer += (score.getOrDefault("C", 0) >= score.getOrDefault("F", 0) ? "C" : "F");
            answer += (score.getOrDefault("J", 0) >= score.getOrDefault("M", 0) ? "J" : "M");
            answer += (score.getOrDefault("A", 0) >= score.getOrDefault("N", 0) ? "A" : "N");

            return answer;
        }
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(Solution.solution(survey, choices));
    }
}

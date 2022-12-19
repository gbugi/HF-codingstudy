package HF_Study.programmers2;

import java.util.LinkedHashMap;

class Solution2 {
    public String solution(String[] survey, int[] choices) {
        /**
         인덱스 (0,1)기준
         매우 비동의(1), 동의(7) : 3점
         비동의(2), 동의(6) : 2점
         약간 비동의(3), 동의(5) : 1점
         모르겠음(4) : 0점
         */

        LinkedHashMap<String, Integer> cntMap = new LinkedHashMap<>();
        cntMap.put("R", 0);
        cntMap.put("T", 0);
        cntMap.put("C", 0);
        cntMap.put("F", 0);
        cntMap.put("J", 0);
        cntMap.put("M", 0);
        cntMap.put("A", 0);
        cntMap.put("N", 0);

        for(int i = 0; i < survey.length; i++) {
            String first = String.valueOf(survey[i].charAt(0));
            String second = String.valueOf(survey[i].charAt(1));

            switch (choices[i]) {
                case 1:
                    cntMap.put(first, cntMap.get(first) + 3);
                    break;
                case 2:
                    cntMap.put(first, cntMap.get(first) + 2);
                    break;
                case 3:
                    cntMap.put(first, cntMap.get(first) + 1);
                    break;
                case 5:
                    cntMap.put(second, cntMap.get(second) + 1);
                    break;
                case 6:
                    cntMap.put(second, cntMap.get(second) + 2);
                    break;
                case 7:
                    cntMap.put(second, cntMap.get(second) + 3);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(cntMap.get("R") >= cntMap.get("T")) sb.append("R");
        else sb.append("T");

        if(cntMap.get("C") >= cntMap.get("F")) sb.append("C");
        else sb.append("F");

        if(cntMap.get("J") >= cntMap.get("M")) sb.append("J");
        else sb.append("M");

        if(cntMap.get("A") >= cntMap.get("N")) sb.append("A");
        else sb.append("N");

        String answer = sb.toString();
        return answer;
    }
}

public class programmers2_2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }
}

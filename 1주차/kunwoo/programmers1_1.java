import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class programmers1_1 {

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            Map<String, HashSet<String>> reporter_map = new HashMap<>(); // (신고자, 신고당한사람목록) map
            Map<String, Integer> reported_map = new HashMap<>(); // (신고당한사람 , 신고당한횟수) map

            // report 배열을 ->  list -> set(신고자 신고당한사람 값이 같은 요소 삭제)
            for(String re: new HashSet<String>(Arrays.asList(report))) {
                String reporter = re.split(" ")[0];
                String reported = re.split(" ")[1];

                //reporter_map에 해당 key가 존재하지 않을때
                reporter_map.putIfAbsent(reporter, new HashSet<String>(){{
                    add(reported);
                }});
                //reporter_map에 해당 key가 존재할때는 해당 키 value에 값 추가
                reporter_map.get(reporter).add(reported);

                //reported_map에 해당 key가 존재할때는 해당 키 value에 +1
                reported_map.put(reported, reported_map.getOrDefault(reported, 0) + 1);
            }
//            System.out.println(reporter_map);
//            System.out.println(reported_map);

            int[] answer = new int[id_list.length];
            //메일발송 배열생성 part
            for(String reported : reported_map.keySet()) {
                if (reported_map.get(reported) >= k) {
                    for(int i =0; i < id_list.length; i++) {
                        if(reporter_map.containsKey(id_list[i]) && reporter_map.get(id_list[i]).contains(reported)) answer[i]++;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2)));

    }
}

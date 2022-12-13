import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class programmers1_1 {
    static class Solution {
        public static int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            // 신고한 목록 Map<유저 아이디, 해당 유저가 신고한 사람>
            HashMap<String, HashSet<String>> userReportList = new HashMap<>();
            // 신고 당한 목록 Map<유저 아이디, 신고 당한 횟수>
            HashMap<String, Integer> reportedUserCount = new HashMap<>();
            // 이용 정지당한 유저 목록
            ArrayList<String> banList = new ArrayList<>();

            // Map 세팅
            for(int i = 0; i < id_list.length; i++) {
                answer[i] = 0;
                HashSet nullSet = new HashSet();
                userReportList.put(id_list[i], nullSet);
                reportedUserCount.put(id_list[i], 0);
            }

            for(String reportDetail : report) {
                String reporterUser = reportDetail.split(" ")[0];
                String reportedUser = reportDetail.split(" ")[1];
                userReportList.get(reporterUser).add(reportedUser);
//                reportedUserCount.replace(reportedUser, reportedUserCount.get(reportedUser) + 1);
            }

            for(String id1 : id_list) {
                for(String id2 : id_list) {
                    if(userReportList.get(id1).contains(id2)) reportedUserCount.replace(id2, reportedUserCount.get(id2) + 1);
                }
            }

            for(String id : id_list) {
                if(reportedUserCount.get(id) >= k) {
                    banList.add(id);
                }
            }

            for(int i = 0; i < id_list.length; i++) {
                for(int j = 0; j < banList.size(); j++) {
                    if(userReportList.get(id_list[i]).contains(banList.get(j))) {
                        answer[i]++;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        int k = 2;

        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;


        System.out.println(Solution.solution(id_list, report, k));
    }
}

import java.util.Arrays;

public class programmers5_1 {
    //구명보트 (lv2)
    static class Solution {
        public static int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            int left = 0;
            int right = people.length -1;
            while(right >= left) {
                //가장 가벼운 사람과 가장 무거운 사람을 더했을 때 제한 무게보다 낮은 경우
                if(people[left]+people[right] <= limit) left++;
                answer++;
                right--;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] people = {70,80,50,50};
        int limit = 100;

        System.out.println(Solution.solution(people, limit));
    }

}

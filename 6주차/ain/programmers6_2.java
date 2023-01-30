import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class programmers6_2 {

    static class Solution {
        public static int solution(int k, int[] tangerine) {
            int answer = 0;

            Map<Integer, Integer> basket = new HashMap<>();
            for(int size : tangerine) {
                //사이즈별 귤 개수 세팅
                basket.put(size, basket.getOrDefault(size, 0) + 1);
            }

            List<Integer> keySet = new ArrayList<>(basket.keySet());

            //사이즈별 귤 개수가 많은 순서대로 내림차순 정렬
            keySet.sort((o1, o2) -> basket.get(o2).compareTo(basket.get(o1)));

            int i = 0;
            while(k > 0) {
                k -= basket.get(keySet.get(i));
                answer++;
                i++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(Solution.solution(k, tangerine));
    }
}

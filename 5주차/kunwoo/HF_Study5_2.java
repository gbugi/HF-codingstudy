package HF_Study.HF_Study5;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize != 0) {
            List<String> cacheList = new ArrayList<>();
            for(int i = 0; i < cities.length; i++) {
                String city = cities[i].toLowerCase();
                if(cacheList.size() != cacheSize) {
                    if(cacheList.contains(city)) {
                        cacheList.remove(city);
                        cacheList.add(city);
                        answer++;
                    } else {
                        cacheList.add(city);
                        answer += 5;
                    }
                } else {
                    if(cacheList.contains(city)) {
                        cacheList.remove(city);
                        cacheList.add(city);
                        answer++;
                    } else {
                        cacheList.remove(0);
                        cacheList.add(city);
                        answer += 5;
                    }

                }

            }
        }
        else {
            answer = 5 * cities.length;
        }

        return answer;
    }
}

public class HF_Study5_2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
    }
}

import java.util.LinkedHashSet;
import java.util.Set;

public class programmers5_2 {

    static class Solution {
        public static int solution(int cacheSize, String[] cities) {
            int answer = 0 ;

            if(cacheSize == 0) {
                return cities.length * 5;
            }

            Set<String> cache = new LinkedHashSet<>();

            for(String city : cities) {
                city = city.toLowerCase();

                if(cache.contains(city)) {
                    cache.remove(city);
                    answer++;
                } else answer += 5;

                cache.add(city);

                if(cache.size() > cacheSize) {
                    String oldest = cache.iterator().next();
                    cache.remove(oldest);
                }
            }

            return answer;

/*
            int answer = 0;

            if(cacheSize == 0) {
                return cities.length * 5;
            }

            String[] cache_list = new String[cacheSize];
            //head - [0]   [1]   [2] - tail

            for(String city : cities) {
                city = city.toLowerCase();
                if (cache_list[0] == null) {
                    answer += 5;
                }else{
                    int key = -1;
                    for (int i = 0; i < cache_list.length; i++) {
                        //캐시에 해당 도시가 존재하는지 확인
                        if (cache_list[i] != null && cache_list[i].equals(city)) {
                            key = i;
                            answer++;
                        }
                    }

                    //캐시에 해당 도시가 없는 경우
                    if (key == -1) {
                        for(int i = 0; i < cacheSize; i++) {
                            if(cache_list[i] == null) break;
                            key = i;
                        }
                        answer += 5;
                    }

                    if(key == 0) {
                        cache_list[1] = cache_list[0];
                    }else {
                        for(int i = key; i >= 0; i--) {
                            if(i+1 < cacheSize) {
                                cache_list[i + 1] = cache_list[i];
                            }
                        }
                    }
                }
                cache_list[0] = city;
            }

            return answer;
 */
        }

        public static void main(String[] args) {
//            String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//            int cacheSize = 3;

            String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
            int cacheSize = 3;

            System.out.println(Solution.solution(cacheSize, cities));
        }
    }

}
